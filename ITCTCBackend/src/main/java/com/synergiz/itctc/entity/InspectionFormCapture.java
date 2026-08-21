package com.synergiz.itctc.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "inspection_form_capture", uniqueConstraints = {
		@UniqueConstraint(name = "uk_inspection_form_capture_reference", columnNames = { "inspection_form_id",
				"reference_id" }) })
public class InspectionFormCapture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inspection_form_capture_id")
	private Long inspectionFormCaptureId;

	// =========================================================
	// FORM REFERENCE
	// =========================================================

	@Column(name = "inspection_form_id", nullable = false)
	private Integer inspectionFormId;

	@Column(name = "reference_id", nullable = false)
	private Long referenceId;

	// =========================================================
	// LOCATION
	// =========================================================

	@Column(name = "latitude", precision = 10, scale = 7)
	private BigDecimal latitude;

	@Column(name = "longitude", precision = 10, scale = 7)
	private BigDecimal longitude;

	@Column(name = "location_address", length = 1000)
	private String locationAddress;

	@Column(name = "location_captured_at")
	private LocalDateTime locationCapturedAt;

	// =========================================================
	// SELFIE
	// =========================================================

	@Column(name = "selfie_file_name", length = 500)
	private String selfieFileName;

	@Column(name = "selfie_content_type", length = 100)
	private String selfieContentType;

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

	public Long getInspectionFormCaptureId() {
		return inspectionFormCaptureId;
	}

	public void setInspectionFormCaptureId(Long inspectionFormCaptureId) {
		this.inspectionFormCaptureId = inspectionFormCaptureId;
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

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getLocationAddress() {
		return locationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	public LocalDateTime getLocationCapturedAt() {
		return locationCapturedAt;
	}

	public void setLocationCapturedAt(LocalDateTime locationCapturedAt) {
		this.locationCapturedAt = locationCapturedAt;
	}

	public String getSelfieFileName() {
		return selfieFileName;
	}

	public void setSelfieFileName(String selfieFileName) {
		this.selfieFileName = selfieFileName;
	}

	public String getSelfieContentType() {
		return selfieContentType;
	}

	public void setSelfieContentType(String selfieContentType) {
		this.selfieContentType = selfieContentType;
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