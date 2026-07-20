package com.synergiz.itctc.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class FasteningBoltResponse {

    private Long fasteningBoltHeaderId;

    private Integer projectId;

    private String formNo;

    private String recordNo;

    private LocalDate inspectionDate;

    private String createdBy;

    private LocalDateTime createdDate;

    private List<FasteningBoltDetailResponse> details;

	public Long getFasteningBoltHeaderId() {
		return fasteningBoltHeaderId;
	}

	public void setFasteningBoltHeaderId(Long fasteningBoltHeaderId) {
		this.fasteningBoltHeaderId = fasteningBoltHeaderId;
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

	public List<FasteningBoltDetailResponse> getDetails() {
		return details;
	}

	public void setDetails(List<FasteningBoltDetailResponse> details) {
		this.details = details;
	}
    
    
}