package com.synergiz.itctc.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synergiz.itctc.dto.request.C2FormationWidthTunnelDetailRequest;
import com.synergiz.itctc.dto.request.C2FormationWidthTunnelRequest;
import com.synergiz.itctc.dto.response.C2FormationWidthTunnelDetailResponse;
import com.synergiz.itctc.dto.response.C2FormationWidthTunnelResponse;
import com.synergiz.itctc.entity.C2FormationWidthTunnelDetail;
import com.synergiz.itctc.entity.C2FormationWidthTunnelHeader;
import com.synergiz.itctc.exception.ResourceNotFoundException;
import com.synergiz.itctc.repository.C2FormationWidthTunnelDetailRepository;
import com.synergiz.itctc.repository.C2FormationWidthTunnelHeaderRepository;
import com.synergiz.itctc.service.C2FormationWidthTunnelService;
import com.synergiz.itctc.service.InspectionWorkflowService;
import com.synergiz.itctc.dto.response.InspectionWorkflowResponse;
import com.synergiz.itctc.constants.WorkflowConstants;

@Service
@Transactional
public class C2FormationWidthTunnelServiceImpl implements C2FormationWidthTunnelService {

	private final C2FormationWidthTunnelHeaderRepository headerRepository;

	private final C2FormationWidthTunnelDetailRepository detailRepository;

	private final InspectionWorkflowService inspectionWorkflowService;

	public C2FormationWidthTunnelServiceImpl(C2FormationWidthTunnelHeaderRepository headerRepository,
			C2FormationWidthTunnelDetailRepository detailRepository,
			InspectionWorkflowService inspectionWorkflowService) {

		this.headerRepository = headerRepository;
		this.detailRepository = detailRepository;
		this.inspectionWorkflowService = inspectionWorkflowService;
	}

	// =========================================================
	// SAVE
	// =========================================================

	@Override
	public C2FormationWidthTunnelResponse saveC2FormationWidthTunnel(C2FormationWidthTunnelRequest request) {

		C2FormationWidthTunnelHeader header = new C2FormationWidthTunnelHeader();

		mapRequestToHeader(request, header);

		header.setIsActive(true);
		header.setCreatedBy(request.getCreatedBy());
		header.setCreatedDate(LocalDateTime.now());

		List<C2FormationWidthTunnelDetail> details = createDetails(request.getDetails(), header);

		header.setDetails(details);

		C2FormationWidthTunnelHeader savedHeader = headerRepository.save(header);

		return mapToResponse(savedHeader);
	}

	// =========================================================
	// GET BY ID
	// =========================================================

	@Override
	@Transactional(readOnly = true)
	public C2FormationWidthTunnelResponse getC2FormationWidthTunnel(Long c2FormationWidthTunnelId) {

		C2FormationWidthTunnelHeader header = headerRepository.findById(c2FormationWidthTunnelId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"C2 Formation Width Tunnel not found with Id : " + c2FormationWidthTunnelId));

		if (!Boolean.TRUE.equals(header.getIsActive())) {

			throw new ResourceNotFoundException(
					"C2 Formation Width Tunnel not found with Id : " + c2FormationWidthTunnelId);
		}

		return mapToResponse(header);
	}

	// =========================================================
	// GET ALL
	// =========================================================

	@Override
	@Transactional(readOnly = true)
	public List<C2FormationWidthTunnelResponse> getAllC2FormationWidthTunnels() {

		List<C2FormationWidthTunnelHeader> headers = headerRepository.findByIsActiveTrue();

		List<C2FormationWidthTunnelResponse> responses = new ArrayList<>();

		for (C2FormationWidthTunnelHeader header : headers) {

			responses.add(mapToResponse(header));
		}

		return responses;
	}

	// =========================================================
	// UPDATE
	// =========================================================

	@Override
	@Transactional
	public C2FormationWidthTunnelResponse updateC2FormationWidthTunnel(Long c2FormationWidthTunnelId,
			C2FormationWidthTunnelRequest request) {

		C2FormationWidthTunnelHeader header = headerRepository.findById(c2FormationWidthTunnelId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"C2 Formation Width Tunnel not found with Id : " + c2FormationWidthTunnelId));

		// =====================================================
		// CHECK HEADER ACTIVE
		// =====================================================

		if (!Boolean.TRUE.equals(header.getIsActive())) {

			throw new ResourceNotFoundException(
					"C2 Formation Width Tunnel not found with Id : " + c2FormationWidthTunnelId);
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
				: request.getDetails().stream()
						.map(C2FormationWidthTunnelDetailRequest::getC2FormationWidthTunnelDetailId)
						.filter(Objects::nonNull).collect(Collectors.toSet());

		// =====================================================
		// SOFT DELETE REMOVED DETAILS
		// =====================================================

		if (header.getDetails() != null) {

			for (C2FormationWidthTunnelDetail existingDetail : header.getDetails()) {

				if (!Boolean.TRUE.equals(existingDetail.getIsActive())) {
					continue;
				}

				Long existingDetailId = existingDetail.getC2FormationWidthTunnelDetailId();

				if (!requestDetailIds.contains(existingDetailId)) {

					existingDetail.setIsActive(false);
					existingDetail.setUpdatedBy(request.getUpdatedBy());
					existingDetail.setUpdatedDate(LocalDateTime.now());
				}
			}
		}

		// =====================================================
		// INSERT / UPDATE DETAILS
		// =====================================================

		if (request.getDetails() != null) {

			for (C2FormationWidthTunnelDetailRequest dto : request.getDetails()) {

				C2FormationWidthTunnelDetail detail = null;

				// =================================================
				// UPDATE EXISTING DETAIL
				// =================================================

				if (dto.getC2FormationWidthTunnelDetailId() != null) {

					Long detailId = dto.getC2FormationWidthTunnelDetailId();

					// Find detail from current header
					if (header.getDetails() != null) {

						for (C2FormationWidthTunnelDetail existingDetail : header.getDetails()) {

							if (detailId.equals(existingDetail.getC2FormationWidthTunnelDetailId())) {

								detail = existingDetail;
								break;
							}
						}
					}

					// Detail does not belong to this header
					if (detail == null) {

						throw new ResourceNotFoundException("C2 Formation Width Tunnel Detail not found "
								+ "for Header Id : " + c2FormationWidthTunnelId + " and Detail Id : " + detailId);
					}

					// Update audit fields
					detail.setUpdatedBy(request.getUpdatedBy());
					detail.setUpdatedDate(LocalDateTime.now());
					detail.setIsActive(true);
				}

				// =================================================
				// INSERT NEW DETAIL
				// =================================================

				else {

					detail = new C2FormationWidthTunnelDetail();

					detail.setC2FormationWidthTunnelHeader(header);

					detail.setIsActive(true);

					detail.setCreatedBy(request.getUpdatedBy());

					detail.setCreatedDate(LocalDateTime.now());

					header.getDetails().add(detail);
				}

				// =================================================
				// MAP DETAIL DATA
				// =================================================

				mapRequestToDetail(dto, detail);
			}
		}

		// =====================================================
		// SAVE
		// =====================================================

		C2FormationWidthTunnelHeader savedHeader = headerRepository.save(header);

		return mapToResponse(savedHeader);
	}
	// =========================================================
	// DELETE - SOFT DELETE
	// =========================================================

	@Override
	public void deleteC2FormationWidthTunnel(Long c2FormationWidthTunnelId, String updatedBy) {

		C2FormationWidthTunnelHeader header = headerRepository.findById(c2FormationWidthTunnelId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"C2 Formation Width Tunnel not found with Id : " + c2FormationWidthTunnelId));

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

			for (C2FormationWidthTunnelDetail detail : header.getDetails()) {

				detail.setIsActive(false);
				detail.setUpdatedBy(updatedBy);
				detail.setUpdatedDate(LocalDateTime.now());
			}
		}

		headerRepository.save(header);
	}

	// =========================================================
	// MAP REQUEST TO HEADER
	// =========================================================

	private void mapRequestToHeader(C2FormationWidthTunnelRequest request, C2FormationWidthTunnelHeader header) {

		header.setMeasurementDate(request.getMeasurementDate());

		header.setChainageKm(request.getChainageKm());

		header.setChainageM(request.getChainageM());

		header.setStraightCurve(request.getStraightCurve());

		header.setShiftValue(request.getShiftValue());

		header.setAppliedCantValue(request.getAppliedCantValue());

		header.setTypeOfTrack(request.getTypeOfTrack());

		// Witnesses

		header.setNhsrcl(request.getNhsrcl());

		header.setEngineerWitness(request.getEngineerWitness());

		header.setContractorWitness(request.getContractorWitness());

		header.setRemarks(request.getRemarks());
	}

	// =========================================================
	// CREATE DETAILS
	// =========================================================

	private List<C2FormationWidthTunnelDetail> createDetails(List<C2FormationWidthTunnelDetailRequest> detailRequests,
			C2FormationWidthTunnelHeader header) {

		List<C2FormationWidthTunnelDetail> details = new ArrayList<>();

		if (detailRequests == null) {
			return details;
		}

		for (C2FormationWidthTunnelDetailRequest dto : detailRequests) {

			C2FormationWidthTunnelDetail detail = new C2FormationWidthTunnelDetail();

			detail.setC2FormationWidthTunnelHeader(header);

			mapRequestToDetail(dto, detail);

			detail.setIsActive(true);

			detail.setCreatedBy(header.getCreatedBy());

			detail.setCreatedDate(LocalDateTime.now());

			details.add(detail);
		}

		return details;
	}

	// =========================================================
	// MAP REQUEST TO DETAIL
	// =========================================================

	private void mapRequestToDetail(C2FormationWidthTunnelDetailRequest dto, C2FormationWidthTunnelDetail detail) {

		// A = a + X

		detail.setAMeasured(dto.getAMeasured());

		detail.setX1Calculated(dto.getX1Calculated());

		detail.setATotalStandard(dto.getATotalStandard());

		detail.setATotalMeasured(dto.getATotalMeasured());

		// B = b (or b')

		detail.setBMeasured(dto.getBMeasured());

		detail.setBPrimeMeasured(dto.getBPrimeMeasured());

		detail.setBTotalStandard(dto.getBTotalStandard());

		detail.setBTotalMeasured(dto.getBTotalMeasured());

		// C = c + X

		detail.setCMeasured(dto.getCMeasured());

		detail.setX2Calculated(dto.getX2Calculated());

		detail.setCTotalStandard(dto.getCTotalStandard());

		detail.setCTotalMeasured(dto.getCTotalMeasured());

		// Elevation / Height

		detail.setH1Measured(dto.getH1Measured());

		detail.setHr1SettingValue(dto.getHr1SettingValue());

		detail.setDeltaH1Calculated(dto.getDeltaH1Calculated());

		detail.setH2Measured(dto.getH2Measured());

		detail.setHr2SettingValue(dto.getHr2SettingValue());

		detail.setDeltaH2Calculated(dto.getDeltaH2Calculated());

		detail.setDifferenceElevationCalculated(dto.getDifferenceElevationCalculated());

		detail.setH3Measured(dto.getH3Measured());

		detail.setEStandard(dto.getEStandard());

		detail.setEMeasured(dto.getEMeasured());

		detail.setRemarks(dto.getRemarks());
	}

	// =========================================================
	// MAP ENTITY TO RESPONSE
	// =========================================================

	private C2FormationWidthTunnelResponse mapToResponse(C2FormationWidthTunnelHeader header) {

		C2FormationWidthTunnelResponse response = new C2FormationWidthTunnelResponse();

		// =====================================================
		// HEADER
		// =====================================================

		response.setC2FormationWidthTunnelId(header.getC2FormationWidthTunnelId());

		response.setMeasurementDate(header.getMeasurementDate());

		response.setChainageKm(header.getChainageKm());

		response.setChainageM(header.getChainageM());

		response.setStraightCurve(header.getStraightCurve());

		response.setShiftValue(header.getShiftValue());

		response.setAppliedCantValue(header.getAppliedCantValue());

		response.setTypeOfTrack(header.getTypeOfTrack());

		// Witnesses

		response.setNhsrcl(header.getNhsrcl());

		response.setEngineerWitness(header.getEngineerWitness());

		response.setContractorWitness(header.getContractorWitness());

		response.setRemarks(header.getRemarks());

		// =====================================================
		// AUDIT
		// =====================================================

		response.setIsActive(header.getIsActive());

		response.setCreatedBy(header.getCreatedBy());

		response.setCreatedDate(header.getCreatedDate());

		response.setUpdatedBy(header.getUpdatedBy());

		response.setUpdatedDate(header.getUpdatedDate());

		// =====================================================
		// DETAILS
		// =====================================================

		List<C2FormationWidthTunnelDetailResponse> detailResponses = new ArrayList<>();

		if (header.getDetails() != null) {

			for (C2FormationWidthTunnelDetail detail : header.getDetails()) {

				// IMPORTANT:
				// Do not return soft-deleted details.

				if (!Boolean.TRUE.equals(detail.getIsActive())) {

					continue;
				}

				C2FormationWidthTunnelDetailResponse detailResponse = new C2FormationWidthTunnelDetailResponse();

				detailResponse.setC2FormationWidthTunnelDetailId(detail.getC2FormationWidthTunnelDetailId());

				// A = a + X

				detailResponse.setAMeasured(detail.getAMeasured());

				detailResponse.setX1Calculated(detail.getX1Calculated());

				detailResponse.setATotalStandard(detail.getATotalStandard());

				detailResponse.setATotalMeasured(detail.getATotalMeasured());

				// B = b (or b')

				detailResponse.setBMeasured(detail.getBMeasured());

				detailResponse.setBPrimeMeasured(detail.getBPrimeMeasured());

				detailResponse.setBTotalStandard(detail.getBTotalStandard());

				detailResponse.setBTotalMeasured(detail.getBTotalMeasured());

				// C = c + X

				detailResponse.setCMeasured(detail.getCMeasured());

				detailResponse.setX2Calculated(detail.getX2Calculated());

				detailResponse.setCTotalStandard(detail.getCTotalStandard());

				detailResponse.setCTotalMeasured(detail.getCTotalMeasured());

				// Elevation / Height

				detailResponse.setH1Measured(detail.getH1Measured());

				detailResponse.setHr1SettingValue(detail.getHr1SettingValue());

				detailResponse.setDeltaH1Calculated(detail.getDeltaH1Calculated());

				detailResponse.setH2Measured(detail.getH2Measured());

				detailResponse.setHr2SettingValue(detail.getHr2SettingValue());

				detailResponse.setDeltaH2Calculated(detail.getDeltaH2Calculated());

				detailResponse.setDifferenceElevationCalculated(detail.getDifferenceElevationCalculated());

				detailResponse.setH3Measured(detail.getH3Measured());

				detailResponse.setEStandard(detail.getEStandard());

				detailResponse.setEMeasured(detail.getEMeasured());

				detailResponse.setRemarks(detail.getRemarks());

				detailResponses.add(detailResponse);
			}
		}

		response.setDetails(detailResponses);

		// =====================================================
		// INSPECTION WORKFLOW
		// =====================================================

		try {

			InspectionWorkflowResponse workflow = inspectionWorkflowService.getWorkflow(
					WorkflowConstants.C2_FORMATION_WIDTH_TUNNEL_FORM_ID, header.getC2FormationWidthTunnelId());

			response.setWorkflow(workflow);

		} catch (RuntimeException ex) {

			// Workflow not created yet.
			response.setWorkflow(null);
		}

		return response;
	}
}