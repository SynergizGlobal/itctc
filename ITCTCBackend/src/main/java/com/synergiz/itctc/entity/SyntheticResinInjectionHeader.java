package com.synergiz.itctc.entity;



import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "synthetic_resin_injection_header")

public class SyntheticResinInjectionHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "synthetic_resin_injection_header_id")
    private Long syntheticResinInjectionHeaderId;

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
    
    

    public Long getSyntheticResinInjectionHeaderId() {
		return syntheticResinInjectionHeaderId;
	}



	public void setSyntheticResinInjectionHeaderId(Long syntheticResinInjectionHeaderId) {
		this.syntheticResinInjectionHeaderId = syntheticResinInjectionHeaderId;
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



	public List<SyntheticResinInjectionDetail> getDetails() {
		return details;
	}



	public void setDetails(List<SyntheticResinInjectionDetail> details) {
		this.details = details;
	}



	@OneToMany(
            mappedBy = "syntheticResinInjectionHeader",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<SyntheticResinInjectionDetail> details =
            new ArrayList<>();
}