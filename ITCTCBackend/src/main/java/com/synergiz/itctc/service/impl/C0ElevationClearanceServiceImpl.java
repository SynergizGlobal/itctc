package com.synergiz.itctc.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synergiz.itctc.constants.WorkflowConstants;
import com.synergiz.itctc.dto.request.C0ElevationClearanceDetailRequest;
import com.synergiz.itctc.dto.request.C0ElevationClearanceRequest;
import com.synergiz.itctc.dto.response.C0ElevationClearanceDetailResponse;
import com.synergiz.itctc.dto.response.C0ElevationClearanceResponse;
import com.synergiz.itctc.dto.response.InspectionWorkflowResponse;
import com.synergiz.itctc.entity.C0ElevationClearanceDetail;
import com.synergiz.itctc.entity.C0ElevationClearanceHeader;
import com.synergiz.itctc.exception.ResourceNotFoundException;
import com.synergiz.itctc.repository.C0ElevationClearanceDetailRepository;
import com.synergiz.itctc.repository.C0ElevationClearanceHeaderRepository;
import com.synergiz.itctc.service.C0ElevationClearanceService;
import com.synergiz.itctc.service.InspectionWorkflowService;

@Service
@Transactional
public class C0ElevationClearanceServiceImpl implements C0ElevationClearanceService {

	private final C0ElevationClearanceHeaderRepository c0ElevationClearanceHeaderRepository;

	private final C0ElevationClearanceDetailRepository c0ElevationClearanceDetailRepository;

	private final InspectionWorkflowService inspectionWorkflowService;

	public C0ElevationClearanceServiceImpl(C0ElevationClearanceHeaderRepository c0ElevationClearanceHeaderRepository,
			C0ElevationClearanceDetailRepository c0ElevationClearanceDetailRepository,
			InspectionWorkflowService inspectionWorkflowService) {

		this.c0ElevationClearanceHeaderRepository = c0ElevationClearanceHeaderRepository;

		this.c0ElevationClearanceDetailRepository = c0ElevationClearanceDetailRepository;

		this.inspectionWorkflowService = inspectionWorkflowService;
	}

	// =========================================================
	// SAVE
	// =========================================================

	@Override
	public C0ElevationClearanceResponse saveC0ElevationClearance(C0ElevationClearanceRequest request) {

		C0ElevationClearanceHeader header = new C0ElevationClearanceHeader();

		mapRequestToHeader(request, header);

		header.setIsActive(true);
		header.setCreatedDate(LocalDateTime.now());

		List<C0ElevationClearanceDetail> details = createDetails(request.getDetails(), header);

		header.setDetails(details);

		calculateMinMax(header, details);

		C0ElevationClearanceHeader savedHeader = c0ElevationClearanceHeaderRepository.save(header);

		return mapToResponse(savedHeader);
	}

	// =========================================================
	// GET BY ID
	// =========================================================

	@Override
	@Transactional(readOnly = true)
	public C0ElevationClearanceResponse getC0ElevationClearance(Long c0ElevationClearanceId) {

		C0ElevationClearanceHeader header = c0ElevationClearanceHeaderRepository.findById(c0ElevationClearanceId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"C0 Elevation Clearance not found with Id : " + c0ElevationClearanceId));

		if (!Boolean.TRUE.equals(header.getIsActive())) {
			throw new ResourceNotFoundException("C0 Elevation Clearance not found with Id : " + c0ElevationClearanceId);
		}

		return mapToResponse(header);
	}
	// =========================================================
	// GET ALL
	// =========================================================

	@Override
	@Transactional(readOnly = true)
	public List<C0ElevationClearanceResponse> getAllC0ElevationClearances() {

		List<C0ElevationClearanceHeader> headers = c0ElevationClearanceHeaderRepository.findByIsActiveTrue();

		return headers.stream().map(this::mapToResponse).collect(Collectors.toList());
	}

	// =========================================================
	// UPDATE
	// =========================================================

	@Override
	@Transactional
	public C0ElevationClearanceResponse updateC0ElevationClearance(Long c0ElevationClearanceId,
			C0ElevationClearanceRequest request) {

		C0ElevationClearanceHeader header = c0ElevationClearanceHeaderRepository.findById(c0ElevationClearanceId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"C0 Elevation Clearance not found with Id : " + c0ElevationClearanceId));

		// =====================================================
		// 1. UPDATE HEADER
		// =====================================================

		header.setStationName(request.getStationName());
		header.setLine(request.getLine());
		header.setMeasurementDate(request.getMeasurementDate());

		header.setSeriesOfRollingStock(request.getSeriesOfRollingStock());

		header.setNhsrcl(request.getNhsrcl());
		header.setEngineerWitness(request.getEngineerWitness());
		header.setContractorWitness(request.getContractorWitness());

		// Elevation
		header.setElevationDesignValue(request.getElevationDesignValue());

		header.setElevationToleranceFrom(request.getElevationToleranceFrom());

		header.setElevationToleranceTo(request.getElevationToleranceTo());

		// Clearance
		header.setClearanceDesignValue(request.getClearanceDesignValue());

		header.setClearanceToleranceFrom(request.getClearanceToleranceFrom());

		header.setClearanceToleranceTo(request.getClearanceToleranceTo());

		header.setRemarks(request.getRemarks());

		header.setUpdatedBy(request.getUpdatedBy());
		header.setUpdatedDate(LocalDateTime.now());

		// =====================================================
		// 2. SOFT DELETE REMOVED DETAILS
		// =====================================================

		Set<Long> requestDetailIds = request.getDetails().stream()
				.map(C0ElevationClearanceDetailRequest::getC0ElevationClearanceDetailId).filter(Objects::nonNull)
				.collect(Collectors.toSet());

		for (C0ElevationClearanceDetail existingDetail : header.getDetails()) {

			if (!requestDetailIds.contains(existingDetail.getC0ElevationClearanceDetailId())) {

				existingDetail.setIsActive(false);

				existingDetail.setUpdatedBy(request.getUpdatedBy());

				existingDetail.setUpdatedDate(LocalDateTime.now());
			}
		}

		// =====================================================
		// 3. INSERT / UPDATE DETAILS
		// =====================================================

		for (C0ElevationClearanceDetailRequest dto : request.getDetails()) {

			C0ElevationClearanceDetail detail;

			// -------------------------------------------------
			// UPDATE EXISTING DETAIL
			// -------------------------------------------------

			if (dto.getC0ElevationClearanceDetailId() != null) {

				detail = c0ElevationClearanceDetailRepository.findById(dto.getC0ElevationClearanceDetailId())
						.orElseThrow(() -> new ResourceNotFoundException("C0 Elevation Clearance Detail "
								+ "not found with Id : " + dto.getC0ElevationClearanceDetailId()));

				detail.setUpdatedBy(request.getUpdatedBy());

				detail.setUpdatedDate(LocalDateTime.now());
			}

			// -------------------------------------------------
			// INSERT NEW DETAIL
			// -------------------------------------------------

			else {

				detail = new C0ElevationClearanceDetail();

				detail.setC0ElevationClearanceHeader(header);

				detail.setCreatedBy(request.getUpdatedBy());

				detail.setCreatedDate(LocalDateTime.now());

				detail.setIsActive(true);

				header.getDetails().add(detail);
			}

			// =================================================
			// UPDATE DETAIL DATA
			// =================================================

			detail.setCarNumber(dto.getCarNumber());

			detail.setMeasurementPoint(dto.getMeasurementPoint());

			detail.setPosition(dto.getPosition());

			detail.setElevationCalculated(dto.getElevationCalculated());

			detail.setElevationMeasured(dto.getElevationMeasured());

			detail.setClearanceCalculated(dto.getClearanceCalculated());

			detail.setClearanceMeasured(dto.getClearanceMeasured());

			detail.setRemarks(dto.getRemarks());

			detail.setIsActive(true);
		}

		// =====================================================
		// 4. RECALCULATE MAX / MIN
		// =====================================================

		calculateMinMax(header, header.getDetails().stream().filter(detail -> Boolean.TRUE.equals(detail.getIsActive()))
				.collect(Collectors.toList()));

		// =====================================================
		// 5. SAVE HEADER
		// =====================================================

		c0ElevationClearanceHeaderRepository.save(header);

		return mapToResponse(header);
	}

	// =========================================================
	// DELETE - SOFT DELETE
	// =========================================================

	@Override
	public void deleteC0ElevationClearance(Long c0ElevationClearanceId, String updatedBy) {

		C0ElevationClearanceHeader header = c0ElevationClearanceHeaderRepository.findById(c0ElevationClearanceId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"C0 Elevation Clearance not found with Id : " + c0ElevationClearanceId));

		// =====================================================
		// SOFT DELETE HEADER
		// =====================================================

		header.setIsActive(false);
		header.setUpdatedBy(updatedBy);
		header.setUpdatedDate(LocalDateTime.now());

		// =====================================================
		// SOFT DELETE DETAILS
		// =====================================================

		if (header.getDetails() != null) {

			for (C0ElevationClearanceDetail detail : header.getDetails()) {

				detail.setIsActive(false);
				detail.setUpdatedBy(updatedBy);
				detail.setUpdatedDate(LocalDateTime.now());
			}
		}

		c0ElevationClearanceHeaderRepository.save(header);
	}

	// =========================================================
	// MAP REQUEST TO HEADER
	// =========================================================

	private void mapRequestToHeader(C0ElevationClearanceRequest request, C0ElevationClearanceHeader header) {

		header.setStationName(request.getStationName());
		header.setLine(request.getLine());
		header.setMeasurementDate(request.getMeasurementDate());
		header.setSeriesOfRollingStock(request.getSeriesOfRollingStock());

		header.setNhsrcl(request.getNhsrcl());
		header.setEngineerWitness(request.getEngineerWitness());
		header.setContractorWitness(request.getContractorWitness());

		// Elevation
		header.setElevationDesignValue(request.getElevationDesignValue());

		header.setElevationToleranceFrom(request.getElevationToleranceFrom());

		header.setElevationToleranceTo(request.getElevationToleranceTo());

		// Clearance
		header.setClearanceDesignValue(request.getClearanceDesignValue());

		header.setClearanceToleranceFrom(request.getClearanceToleranceFrom());

		header.setClearanceToleranceTo(request.getClearanceToleranceTo());

		header.setRemarks(request.getRemarks());
	}

	// =========================================================
	// CREATE DETAILS
	// =========================================================

	private List<C0ElevationClearanceDetail> createDetails(List<C0ElevationClearanceDetailRequest> detailRequests,
			C0ElevationClearanceHeader header) {

		List<C0ElevationClearanceDetail> details = new ArrayList<>();

		if (detailRequests == null) {
			return details;
		}

		for (C0ElevationClearanceDetailRequest request : detailRequests) {

			C0ElevationClearanceDetail detail = new C0ElevationClearanceDetail();

			detail.setC0ElevationClearanceHeader(header);

			detail.setCarNumber(request.getCarNumber());
			detail.setMeasurementPoint(request.getMeasurementPoint());
			detail.setPosition(request.getPosition());

			detail.setElevationCalculated(request.getElevationCalculated());

			detail.setElevationMeasured(request.getElevationMeasured());

			detail.setClearanceCalculated(request.getClearanceCalculated());

			detail.setClearanceMeasured(request.getClearanceMeasured());

			detail.setRemarks(request.getRemarks());

			detail.setIsActive(true);
			detail.setCreatedBy(header.getCreatedBy());
			detail.setCreatedDate(LocalDateTime.now());
			details.add(detail);
		}

		return details;
	}

	// =========================================================
	// CALCULATE MAX / MIN
	// =========================================================

	private void calculateMinMax(C0ElevationClearanceHeader header, List<C0ElevationClearanceDetail> details) {

		List<BigDecimal> elevationValues = details.stream().filter(detail -> Boolean.TRUE.equals(detail.getIsActive()))
				.map(C0ElevationClearanceDetail::getElevationMeasured).filter(Objects::nonNull)
				.collect(Collectors.toList());

		List<BigDecimal> clearanceValues = details.stream().filter(detail -> Boolean.TRUE.equals(detail.getIsActive()))
				.map(C0ElevationClearanceDetail::getClearanceMeasured).filter(Objects::nonNull)
				.collect(Collectors.toList());

		// Elevation MAX / MIN

		if (!elevationValues.isEmpty()) {

			header.setMaxElevationMeasured(elevationValues.stream().max(BigDecimal::compareTo).orElse(null));

			header.setMinElevationMeasured(elevationValues.stream().min(BigDecimal::compareTo).orElse(null));

		} else {

			header.setMaxElevationMeasured(null);
			header.setMinElevationMeasured(null);
		}

		// Clearance MAX / MIN

		if (!clearanceValues.isEmpty()) {

			header.setMaxClearanceMeasured(clearanceValues.stream().max(BigDecimal::compareTo).orElse(null));

			header.setMinClearanceMeasured(clearanceValues.stream().min(BigDecimal::compareTo).orElse(null));

		} else {

			header.setMaxClearanceMeasured(null);
			header.setMinClearanceMeasured(null);
		}
	}

	// =========================================================
	// MAP HEADER TO RESPONSE
	// =========================================================

	private C0ElevationClearanceResponse mapToResponse(C0ElevationClearanceHeader header) {

		C0ElevationClearanceResponse response = new C0ElevationClearanceResponse();

		response.setC0ElevationClearanceId(header.getC0ElevationClearanceId());

		response.setStationName(header.getStationName());
		response.setLine(header.getLine());
		response.setMeasurementDate(header.getMeasurementDate());

		response.setSeriesOfRollingStock(header.getSeriesOfRollingStock());

		response.setNhsrcl(header.getNhsrcl());
		response.setEngineerWitness(header.getEngineerWitness());

		response.setContractorWitness(header.getContractorWitness());

		// Elevation
		response.setElevationDesignValue(header.getElevationDesignValue());

		response.setElevationToleranceFrom(header.getElevationToleranceFrom());

		response.setElevationToleranceTo(header.getElevationToleranceTo());

		// Clearance
		response.setClearanceDesignValue(header.getClearanceDesignValue());

		response.setClearanceToleranceFrom(header.getClearanceToleranceFrom());

		response.setClearanceToleranceTo(header.getClearanceToleranceTo());

		// Max / Min
		response.setMaxElevationMeasured(header.getMaxElevationMeasured());

		response.setMinElevationMeasured(header.getMinElevationMeasured());

		response.setMaxClearanceMeasured(header.getMaxClearanceMeasured());

		response.setMinClearanceMeasured(header.getMinClearanceMeasured());

		response.setRemarks(header.getRemarks());

		// Audit
		response.setIsActive(header.getIsActive());
		response.setCreatedBy(header.getCreatedBy());
		response.setCreatedDate(header.getCreatedDate());

		response.setUpdatedBy(header.getUpdatedBy());
		response.setUpdatedDate(header.getUpdatedDate());

		// Details
		List<C0ElevationClearanceDetailResponse> detailResponses = new ArrayList<>();

		if (header.getDetails() != null) {

			for (C0ElevationClearanceDetail detail : header.getDetails()) {

				if (!Boolean.TRUE.equals(detail.getIsActive())) {
					continue;
				}

				C0ElevationClearanceDetailResponse detailResponse = new C0ElevationClearanceDetailResponse();

				detailResponse.setC0ElevationClearanceDetailId(detail.getC0ElevationClearanceDetailId());

				detailResponse.setCarNumber(detail.getCarNumber());

				detailResponse.setMeasurementPoint(detail.getMeasurementPoint());

				detailResponse.setPosition(detail.getPosition());

				detailResponse.setElevationCalculated(detail.getElevationCalculated());

				detailResponse.setElevationMeasured(detail.getElevationMeasured());

				detailResponse.setClearanceCalculated(detail.getClearanceCalculated());

				detailResponse.setClearanceMeasured(detail.getClearanceMeasured());

				detailResponse.setRemarks(detail.getRemarks());

				detailResponses.add(detailResponse);
			}
		}

		response.setDetails(detailResponses);

		try {

			InspectionWorkflowResponse workflow = inspectionWorkflowService
					.getWorkflow(WorkflowConstants.C0_ELEVATION_CLEARANCE_FORM_ID, header.getC0ElevationClearanceId());

			response.setWorkflow(workflow);

		} catch (RuntimeException ex) {

			// Workflow not created yet.
			response.setWorkflow(null);
		}

		return response;
	}
}