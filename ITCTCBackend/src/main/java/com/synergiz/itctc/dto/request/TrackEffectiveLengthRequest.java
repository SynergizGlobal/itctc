package com.synergiz.itctc.dto.request;

import java.time.LocalDate;
import java.util.List;

public class TrackEffectiveLengthRequest {

    private Integer projectId;

    private String formNo;

    private String location;

    private LocalDate inspectionDate;

    private String createdBy;

    private String updatedBy;

    private List<TrackEffectiveLengthDetailRequest> details;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<TrackEffectiveLengthDetailRequest> getDetails() {
		return details;
	}

	public void setDetails(List<TrackEffectiveLengthDetailRequest> details) {
		this.details = details;
	}
    
    
}