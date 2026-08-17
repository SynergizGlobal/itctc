package com.synergiz.itctc.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class C2FormationWidthTunnelResponse {

    private Long c2FormationWidthTunnelId;

    private LocalDate measurementDate;

    private BigDecimal chainageKm;
    private BigDecimal chainageM;
  
    private String straightCurve;

    private BigDecimal shiftValue;

    private BigDecimal appliedCantValue;

    private String typeOfTrack;

    // Witnesses
    private String nhsrcl;
    private String engineerWitness;
    private String contractorWitness;

    private String remarks;

    // Audit
    private Boolean isActive;
    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime updatedDate;

    private List<C2FormationWidthTunnelDetailResponse> details;

    // Inspection Workflow
    private InspectionWorkflowResponse workflow;

    public Long getC2FormationWidthTunnelId() {
        return c2FormationWidthTunnelId;
    }

    public void setC2FormationWidthTunnelId(Long c2FormationWidthTunnelId) {
        this.c2FormationWidthTunnelId =
                c2FormationWidthTunnelId;
    }

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

    public BigDecimal getShiftValue() {
        return shiftValue;
    }

    public void setShiftValue(BigDecimal shiftValue) {
        this.shiftValue = shiftValue;
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

    public List<C2FormationWidthTunnelDetailResponse> getDetails() {
        return details;
    }

    public void setDetails(
            List<C2FormationWidthTunnelDetailResponse> details) {
        this.details = details;
    }

    public InspectionWorkflowResponse getWorkflow() {
        return workflow;
    }

    public void setWorkflow(InspectionWorkflowResponse workflow) {
        this.workflow = workflow;
    }
}