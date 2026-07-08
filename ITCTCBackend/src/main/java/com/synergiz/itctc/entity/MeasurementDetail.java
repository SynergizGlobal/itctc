package com.synergiz.itctc.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="MeasurementDetail")

public class MeasurementDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MeasurementDetailId")
    private Long measurementDetailId;

    public Long getMeasurementDetailId() {
		return measurementDetailId;
	}

	public void setMeasurementDetailId(Long measurementDetailId) {
		this.measurementDetailId = measurementDetailId;
	}

	public MeasurementHeader getMeasurementHeader() {
		return measurementHeader;
	}

	public void setMeasurementHeader(MeasurementHeader measurementHeader) {
		this.measurementHeader = measurementHeader;
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

	public BigDecimal getaStandard() {
		return aStandard;
	}

	public void setaStandard(BigDecimal aStandard) {
		this.aStandard = aStandard;
	}

	public BigDecimal getAMeasuredTotal() {
		return aMeasuredTotal;
	}

	public void setAMeasuredTotal(BigDecimal aMeasuredTotal) {
		this.aMeasuredTotal = aMeasuredTotal;
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

	public BigDecimal getBStandard() {
		return bStandard;
	}

	public void setBStandard(BigDecimal bStandard) {
		this.bStandard = bStandard;
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

	public BigDecimal getDStandard() {
		return dStandard;
	}

	public void setDStandard(BigDecimal dStandard) {
		this.dStandard = dStandard;
	}

	public BigDecimal getDMeasured() {
		return dMeasured;
	}

	public void setDMeasured(BigDecimal dMeasured) {
		this.dMeasured = dMeasured;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MeasurementId")
    private MeasurementHeader measurementHeader;

    @Column(name="A_Measured")
    private BigDecimal aMeasured;

    @Column(name="X1_Calculated")
    private BigDecimal x1Calculated;

    @Column(name="A_Standard")
    private BigDecimal aStandard;

    @Column(name="A_Measured_Total")
    private BigDecimal aMeasuredTotal;

    @Column(name="B_Measured")
    private BigDecimal bMeasured;

    @Column(name="B_Prime_Measured")
    private BigDecimal bPrimeMeasured;

    @Column(name="B_Standard")
    private BigDecimal bStandard;

    @Column(name="B_Total_Measured")
    private BigDecimal bTotalMeasured;

    @Column(name="C_Measured")
    private BigDecimal cMeasured;

    @Column(name="X2_Calculated")
    private BigDecimal x2Calculated;

    @Column(name="C_Standard")
    private BigDecimal cStandard;

    @Column(name="C_Total_Measured")
    private BigDecimal cTotalMeasured;

    @Column(name="D_Standard")
    private BigDecimal dStandard;

    @Column(name="D_Measured")
    private BigDecimal dMeasured;

    @Column(name="IsActive")
    private Boolean isActive;

    @Column(name="CreatedDate")
    private LocalDateTime createdDate;

}