package com.synergiz.itctc.entity;



import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "track_irregularity_header")
public class TrackIrregularityHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_irregularity_id")
    private Long trackIrregularityId;

    @Column(name = "project_id", nullable = false)
    private Integer projectId;

    @Column(name = "form_number", nullable = false, length = 20)
    private String formNumber;

    @Column(name = "measurement_date", nullable = false)
    private LocalDate measurementDate;

    @Column(name = "chainage_km", precision = 10, scale = 3, nullable = false)
    private BigDecimal chainageKm;

    @Column(name = "chainage_m", precision = 10, scale = 3, nullable = false)
    private BigDecimal chainageM;

    @Column(name = "measuring_point_down", length = 100)
    private String measuringPointDown;

    @Column(name = "measuring_point_up", length = 100)
    private String measuringPointUp;

    @Column(name = "vertical_curve_diagram_down", length = 255)
    private String verticalCurveDiagramDown;

    @Column(name = "plane_curve_diagram_down", length = 255)
    private String planeCurveDiagramDown;

    @Column(name = "vertical_curve_diagram_up", length = 255)
    private String verticalCurveDiagramUp;

    @Column(name = "plane_curve_diagram_up", length = 255)
    private String planeCurveDiagramUp;

    @Column(name = "remarks", length = 2000)
    private String remarks;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_by", nullable = false, length = 100)
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @OneToMany(
            mappedBy = "trackIrregularityHeader",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<TrackIrregularityDetail> details = new ArrayList<>();

    // ===========================
    // Getters and Setters
    // ===========================

    public Long getTrackIrregularityId() {
        return trackIrregularityId;
    }

    public void setTrackIrregularityId(Long trackIrregularityId) {
        this.trackIrregularityId = trackIrregularityId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getFormNumber() {
        return formNumber;
    }

    public void setFormNumber(String formNumber) {
        this.formNumber = formNumber;
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

    public String getMeasuringPointDown() {
        return measuringPointDown;
    }

    public void setMeasuringPointDown(String measuringPointDown) {
        this.measuringPointDown = measuringPointDown;
    }

    public String getMeasuringPointUp() {
        return measuringPointUp;
    }

    public void setMeasuringPointUp(String measuringPointUp) {
        this.measuringPointUp = measuringPointUp;
    }

    public String getVerticalCurveDiagramDown() {
        return verticalCurveDiagramDown;
    }

    public void setVerticalCurveDiagramDown(String verticalCurveDiagramDown) {
        this.verticalCurveDiagramDown = verticalCurveDiagramDown;
    }

    public String getPlaneCurveDiagramDown() {
        return planeCurveDiagramDown;
    }

    public void setPlaneCurveDiagramDown(String planeCurveDiagramDown) {
        this.planeCurveDiagramDown = planeCurveDiagramDown;
    }

    public String getVerticalCurveDiagramUp() {
        return verticalCurveDiagramUp;
    }

    public void setVerticalCurveDiagramUp(String verticalCurveDiagramUp) {
        this.verticalCurveDiagramUp = verticalCurveDiagramUp;
    }

    public String getPlaneCurveDiagramUp() {
        return planeCurveDiagramUp;
    }

    public void setPlaneCurveDiagramUp(String planeCurveDiagramUp) {
        this.planeCurveDiagramUp = planeCurveDiagramUp;
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

    public void setIsActive(Boolean active) {
        isActive = active;
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

    public List<TrackIrregularityDetail> getDetails() {
        return details;
    }

    public void setDetails(List<TrackIrregularityDetail> details) {
        this.details = details;
    }
}