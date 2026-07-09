package com.synergiz.itctc.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name="TrackType")

public class TrackType {

    public Integer getTrackTypeId() {
		return trackTypeId;
	}

	public void setTrackTypeId(Integer trackTypeId) {
		this.trackTypeId = trackTypeId;
	}

	public String getTrackTypeCode() {
		return trackTypeCode;
	}

	public void setTrackTypeCode(String trackTypeCode) {
		this.trackTypeCode = trackTypeCode;
	}

	public String getTrackTypeName() {
		return trackTypeName;
	}

	public void setTrackTypeName(String trackTypeName) {
		this.trackTypeName = trackTypeName;
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

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TrackTypeId")
    private Integer trackTypeId;

    @Column(name="TrackTypeCode")
    private String trackTypeCode;

    @Column(name="TrackTypeName")
    private String trackTypeName;

    @Column(name="IsActive")
    private Boolean isActive;

    @Column(name="CreatedBy")
    private String createdBy;

    @Column(name="CreatedDate")
    private LocalDateTime createdDate;

    @Column(name="UpdatedBy")
    private String updatedBy;

    @Column(name="UpdatedDate")
    private LocalDateTime updatedDate;

}
