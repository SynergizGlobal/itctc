package com.synergiz.itctc.dto.request;

import java.math.BigDecimal;
import java.util.List;

public class MeasurementUpdateRequest {

    private Integer projectId;
    private BigDecimal chainageKm;
    private BigDecimal chainageM;

    private Integer structureTypeId;
    private Integer trackTypeId;

    private Boolean isCurve;
    private BigDecimal curveRadius;
    private BigDecimal appliedCantValueMm;

    private String remarks;

    private String updatedBy;

    private List<MeasurementDetailRequest> details;

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

    public Integer getStructureTypeId() {
        return structureTypeId;
    }

    public void setStructureTypeId(Integer structureTypeId) {
        this.structureTypeId = structureTypeId;
    }

    public Integer getTrackTypeId() {
        return trackTypeId;
    }

    public void setTrackTypeId(Integer trackTypeId) {
        this.trackTypeId = trackTypeId;
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

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<MeasurementDetailRequest> getDetails() {
        return details;
    }

    public void setDetails(List<MeasurementDetailRequest> details) {
        this.details = details;
    }
}