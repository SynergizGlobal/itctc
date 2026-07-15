package com.synergiz.itctc.dto.request;

import java.time.LocalDate;
import java.util.List;

public class BufferStopRequest {

    private Integer projectId;

    private String formNo;

    private String lineName;

    private LocalDate inspectionDate;

    private String createdBy;

    private String updatedBy;

    private List<BufferStopDetailRequest> details;

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

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
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

	public List<BufferStopDetailRequest> getDetails() {
		return details;
	}

	public void setDetails(List<BufferStopDetailRequest> details) {
		this.details = details;
	}
    
    
}