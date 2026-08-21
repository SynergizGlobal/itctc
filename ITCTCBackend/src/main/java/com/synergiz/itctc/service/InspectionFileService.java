package com.synergiz.itctc.service;

import org.springframework.web.multipart.MultipartFile;

import com.synergiz.itctc.dto.request.InspectionFileRequest;
import com.synergiz.itctc.dto.response.InspectionFileResponse;

public interface InspectionFileService {

	InspectionFileResponse saveInspectionFile(InspectionFileRequest request, MultipartFile file, int attachmentNumber,
			String formCode);

	InspectionFileResponse updateInspectionFile(Long inspectionFileId, InspectionFileRequest request);
}