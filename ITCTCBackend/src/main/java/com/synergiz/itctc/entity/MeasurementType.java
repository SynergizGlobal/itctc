package com.synergiz.itctc.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="MeasurementType")

public class MeasurementType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MeasurementTypeId")
    private Integer measurementTypeId;

    @Column(name="MeasurementCode")
    private String measurementCode;

    @Column(name="MeasurementName")
    private String measurementName;

    @Column(name="DisplayOrder")
    private Integer displayOrder;

    @Column(name="IsActive")
    private Boolean isActive;

    @Column(name="CreatedBy")
    private String createdBy;

    @Column(name="CreatedDate")
    private LocalDateTime createdDate;

    public Integer getMeasurementTypeId() {
		return measurementTypeId;
	}

	public void setMeasurementTypeId(Integer measurementTypeId) {
		this.measurementTypeId = measurementTypeId;
	}

	public String getMeasurementCode() {
		return measurementCode;
	}

	public void setMeasurementCode(String measurementCode) {
		this.measurementCode = measurementCode;
	}

	public String getMeasurementName() {
		return measurementName;
	}

	public void setMeasurementName(String measurementName) {
		this.measurementName = measurementName;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
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

	@Column(name="UpdatedBy")
    private String updatedBy;

    @Column(name="UpdatedDate")
    private LocalDateTime updatedDate;

}