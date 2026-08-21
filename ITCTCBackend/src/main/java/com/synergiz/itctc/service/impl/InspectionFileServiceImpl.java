package com.synergiz.itctc.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.synergiz.itctc.dto.request.InspectionFileRequest;
import com.synergiz.itctc.dto.response.InspectionFileResponse;
import com.synergiz.itctc.entity.InspectionFile;
import com.synergiz.itctc.repository.InspectionFileRepository;
import com.synergiz.itctc.service.InspectionFileService;
import com.synergiz.itctc.service.InspectionFileStorageService;

@Service
@Transactional
public class InspectionFileServiceImpl implements InspectionFileService {

	private final InspectionFileRepository inspectionFileRepository;
	private final InspectionFileStorageService inspectionFileStorageService;

	public InspectionFileServiceImpl(InspectionFileRepository inspectionFileRepository,
			InspectionFileStorageService inspectionFileStorageService) {

		this.inspectionFileRepository = inspectionFileRepository;
		this.inspectionFileStorageService = inspectionFileStorageService;
	}

	// =========================================================
	// SAVE
	// =========================================================

	@Override
	@Transactional
	public InspectionFileResponse saveInspectionFile(InspectionFileRequest request, MultipartFile file,
			int attachmentNumber, String formCode) {

		if (request.getInspectionFormId() == null) {
			throw new IllegalArgumentException("Inspection Form Id is required.");
		}

		if (request.getReferenceId() == null) {
			throw new IllegalArgumentException("Reference Id is required.");
		}

		if (file == null || file.isEmpty()) {
			throw new IllegalArgumentException("Attachment file is required.");
		}

		if (formCode == null || formCode.trim().isEmpty()) {
			throw new IllegalArgumentException("Form code is required.");
		}

		// =====================================================
		// SAVE PHYSICAL FILE
		// =====================================================

		String generatedFileName = inspectionFileStorageService.saveAttachment(file, formCode, request.getReferenceId(),
				attachmentNumber);

		// =====================================================
		// CREATE ENTITY
		// =====================================================

		InspectionFile entity = new InspectionFile();

		entity.setInspectionFormId(request.getInspectionFormId());

		entity.setReferenceId(request.getReferenceId());

		// =====================================================
		// FILE
		// =====================================================

		entity.setFileName(generatedFileName);

		entity.setContentType(file.getContentType());

		// =====================================================
		// AUDIT
		// =====================================================

		entity.setIsActive(true);
		entity.setCreatedDate(LocalDateTime.now());

		// =====================================================
		// SAVE DB
		// =====================================================

		InspectionFile savedEntity = inspectionFileRepository.save(entity);

		return mapToResponse(savedEntity);
	}

	// =========================================================
	// UPDATE
	// =========================================================

	@Override
	public InspectionFileResponse updateInspectionFile(Long inspectionFileId, InspectionFileRequest request) {

		InspectionFile entity = inspectionFileRepository.findById(inspectionFileId)
				.orElseThrow(() -> new RuntimeException("Inspection file not found for id: " + inspectionFileId));

		// =====================================================
		// FILE
		// =====================================================

		entity.setFileName(request.getFileName());

		entity.setContentType(request.getContentType());

		// =====================================================
		// AUDIT
		// =====================================================

		entity.setUpdatedDate(LocalDateTime.now());

		// If updatedBy is available from request/security context,
		// set it here.

		// entity.setUpdatedBy(...);

		InspectionFile updatedEntity = inspectionFileRepository.save(entity);

		return mapToResponse(updatedEntity);
	}

	// =========================================================
	// ENTITY -> RESPONSE DTO
	// =========================================================

	private InspectionFileResponse mapToResponse(InspectionFile entity) {

		InspectionFileResponse response = new InspectionFileResponse();

		response.setInspectionFileId(entity.getInspectionFileId());

		response.setInspectionFormId(entity.getInspectionFormId());

		response.setReferenceId(entity.getReferenceId());

		response.setFileName(entity.getFileName());

		response.setContentType(entity.getContentType());

		response.setIsActive(entity.getIsActive());

		response.setCreatedBy(entity.getCreatedBy());

		response.setCreatedDate(entity.getCreatedDate());

		response.setUpdatedBy(entity.getUpdatedBy());

		response.setUpdatedDate(entity.getUpdatedDate());

		return response;
	}
}