package com.synergiz.itctc.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "c2_formation_width_tunnel_detail")
public class C2FormationWidthTunnelDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c2_formation_width_tunnel_detail_id")
    private Long c2FormationWidthTunnelDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "c2_formation_width_tunnel_id",
            nullable = false
    )
    private C2FormationWidthTunnelHeader c2FormationWidthTunnelHeader;

    // =========================================================
    // A = a + X
    // =========================================================

    @Column(name = "a_measured", precision = 12, scale = 3)
    private BigDecimal aMeasured;

    @Column(name = "x1_calculated", precision = 12, scale = 3)
    private BigDecimal x1Calculated;

    @Column(name = "a_total_standard", precision = 12, scale = 3)
    private BigDecimal aTotalStandard;

    @Column(name = "a_total_measured", precision = 12, scale = 3)
    private BigDecimal aTotalMeasured;

    // =========================================================
    // B = b (or b')
    // =========================================================

    @Column(name = "b_measured", precision = 12, scale = 3)
    private BigDecimal bMeasured;

    @Column(name = "b_prime_measured", precision = 12, scale = 3)
    private BigDecimal bPrimeMeasured;
 
    @Column(name = "b_total_standard", precision = 12, scale = 3)
    private BigDecimal bTotalStandard;

    @Column(name = "b_total_measured", precision = 12, scale = 3)
    private BigDecimal bTotalMeasured;

    // =========================================================
    // C = c + X
    // =========================================================

    @Column(name = "c_measured", precision = 12, scale = 3)
    private BigDecimal cMeasured;

    @Column(name = "x2_calculated", precision = 12, scale = 3)
    private BigDecimal x2Calculated;

    @Column(name = "c_total_standard", precision = 12, scale = 3)
    private BigDecimal cTotalStandard;

    @Column(name = "c_total_measured", precision = 12, scale = 3)
    private BigDecimal cTotalMeasured;

    // =========================================================
    // Elevation / Height
    // =========================================================

    @Column(name = "h1_measured", precision = 12, scale = 3)
    private BigDecimal h1Measured;

    @Column(name = "hr1_setting_value")
    private Integer hr1SettingValue;

    @Column(name = "delta_h1_calculated", precision = 12, scale = 3)
    private BigDecimal deltaH1Calculated;

    @Column(name = "h2_measured", precision = 12, scale = 3)
    private BigDecimal h2Measured;

    @Column(name = "hr2_setting_value")
    private Integer hr2SettingValue;

    @Column(name = "delta_h2_calculated", precision = 12, scale = 3)
    private BigDecimal deltaH2Calculated;

    @Column(
            name = "difference_elevation_calculated",
            precision = 12,
            scale = 3
    )
    private BigDecimal differenceElevationCalculated;

    @Column(name = "h3_measured", precision = 12, scale = 3)
    private BigDecimal h3Measured;

    // E = h3 - larger of ΔH1 / ΔH2

    @Column(name = "e_standard", precision = 12, scale = 3)
    private BigDecimal eStandard;

    @Column(name = "e_measured", precision = 12, scale = 3)
    private BigDecimal eMeasured;

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

    public Long getC2FormationWidthTunnelDetailId() {
        return c2FormationWidthTunnelDetailId;
    }

    public void setC2FormationWidthTunnelDetailId(
            Long c2FormationWidthTunnelDetailId) {
        this.c2FormationWidthTunnelDetailId =
                c2FormationWidthTunnelDetailId;
    }

    public C2FormationWidthTunnelHeader getC2FormationWidthTunnelHeader() {
        return c2FormationWidthTunnelHeader;
    }

    public void setC2FormationWidthTunnelHeader(
            C2FormationWidthTunnelHeader c2FormationWidthTunnelHeader) {
        this.c2FormationWidthTunnelHeader =
                c2FormationWidthTunnelHeader;
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

    public void setDifferenceElevationCalculated(
            BigDecimal differenceElevationCalculated) {
        this.differenceElevationCalculated =
                differenceElevationCalculated;
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