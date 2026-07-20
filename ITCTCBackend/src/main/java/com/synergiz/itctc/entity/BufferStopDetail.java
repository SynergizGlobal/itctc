package com.synergiz.itctc.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "buffer_stop_detail")

public class BufferStopDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buffer_stop_detail_id")
    private Long bufferStopDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "buffer_stop_header_id",
            nullable = false
    )
    private BufferStopHeader bufferStopHeader;

    @Column(name = "location")
    private String location;

    @Column(name = "measurement_point_1")
    private BigDecimal measurementPoint1;

    @Column(name = "measurement_point_2")
    private BigDecimal measurementPoint2;

    @Column(name = "measurement_point_3")
    private BigDecimal measurementPoint3;

    @Column(name = "measurement_point_4")
    private BigDecimal measurementPoint4;

    @Column(name = "measurement_point_5")
    private BigDecimal measurementPoint5;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

	public Long getBufferStopDetailId() {
		return bufferStopDetailId;
	}

	public void setBufferStopDetailId(Long bufferStopDetailId) {
		this.bufferStopDetailId = bufferStopDetailId;
	}

	public BufferStopHeader getBufferStopHeader() {
		return bufferStopHeader;
	}

	public void setBufferStopHeader(BufferStopHeader bufferStopHeader) {
		this.bufferStopHeader = bufferStopHeader;
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
    
    
}