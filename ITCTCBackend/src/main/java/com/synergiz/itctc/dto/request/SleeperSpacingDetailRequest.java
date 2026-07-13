package com.synergiz.itctc.dto.request;


import java.math.BigDecimal;

public class SleeperSpacingDetailRequest {

    private Long sleeperSpacingDetailId;

    private Integer trackDirectionId;
    
    private BigDecimal chainageKm;

    private BigDecimal chainageM;

    private BigDecimal chainageCm;

    private String sleeperNumber;

    private BigDecimal squareness;

    private BigDecimal spacingDesignValue;

    private BigDecimal spacingMeasuredValue;

    private BigDecimal spacingIrregularity;

    private String remarks;

    public Long getSleeperSpacingDetailId() {
		return sleeperSpacingDetailId;
	}

	public void setSleeperSpacingDetailId(Long sleeperSpacingDetailId) {
		this.sleeperSpacingDetailId = sleeperSpacingDetailId;
	}

	public Integer getTrackDirectionId() {
		return trackDirectionId;
	}

	public void setTrackDirectionId(Integer trackDirectionId) {
		this.trackDirectionId = trackDirectionId;
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

	
}