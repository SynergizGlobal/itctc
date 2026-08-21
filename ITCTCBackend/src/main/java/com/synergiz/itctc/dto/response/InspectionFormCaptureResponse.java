package com.synergiz.itctc.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InspectionFormCaptureResponse {

    private Long inspectionFormCaptureId;

    // =========================================================
    // FORM REFERENCE
    // =========================================================

    private Integer inspectionFormId;

    private Long referenceId;

    // =========================================================
    // LOCATION
    // =========================================================

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String locationAddress;

    private LocalDateTime locationCapturedAt;

    // =========================================================
    // SELFIE
    // =========================================================

    private String selfieFileName;

    private String selfieContentType;

    // =========================================================
    // AUDIT
    // =========================================================

    private Boolean isActive;

    private String createdBy;

    private LocalDateTime createdDate;

    private String updatedBy;

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