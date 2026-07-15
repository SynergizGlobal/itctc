package com.synergiz.itctc.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "fouling_mark_detail")

public class FoulingMarkDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fouling_mark_detail_id")
    private Long foulingMarkDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "fouling_mark_header_id",
            nullable = false
    )
    private FoulingMarkHeader foulingMarkHeader;

    @Column(name = "chainage_location")
    private String chainageLocation;

    @Column(name = "design_value")
    private BigDecimal designValue;

    @Column(name = "measured_value")
    private BigDecimal measuredValue;

    @Column(name = "difference_value")
    private BigDecimal differenceValue;

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

	public Long getFoulingMarkDetailId() {
		return foulingMarkDetailId;
	}

	public void setFoulingMarkDetailId(Long foulingMarkDetailId) {
		this.foulingMarkDetailId = foulingMarkDetailId;
	}

	public FoulingMarkHeader getFoulingMarkHeader() {
		return foulingMarkHeader;
	}

	public void setFoulingMarkHeader(FoulingMarkHeader foulingMarkHeader) {
		this.foulingMarkHeader = foulingMarkHeader;
	}

	public String getChainageLocation() {
		return chainageLocation;
	}

	public void setChainageLocation(String chainageLocation) {
		this.chainageLocation = chainageLocation;
	}

	public BigDecimal getDesignValue() {
		return designValue;
	}

	public void setDesignValue(BigDecimal designValue) {
		this.designValue = designValue;
	}

	public BigDecimal getMeasuredValue() {
		return measuredValue;
	}

	public void setMeasuredValue(BigDecimal measuredValue) {
		this.measuredValue = measuredValue;
	}

	public BigDecimal getDifferenceValue() {
		return differenceValue;
	}

	public void setDifferenceValue(BigDecimal differenceValue) {
		this.differenceValue = differenceValue;
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