package com.synergiz.itctc.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "MeasurementHeader")

public class MeasurementHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MeasurementId")
    private Long measurementId;

    public Long getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(Long measurementId) {
		this.measurementId = measurementId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public BigDecimal getChainageKm() {
		return chainageKm;
	}

	public void setChainageKm(BigDecimal chainageKm) {
		this.chainageKm = chainageKm;
	}

	public BigDecimal getChainageM() {
		return chainageM;
	}

	public void setChainageM(BigDecimal chainageM) {
		this.chainageM = chainageM;
	}

	public StructureType getStructureType() {
		return structureType;
	}

	public void setStructureType(StructureType structureType) {
		this.structureType = structureType;
	}

	public TrackType getTrackType() {
		return trackType;
	}

	public void setTrackType(TrackType trackType) {
		this.trackType = trackType;
	}

	public Boolean getIsCurve() {
		return isCurve;
	}

	public void setIsCurve(Boolean isCurve) {
		this.isCurve = isCurve;
	}

	public BigDecimal getCurveRadius() {
		return curveRadius;
	}

	public void setCurveRadius(BigDecimal curveRadius) {
		this.curveRadius = curveRadius;
	}

	public BigDecimal getAppliedCantValueMm() {
		return appliedCantValueMm;
	}

	public void setAppliedCantValueMm(BigDecimal appliedCantValueMm) {
		this.appliedCantValueMm = appliedCantValueMm;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public List<MeasurementDetail> getDetails() {
		return details;
	}

	public void setDetails(List<MeasurementDetail> details) {
		this.details = details;
	}

	@Column(name = "ProjectId")
    private Integer projectId;

    @Column(name = "ChainageKm")
    private BigDecimal chainageKm;

    @Column(name = "ChainageM")
    private BigDecimal chainageM;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "StructureTypeId")
    private StructureType structureType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TrackTypeId")
    private TrackType trackType;

    @Column(name = "IsCurve")
    private Boolean isCurve;

    @Column(name = "CurveRadius")
    private BigDecimal curveRadius;

    @Column(name = "AppliedCantValueMm")
    private BigDecimal appliedCantValueMm;

    @Column(name = "Remarks")
    private String remarks;

    @Column(name = "IsActive")
    private Boolean isActive = true;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "CreatedDate")
    private LocalDateTime createdDate;

    @Column(name = "UpdatedBy")
    private String updatedBy;

    @Column(name = "UpdatedDate")
    private LocalDateTime updatedDate;

    @OneToMany(
            mappedBy = "measurementHeader",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MeasurementDetail> details = new ArrayList<>();

}