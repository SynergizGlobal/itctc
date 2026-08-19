package com.synergiz.itctc.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class C4StructureGaugeRequest {

    // =========================================================
    // Measurement Information
    // =========================================================

    private LocalDate measurementDate;

    private BigDecimal chainageKm;

    private BigDecimal chainageM;

    private String straightCurve;

    private BigDecimal appliedCantValue;

    private String typeOfTrack;

    // =========================================================
    // Witnesses
    // =========================================================

    private String nhsrcl;

    private String engineerWitness;

    private String contractorWitness;

    // =========================================================
    // Remarks
    // =========================================================

    private String remarks;

    // =========================================================
    // Audit
    // =========================================================

    private String createdBy;

    private String updatedBy;

    // =========================================================
    // Details
    // =========================================================

    private List<C4StructureGaugeDetailRequest> details;

    // =========================================================
    // Getters and Setters
    // =========================================================

    public LocalDate getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(LocalDate measurementDate) {
        this.measurementDate = measurementDate;
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

    public String getStraightCurve() {
        return straightCurve;
    }

    public void setStraightCurve(String straightCurve) {
        this.straightCurve = straightCurve;
    }

    public BigDecimal getAppliedCantValue() {
        return appliedCantValue;
    }

    public void setAppliedCantValue(BigDecimal appliedCantValue) {
        this.appliedCantValue = appliedCantValue;
    }

    public String getTypeOfTrack() {
        return typeOfTrack;
    }

    public void setTypeOfTrack(String typeOfTrack) {
        this.typeOfTrack = typeOfTrack;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<C4StructureGaugeDetailRequest> getDetails() {
        return details;
    }

    public void setDetails(List<C4StructureGaugeDetailRequest> details) {
        this.details = details;
    }
}
