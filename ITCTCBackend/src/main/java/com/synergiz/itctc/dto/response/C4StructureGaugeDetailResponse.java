package com.synergiz.itctc.dto.response;

import java.math.BigDecimal;

public class C4StructureGaugeDetailResponse {

	private Long c4StructureGaugeDetailId;

	// =========================================================
	// A
	// A = a + s
	// =========================================================

	private BigDecimal aMeasured;
	private BigDecimal aStandard;
	private BigDecimal aTotalMeasured;

	// =========================================================
	// B
	// =========================================================

	private BigDecimal bDesign;
	private BigDecimal bMeasured;

	// =========================================================
	// C
	// C = c or c' + 2200
	// =========================================================

	private BigDecimal cMeasured;
	private BigDecimal cCalculated;
	private BigDecimal cStandard;
	private BigDecimal cTotalMeasured;

	// =========================================================
	// D
	// D = d + s
	// =========================================================

	private BigDecimal dMeasured;
	private BigDecimal dStandard;
	private BigDecimal dTotalMeasured;

	// =========================================================
	// E
	// =========================================================

	private BigDecimal eDesign;
	private BigDecimal eMeasured;

	// =========================================================
	// F
	// F = f or f' + 2200
	// =========================================================

	private BigDecimal fMeasured;
	private BigDecimal fCalculated;
	private BigDecimal fStandard;
	private BigDecimal fTotalMeasured;

	// =========================================================
	// Remarks
	// =========================================================

	private String remarks;

	// =========================================================
	// Getters and Setters
	// =========================================================

	public Long getC4StructureGaugeDetailId() {
		return c4StructureGaugeDetailId;
	}

	public void setC4StructureGaugeDetailId(Long c4StructureGaugeDetailId) {
		this.c4StructureGaugeDetailId = c4StructureGaugeDetailId;
	}

	public BigDecimal getAMeasured() {
		return aMeasured;
	}

	public void setAMeasured(BigDecimal aMeasured) {
		this.aMeasured = aMeasured;
	}

	public BigDecimal getAStandard() {
		return aStandard;
	}

	public void setAStandard(BigDecimal aStandard) {
		this.aStandard = aStandard;
	}

	public BigDecimal getATotalMeasured() {
		return aTotalMeasured;
	}

	public void setATotalMeasured(BigDecimal aTotalMeasured) {
		this.aTotalMeasured = aTotalMeasured;
	}

	public BigDecimal getBDesign() {
		return bDesign;
	}

	public void setBDesign(BigDecimal bDesign) {
		this.bDesign = bDesign;
	}

	public BigDecimal getBMeasured() {
		return bMeasured;
	}

	public void setBMeasured(BigDecimal bMeasured) {
		this.bMeasured = bMeasured;
	}

	public BigDecimal getCMeasured() {
		return cMeasured;
	}

	public void setCMeasured(BigDecimal cMeasured) {
		this.cMeasured = cMeasured;
	}

	public BigDecimal getCCalculated() {
		return cCalculated;
	}

	public void setCCalculated(BigDecimal cCalculated) {
		this.cCalculated = cCalculated;
	}

	public BigDecimal getCStandard() {
		return cStandard;
	}

	public void setCStandard(BigDecimal cStandard) {
		this.cStandard = cStandard;
	}

	public BigDecimal getCTotalMeasured() {
		return cTotalMeasured;
	}

	public void setCTotalMeasured(BigDecimal cTotalMeasured) {
		this.cTotalMeasured = cTotalMeasured;
	}

	public BigDecimal getDMeasured() {
		return dMeasured;
	}

	public void setDMeasured(BigDecimal dMeasured) {
		this.dMeasured = dMeasured;
	}

	public BigDecimal getDStandard() {
		return dStandard;
	}

	public void setDStandard(BigDecimal dStandard) {
		this.dStandard = dStandard;
	}

	public BigDecimal getDTotalMeasured() {
		return dTotalMeasured;
	}

	public void setDTotalMeasured(BigDecimal dTotalMeasured) {
		this.dTotalMeasured = dTotalMeasured;
	}

	public BigDecimal getEDesign() {
		return eDesign;
	}

	public void setEDesign(BigDecimal eDesign) {
		this.eDesign = eDesign;
	}

	public BigDecimal getEMeasured() {
		return eMeasured;
	}

	public void setEMeasured(BigDecimal eMeasured) {
		this.eMeasured = eMeasured;
	}

	public BigDecimal getFMeasured() {
		return fMeasured;
	}

	public void setFMeasured(BigDecimal fMeasured) {
		this.fMeasured = fMeasured;
	}

	public BigDecimal getFCalculated() {
		return fCalculated;
	}

	public void setFCalculated(BigDecimal fCalculated) {
		this.fCalculated = fCalculated;
	}

	public BigDecimal getFStandard() {
		return fStandard;
	}

	public void setFStandard(BigDecimal fStandard) {
		this.fStandard = fStandard;
	}

	public BigDecimal getFTotalMeasured() {
		return fTotalMeasured;
	}

	public void setFTotalMeasured(BigDecimal fTotalMeasured) {
		this.fTotalMeasured = fTotalMeasured;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
