package com.synergiz.itctc.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Inspection_History")
public class InspectionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inspection_history_id")
    private Long inspectionHistoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inspection_workflow_id")
    private InspectionWorkflow inspectionWorkflow;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "previous_status_id")
    private InspectionStatus previousStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "new_status_id")
    private InspectionStatus newStatus;

    @Column(name = "action_taken")
    private String actionTaken;

    @Column(name = "action_by")
    private String actionBy;

    @Column(name = "action_role")
    private String actionRole;

    @Column(name = "comments")
    private String comments;

    @Column(name = "action_date")
    private LocalDateTime actionDate;

	public Long getInspectionHistoryId() {
		return inspectionHistoryId;
	}

	public void setInspectionHistoryId(Long inspectionHistoryId) {
		this.inspectionHistoryId = inspectionHistoryId;
	}

	public InspectionWorkflow getInspectionWorkflow() {
		return inspectionWorkflow;
	}

	public void setInspectionWorkflow(InspectionWorkflow inspectionWorkflow) {
		this.inspectionWorkflow = inspectionWorkflow;
	}

	public InspectionStatus getPreviousStatus() {
		return previousStatus;
	}

	public void setPreviousStatus(InspectionStatus previousStatus) {
		this.previousStatus = previousStatus;
	}

	public InspectionStatus getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(InspectionStatus newStatus) {
		this.newStatus = newStatus;
	}

	public String getActionTaken() {
		return actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public String getActionRole() {
		return actionRole;
	}

	public void setActionRole(String actionRole) {
		this.actionRole = actionRole;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDateTime getActionDate() {
		return actionDate;
	}

	public void setActionDate(LocalDateTime actionDate) {
		this.actionDate = actionDate;
	}
    
    
}