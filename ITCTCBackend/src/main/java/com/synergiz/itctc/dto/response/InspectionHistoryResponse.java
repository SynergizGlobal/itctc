package com.synergiz.itctc.dto.response;

import java.time.LocalDateTime;

public class InspectionHistoryResponse {

    private Long inspectionHistoryId;

    private Integer fromStatusId;

    private String fromStatusCode;

    private String fromStatusName;

    private Integer toStatusId;

    private String toStatusCode;

    private String toStatusName;

    private String actionBy;

    private String actionComments;

    private LocalDateTime actionDate;
    
    private String actionTaken;

    public String getActionTaken() {
		return actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}

	public String getActionRole() {
		return actionRole;
	}

	public void setActionRole(String actionRole) {
		this.actionRole = actionRole;
	}

	private String actionRole;

    public InspectionHistoryResponse() {
    }

    public Long getInspectionHistoryId() {
        return inspectionHistoryId;
    }

    public void setInspectionHistoryId(Long inspectionHistoryId) {
        this.inspectionHistoryId = inspectionHistoryId;
    }

    public Integer getFromStatusId() {
        return fromStatusId;
    }

    public void setFromStatusId(Integer fromStatusId) {
        this.fromStatusId = fromStatusId;
    }

    public String getFromStatusCode() {
        return fromStatusCode;
    }

    public void setFromStatusCode(String fromStatusCode) {
        this.fromStatusCode = fromStatusCode;
    }

    public String getFromStatusName() {
        return fromStatusName;
    }

    public void setFromStatusName(String fromStatusName) {
        this.fromStatusName = fromStatusName;
    }

    public Integer getToStatusId() {
        return toStatusId;
    }

    public void setToStatusId(Integer toStatusId) {
        this.toStatusId = toStatusId;
    }

    public String getToStatusCode() {
        return toStatusCode;
    }

    public void setToStatusCode(String toStatusCode) {
        this.toStatusCode = toStatusCode;
    }

    public String getToStatusName() {
        return toStatusName;
    }

    public void setToStatusName(String toStatusName) {
        this.toStatusName = toStatusName;
    }

    public String getActionBy() {
        return actionBy;
    }

    public void setActionBy(String actionBy) {
        this.actionBy = actionBy;
    }

    public String getActionComments() {
        return actionComments;
    }

    public void setActionComments(String actionComments) {
        this.actionComments = actionComments;
    }

    public LocalDateTime getActionDate() {
        return actionDate;
    }

    public void setActionDate(LocalDateTime actionDate) {
        this.actionDate = actionDate;
    }
}