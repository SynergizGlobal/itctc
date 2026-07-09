package com.synergiz.itctc.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name="StructureType")

public class StructureType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="StructureTypeId")
    private Integer structureTypeId;

    @Column(name="StructureCode")
    private String structureCode;

    @Column(name="StructureName")
    private String structureName;

    @Column(name="IsActive")
    private Boolean isActive;

    @Column(name="CreatedBy")
    private String createdBy;

    @Column(name="CreatedDate")
    private LocalDateTime createdDate;

    public Integer getStructureTypeId() {
		return structureTypeId;
	}

	public void setStructureTypeId(Integer structureTypeId) {
		this.structureTypeId = structureTypeId;
	}

	public String getStructureCode() {
		return structureCode;
	}

	public void setStructureCode(String structureCode) {
		this.structureCode = structureCode;
	}

	public String getStructureName() {
		return structureName;
	}

	public void setStructureName(String structureName) {
		this.structureName = structureName;
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