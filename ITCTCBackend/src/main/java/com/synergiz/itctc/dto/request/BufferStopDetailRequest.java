package com.synergiz.itctc.dto.request;

import java.math.BigDecimal;


public class BufferStopDetailRequest {

    private Long bufferStopDetailId;

    private String location;

    private BigDecimal measurementPoint1;

    private BigDecimal measurementPoint2;

    private BigDecimal measurementPoint3;

    private BigDecimal measurementPoint4;

    private BigDecimal measurementPoint5;

	public Long getBufferStopDetailId() {
		return bufferStopDetailId;
	}

	public void setBufferStopDetailId(Long bufferStopDetailId) {
		this.bufferStopDetailId = bufferStopDetailId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public BigDecimal getMeasurementPoint1() {
		return measurementPoint1;
	}

	public void setMeasurementPoint1(BigDecimal measurementPoint1) {
		this.measurementPoint1 = measurementPoint1;
	}

	public BigDecimal getMeasurementPoint2() {
		return measurementPoint2;
	}

	public void setMeasurementPoint2(BigDecimal measurementPoint2) {
		this.measurementPoint2 = measurementPoint2;
	}

	public BigDecimal getMeasurementPoint3() {
		return measurementPoint3;
	}

	public void setMeasurementPoint3(BigDecimal measurementPoint3) {
		this.measurementPoint3 = measurementPoint3;
	}

	public BigDecimal getMeasurementPoint4() {
		return measurementPoint4;
	}

	public void setMeasurementPoint4(BigDecimal measurementPoint4) {
		this.measurementPoint4 = measurementPoint4;
	}

	public BigDecimal getMeasurementPoint5() {
		return measurementPoint5;
	}

	public void setMeasurementPoint5(BigDecimal measurementPoint5) {
		this.measurementPoint5 = measurementPoint5;
	}
    
    
}