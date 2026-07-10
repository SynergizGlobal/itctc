package com.synergiz.itctc.dto.response;



public class TrackIrregularityTypeResponse {

    private Integer trackIrregularityTypeId;

    private String measurementCode;

    private String measurementName;

    public Integer getTrackIrregularityTypeId() {
        return trackIrregularityTypeId;
    }

    public void setTrackIrregularityTypeId(Integer trackIrregularityTypeId) {
        this.trackIrregularityTypeId = trackIrregularityTypeId;
    }

    public String getMeasurementCode() {
        return measurementCode;
    }

    public void setMeasurementCode(String measurementCode) {
        this.measurementCode = measurementCode;
    }

    public String getMeasurementName() {
        return measurementName;
    }

    public void setMeasurementName(String measurementName) {
        this.measurementName = measurementName;
    }
}