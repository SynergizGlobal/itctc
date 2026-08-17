package com.synergiz.itctc.dto.request;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class C2FormationWidthTunnelDetailRequest {

	private Long c2FormationWidthTunnelDetailId;

	// A = a + X
	@JsonProperty("aMeasured")
	private BigDecimal aMeasured;

	private BigDecimal x1Calculated;

	@JsonProperty("aTotalStandard")
	private BigDecimal aTotalStandard;

	@JsonProperty("aTotalMeasured")
	private BigDecimal aTotalMeasured;

	// B = b (or b')
	@JsonProperty("bMeasured")
	private BigDecimal bMeasured;

	@JsonProperty("bPrimeMeasured")
	private BigDecimal bPrimeMeasured;

	@JsonProperty("bTotalStandard")
	private BigDecimal bTotalStandard;

	@JsonProperty("bTotalMeasured")
	private BigDecimal bTotalMeasured;

	// C = c + X
	@JsonProperty("cMeasured")
	private BigDecimal cMeasured;

	private BigDecimal x2Calculated;

	@JsonProperty("cTotalStandard")
	private BigDecimal cTotalStandard;

	@JsonProperty("cTotalMeasured")
	private BigDecimal cTotalMeasured;

	// Elevation / Height
	private BigDecimal h1Measured;
	private Integer hr1SettingValue;
	private BigDecimal deltaH1Calculated;

	private BigDecimal h2Measured;
	private Integer hr2SettingValue;
	private BigDecimal deltaH2Calculated;

	private BigDecimal differenceElevationCalculated;

	private BigDecimal h3Measured;

	@JsonProperty("eStandard")
	private BigDecimal eStandard;

	@JsonProperty("eMeasured")
	private BigDecimal eMeasured;

	private String remarks;

	public Long getC2FormationWidthTunnelDetailId() {
		return c2FormationWidthTunnelDetailId;
	}

	public void setC2FormationWidthTunnelDetailId(Long c2FormationWidthTunnelDetailId) {
		this.c2FormationWidthTunnelDetailId = c2FormationWidthTunnelDetailId;
	}

	public BigDecimal getAMeasured() {
		return aMeasured;
	}

	public void setAMeasured(BigDecimal aMeasured) {
		this.aMeasured = aMeasured;
	}

	public BigDecimal getX1Calculated() {
		return x1Calculated;
	}

	public void setX1Calculated(BigDecimal x1Calculated) {
		this.x1Calculated = x1Calculated;
	}

	public BigDecimal getATotalStandard() {
		return aTotalStandard;
	}

	public void setATotalStandard(BigDecimal aTotalStandard) {
		this.aTotalStandard = aTotalStandard;
	}

	public BigDecimal getATotalMeasured() {
		return aTotalMeasured;
	}

	public void setATotalMeasured(BigDecimal aTotalMeasured) {
		this.aTotalMeasured = aTotalMeasured;
	}

	public BigDecimal getBMeasured() {
		return bMeasured;
	}

	public void setBMeasured(BigDecimal bMeasured) {
		this.bMeasured = bMeasured;
	}

	public BigDecimal getBPrimeMeasured() {
		return bPrimeMeasured;
	}

	public void setBPrimeMeasured(BigDecimal bPrimeMeasured) {
		this.bPrimeMeasured = bPrimeMeasured;
	}

	public BigDecimal getBTotalStandard() {
		return bTotalStandard;
	}

	public void setBTotalStandard(BigDecimal bTotalStandard) {
		this.bTotalStandard = bTotalStandard;
	}

	public BigDecimal getBTotalMeasured() {
		return bTotalMeasured;
	}

	public void setBTotalMeasured(BigDecimal bTotalMeasured) {
		this.bTotalMeasured = bTotalMeasured;
	}

	public BigDecimal getCMeasured() {
		return cMeasured;
	}

	public void setCMeasured(BigDecimal cMeasured) {
		this.cMeasured = cMeasured;
	}

	public BigDecimal getX2Calculated() {
		return x2Calculated;
	}

	public void setX2Calculated(BigDecimal x2Calculated) {
		this.x2Calculated = x2Calculated;
	}

	public BigDecimal getCTotalStandard() {
		return cTotalStandard;
	}

	public void setCTotalStandard(BigDecimal cTotalStandard) {
		this.cTotalStandard = cTotalStandard;
	}

	public BigDecimal getCTotalMeasured() {
		return cTotalMeasured;
	}

	public void setCTotalMeasured(BigDecimal cTotalMeasured) {
		this.cTotalMeasured = cTotalMeasured;
	}

	public BigDecimal getH1Measured() {
		return h1Measured;
	}

	public void setH1Measured(BigDecimal h1Measured) {
		this.h1Measured = h1Measured;
	}

	public Integer getHr1SettingValue() {
		return hr1SettingValue;
	}

	public void setHr1SettingValue(Integer hr1SettingValue) {
		this.hr1SettingValue = hr1SettingValue;
	}

	public BigDecimal getDeltaH1Calculated() {
		return deltaH1Calculated;
	}

	public void setDeltaH1Calculated(BigDecimal deltaH1Calculated) {
		this.deltaH1Calculated = deltaH1Calculated;
	}

	public BigDecimal getH2Measured() {
		return h2Measured;
	}

	public void setH2Measured(BigDecimal h2Measured) {
		this.h2Measured = h2Measured;
	}

	public Integer getHr2SettingValue() {
		return hr2SettingValue;
	}

	public void setHr2SettingValue(Integer hr2SettingValue) {
		this.hr2SettingValue = hr2SettingValue;
	}

	public BigDecimal getDeltaH2Calculated() {
		return deltaH2Calculated;
	}

	public void setDeltaH2Calculated(BigDecimal deltaH2Calculated) {
		this.deltaH2Calculated = deltaH2Calculated;
	}

	public BigDecimal getDifferenceElevationCalculated() {
		return differenceElevationCalculated;
	}

	public void setDifferenceElevationCalculated(BigDecimal differenceElevationCalculated) {
		this.differenceElevationCalculated = differenceElevationCalculated;
	}

	public BigDecimal getH3Measured() {
		return h3Measured;
	}

	public void setH3Measured(BigDecimal h3Measured) {
		this.h3Measured = h3Measured;
	}

	public BigDecimal getEStandard() {
		return eStandard;
	}

	public void setEStandard(BigDecimal eStandard) {
		this.eStandard = eStandard;
	}

	public BigDecimal getEMeasured() {
		return eMeasured;
	}

	public void setEMeasured(BigDecimal eMeasured) {
		this.eMeasured = eMeasured;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}