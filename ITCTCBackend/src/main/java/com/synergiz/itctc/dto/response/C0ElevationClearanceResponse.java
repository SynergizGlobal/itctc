package com.synergiz.itctc.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class C0ElevationClearanceResponse {

    private Long c0ElevationClearanceId;

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
    // Dynamic Maximum / Minimum
    // ===========================

    private BigDecimal maxElevationMeasured;

    private BigDecimal minElevationMeasured;

    private BigDecimal maxClearanceMeasured;

    private BigDecimal minClearanceMeasured;

    // ===========================
    // Remarks
    // ===========================

    private String remarks;

    private Boolean isActive;

    private String createdBy;

    private LocalDateTime createdDate;

    private String updatedBy;

    private LocalDateTime updatedDate;

    // ===========================
    // Details
    // ===========================

    private List<C0ElevationClearanceDetailResponse> details;

    // ===========================
    // Workflow
    // ===========================

    private InspectionWorkflowResponse workflow;

    public C0ElevationClearanceResponse() {
    }

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

    public List<C0ElevationClearanceDetailResponse> getDetails() {
        return details;
    }

    public void setDetails(List<C0ElevationClearanceDetailResponse> details) {
        this.details = details;
    }

    public InspectionWorkflowResponse getWorkflow() {
        return workflow;
    }

    public void setWorkflow(InspectionWorkflowResponse workflow) {
        this.workflow = workflow;
    }
}
