package com.synergiz.itctc.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.synergiz.itctc.dto.request.InspectionFileRequest;
import com.synergiz.itctc.dto.response.InspectionFileResponse;

public interface InspectionFileService {

	InspectionFileResponse saveInspectionFile(InspectionFileRequest request, MultipartFile file, int attachmentNumber,
			String formCode);

	void addInspectionFiles(Integer inspectionFormId, Long referenceId, List<MultipartFile> attachments,
			String createdBy, String formCode);
}