package com.synergiz.itctc.dto.request;

public class InspectionWorkflowRequest {

    private Integer inspectionFormId;

    private Long referenceId;

    private String comments;

    private String actionBy;

    public InspectionWorkflowRequest() {
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getActionBy() {
        return actionBy;
    }

    public void setActionBy(String actionBy) {
        this.actionBy = actionBy;
    }
}