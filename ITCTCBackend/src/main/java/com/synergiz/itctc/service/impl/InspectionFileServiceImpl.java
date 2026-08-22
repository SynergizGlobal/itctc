package com.synergiz.itctc.service.impl;

import java.time.LocalDateTime;
import java.util.List;

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
		entity.setCreatedBy(request.getCreatedBy());
		entity.setCreatedDate(LocalDateTime.now());

		// =====================================================
		// SAVE DB
		// =====================================================

		InspectionFile savedEntity = inspectionFileRepository.save(entity);

		return mapToResponse(savedEntity);
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

	@Override
	public void addInspectionFiles(Integer inspectionFormId, Long referenceId, List<MultipartFile> attachments,
			String createdBy, String formCode) {

		// =====================================================
		// FIND EXISTING ATTACHMENTS
		// =====================================================

		List<InspectionFile> existingFiles = inspectionFileRepository
				.findByInspectionFormIdAndReferenceIdAndIsActiveTrue(inspectionFormId, referenceId);

		// =====================================================
		// NEXT ATTACHMENT NUMBER
		// =====================================================

		int attachmentNumber = existingFiles.size() + 1;

		// =====================================================
		// SAVE NEW ATTACHMENTS
		// =====================================================

		for (MultipartFile file : attachments) {

			if (file == null || file.isEmpty()) {
				continue;
			}

			InspectionFileRequest fileRequest = new InspectionFileRequest();

			fileRequest.setInspectionFormId(inspectionFormId);
			fileRequest.setReferenceId(referenceId);
			fileRequest.setCreatedBy(createdBy);

			saveInspectionFile(fileRequest, file, attachmentNumber, formCode);

			attachmentNumber++;
		}
	}
}