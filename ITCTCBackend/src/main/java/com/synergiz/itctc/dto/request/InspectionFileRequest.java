package com.synergiz.itctc.dto.request;

public class InspectionFileRequest {

	// =========================================================
	// FORM REFERENCE
	// =========================================================

	private Integer inspectionFormId;

	private Long referenceId;

	// =========================================================
	// FILE
	// =========================================================

	private String fileName;

	private String contentType;

	// =========================================================
	// Getters / Setters
	// =========================================================

	public Integer getInspectionFormId() {
		return inspectionFormId;
	}

	public void setInspectionFormId(Integer inspectionFormId) {
		this.inspectionFormId = inspectionFormId;
	}

	public Long getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}