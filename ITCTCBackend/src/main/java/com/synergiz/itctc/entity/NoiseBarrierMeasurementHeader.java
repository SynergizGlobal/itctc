package com.synergiz.itctc.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "noise_barrier_measurement_header")
public class NoiseBarrierMeasurementHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noise_barrier_measurement_id")
    private Long noiseBarrierMeasurementId;

    @Column(name = "project_id", nullable = false)
    private Integer projectId;

    @Column(name = "chainage_km", nullable = false)
    private BigDecimal chainageKm;

    @Column(name = "chainage_m", nullable = false)
    private BigDecimal chainageM;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "structure_type_id", nullable = false)
    private StructureType structureType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_type_id", nullable = false)
    private TrackType trackType;

    @Column(name = "is_curve")
    private Boolean isCurve;

    @Column(name = "curve_radius")
    private BigDecimal curveRadius;

    @Column(name = "applied_cant_value_mm")
    private BigDecimal appliedCantValueMm;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @OneToMany(
            mappedBy = "noiseBarrierMeasurementHeader",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<NoiseBarrierMeasurementDetail> details = new ArrayList<>();

    public Long getNoiseBarrierMeasurementId() {
        return noiseBarrierMeasurementId;
    }

    public void setNoiseBarrierMeasurementId(Long noiseBarrierMeasurementId) {
        this.noiseBarrierMeasurementId = noiseBarrierMeasurementId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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

    public StructureType getStructureType() {
        return structureType;
    }

    public void setStructureType(StructureType structureType) {
        this.structureType = structureType;
    }

    public TrackType getTrackType() {
        return trackType;
    }

    public void setTrackType(TrackType trackType) {
        this.trackType = trackType;
    }

    public Boolean getIsCurve() {
        return isCurve;
    }

    public void setIsCurve(Boolean isCurve) {
        this.isCurve = isCurve;
    }

    public BigDecimal getCurveRadius() {
        return curveRadius;
    }

    public void setCurveRadius(BigDecimal curveRadius) {
        this.curveRadius = curveRadius;
    }

    public BigDecimal getAppliedCantValueMm() {
        return appliedCantValueMm;
    }

    public void setAppliedCantValueMm(BigDecimal appliedCantValueMm) {
        this.appliedCantValueMm = appliedCantValueMm;
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

    public List<NoiseBarrierMeasurementDetail> getDetails() {
        return details;
    }

    public void setDetails(List<NoiseBarrierMeasurementDetail> details) {
        this.details = details;
    }
}