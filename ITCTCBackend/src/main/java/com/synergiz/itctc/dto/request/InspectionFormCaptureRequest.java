package com.synergiz.itctc.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InspectionFormCaptureRequest {

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
}
