package com.synergiz.itctc.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "c4_structure_gauge_detail")
public class C4StructureGaugeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c4_structure_gauge_detail_id")
    private Long c4StructureGaugeDetailId;

    // =========================================================
    // Header Reference
    // =========================================================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "c4_structure_gauge_id",
            nullable = false
    )
    private C4StructureGaugeHeader c4StructureGaugeHeader;

    // =========================================================
    // A = a + s
    // =========================================================

    @Column(name = "a_measured", precision = 12, scale = 3)
    private BigDecimal aMeasured;

    @Column(name = "a_standard", precision = 12, scale = 3)
    private BigDecimal aStandard;

    @Column(name = "a_measured_total", precision = 12, scale = 3)
    private BigDecimal aMeasuredTotal;

    // =========================================================
    // B
    // =========================================================

    @Column(name = "b_design", precision = 12, scale = 3)
    private BigDecimal bDesign;

    @Column(name = "b_measured", precision = 12, scale = 3)
    private BigDecimal bMeasured;

    // =========================================================
    // C = c or c' + 2200
    // =========================================================

    @Column(name = "c_measured", precision = 12, scale = 3)
    private BigDecimal cMeasured;

    @Column(name = "c_calculated", precision = 12, scale = 3)
    private BigDecimal cCalculated;

    @Column(name = "c_standard", precision = 12, scale = 3)
    private BigDecimal cStandard;

    @Column(name = "c_measured_total", precision = 12, scale = 3)
    private BigDecimal cMeasuredTotal;

    // =========================================================
    // D = d + s
    // =========================================================

    @Column(name = "d_measured", precision = 12, scale = 3)
    private BigDecimal dMeasured;

    @Column(name = "d_standard", precision = 12, scale = 3)
    private BigDecimal dStandard;

    @Column(name = "d_measured_total", precision = 12, scale = 3)
    private BigDecimal dMeasuredTotal;

    // =========================================================
    // E
    // =========================================================

    @Column(name = "e_design", precision = 12, scale = 3)
    private BigDecimal eDesign;

    @Column(name = "e_measured", precision = 12, scale = 3)
    private BigDecimal eMeasured;

    // =========================================================
    // F = f or f' + 2200
    // =========================================================

    @Column(name = "f_measured", precision = 12, scale = 3)
    private BigDecimal fMeasured;

    @Column(name = "f_calculated", precision = 12, scale = 3)
    private BigDecimal fCalculated;

    @Column(name = "f_standard", precision = 12, scale = 3)
    private BigDecimal fStandard;

    @Column(name = "f_measured_total", precision = 12, scale = 3)
    private BigDecimal fMeasuredTotal;

    // =========================================================
    // Remarks
    // =========================================================

    @Column(name = "remarks", length = 1000)
    private String remarks;

    // =========================================================
    // Audit
    // =========================================================

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    // =========================================================
    // Getters and Setters
    // =========================================================

    public Long getC4StructureGaugeDetailId() {
        return c4StructureGaugeDetailId;
    }

    public void setC4StructureGaugeDetailId(
            Long c4StructureGaugeDetailId) {
        this.c4StructureGaugeDetailId = c4StructureGaugeDetailId;
    }

    public C4StructureGaugeHeader getC4StructureGaugeHeader() {
        return c4StructureGaugeHeader;
    }

    public void setC4StructureGaugeHeader(
            C4StructureGaugeHeader c4StructureGaugeHeader) {
        this.c4StructureGaugeHeader = c4StructureGaugeHeader;
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
