package com.synergiz.itctc.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CamMeasurementResponse {

    private Long camMeasurementHeaderId;

    private Integer projectId;

    public Long getCamMeasurementHeaderId() {
		return camMeasurementHeaderId;
	}

	public void setCamMeasurementHeaderId(Long camMeasurementHeaderId) {
		this.camMeasurementHeaderId = camMeasurementHeaderId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getFormNo() {
		return formNo;
	}

	public void setFormNo(String formNo) {
		this.formNo = formNo;
	}

	public String getRecordNo() {
		return recordNo;
	}

	public void setRecordNo(String recordNo) {
		this.recordNo = recordNo;
	}

	public LocalDate getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(LocalDate inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public List<CamMeasurementDetailResponse> getDetails() {
		return details;
	}

	public void setDetails(List<CamMeasurementDetailResponse> details) {
		this.details = details;
	}

	private String formNo;

    private String recordNo;

    private LocalDate inspectionDate;

    private String createdBy;

    private LocalDateTime createdDate;

    private List<CamMeasurementDetailResponse> details;
}