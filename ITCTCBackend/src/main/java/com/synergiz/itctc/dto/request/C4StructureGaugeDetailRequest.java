package com.synergiz.itctc.dto.request;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class C4StructureGaugeDetailRequest {

    // =========================================================
    // Detail ID
    // =========================================================

    private Long c4StructureGaugeDetailId;

    // =========================================================
    // A = a + s
    // =========================================================

    @JsonProperty("aMeasured")
    private BigDecimal aMeasured;

    @JsonProperty("aStandard")
    private BigDecimal aStandard;

    @JsonProperty("aMeasuredTotal")
    private BigDecimal aMeasuredTotal;

    // =========================================================
    // B
    // =========================================================

    @JsonProperty("bDesign")
    private BigDecimal bDesign;

    @JsonProperty("bMeasured")
    private BigDecimal bMeasured;

    // =========================================================
    // C = c or c' + 2200
    // =========================================================

    @JsonProperty("cMeasured")
    private BigDecimal cMeasured;

    @JsonProperty("cCalculated")
    private BigDecimal cCalculated;

    @JsonProperty("cStandard")
    private BigDecimal cStandard;

    @JsonProperty("cMeasuredTotal")
    private BigDecimal cMeasuredTotal;

    // =========================================================
    // D = d + s
    // =========================================================

    @JsonProperty("dMeasured")
    private BigDecimal dMeasured;

    @JsonProperty("dStandard")
    private BigDecimal dStandard;

    @JsonProperty("dMeasuredTotal")
    private BigDecimal dMeasuredTotal;

    // =========================================================
    // E
    // =========================================================

    @JsonProperty("eDesign")
    private BigDecimal eDesign;

    @JsonProperty("eMeasured")
    private BigDecimal eMeasured;

    // =========================================================
    // F = f or f' + 2200
    // =========================================================

    @JsonProperty("fMeasured")
    private BigDecimal fMeasured;

    @JsonProperty("fCalculated")
    private BigDecimal fCalculated;

    @JsonProperty("fStandard")
    private BigDecimal fStandard;

    @JsonProperty("fMeasuredTotal")
    private BigDecimal fMeasuredTotal;

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

    public void setC4StructureGaugeDetailId(
            Long c4StructureGaugeDetailId) {
        this.c4StructureGaugeDetailId =
                c4StructureGaugeDetailId;
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

    public BigDecimal getAMeasuredTotal() {
        return aMeasuredTotal;
    }

    public void setAMeasuredTotal(BigDecimal aMeasuredTotal) {
        this.aMeasuredTotal = aMeasuredTotal;
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

    public BigDecimal getCMeasuredTotal() {
        return cMeasuredTotal;
    }

    public void setCMeasuredTotal(BigDecimal cMeasuredTotal) {
        this.cMeasuredTotal = cMeasuredTotal;
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

    public BigDecimal getDMeasuredTotal() {
        return dMeasuredTotal;
    }

    public void setDMeasuredTotal(BigDecimal dMeasuredTotal) {
        this.dMeasuredTotal = dMeasuredTotal;
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

    public BigDecimal getFMeasuredTotal() {
        return fMeasuredTotal;
    }

    public void setFMeasuredTotal(BigDecimal fMeasuredTotal) {
        this.fMeasuredTotal = fMeasuredTotal;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}