package com.synergiz.itctc.dto.response;


import java.math.BigDecimal;

public class FasteningBoltDetailResponse {

    private Long fasteningBoltDetailId;

    private Integer trackDirectionId;

    private String trackDirectionName;

    private BigDecimal chainageKm;

    private BigDecimal chainageM;

    private BigDecimal chainageCm;

    private String sleeperNumber;

    private BigDecimal measuredLeft;

    private BigDecimal measuredRight;

    private String remarks;

	public Long getFasteningBoltDetailId() {
		return fasteningBoltDetailId;
	}

	public void setFasteningBoltDetailId(Long fasteningBoltDetailId) {
		this.fasteningBoltDetailId = fasteningBoltDetailId;
	}

	public Integer getTrackDirectionId() {
		return trackDirectionId;
	}

	public void setTrackDirectionId(Integer trackDirectionId) {
		this.trackDirectionId = trackDirectionId;
	}

	public String getTrackDirectionName() {
		return trackDirectionName;
	}

	public void setTrackDirectionName(String trackDirectionName) {
		this.trackDirectionName = trackDirectionName;
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

	public BigDecimal getChainageCm() {
		return chainageCm;
	}

	public void setChainageCm(BigDecimal chainageCm) {
		this.chainageCm = chainageCm;
	}

	public String getSleeperNumber() {
		return sleeperNumber;
	}

	public void setSleeperNumber(String sleeperNumber) {
		this.sleeperNumber = sleeperNumber;
	}

	public BigDecimal getMeasuredLeft() {
		return measuredLeft;
	}

	public void setMeasuredLeft(BigDecimal measuredLeft) {
		this.measuredLeft = measuredLeft;
	}

	public BigDecimal getMeasuredRight() {
		return measuredRight;
	}

	public void setMeasuredRight(BigDecimal measuredRight) {
		this.measuredRight = measuredRight;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
    
    
}