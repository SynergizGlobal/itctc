package com.synergiz.itctc.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "noise_barrier_measurement_detail")
public class NoiseBarrierMeasurementDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noise_barrier_measurement_detail_id")
    private Long noiseBarrierMeasurementDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "noise_barrier_measurement_id", nullable = false)
    private NoiseBarrierMeasurementHeader noiseBarrierMeasurementHeader;

    @Column(name = "h1_measured_value")
    private BigDecimal h1MeasuredValue;

    @Column(name = "h2_measured_value")
    private BigDecimal h2MeasuredValue;

    @Column(name = "h3_measured_value")
    private BigDecimal h3MeasuredValue;

    @Column(name = "h4_measured_value")
    private BigDecimal h4MeasuredValue;

    @Column(name = "h5_measured_value")
    private BigDecimal h5MeasuredValue;

    @Column(name = "h6_measured_value")
    private BigDecimal h6MeasuredValue;

    @Column(name = "a_standard_value")
    private BigDecimal aStandardValue;

    @Column(name = "a_measured_value")
    private BigDecimal aMeasuredValue;

    @Column(name = "b_standard_value")
    private BigDecimal bStandardValue;

    @Column(name = "b_measured_value")
    private BigDecimal bMeasuredValue;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public Long getNoiseBarrierMeasurementDetailId() {
        return noiseBarrierMeasurementDetailId;
    }

    public void setNoiseBarrierMeasurementDetailId(Long noiseBarrierMeasurementDetailId) {
        this.noiseBarrierMeasurementDetailId = noiseBarrierMeasurementDetailId;
    }

    public NoiseBarrierMeasurementHeader getNoiseBarrierMeasurementHeader() {
        return noiseBarrierMeasurementHeader;
    }

    public void setNoiseBarrierMeasurementHeader(NoiseBarrierMeasurementHeader noiseBarrierMeasurementHeader) {
        this.noiseBarrierMeasurementHeader = noiseBarrierMeasurementHeader;
    }

    public BigDecimal getH1MeasuredValue() {
        return h1MeasuredValue;
    }

    public void setH1MeasuredValue(BigDecimal h1MeasuredValue) {
        this.h1MeasuredValue = h1MeasuredValue;
    }

    public BigDecimal getH2MeasuredValue() {
        return h2MeasuredValue;
    }

    public void setH2MeasuredValue(BigDecimal h2MeasuredValue) {
        this.h2MeasuredValue = h2MeasuredValue;
    }

    public BigDecimal getH3MeasuredValue() {
        return h3MeasuredValue;
    }

    public void setH3MeasuredValue(BigDecimal h3MeasuredValue) {
        this.h3MeasuredValue = h3MeasuredValue;
    }

    public BigDecimal getH4MeasuredValue() {
        return h4MeasuredValue;
    }

    public void setH4MeasuredValue(BigDecimal h4MeasuredValue) {
        this.h4MeasuredValue = h4MeasuredValue;
    }

    public BigDecimal getH5MeasuredValue() {
        return h5MeasuredValue;
    }

    public void setH5MeasuredValue(BigDecimal h5MeasuredValue) {
        this.h5MeasuredValue = h5MeasuredValue;
    }

    public BigDecimal getH6MeasuredValue() {
        return h6MeasuredValue;
    }

    public void setH6MeasuredValue(BigDecimal h6MeasuredValue) {
        this.h6MeasuredValue = h6MeasuredValue;
    }

    public BigDecimal getAStandardValue() {
        return aStandardValue;
    }

    public void setAStandardValue(BigDecimal aStandardValue) {
        this.aStandardValue = aStandardValue;
    }

    public BigDecimal getAMeasuredValue() {
        return aMeasuredValue;
    }

    public void setAMeasuredValue(BigDecimal aMeasuredValue) {
        this.aMeasuredValue = aMeasuredValue;
    }

    public BigDecimal getBStandardValue() {
        return bStandardValue;
    }

    public void setBStandardValue(BigDecimal bStandardValue) {
        this.bStandardValue = bStandardValue;
    }

    public BigDecimal getBMeasuredValue() {
        return bMeasuredValue;
    }

    public void setBMeasuredValue(BigDecimal bMeasuredValue) {
        this.bMeasuredValue = bMeasuredValue;
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
}