package com.synergiz.itctc.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "track_irregularity_detail",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_track_irregularity_detail",
                        columnNames = {
                                "track_irregularity_id",
                                "track_direction_id",
                                "track_irregularity_type_id"
                        }
                )
        }
)
public class TrackIrregularityDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_irregularity_detail_id")
    private Long trackIrregularityDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_irregularity_id", nullable = false)
    private TrackIrregularityHeader trackIrregularityHeader;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_direction_id", nullable = false)
    private TrackDirection trackDirection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_irregularity_type_id", nullable = false)
    private TrackIrregularityType trackIrregularityType;

    @Column(name = "design_value", precision = 12, scale = 3)
    private BigDecimal designValue;

    @Column(name = "measured_value", precision = 12, scale = 3)
    private BigDecimal measuredValue;

    @Column(name = "irregularity_value", precision = 12, scale = 3)
    private BigDecimal irregularityValue;

    @Column(name = "detail_remarks", length = 500)
    private String detailRemarks;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    // =========================
    // Getters and Setters
    // =========================

    public Long getTrackIrregularityDetailId() {
        return trackIrregularityDetailId;
    }

    public void setTrackIrregularityDetailId(Long trackIrregularityDetailId) {
        this.trackIrregularityDetailId = trackIrregularityDetailId;
    }

    public TrackIrregularityHeader getTrackIrregularityHeader() {
        return trackIrregularityHeader;
    }

    public void setTrackIrregularityHeader(TrackIrregularityHeader trackIrregularityHeader) {
        this.trackIrregularityHeader = trackIrregularityHeader;
    }

    public TrackDirection getTrackDirection() {
        return trackDirection;
    }

    public void setTrackDirection(TrackDirection trackDirection) {
        this.trackDirection = trackDirection;
    }

    public TrackIrregularityType getTrackIrregularityType() {
        return trackIrregularityType;
    }

    public void setTrackIrregularityType(TrackIrregularityType trackIrregularityType) {
        this.trackIrregularityType = trackIrregularityType;
    }

    public BigDecimal getDesignValue() {
        return designValue;
    }

    public void setDesignValue(BigDecimal designValue) {
        this.designValue = designValue;
    }

    public BigDecimal getMeasuredValue() {
        return measuredValue;
    }

    public void setMeasuredValue(BigDecimal measuredValue) {
        this.measuredValue = measuredValue;
    }

    public BigDecimal getIrregularityValue() {
        return irregularityValue;
    }

    public void setIrregularityValue(BigDecimal irregularityValue) {
        this.irregularityValue = irregularityValue;
    }

    public String getDetailRemarks() {
        return detailRemarks;
    }

    public void setDetailRemarks(String detailRemarks) {
        this.detailRemarks = detailRemarks;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
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