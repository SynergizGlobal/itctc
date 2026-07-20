package com.synergiz.itctc.entity;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "track_effective_length_detail")

public class TrackEffectiveLengthDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_effective_length_detail_id")
    private Long trackEffectiveLengthDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "track_effective_length_header_id",
            nullable = false
    )
    private TrackEffectiveLengthHeader trackEffectiveLengthHeader;

    @Column(name = "line_name")
    private String lineName;

    @Column(name = "chainage_km")
    private BigDecimal chainageKm;

    @Column(name = "chainage_m")
    private BigDecimal chainageM;

    @Column(name = "distance_design_value")
    private BigDecimal distanceDesignValue;

    @Column(name = "distance_measured_value")
    private BigDecimal distanceMeasuredValue;

    @Column(name = "effective_length_design")
    private BigDecimal effectiveLengthDesign;

    @Column(name = "effective_length_measured")
    private BigDecimal effectiveLengthMeasured;

    @Column(name = "irregularity")
    private BigDecimal irregularity;

    @Column(name = "remarks")
    private String remarks;

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

	public Long getTrackEffectiveLengthDetailId() {
		return trackEffectiveLengthDetailId;
	}

	public void setTrackEffectiveLengthDetailId(Long trackEffectiveLengthDetailId) {
		this.trackEffectiveLengthDetailId = trackEffectiveLengthDetailId;
	}

	public TrackEffectiveLengthHeader getTrackEffectiveLengthHeader() {
		return trackEffectiveLengthHeader;
	}

	public void setTrackEffectiveLengthHeader(TrackEffectiveLengthHeader trackEffectiveLengthHeader) {
		this.trackEffectiveLengthHeader = trackEffectiveLengthHeader;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
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

	public BigDecimal getDistanceDesignValue() {
		return distanceDesignValue;
	}

	public void setDistanceDesignValue(BigDecimal distanceDesignValue) {
		this.distanceDesignValue = distanceDesignValue;
	}

	public BigDecimal getDistanceMeasuredValue() {
		return distanceMeasuredValue;
	}

	public void setDistanceMeasuredValue(BigDecimal distanceMeasuredValue) {
		this.distanceMeasuredValue = distanceMeasuredValue;
	}

	public BigDecimal getEffectiveLengthDesign() {
		return effectiveLengthDesign;
	}

	public void setEffectiveLengthDesign(BigDecimal effectiveLengthDesign) {
		this.effectiveLengthDesign = effectiveLengthDesign;
	}

	public BigDecimal getEffectiveLengthMeasured() {
		return effectiveLengthMeasured;
	}

	public void setEffectiveLengthMeasured(BigDecimal effectiveLengthMeasured) {
		this.effectiveLengthMeasured = effectiveLengthMeasured;
	}

	public BigDecimal getIrregularity() {
		return irregularity;
	}

	public void setIrregularity(BigDecimal irregularity) {
		this.irregularity = irregularity;
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
    
    
}