package com.synergiz.itctc.dto.request;

import java.math.BigDecimal;

public class C0ElevationClearanceDetailRequest {

	private Long c0ElevationClearanceDetailId;

	private Integer carNumber;

	private String measurementPoint;

	private String position;

	private BigDecimal elevationCalculated;

	private BigDecimal elevationMeasured;

	private BigDecimal clearanceCalculated;

	private BigDecimal clearanceMeasured;

	private String remarks;

	public C0ElevationClearanceDetailRequest() {
	}

	public Long getC0ElevationClearanceDetailId() {
		return c0ElevationClearanceDetailId;
	}

	public void setC0ElevationClearanceDetailId(Long c0ElevationClearanceDetailId) {
		this.c0ElevationClearanceDetailId = c0ElevationClearanceDetailId;
	}

	public Integer getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(Integer carNumber) {
		this.carNumber = carNumber;
	}

	public String getMeasurementPoint() {
		return measurementPoint;
	}

	public void setMeasurementPoint(String measurementPoint) {
		this.measurementPoint = measurementPoint;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public BigDecimal getElevationCalculated() {
		return elevationCalculated;
	}

	public void setElevationCalculated(BigDecimal elevationCalculated) {
		this.elevationCalculated = elevationCalculated;
	}

	public BigDecimal getElevationMeasured() {
		return elevationMeasured;
	}

	public void setElevationMeasured(BigDecimal elevationMeasured) {
		this.elevationMeasured = elevationMeasured;
	}

	public BigDecimal getClearanceCalculated() {
		return clearanceCalculated;
	}

	public void setClearanceCalculated(BigDecimal clearanceCalculated) {
		this.clearanceCalculated = clearanceCalculated;
	}

	public BigDecimal getClearanceMeasured() {
		return clearanceMeasured;
	}

	public void setClearanceMeasured(BigDecimal clearanceMeasured) {
		this.clearanceMeasured = clearanceMeasured;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
