package com.synergiz.itctc.service;

import org.springframework.web.multipart.MultipartFile;

import com.synergiz.itctc.dto.request.InspectionFormCaptureRequest;
import com.synergiz.itctc.dto.response.InspectionFormCaptureResponse;


public interface InspectionFormCaptureService {

	InspectionFormCaptureResponse saveInspectionFormCapture(InspectionFormCaptureRequest request,MultipartFile selfie,String formCode);

	InspectionFormCaptureResponse updateInspectionFormCapture(Integer inspectionFormId, Long referenceId,
			InspectionFormCaptureRequest request);
}