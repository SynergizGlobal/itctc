package com.synergiz.itctc.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.synergiz.itctc.dto.request.InspectionFormCaptureRequest;
import com.synergiz.itctc.dto.response.InspectionFormCaptureResponse;
import com.synergiz.itctc.entity.InspectionFormCapture;
import com.synergiz.itctc.repository.InspectionFormCaptureRepository;
import com.synergiz.itctc.service.InspectionFileStorageService;
import com.synergiz.itctc.service.InspectionFormCaptureService;
import jakarta.transaction.Transactional;

@Service
public class InspectionFormCaptureServiceImpl implements InspectionFormCaptureService {

	private final InspectionFormCaptureRepository inspectionFormCaptureRepository;
	private final InspectionFileStorageService inspectionFileStorageService;

	public InspectionFormCaptureServiceImpl(InspectionFormCaptureRepository inspectionFormCaptureRepository,
			InspectionFileStorageService inspectionFileStorageService) {

		this.inspectionFormCaptureRepository = inspectionFormCaptureRepository;
		this.inspectionFileStorageService = inspectionFileStorageService;
	}

	// =========================================================
	// SAVE INSPECTION FORM CAPTURE
	// =========================================================

	@Override
	@Transactional
	public InspectionFormCaptureResponse saveInspectionFormCapture(InspectionFormCaptureRequest request,
			MultipartFile selfie, String formCode) {

		if (request.getInspectionFormId() == null) {
			throw new IllegalArgumentException("Inspection Form Id is required.");
		}

		if (request.getReferenceId() == null) {
			throw new IllegalArgumentException("Reference Id is required.");
		}

		if (selfie == null || selfie.isEmpty()) {
			throw new IllegalArgumentException("Selfie file is required.");
		}

		if (formCode == null || formCode.trim().isEmpty()) {
			throw new IllegalArgumentException("Form code is required.");
		}

		// =====================================================
		// SAVE PHYSICAL SELFIE
		// =====================================================

		String generatedFileName = inspectionFileStorageService.saveSelfie(selfie, formCode, request.getReferenceId());

		// =====================================================
		// CREATE ENTITY
		// =====================================================

		InspectionFormCapture entity = new InspectionFormCapture();

		entity.setInspectionFormId(request.getInspectionFormId());

		entity.setReferenceId(request.getReferenceId());

		// =====================================================
		// LOCATION
		// =====================================================

		entity.setLatitude(request.getLatitude());
		entity.setLongitude(request.getLongitude());
		entity.setLocationAddress(request.getLocationAddress());
		entity.setLocationCapturedAt(request.getLocationCapturedAt());

		// =====================================================
		// SELFIE
		// =====================================================

		entity.setSelfieFileName(generatedFileName);
		entity.setSelfieContentType(selfie.getContentType());

		// =====================================================
		// AUDIT
		// =====================================================

		entity.setIsActive(true);
		entity.setCreatedDate(LocalDateTime.now());

		// =====================================================
		// SAVE DB
		// =====================================================

		InspectionFormCapture savedEntity = inspectionFormCaptureRepository.save(entity);

		return mapToResponse(savedEntity);
	}

	// =========================================================
	// UPDATE
	// =========================================================
	@Override
	public InspectionFormCaptureResponse updateInspectionFormCapture(Integer inspectionFormId, Long referenceId,
			InspectionFormCaptureRequest request) {

		InspectionFormCapture entity = inspectionFormCaptureRepository
				.findByInspectionFormIdAndReferenceIdAndIsActiveTrue(inspectionFormId, referenceId)
				.orElseThrow(() -> new RuntimeException("Inspection form capture not found for " + "inspectionFormId: "
						+ inspectionFormId + " and referenceId: " + referenceId));

		// =====================================================
		// LOCATION
		// =====================================================

		entity.setLatitude(request.getLatitude());

		entity.setLongitude(request.getLongitude());

		entity.setLocationAddress(request.getLocationAddress());

		entity.setLocationCapturedAt(request.getLocationCapturedAt());

		// =====================================================
		// SELFIE
		// =====================================================

		entity.setSelfieFileName(request.getSelfieFileName());

		entity.setSelfieContentType(request.getSelfieContentType());

		// =====================================================
		// AUDIT
		// =====================================================

		entity.setUpdatedDate(LocalDateTime.now());

		// If updatedBy is available from request/security context,
		// set it here.

		// entity.setUpdatedBy(...);

		InspectionFormCapture updatedEntity = inspectionFormCaptureRepository.save(entity);

		return mapToResponse(updatedEntity);
	}

	// =========================================================
	// ENTITY -> RESPONSE DTO
	// =========================================================

	private InspectionFormCaptureResponse mapToResponse(InspectionFormCapture entity) {

		InspectionFormCaptureResponse response = new InspectionFormCaptureResponse();

		response.setInspectionFormCaptureId(entity.getInspectionFormCaptureId());

		response.setInspectionFormId(entity.getInspectionFormId());

		response.setReferenceId(entity.getReferenceId());

		response.setLatitude(entity.getLatitude());

		response.setLongitude(entity.getLongitude());

		response.setLocationAddress(entity.getLocationAddress());

		response.setLocationCapturedAt(entity.getLocationCapturedAt());

		response.setSelfieFileName(entity.getSelfieFileName());

		response.setSelfieContentType(entity.getSelfieContentType());

		response.setIsActive(entity.getIsActive());

		response.setCreatedBy(entity.getCreatedBy());

		response.setCreatedDate(entity.getCreatedDate());

		response.setUpdatedBy(entity.getUpdatedBy());

		response.setUpdatedDate(entity.getUpdatedDate());

		return response;
	}

}
