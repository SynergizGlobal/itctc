package com.synergiz.itctc.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class SyntheticResinInjectionResponse {

    private Long syntheticResinInjectionHeaderId;

    private Integer projectId;

    private String formNo;

    private String recordNo;

    private LocalDate inspectionDate;

    private String createdBy;

    private LocalDateTime createdDate;

    private List<SyntheticResinInjectionDetailResponse> details;

	public Long getSyntheticResinInjectionHeaderId() {
		return syntheticResinInjectionHeaderId;
	}

	public void setSyntheticResinInjectionHeaderId(Long syntheticResinInjectionHeaderId) {
		this.syntheticResinInjectionHeaderId = syntheticResinInjectionHeaderId;
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

	public List<SyntheticResinInjectionDetailResponse> getDetails() {
		return details;
	}

	public void setDetails(List<SyntheticResinInjectionDetailResponse> details) {
		this.details = details;
	}
    
    
}