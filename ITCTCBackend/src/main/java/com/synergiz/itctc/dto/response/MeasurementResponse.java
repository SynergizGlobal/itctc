package com.synergiz.itctc.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class MeasurementResponse {

    private Long measurementId;

    private Integer projectId;

    private BigDecimal chainageKm;

    public Long getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(Long measurementId) {
		this.measurementId = measurementId;
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

	public Integer getStructureTypeId() {
		return structureTypeId;
	}

	public void setStructureTypeId(Integer structureTypeId) {
		this.structureTypeId = structureTypeId;
	}

	public String getStructureTypeName() {
		return structureTypeName;
	}

	public void setStructureTypeName(String structureTypeName) {
		this.structureTypeName = structureTypeName;
	}

	public Integer getTrackTypeId() {
		return trackTypeId;
	}

	public void setTrackTypeId(Integer trackTypeId) {
		this.trackTypeId = trackTypeId;
	}

	public String getTrackTypeName() {
		return trackTypeName;
	}

	public void setTrackTypeName(String trackTypeName) {
		this.trackTypeName = trackTypeName;
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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public List<MeasurementDetailResponse> getDetails() {
		return details;
	}

	public void setDetails(List<MeasurementDetailResponse> details) {
		this.details = details;
	}

	private BigDecimal chainageM;

    private Integer structureTypeId;

    private String structureTypeName;

    private Integer trackTypeId;

    private String trackTypeName;

    private Boolean isCurve;

    private BigDecimal curveRadius;

    private BigDecimal appliedCantValueMm;

    private String remarks;

    private LocalDateTime createdDate;

    private List<MeasurementDetailResponse> details;

}