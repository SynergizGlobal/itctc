package com.synergiz.itctc.dto.response;

import java.time.LocalDateTime;

public class InspectionWorkflowResponse {

	private Long inspectionWorkflowId;

	private Integer inspectionFormId;

	private String formName;

	private String formCode;

	private Long referenceId;

	private Integer currentStatusId;

	private String currentStatusCode;

	private String currentStatusName;

	private String comments;

	private Boolean isActive;

	private String createdBy;

	private LocalDateTime createdDate;

	private String updatedBy;

	private LocalDateTime updatedDate;

	public InspectionWorkflowResponse() {
	}

	public Long getInspectionWorkflowId() {
		return inspectionWorkflowId;
	}

	public void setInspectionWorkflowId(Long inspectionWorkflowId) {
		this.inspectionWorkflowId = inspectionWorkflowId;
	}

	public Integer getInspectionFormId() {
		return inspectionFormId;
	}

	public void setInspectionFormId(Integer inspectionFormId) {
		this.inspectionFormId = inspectionFormId;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public Long getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}

	public Integer getCurrentStatusId() {
		return currentStatusId;
	}

	public void setCurrentStatusId(Integer currentStatusId) {
		this.currentStatusId = currentStatusId;
	}

	public String getCurrentStatusCode() {
		return currentStatusCode;
	}

	public void setCurrentStatusCode(String currentStatusCode) {
		this.currentStatusCode = currentStatusCode;
	}

	public String getCurrentStatusName() {
		return currentStatusName;
	}

	public void setCurrentStatusName(String currentStatusName) {
		this.currentStatusName = currentStatusName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
}