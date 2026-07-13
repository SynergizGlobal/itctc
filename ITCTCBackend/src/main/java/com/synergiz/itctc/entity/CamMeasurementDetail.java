package com.synergiz.itctc.entity;



import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cam_measurement_detail")

public class CamMeasurementDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cam_measurement_detail_id")
    private Long camMeasurementDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "cam_measurement_header_id",
            nullable = false
    )
    private CamMeasurementHeader camMeasurementHeader;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "track_direction_id",
            nullable = false
    )
    private TrackDirection trackDirection;

    @Column(name = "rc_anchor_serial_no", length = 50)
    private String rcAnchorSerialNo;

    @Column(name = "chainage_km", precision = 10, scale = 3)
    private BigDecimal chainageKm;

    @Column(name = "chainage_m", precision = 10, scale = 3)
    private BigDecimal chainageM;

    @Column(name = "track_slab_number", length = 50)
    private String trackSlabNumber;

    @Column(name = "track_slab_type", length = 50)
    private String trackSlabType;

    @Column(name = "resin_origin_thickness", precision = 8, scale = 2)
    private BigDecimal resinOriginThickness;

    @Column(name = "resin_end_thickness", precision = 8, scale = 2)
    private BigDecimal resinEndThickness;

    @Column(name = "cam_thickness_1", precision = 8, scale = 2)
    private BigDecimal camThickness1;

    @Column(name = "cam_thickness_2", precision = 8, scale = 2)
    private BigDecimal camThickness2;

    public Long getCamMeasurementDetailId() {
		return camMeasurementDetailId;
	}

	public void setCamMeasurementDetailId(Long camMeasurementDetailId) {
		this.camMeasurementDetailId = camMeasurementDetailId;
	}

	public CamMeasurementHeader getCamMeasurementHeader() {
		return camMeasurementHeader;
	}

	public void setCamMeasurementHeader(CamMeasurementHeader camMeasurementHeader) {
		this.camMeasurementHeader = camMeasurementHeader;
	}

	public TrackDirection getTrackDirection() {
		return trackDirection;
	}

	public void setTrackDirection(TrackDirection trackDirection) {
		this.trackDirection = trackDirection;
	}

	public String getRcAnchorSerialNo() {
		return rcAnchorSerialNo;
	}

	public void setRcAnchorSerialNo(String rcAnchorSerialNo) {
		this.rcAnchorSerialNo = rcAnchorSerialNo;
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

	public String getTrackSlabNumber() {
		return trackSlabNumber;
	}

	public void setTrackSlabNumber(String trackSlabNumber) {
		this.trackSlabNumber = trackSlabNumber;
	}

	public String getTrackSlabType() {
		return trackSlabType;
	}

	public void setTrackSlabType(String trackSlabType) {
		this.trackSlabType = trackSlabType;
	}

	public BigDecimal getResinOriginThickness() {
		return resinOriginThickness;
	}

	public void setResinOriginThickness(BigDecimal resinOriginThickness) {
		this.resinOriginThickness = resinOriginThickness;
	}

	public BigDecimal getResinEndThickness() {
		return resinEndThickness;
	}

	public void setResinEndThickness(BigDecimal resinEndThickness) {
		this.resinEndThickness = resinEndThickness;
	}

	public BigDecimal getCamThickness1() {
		return camThickness1;
	}

	public void setCamThickness1(BigDecimal camThickness1) {
		this.camThickness1 = camThickness1;
	}

	public BigDecimal getCamThickness2() {
		return camThickness2;
	}

	public void setCamThickness2(BigDecimal camThickness2) {
		this.camThickness2 = camThickness2;
	}

	public BigDecimal getCamThickness3() {
		return camThickness3;
	}

	public void setCamThickness3(BigDecimal camThickness3) {
		this.camThickness3 = camThickness3;
	}

	public BigDecimal getCamThickness4() {
		return camThickness4;
	}

	public void setCamThickness4(BigDecimal camThickness4) {
		this.camThickness4 = camThickness4;
	}

	public BigDecimal getCamThickness5() {
		return camThickness5;
	}

	public void setCamThickness5(BigDecimal camThickness5) {
		this.camThickness5 = camThickness5;
	}

	public BigDecimal getCamThickness6() {
		return camThickness6;
	}

	public void setCamThickness6(BigDecimal camThickness6) {
		this.camThickness6 = camThickness6;
	}

	public BigDecimal getCamThickness7() {
		return camThickness7;
	}

	public void setCamThickness7(BigDecimal camThickness7) {
		this.camThickness7 = camThickness7;
	}

	public BigDecimal getCamThickness8() {
		return camThickness8;
	}

	public void setCamThickness8(BigDecimal camThickness8) {
		this.camThickness8 = camThickness8;
	}

	public BigDecimal getCamAverageThickness() {
		return camAverageThickness;
	}

	public void setCamAverageThickness(BigDecimal camAverageThickness) {
		this.camAverageThickness = camAverageThickness;
	}

	public BigDecimal getGapOrigin() {
		return gapOrigin;
	}

	public void setGapOrigin(BigDecimal gapOrigin) {
		this.gapOrigin = gapOrigin;
	}

	public BigDecimal getGapEnd() {
		return gapEnd;
	}

	public void setGapEnd(BigDecimal gapEnd) {
		this.gapEnd = gapEnd;
	}

	public String getReferencePinOrigin() {
		return referencePinOrigin;
	}

	public void setReferencePinOrigin(String referencePinOrigin) {
		this.referencePinOrigin = referencePinOrigin;
	}

	public String getReferencePinEnd() {
		return referencePinEnd;
	}

	public void setReferencePinEnd(String referencePinEnd) {
		this.referencePinEnd = referencePinEnd;
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

	@Column(name = "cam_thickness_3", precision = 8, scale = 2)
    private BigDecimal camThickness3;

    @Column(name = "cam_thickness_4", precision = 8, scale = 2)
    private BigDecimal camThickness4;

    @Column(name = "cam_thickness_5", precision = 8, scale = 2)
    private BigDecimal camThickness5;

    @Column(name = "cam_thickness_6", precision = 8, scale = 2)
    private BigDecimal camThickness6;

    @Column(name = "cam_thickness_7", precision = 8, scale = 2)
    private BigDecimal camThickness7;

    @Column(name = "cam_thickness_8", precision = 8, scale = 2)
    private BigDecimal camThickness8;

    @Column(name = "cam_average_thickness", precision = 8, scale = 2)
    private BigDecimal camAverageThickness;

    @Column(name = "gap_origin", precision = 8, scale = 2)
    private BigDecimal gapOrigin;

    @Column(name = "gap_end", precision = 8, scale = 2)
    private BigDecimal gapEnd;

    @Column(name = "reference_pin_origin", length = 50)
    private String referencePinOrigin;

    @Column(name = "reference_pin_end", length = 50)
    private String referencePinEnd;

    @Column(name = "remarks", length = 500)
    private String remarks;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "created_by", nullable = false, length = 100)
    private String createdBy;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
}