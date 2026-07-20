package com.synergiz.itctc.entity;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "fastening_bolt_detail")

public class FasteningBoltDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fastening_bolt_detail_id")
    private Long fasteningBoltDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "fastening_bolt_header_id",
            nullable = false
    )
    private FasteningBoltHeader fasteningBoltHeader;

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

    @Column(name = "measured_left", precision = 10, scale = 3)
    private BigDecimal measuredLeft;

    @Column(name = "measured_right", precision = 10, scale = 3)
    private BigDecimal measuredRight;

    @Column(name = "remarks", length = 500)
    private String remarks;

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

	public Long getFasteningBoltDetailId() {
		return fasteningBoltDetailId;
	}

	public void setFasteningBoltDetailId(Long fasteningBoltDetailId) {
		this.fasteningBoltDetailId = fasteningBoltDetailId;
	}

	public FasteningBoltHeader getFasteningBoltHeader() {
		return fasteningBoltHeader;
	}

	public void setFasteningBoltHeader(FasteningBoltHeader fasteningBoltHeader) {
		this.fasteningBoltHeader = fasteningBoltHeader;
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

	public BigDecimal getMeasuredLeft() {
		return measuredLeft;
	}

	public void setMeasuredLeft(BigDecimal measuredLeft) {
		this.measuredLeft = measuredLeft;
	}

	public BigDecimal getMeasuredRight() {
		return measuredRight;
	}

	public void setMeasuredRight(BigDecimal measuredRight) {
		this.measuredRight = measuredRight;
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