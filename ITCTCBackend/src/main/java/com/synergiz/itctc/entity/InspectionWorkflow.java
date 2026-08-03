package com.synergiz.itctc.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Inspection_Workflow")
public class InspectionWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inspection_workflow_id")
    private Long inspectionWorkflowId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inspection_form_id", nullable = false)
    private InspectionForm inspectionForm;

    @Column(name = "reference_id", nullable = false)
    private Long referenceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_status_id", nullable = false)
    private InspectionStatus currentStatus;

    @Column(name = "comments", length = 2000)
    private String comments;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    public InspectionWorkflow() {
    }

    public Long getInspectionWorkflowId() {
        return inspectionWorkflowId;
    }

    public void setInspectionWorkflowId(Long inspectionWorkflowId) {
        this.inspectionWorkflowId = inspectionWorkflowId;
    }

    public InspectionForm getInspectionForm() {
        return inspectionForm;
    }

    public void setInspectionForm(InspectionForm inspectionForm) {
        this.inspectionForm = inspectionForm;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public InspectionStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(InspectionStatus currentStatus) {
        this.currentStatus = currentStatus;
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