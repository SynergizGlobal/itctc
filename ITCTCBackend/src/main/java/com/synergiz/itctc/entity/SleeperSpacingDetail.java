package com.synergiz.itctc.entity;


import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sleeper_spacing_detail")

public class SleeperSpacingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sleeper_spacing_detail_id")
    private Long sleeperSpacingDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "sleeper_spacing_header_id",
            nullable = false
    )
    private SleeperSpacingHeader sleeperSpacingHeader;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "track_direction_id",
            nullable = false
    )
    private TrackDirection trackDirection;

    @Column(name = "chainage_km", precision = 10, scale = 3)
    private BigDecimal chainageKm;

    @Column(name = "chainage_m", precision = 10, scale = 3)
    private BigDecimal chainageM;

    @Column(name = "chainage_cm", precision = 10, scale = 3)
    private BigDecimal chainageCm;

    @Column(name = "sleeper_number", length = 50)
    private String sleeperNumber;

    @Column(name = "squareness", precision = 10, scale = 3)
    private BigDecimal squareness;

    @Column(name = "spacing_design_value", precision = 10, scale = 3)
    private BigDecimal spacingDesignValue;

    @Column(name = "spacing_measured_value", precision = 10, scale = 3)
    private BigDecimal spacingMeasuredValue;

    @Column(name = "spacing_irregularity", precision = 10, scale = 3)
    private BigDecimal spacingIrregularity;

    @Column(name = "remarks", length = 500)
    private String remarks;

    public Long getSleeperSpacingDetailId() {
		return sleeperSpacingDetailId;
	}

	public void setSleeperSpacingDetailId(Long sleeperSpacingDetailId) {
		this.sleeperSpacingDetailId = sleeperSpacingDetailId;
	}

	public SleeperSpacingHeader getSleeperSpacingHeader() {
		return sleeperSpacingHeader;
	}

	public void setSleeperSpacingHeader(SleeperSpacingHeader sleeperSpacingHeader) {
		this.sleeperSpacingHeader = sleeperSpacingHeader;
	}

	public TrackDirection getTrackDirection() {
		return trackDirection;
	}

	public void setTrackDirection(TrackDirection trackDirection) {
		this.trackDirection = trackDirection;
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

	public BigDecimal getChainageCm() {
		return chainageCm;
	}

	public void setChainageCm(BigDecimal chainageCm) {
		this.chainageCm = chainageCm;
	}

	public String getSleeperNumber() {
		return sleeperNumber;
	}

	public void setSleeperNumber(String sleeperNumber) {
		this.sleeperNumber = sleeperNumber;
	}

	public BigDecimal getSquareness() {
		return squareness;
	}

	public void setSquareness(BigDecimal squareness) {
		this.squareness = squareness;
	}

	public BigDecimal getSpacingDesignValue() {
		return spacingDesignValue;
	}

	public void setSpacingDesignValue(BigDecimal spacingDesignValue) {
		this.spacingDesignValue = spacingDesignValue;
	}

	public BigDecimal getSpacingMeasuredValue() {
		return spacingMeasuredValue;
	}

	public void setSpacingMeasuredValue(BigDecimal spacingMeasuredValue) {
		this.spacingMeasuredValue = spacingMeasuredValue;
	}

	public BigDecimal getSpacingIrregularity() {
		return spacingIrregularity;
	}

	public void setSpacingIrregularity(BigDecimal spacingIrregularity) {
		this.spacingIrregularity = spacingIrregularity;
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
}