package com.synergiz.itctc.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fouling_mark_header")

public class FoulingMarkHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fouling_mark_header_id")
    private Long foulingMarkHeaderId;

    @Column(name = "project_id", nullable = false)
    private Integer projectId;

    @Column(name = "form_no", nullable = false)
    private String formNo;

    @Column(name = "record_no")
    private String recordNo;

    @Column(name = "inspection_date", nullable = false)
    private LocalDate inspectionDate;

    @Column(name = "line_name")
    private String lineName;

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
    
    

    public Long getFoulingMarkHeaderId() {
		return foulingMarkHeaderId;
	}



	public void setFoulingMarkHeaderId(Long foulingMarkHeaderId) {
		this.foulingMarkHeaderId = foulingMarkHeaderId;
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



	public String getRecordNo() {
		return recordNo;
	}



	public void setRecordNo(String recordNo) {
		this.recordNo = recordNo;
	}



	public LocalDate getInspectionDate() {
		return inspectionDate;
	}



	public void setInspectionDate(LocalDate inspectionDate) {
		this.inspectionDate = inspectionDate;
	}



	public String getLineName() {
		return lineName;
	}



	public void setLineName(String lineName) {
		this.lineName = lineName;
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



	public List<FoulingMarkDetail> getDetails() {
		return details;
	}



	public void setDetails(List<FoulingMarkDetail> details) {
		this.details = details;
	}



	@OneToMany(
            mappedBy = "foulingMarkHeader",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<FoulingMarkDetail> details = new ArrayList<>();
}