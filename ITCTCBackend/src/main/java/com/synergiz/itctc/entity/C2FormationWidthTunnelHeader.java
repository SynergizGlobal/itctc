package com.synergiz.itctc.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "c2_formation_width_tunnel_header")
public class C2FormationWidthTunnelHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c2_formation_width_tunnel_id")
    private Long c2FormationWidthTunnelId;

    @Column(name = "measurement_date", nullable = false)
    private LocalDate measurementDate;

    @Column(name = "chainage_km", nullable = false, precision = 10, scale = 3)
    private BigDecimal chainageKm;

    @Column(name = "chainage_m", nullable = false, precision = 10, scale = 3)
    private BigDecimal chainageM;

    @Column(name = "straight_curve", length = 100)
    private String straightCurve;

    @Column(name = "shift_value", precision = 12, scale = 3)
    private BigDecimal shiftValue;

    @Column(name = "applied_cant_value", precision = 12, scale = 3)
    private BigDecimal appliedCantValue;

    @Column(name = "type_of_track", length = 100)
    private String typeOfTrack;

    // Witnesses

    @Column(name = "nhsrcl", length = 200)
    private String nhsrcl;

    @Column(name = "engineer_witness", length = 200)
    private String engineerWitness;

    @Column(name = "contractor_witness", length = 200)
    private String contractorWitness;

    @Column(name = "remarks", length = 2000)
    private String remarks;

    // Audit

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

    @OneToMany(
            mappedBy = "c2FormationWidthTunnelHeader",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<C2FormationWidthTunnelDetail> details = new ArrayList<>();

    public Long getC2FormationWidthTunnelId() {
        return c2FormationWidthTunnelId;
    }

    public void setC2FormationWidthTunnelId(Long c2FormationWidthTunnelId) {
        this.c2FormationWidthTunnelId = c2FormationWidthTunnelId;
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

    public List<C2FormationWidthTunnelDetail> getDetails() {
        return details;
    }

    public void setDetails(List<C2FormationWidthTunnelDetail> details) {
        this.details = details;
    }
}