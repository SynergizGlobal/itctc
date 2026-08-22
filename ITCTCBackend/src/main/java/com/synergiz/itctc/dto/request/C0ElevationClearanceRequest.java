package com.synergiz.itctc.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class C0ElevationClearanceRequest {

	private String stationName;

	private String line;

	private LocalDate measurementDate;

	private String seriesOfRollingStock;

	private String nhsrcl;

	private String engineerWitness;

	private String contractorWitness;

	// ===========================
	// Elevation Design / Tolerance
	// ===========================

	private BigDecimal elevationDesignValue;

	private BigDecimal elevationToleranceFrom;

	private BigDecimal elevationToleranceTo;

	// ===========================
	// Clearance Design / Tolerance
	// ===========================

	private BigDecimal clearanceDesignValue;

	private BigDecimal clearanceToleranceFrom;

	private BigDecimal clearanceToleranceTo;

	// ===========================
	// Overall Remarks
	// ===========================

	private String remarks;
	private String updatedBy;
	private String createdBy;

	// ===========================
	// Details
	// ===========================

	private List<C0ElevationClearanceDetailRequest> details;

	private InspectionFormCaptureRequest inspectionFormCapture;

	private List<InspectionFileRequest> attachments;

	public C0ElevationClearanceRequest() {
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

	public List<C0ElevationClearanceDetailRequest> getDetails() {
		return details;
	}

	public void setDetails(List<C0ElevationClearanceDetailRequest> details) {
		this.details = details;
	}

	public InspectionFormCaptureRequest getInspectionFormCapture() {
		return inspectionFormCapture;
	}

	public void setInspectionFormCapture(InspectionFormCaptureRequest inspectionFormCapture) {
		this.inspectionFormCapture = inspectionFormCapture;
	}

	public List<InspectionFileRequest> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<InspectionFileRequest> attachments) {
		this.attachments = attachments;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}