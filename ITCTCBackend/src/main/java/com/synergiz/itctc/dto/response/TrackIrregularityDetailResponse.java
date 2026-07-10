package com.synergiz.itctc.dto.response;


import java.math.BigDecimal;

public class TrackIrregularityDetailResponse {

    private Long trackIrregularityDetailId;

    private Integer trackDirectionId;

    private String directionName;

    private Integer trackIrregularityTypeId;

    private String measurementName;

    private BigDecimal designValue;

    private BigDecimal measuredValue;

    private BigDecimal irregularityValue;

    private String detailRemarks;

    public Long getTrackIrregularityDetailId() {
        return trackIrregularityDetailId;
    }

    public void setTrackIrregularityDetailId(Long trackIrregularityDetailId) {
        this.trackIrregularityDetailId = trackIrregularityDetailId;
    }

    public Integer getTrackDirectionId() {
        return trackDirectionId;
    }

    public void setTrackDirectionId(Integer trackDirectionId) {
        this.trackDirectionId = trackDirectionId;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public Integer getTrackIrregularityTypeId() {
        return trackIrregularityTypeId;
    }

    public void setTrackIrregularityTypeId(Integer trackIrregularityTypeId) {
        this.trackIrregularityTypeId = trackIrregularityTypeId;
    }

    public String getMeasurementName() {
        return measurementName;
    }

    public void setMeasurementName(String measurementName) {
        this.measurementName = measurementName;
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
}