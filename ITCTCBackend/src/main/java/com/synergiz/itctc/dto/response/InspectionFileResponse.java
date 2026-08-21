package com.synergiz.itctc.dto.response;

import java.time.LocalDateTime;

public class InspectionFileResponse {

    private Long inspectionFileId;

    // =========================================================
    // FORM REFERENCE
    // =========================================================

    private Integer inspectionFormId;

    private Long referenceId;

    // =========================================================
    // FILE
    // =========================================================

    private String fileName;

    private String contentType;

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