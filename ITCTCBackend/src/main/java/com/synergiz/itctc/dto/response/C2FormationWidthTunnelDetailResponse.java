package com.synergiz.itctc.dto.response;

import java.math.BigDecimal;

public class C2FormationWidthTunnelDetailResponse {

	private Long c2FormationWidthTunnelDetailId;

	// A = a + X
	private BigDecimal aMeasured;
	private BigDecimal x1Calculated;
	private BigDecimal ATotalStandard;
	private BigDecimal ATotalMeasured;

	// B = b (or b')
	private BigDecimal BMeasured;
	private BigDecimal BPrimeMeasured;
	private BigDecimal BTotalStandard;
	private BigDecimal BTotalMeasured;

	// C = c + X
	private BigDecimal CMeasured;
	private BigDecimal x2Calculated;
	private BigDecimal CTotalStandard;
	private BigDecimal CTotalMeasured;

	// Elevation / Height
	private BigDecimal h1Measured;
	private Integer hr1SettingValue;
	private BigDecimal deltaH1Calculated;

	private BigDecimal h2Measured;
	private Integer hr2SettingValue;
	private BigDecimal deltaH2Calculated;

	private BigDecimal differenceElevationCalculated;

	private BigDecimal h3Measured;

	private BigDecimal EStandard;
	private BigDecimal EMeasured;

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
		return ATotalStandard;
	}

	public void setATotalStandard(BigDecimal aTotalStandard) {
		this.ATotalStandard = aTotalStandard;
	}

	public BigDecimal getATotalMeasured() {
		return ATotalMeasured;
	}

	public void setATotalMeasured(BigDecimal aTotalMeasured) {
		this.ATotalMeasured = aTotalMeasured;
	}

	public BigDecimal getBMeasured() {
		return BMeasured;
	}

	public void setBMeasured(BigDecimal bMeasured) {
		this.BMeasured = bMeasured;
	}

	public BigDecimal getBPrimeMeasured() {
		return BPrimeMeasured;
	}

	public void setBPrimeMeasured(BigDecimal bPrimeMeasured) {
		this.BPrimeMeasured = bPrimeMeasured;
	}

	public BigDecimal getBTotalStandard() {
		return BTotalStandard;
	}

	public void setBTotalStandard(BigDecimal bTotalStandard) {
		this.BTotalStandard = bTotalStandard;
	}

	public BigDecimal getBTotalMeasured() {
		return BTotalMeasured;
	}

	public void setBTotalMeasured(BigDecimal bTotalMeasured) {
		this.BTotalMeasured = bTotalMeasured;
	}

	public BigDecimal getCMeasured() {
		return CMeasured;
	}

	public void setCMeasured(BigDecimal cMeasured) {
		this.CMeasured = cMeasured;
	}

	public BigDecimal getX2Calculated() {
		return x2Calculated;
	}

	public void setX2Calculated(BigDecimal x2Calculated) {
		this.x2Calculated = x2Calculated;
	}

	public BigDecimal getCTotalStandard() {
		return CTotalStandard;
	}

	public void setCTotalStandard(BigDecimal cTotalStandard) {
		this.CTotalStandard = cTotalStandard;
	}

	public BigDecimal getCTotalMeasured() {
		return CTotalMeasured;
	}

	public void setCTotalMeasured(BigDecimal cTotalMeasured) {
		this.CTotalMeasured = cTotalMeasured;
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
		return EStandard;
	}

	public void setEStandard(BigDecimal eStandard) {
		this.EStandard = eStandard;
	}

	public BigDecimal getEMeasured() {
		return EMeasured;
	}

	public void setEMeasured(BigDecimal eMeasured) {
		this.EMeasured = eMeasured;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}