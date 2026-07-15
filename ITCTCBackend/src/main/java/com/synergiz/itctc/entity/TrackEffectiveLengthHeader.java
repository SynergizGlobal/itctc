package com.synergiz.itctc.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "track_effective_length_header")

public class TrackEffectiveLengthHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_effective_length_header_id")
    private Long trackEffectiveLengthHeaderId;

    @Column(name = "project_id", nullable = false)
    private Integer projectId;

    @Column(name = "form_no", nullable = false)
    private String formNo;

    @Column(name = "location")
    private String location;

    @Column(name = "inspection_date", nullable = false)
    private LocalDate inspectionDate;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    
    public Long getTrackEffectiveLengthHeaderId() {
		return trackEffectiveLengthHeaderId;
	}


	public void setTrackEffectiveLengthHeaderId(Long trackEffectiveLengthHeaderId) {
		this.trackEffectiveLengthHeaderId = trackEffectiveLengthHeaderId;
	}


	public Integer getProjectId() {
		return projectId;
	}


	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}


	public String getFormNo() {
		return formNo;
	}


	public void setFormNo(String formNo) {
		this.formNo = formNo;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public LocalDate getInspectionDate() {
		return inspectionDate;
	}


	public void setInspectionDate(LocalDate inspectionDate) {
		this.inspectionDate = inspectionDate;
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


	public List<TrackEffectiveLengthDetail> getDetails() {
		return details;
	}


	public void setDetails(List<TrackEffectiveLengthDetail> details) {
		this.details = details;
	}


	@OneToMany(
            mappedBy = "trackEffectiveLengthHeader",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<TrackEffectiveLengthDetail> details = new ArrayList<>();
}