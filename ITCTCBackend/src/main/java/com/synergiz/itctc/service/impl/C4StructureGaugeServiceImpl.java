package com.synergiz.itctc.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synergiz.itctc.constants.WorkflowConstants;
import com.synergiz.itctc.dto.request.C4StructureGaugeDetailRequest;
import com.synergiz.itctc.dto.request.C4StructureGaugeRequest;
import com.synergiz.itctc.dto.response.C4StructureGaugeDetailResponse;
import com.synergiz.itctc.dto.response.C4StructureGaugeResponse;
import com.synergiz.itctc.dto.response.InspectionWorkflowResponse;
import com.synergiz.itctc.entity.C4StructureGaugeDetail;
import com.synergiz.itctc.entity.C4StructureGaugeHeader;
import com.synergiz.itctc.exception.ResourceNotFoundException;
import com.synergiz.itctc.repository.C4StructureGaugeDetailRepository;
import com.synergiz.itctc.repository.C4StructureGaugeHeaderRepository;
import com.synergiz.itctc.service.C4StructureGaugeService;
import com.synergiz.itctc.service.InspectionWorkflowService;

@Service
@Transactional
public class C4StructureGaugeServiceImpl implements C4StructureGaugeService {

	private final C4StructureGaugeHeaderRepository headerRepository;

	private final C4StructureGaugeDetailRepository detailRepository;

	private final InspectionWorkflowService inspectionWorkflowService;

	public C4StructureGaugeServiceImpl(C4StructureGaugeHeaderRepository headerRepository,
			C4StructureGaugeDetailRepository detailRepository, InspectionWorkflowService inspectionWorkflowService) {

		this.headerRepository = headerRepository;
		this.detailRepository = detailRepository;
		this.inspectionWorkflowService = inspectionWorkflowService;
	}

	// =========================================================
	// CREATE
	// =========================================================

	@Override
	public C4StructureGaugeResponse saveC4StructureGauge(C4StructureGaugeRequest request) {

		C4StructureGaugeHeader header = new C4StructureGaugeHeader();

		mapRequestToHeader(request, header);

		header.setIsActive(true);

		header.setCreatedBy(request.getCreatedBy());

		header.setCreatedDate(LocalDateTime.now());

		/*
		 * Create details
		 */
		List<C4StructureGaugeDetail> details = createDetails(request.getDetails(), header);

		header.setDetails(details);

		/*
		 * Save header first
		 */
		C4StructureGaugeHeader savedHeader = headerRepository.save(header);

		/*
		 * Save details explicitly.
		 *
		 * This avoids depending on Cascade configuration.
		 */
		if (!details.isEmpty()) {
			detailRepository.saveAll(details);
		}

		return mapToResponse(savedHeader);
	}

	// =========================================================
	// GET BY ID
	// =========================================================

	@Override
	@Transactional(readOnly = true)
	public C4StructureGaugeResponse getC4StructureGauge(Long c4StructureGaugeId) {

		C4StructureGaugeHeader header = headerRepository.findById(c4StructureGaugeId).orElseThrow(
				() -> new ResourceNotFoundException("C4 Structure Gauge not found with Id : " + c4StructureGaugeId));

		if (!Boolean.TRUE.equals(header.getIsActive())) {

			throw new ResourceNotFoundException("C4 Structure Gauge not found with Id : " + c4StructureGaugeId);
		}

		return mapToResponse(header);
	}

	// =========================================================
	// GET ALL
	// =========================================================

	@Override
	@Transactional(readOnly = true)
	public List<C4StructureGaugeResponse> getAllC4StructureGauge() {

		List<C4StructureGaugeHeader> headers = headerRepository.findAll();

		List<C4StructureGaugeResponse> responses = new ArrayList<>();

		for (C4StructureGaugeHeader header : headers) {

			/*
			 * Do not return soft-deleted headers.
			 */
			if (!Boolean.TRUE.equals(header.getIsActive())) {
				continue;
			}

			responses.add(mapToResponse(header));
		}

		return responses;
	}

	// =========================================================
	// UPDATE
	// =========================================================

	@Override
	public C4StructureGaugeResponse updateC4StructureGauge(Long c4StructureGaugeId, C4StructureGaugeRequest request) {

		C4StructureGaugeHeader header = headerRepository.findById(c4StructureGaugeId).orElseThrow(
				() -> new ResourceNotFoundException("C4 Structure Gauge not found with Id : " + c4StructureGaugeId));

		/*
		 * Do not update an already soft-deleted header.
		 */
		if (!Boolean.TRUE.equals(header.getIsActive())) {

			throw new ResourceNotFoundException("C4 Structure Gauge not found with Id : " + c4StructureGaugeId);
		}

		// =====================================================
		// UPDATE HEADER
		// =====================================================

		mapRequestToHeader(request, header);

		header.setUpdatedBy(request.getUpdatedBy());

		header.setUpdatedDate(LocalDateTime.now());

		// =====================================================
		// REQUEST DETAIL IDs
		// =====================================================

		Set<Long> requestDetailIds = request.getDetails() == null ? Set.of()
				: request.getDetails().stream().map(C4StructureGaugeDetailRequest::getC4StructureGaugeDetailId)
						.filter(Objects::nonNull).collect(Collectors.toSet());

		// =====================================================
		// SOFT DELETE REMOVED DETAILS
		// =====================================================

		if (header.getDetails() != null) {

			for (C4StructureGaugeDetail existingDetail : header.getDetails()) {

				Long existingDetailId = existingDetail.getC4StructureGaugeDetailId();

				/*
				 * If an existing detail ID is not present in the request, it has been removed.
				 *
				 * Therefore soft delete it.
				 */
				if (!requestDetailIds.contains(existingDetailId)) {

					if (Boolean.TRUE.equals(existingDetail.getIsActive())) {

						existingDetail.setIsActive(false);

						existingDetail.setUpdatedBy(request.getUpdatedBy());

						existingDetail.setUpdatedDate(LocalDateTime.now());
					}
				}
			}
		}

		// =====================================================
		// INSERT / UPDATE DETAILS
		// =====================================================

		if (request.getDetails() != null) {

			for (C4StructureGaugeDetailRequest dto : request.getDetails()) {

				C4StructureGaugeDetail detail;

				// =================================================
				// UPDATE EXISTING DETAIL
				// =================================================

				if (dto.getC4StructureGaugeDetailId() != null) {

					detail = detailRepository.findById(dto.getC4StructureGaugeDetailId())
							.orElseThrow(() -> new ResourceNotFoundException("C4 Structure Gauge Detail "
									+ "not found with Id : " + dto.getC4StructureGaugeDetailId()));

					/*
					 * Safety check: Make sure this detail belongs to the current header.
					 */
					if (detail.getC4StructureGaugeHeader() == null || !Objects
							.equals(detail.getC4StructureGaugeHeader().getC4StructureGaugeId(), c4StructureGaugeId)) {

						throw new ResourceNotFoundException("C4 Structure Gauge Detail does not "
								+ "belong to C4 Structure Gauge Id : " + c4StructureGaugeId);
					}

					detail.setUpdatedBy(request.getUpdatedBy());

					detail.setUpdatedDate(LocalDateTime.now());

					/*
					 * Existing record remains active.
					 */
					detail.setIsActive(true);
				}

				// =================================================
				// INSERT NEW DETAIL
				// =================================================

				else {

					detail = new C4StructureGaugeDetail();

					detail.setC4StructureGaugeHeader(header);

					detail.setCreatedBy(request.getUpdatedBy());

					detail.setCreatedDate(LocalDateTime.now());

					detail.setIsActive(true);

					/*
					 * Make sure collection exists.
					 */
					if (header.getDetails() == null) {

						header.setDetails(new ArrayList<>());
					}

					header.getDetails().add(detail);
				}

				// =================================================
				// MAP DETAIL DATA
				// =================================================

				mapRequestToDetail(dto, detail);
			}
		}

		// =====================================================
		// SAVE HEADER
		// =====================================================

		C4StructureGaugeHeader savedHeader = headerRepository.save(header);

		/*
		 * Explicitly save details.
		 *
		 * This also makes the implementation independent of CascadeType configuration.
		 */
		if (savedHeader.getDetails() != null && !savedHeader.getDetails().isEmpty()) {

			detailRepository.saveAll(savedHeader.getDetails());
		}

		return mapToResponse(savedHeader);
	}

	// =========================================================
	// DELETE - SOFT DELETE
	// =========================================================

	@Override
	public String deleteC4StructureGauge(Long c4StructureGaugeId, String updatedBy) {

		C4StructureGaugeHeader header = headerRepository.findById(c4StructureGaugeId).orElseThrow(
				() -> new ResourceNotFoundException("C4 Structure Gauge not found with Id : " + c4StructureGaugeId));

		if (!Boolean.TRUE.equals(header.getIsActive())) {

			throw new ResourceNotFoundException("C4 Structure Gauge not found with Id : " + c4StructureGaugeId);
		}

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

			for (C4StructureGaugeDetail detail : header.getDetails()) {

				if (Boolean.TRUE.equals(detail.getIsActive())) {

					detail.setIsActive(false);

					detail.setUpdatedBy(updatedBy);

					detail.setUpdatedDate(LocalDateTime.now());
				}
			}
		}

		headerRepository.save(header);

		if (header.getDetails() != null && !header.getDetails().isEmpty()) {

			detailRepository.saveAll(header.getDetails());
		}

		return "C4 Structure Gauge deleted successfully.";
	}

	// =========================================================
	// CREATE DETAILS
	// =========================================================

	private List<C4StructureGaugeDetail> createDetails(List<C4StructureGaugeDetailRequest> detailRequests,
			C4StructureGaugeHeader header) {

		List<C4StructureGaugeDetail> details = new ArrayList<>();

		if (detailRequests == null) {
			return details;
		}

		for (C4StructureGaugeDetailRequest dto : detailRequests) {

			C4StructureGaugeDetail detail = new C4StructureGaugeDetail();

			detail.setC4StructureGaugeHeader(header);

			mapRequestToDetail(dto, detail);

			detail.setIsActive(true);

			detail.setCreatedBy(header.getCreatedBy());

			detail.setCreatedDate(LocalDateTime.now());

			details.add(detail);
		}

		return details;
	}

	// =========================================================
	// MAP REQUEST TO HEADER
	// =========================================================

	private void mapRequestToHeader(C4StructureGaugeRequest request, C4StructureGaugeHeader header) {

		header.setMeasurementDate(request.getMeasurementDate());

		header.setChainageKm(request.getChainageKm());

		header.setChainageM(request.getChainageM());

		header.setStraightCurve(request.getStraightCurve());

		header.setAppliedCantValue(request.getAppliedCantValue());

		header.setTypeOfTrack(request.getTypeOfTrack());

		// =====================================================
		// Witnesses
		// =====================================================

		header.setNhsrcl(request.getNhsrcl());

		header.setEngineerWitness(request.getEngineerWitness());

		header.setContractorWitness(request.getContractorWitness());

		// =====================================================
		// Remarks
		// =====================================================

		header.setRemarks(request.getRemarks());
	}

	// =========================================================
	// MAP REQUEST TO DETAIL
	// =========================================================

	private void mapRequestToDetail(C4StructureGaugeDetailRequest dto, C4StructureGaugeDetail detail) {

		// =====================================================
		// A
		// =====================================================

		detail.setAMeasured(dto.getAMeasured());

		detail.setAStandard(dto.getAStandard());

		detail.setAMeasuredTotal(dto.getAMeasuredTotal());

		// =====================================================
		// B
		// =====================================================

		detail.setBDesign(dto.getBDesign());

		detail.setBMeasured(dto.getBMeasured());

		// =====================================================
		// C
		// =====================================================

		detail.setCMeasured(dto.getCMeasured());

		detail.setCCalculated(dto.getCCalculated());

		detail.setCStandard(dto.getCStandard());

		detail.setCMeasuredTotal(dto.getCMeasuredTotal());

		// =====================================================
		// D
		// =====================================================

		detail.setDMeasured(dto.getDMeasured());

		detail.setDStandard(dto.getDStandard());

		detail.setDMeasuredTotal(dto.getDMeasuredTotal());

		// =====================================================
		// E
		// =====================================================

		detail.setEDesign(dto.getEDesign());

		detail.setEMeasured(dto.getEMeasured());

		// =====================================================
		// F
		// =====================================================

		detail.setFMeasured(dto.getFMeasured());

		detail.setFCalculated(dto.getFCalculated());

		detail.setFStandard(dto.getFStandard());

		detail.setFMeasuredTotal(dto.getFMeasuredTotal());

		// =====================================================
		// Remarks
		// =====================================================

		detail.setRemarks(dto.getRemarks());
	}

	// =========================================================
	// MAP ENTITY TO RESPONSE
	// =========================================================

	private C4StructureGaugeResponse mapToResponse(C4StructureGaugeHeader header) {

		C4StructureGaugeResponse response = new C4StructureGaugeResponse();

		// =====================================================
		// Header
		// =====================================================

		response.setC4StructureGaugeId(header.getC4StructureGaugeId());

		response.setMeasurementDate(header.getMeasurementDate());

		response.setChainageKm(header.getChainageKm());

		response.setChainageM(header.getChainageM());

		response.setStraightCurve(header.getStraightCurve());

		response.setAppliedCantValue(header.getAppliedCantValue());

		response.setTypeOfTrack(header.getTypeOfTrack());

		// =====================================================
		// Witnesses
		// =====================================================

		response.setNhsrcl(header.getNhsrcl());

		response.setEngineerWitness(header.getEngineerWitness());

		response.setContractorWitness(header.getContractorWitness());

		// =====================================================
		// Remarks
		// =====================================================

		response.setRemarks(header.getRemarks());

		// =====================================================
		// Audit
		// =====================================================

		response.setIsActive(header.getIsActive());

		response.setCreatedBy(header.getCreatedBy());

		response.setCreatedDate(header.getCreatedDate());

		response.setUpdatedBy(header.getUpdatedBy());

		response.setUpdatedDate(header.getUpdatedDate());

		// =====================================================
		// Details
		// =====================================================

		List<C4StructureGaugeDetailResponse> detailResponses = new ArrayList<>();

		if (header.getDetails() != null) {

			for (C4StructureGaugeDetail detail : header.getDetails()) {

				/*
				 * Do not return soft-deleted details.
				 */
				if (!Boolean.TRUE.equals(detail.getIsActive())) {

					continue;
				}

				C4StructureGaugeDetailResponse detailResponse = new C4StructureGaugeDetailResponse();

				detailResponse.setC4StructureGaugeDetailId(detail.getC4StructureGaugeDetailId());

				// =================================================
				// A
				// =================================================

				detailResponse.setAMeasured(detail.getAMeasured());

				detailResponse.setAStandard(detail.getAStandard());

				detailResponse.setATotalMeasured(detail.getAMeasuredTotal());

				// =================================================
				// B
				// =================================================

				detailResponse.setBDesign(detail.getBDesign());

				detailResponse.setBMeasured(detail.getBMeasured());

				// =================================================
				// C
				// =================================================

				detailResponse.setCMeasured(detail.getCMeasured());

				detailResponse.setCCalculated(detail.getCCalculated());

				detailResponse.setCStandard(detail.getCStandard());

				detailResponse.setCTotalMeasured(detail.getCMeasuredTotal());

				// =================================================
				// D
				// =================================================

				detailResponse.setDMeasured(detail.getDMeasured());

				detailResponse.setDStandard(detail.getDStandard());

				detailResponse.setDTotalMeasured(detail.getDMeasuredTotal());

				// =================================================
				// E
				// =================================================

				detailResponse.setEDesign(detail.getEDesign());

				detailResponse.setEMeasured(detail.getEMeasured());

				// =================================================
				// F
				// =================================================

				detailResponse.setFMeasured(detail.getFMeasured());

				detailResponse.setFCalculated(detail.getFCalculated());

				detailResponse.setFStandard(detail.getFStandard());

				detailResponse.setFTotalMeasured(detail.getFMeasuredTotal());

				// =================================================
				// Remarks
				// =================================================

				detailResponse.setRemarks(detail.getRemarks());

				detailResponses.add(detailResponse);
			}
		}

		response.setDetails(detailResponses);

		// =====================================================
		// INSPECTION WORKFLOW
		// =====================================================

		try {

			InspectionWorkflowResponse workflow = inspectionWorkflowService
					.getWorkflow(WorkflowConstants.C4_STRUCTURE_GAUGE_FORM_ID, header.getC4StructureGaugeId());

			response.setWorkflow(workflow);

		} catch (RuntimeException ex) {

			// Workflow not created yet
			response.setWorkflow(null);
		}

		return response;
	}
}
