package com.synergiz.itctc.dto.response;


public class TrackDirectionResponse {

    private Integer trackDirectionId;

    private String directionCode;

    private String directionName;

    public Integer getTrackDirectionId() {
        return trackDirectionId;
    }

    public void setTrackDirectionId(Integer trackDirectionId) {
        this.trackDirectionId = trackDirectionId;
    }

    public String getDirectionCode() {
        return directionCode;
    }

    public void setDirectionCode(String directionCode) {
        this.directionCode = directionCode;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }
}