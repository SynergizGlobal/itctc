package com.synergiz.itctc.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "inspection_file")
public class InspectionFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inspection_file_id")
	private Long inspectionFileId;

	// =========================================================
	// FORM REFERENCE
	// =========================================================

	@Column(name = "inspection_form_id", nullable = false)
	private Integer inspectionFormId;

	@Column(name = "reference_id", nullable = false)
	private Long referenceId;

	// =========================================================
	// FILE
	// =========================================================

	@Column(name = "file_name", nullable = false, length = 500)
	private String fileName;

	@Column(name = "content_type", length = 100)
	private String contentType;

	// =========================================================
	// AUDIT
	// =========================================================

	@Column(name = "is_active", nullable = false)
	private Boolean isActive = true;

	@Column(name = "created_by", length = 100)
	private String createdBy;

	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Column(name = "updated_by", length = 100)
	private String updatedBy;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	// =========================================================
	// Getters / Setters
	// =========================================================

	public Long getInspectionFileId() {
		return inspectionFileId;
	}

	public void setInspectionFileId(Long inspectionFileId) {
		this.inspectionFileId = inspectionFileId;
	}

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