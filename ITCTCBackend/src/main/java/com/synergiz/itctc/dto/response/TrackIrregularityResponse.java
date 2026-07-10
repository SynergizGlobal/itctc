package com.synergiz.itctc.dto.response;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TrackIrregularityResponse {

    private Long trackIrregularityId;

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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public List<TrackIrregularityDetailResponse> getDetails() {
		return details;
	}

	public void setDetails(List<TrackIrregularityDetailResponse> details) {
		this.details = details;
	}

	private Integer projectId;

    private String formNumber;

    private LocalDate measurementDate;

    private BigDecimal chainageKm;

    private BigDecimal chainageM;

    private String measuringPointDown;

    private String measuringPointUp;

    private String verticalCurveDiagramDown;

    private String planeCurveDiagramDown;

    private String verticalCurveDiagramUp;

    private String planeCurveDiagramUp;

    private String remarks;

    private LocalDateTime createdDate;

    private List<TrackIrregularityDetailResponse> details;

    
}