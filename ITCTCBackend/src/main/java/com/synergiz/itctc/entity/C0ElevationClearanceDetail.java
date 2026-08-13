package com.synergiz.itctc.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "c0_elevation_clearance_detail")

public class C0ElevationClearanceDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c0_elevation_clearance_detail_id")
	private Long c0ElevationClearanceDetailId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c0_elevation_clearance_id", nullable = false)
	private C0ElevationClearanceHeader c0ElevationClearanceHeader;

	@Column(name = "car_number", nullable = false)
	private Integer carNumber;

	@Column(name = "measurement_point", nullable = false, length = 10)
	private String measurementPoint;

	@Column(name = "position", nullable = false, length = 50)
	private String position;

	@Column(name = "elevation_calculated", precision = 12, scale = 3)
	private BigDecimal elevationCalculated;

	@Column(name = "elevation_measured", precision = 12, scale = 3)
	private BigDecimal elevationMeasured;

	@Column(name = "clearance_calculated", precision = 12, scale = 3)
	private BigDecimal clearanceCalculated;

	@Column(name = "clearance_measured", precision = 12, scale = 3)
	private BigDecimal clearanceMeasured;

	@Column(name = "remarks", length = 1000)
	private String remarks;

	@Column(name = "is_active", nullable = false)
	private Boolean isActive = true;

	@Column(name = "created_by", length = 100)
	private String createdBy;

	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Column(name = "updated_by", length = 100)
	private String updatedBy;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	public Long getC0ElevationClearanceDetailId() {
		return c0ElevationClearanceDetailId;
	}

	public void setC0ElevationClearanceDetailId(Long c0ElevationClearanceDetailId) {
		this.c0ElevationClearanceDetailId = c0ElevationClearanceDetailId;
	}

	public C0ElevationClearanceHeader getC0ElevationClearanceHeader() {
		return c0ElevationClearanceHeader;
	}

	public void setC0ElevationClearanceHeader(C0ElevationClearanceHeader c0ElevationClearanceHeader) {
		this.c0ElevationClearanceHeader = c0ElevationClearanceHeader;
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