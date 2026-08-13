package com.synergiz.itctc.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "c0_elevation_clearance_header")

public class C0ElevationClearanceHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c0_elevation_clearance_id")
	private Long c0ElevationClearanceId;

	@Column(name = "station_name", nullable = false, length = 200)
	private String stationName;

	@Column(name = "line", nullable = false, length = 100)
	private String line;

	@Column(name = "measurement_date", nullable = false)
	private LocalDate measurementDate;

	@Column(name = "series_of_rolling_stock", length = 200)
	private String seriesOfRollingStock;

	@Column(name = "nhsrcl", length = 200)
	private String nhsrcl;

	@Column(name = "engineer_witness", length = 200)
	private String engineerWitness;

	@Column(name = "contractor_witness", length = 200)
	private String contractorWitness;

	@Column(name = "elevation_design_value", precision = 12, scale = 3)
	private BigDecimal elevationDesignValue;

	@Column(name = "elevation_tolerance_from", precision = 12, scale = 3)
	private BigDecimal elevationToleranceFrom;

	@Column(name = "elevation_tolerance_to", precision = 12, scale = 3)
	private BigDecimal elevationToleranceTo;

	@Column(name = "clearance_design_value", precision = 12, scale = 3)
	private BigDecimal clearanceDesignValue;

	@Column(name = "clearance_tolerance_from", precision = 12, scale = 3)
	private BigDecimal clearanceToleranceFrom;

	@Column(name = "clearance_tolerance_to", precision = 12, scale = 3)
	private BigDecimal clearanceToleranceTo;

	@Column(name = "max_elevation_measured", precision = 12, scale = 3)
	private BigDecimal maxElevationMeasured;

	@Column(name = "min_elevation_measured", precision = 12, scale = 3)
	private BigDecimal minElevationMeasured;

	@Column(name = "max_clearance_measured", precision = 12, scale = 3)
	private BigDecimal maxClearanceMeasured;

	@Column(name = "min_clearance_measured", precision = 12, scale = 3)
	private BigDecimal minClearanceMeasured;

	@Column(name = "remarks", length = 2000)
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

	@OneToMany(mappedBy = "c0ElevationClearanceHeader", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<C0ElevationClearanceDetail> details = new ArrayList<>();

	public Long getC0ElevationClearanceId() {
		return c0ElevationClearanceId;
	}

	public void setC0ElevationClearanceId(Long c0ElevationClearanceId) {
		this.c0ElevationClearanceId = c0ElevationClearanceId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public LocalDate getMeasurementDate() {
		return measurementDate;
	}

	public void setMeasurementDate(LocalDate measurementDate) {
		this.measurementDate = measurementDate;
	}

	public String getSeriesOfRollingStock() {
		return seriesOfRollingStock;
	}

	public void setSeriesOfRollingStock(String seriesOfRollingStock) {
		this.seriesOfRollingStock = seriesOfRollingStock;
	}

	public String getNhsrcl() {
		return nhsrcl;
	}

	public void setNhsrcl(String nhsrcl) {
		this.nhsrcl = nhsrcl;
	}

	public String getEngineerWitness() {
		return engineerWitness;
	}

	public void setEngineerWitness(String engineerWitness) {
		this.engineerWitness = engineerWitness;
	}

	public String getContractorWitness() {
		return contractorWitness;
	}

	public void setContractorWitness(String contractorWitness) {
		this.contractorWitness = contractorWitness;
	}

	public BigDecimal getElevationDesignValue() {
		return elevationDesignValue;
	}

	public void setElevationDesignValue(BigDecimal elevationDesignValue) {
		this.elevationDesignValue = elevationDesignValue;
	}

	public BigDecimal getElevationToleranceFrom() {
		return elevationToleranceFrom;
	}

	public void setElevationToleranceFrom(BigDecimal elevationToleranceFrom) {
		this.elevationToleranceFrom = elevationToleranceFrom;
	}

	public BigDecimal getElevationToleranceTo() {
		return elevationToleranceTo;
	}

	public void setElevationToleranceTo(BigDecimal elevationToleranceTo) {
		this.elevationToleranceTo = elevationToleranceTo;
	}

	public BigDecimal getClearanceDesignValue() {
		return clearanceDesignValue;
	}

	public void setClearanceDesignValue(BigDecimal clearanceDesignValue) {
		this.clearanceDesignValue = clearanceDesignValue;
	}

	public BigDecimal getClearanceToleranceFrom() {
		return clearanceToleranceFrom;
	}

	public void setClearanceToleranceFrom(BigDecimal clearanceToleranceFrom) {
		this.clearanceToleranceFrom = clearanceToleranceFrom;
	}

	public BigDecimal getClearanceToleranceTo() {
		return clearanceToleranceTo;
	}

	public void setClearanceToleranceTo(BigDecimal clearanceToleranceTo) {
		this.clearanceToleranceTo = clearanceToleranceTo;
	}

	public BigDecimal getMaxElevationMeasured() {
		return maxElevationMeasured;
	}

	public void setMaxElevationMeasured(BigDecimal maxElevationMeasured) {
		this.maxElevationMeasured = maxElevationMeasured;
	}

	public BigDecimal getMinElevationMeasured() {
		return minElevationMeasured;
	}

	public void setMinElevationMeasured(BigDecimal minElevationMeasured) {
		this.minElevationMeasured = minElevationMeasured;
	}

	public BigDecimal getMaxClearanceMeasured() {
		return maxClearanceMeasured;
	}

	public void setMaxClearanceMeasured(BigDecimal maxClearanceMeasured) {
		this.maxClearanceMeasured = maxClearanceMeasured;
	}

	public BigDecimal getMinClearanceMeasured() {
		return minClearanceMeasured;
	}

	public void setMinClearanceMeasured(BigDecimal minClearanceMeasured) {
		this.minClearanceMeasured = minClearanceMeasured;
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

	public List<C0ElevationClearanceDetail> getDetails() {
		return details;
	}

	public void setDetails(List<C0ElevationClearanceDetail> details) {
		this.details = details;
	}

}