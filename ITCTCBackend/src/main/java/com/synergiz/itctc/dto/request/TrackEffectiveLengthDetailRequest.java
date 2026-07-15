package com.synergiz.itctc.dto.request;

import java.math.BigDecimal;

public class TrackEffectiveLengthDetailRequest {

    private Long trackEffectiveLengthDetailId;

    private String lineName;

    private BigDecimal chainageKm;

    private BigDecimal chainageM;

    private BigDecimal distanceDesignValue;

    private BigDecimal distanceMeasuredValue;

    private BigDecimal effectiveLengthDesign;

    private BigDecimal effectiveLengthMeasured;

    private BigDecimal irregularity;

    private String remarks;

	public Long getTrackEffectiveLengthDetailId() {
		return trackEffectiveLengthDetailId;
	}

	public void setTrackEffectiveLengthDetailId(Long trackEffectiveLengthDetailId) {
		this.trackEffectiveLengthDetailId = trackEffectiveLengthDetailId;
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
    
    
}