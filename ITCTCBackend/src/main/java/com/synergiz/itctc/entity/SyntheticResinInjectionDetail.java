package com.synergiz.itctc.entity;


import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "synthetic_resin_injection_detail")

public class SyntheticResinInjectionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "synthetic_resin_injection_detail_id")
    private Long syntheticResinInjectionDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "synthetic_resin_injection_header_id",
            nullable = false
    )
    private SyntheticResinInjectionHeader syntheticResinInjectionHeader;

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

    @Column(name = "injection_left", precision = 10, scale = 3)
    private BigDecimal injectionLeft;

    @Column(name = "injection_centre", precision = 10, scale = 3)
    private BigDecimal injectionCentre;

    @Column(name = "injection_right", precision = 10, scale = 3)
    private BigDecimal injectionRight;

    @Column(name = "injection_average", precision = 10, scale = 3)
    private BigDecimal injectionAverage;

    @Column(name = "gap", precision = 10, scale = 3)
    private BigDecimal gap;

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

	public Long getSyntheticResinInjectionDetailId() {
		return syntheticResinInjectionDetailId;
	}

	public void setSyntheticResinInjectionDetailId(Long syntheticResinInjectionDetailId) {
		this.syntheticResinInjectionDetailId = syntheticResinInjectionDetailId;
	}

	public SyntheticResinInjectionHeader getSyntheticResinInjectionHeader() {
		return syntheticResinInjectionHeader;
	}

	public void setSyntheticResinInjectionHeader(SyntheticResinInjectionHeader syntheticResinInjectionHeader) {
		this.syntheticResinInjectionHeader = syntheticResinInjectionHeader;
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

	public BigDecimal getInjectionLeft() {
		return injectionLeft;
	}

	public void setInjectionLeft(BigDecimal injectionLeft) {
		this.injectionLeft = injectionLeft;
	}

	public BigDecimal getInjectionCentre() {
		return injectionCentre;
	}

	public void setInjectionCentre(BigDecimal injectionCentre) {
		this.injectionCentre = injectionCentre;
	}

	public BigDecimal getInjectionRight() {
		return injectionRight;
	}

	public void setInjectionRight(BigDecimal injectionRight) {
		this.injectionRight = injectionRight;
	}

	public BigDecimal getInjectionAverage() {
		return injectionAverage;
	}

	public void setInjectionAverage(BigDecimal injectionAverage) {
		this.injectionAverage = injectionAverage;
	}

	public BigDecimal getGap() {
		return gap;
	}

	public void setGap(BigDecimal gap) {
		this.gap = gap;
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