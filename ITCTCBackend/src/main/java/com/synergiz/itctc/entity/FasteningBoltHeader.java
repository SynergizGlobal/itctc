package com.synergiz.itctc.entity;


import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fastening_bolt_header")

public class FasteningBoltHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fastening_bolt_header_id")
    private Long fasteningBoltHeaderId;

    @Column(name = "project_id", nullable = false)
    private Integer projectId;

    @Column(name = "form_no", nullable = false, length = 100)
    private String formNo;

    @Column(name = "record_no", length = 100)
    private String recordNo;

    @Column(name = "inspection_date", nullable = false)
    private LocalDate inspectionDate;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "created_by", nullable = false, length = 100)
    private String createdBy;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    
    
    public Long getFasteningBoltHeaderId() {
		return fasteningBoltHeaderId;
	}



	public void setFasteningBoltHeaderId(Long fasteningBoltHeaderId) {
		this.fasteningBoltHeaderId = fasteningBoltHeaderId;
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



	public List<FasteningBoltDetail> getDetails() {
		return details;
	}



	public void setDetails(List<FasteningBoltDetail> details) {
		this.details = details;
	}



	@OneToMany(
            mappedBy = "fasteningBoltHeader",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<FasteningBoltDetail> details = new ArrayList<>();
}