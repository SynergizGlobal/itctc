package com.synergiz.itctc.dto.request;


import java.math.BigDecimal;


public class SyntheticResinInjectionDetailRequest {

    private Long syntheticResinInjectionDetailId;

    private Integer trackDirectionId;

    private BigDecimal chainageKm;

    private BigDecimal chainageM;

    private BigDecimal chainageCm;

    private String sleeperNumber;

    private BigDecimal injectionLeft;

    private BigDecimal injectionCentre;

    private BigDecimal injectionRight;

    private BigDecimal injectionAverage;

    private BigDecimal gap;

    private String remarks;

	public Long getSyntheticResinInjectionDetailId() {
		return syntheticResinInjectionDetailId;
	}

	public void setSyntheticResinInjectionDetailId(Long syntheticResinInjectionDetailId) {
		this.syntheticResinInjectionDetailId = syntheticResinInjectionDetailId;
	}

	public Integer getTrackDirectionId() {
		return trackDirectionId;
	}

	public void setTrackDirectionId(Integer trackDirectionId) {
		this.trackDirectionId = trackDirectionId;
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

	public BigDecimal getInjectionLeft() {
		return injectionLeft;
	}

	public void setInjectionLeft(BigDecimal injectionLeft) {
		this.injectionLeft = injectionLeft;
	}

	public BigDecimal getInjectionCentre() {
		return injectionCentre;
	}

	public void setInjectionCentre(BigDecimal injectionCentre) {
		this.injectionCentre = injectionCentre;
	}

	public BigDecimal getInjectionRight() {
		return injectionRight;
	}

	public void setInjectionRight(BigDecimal injectionRight) {
		this.injectionRight = injectionRight;
	}

	public BigDecimal getInjectionAverage() {
		return injectionAverage;
	}

	public void setInjectionAverage(BigDecimal injectionAverage) {
		this.injectionAverage = injectionAverage;
	}

	public BigDecimal getGap() {
		return gap;
	}

	public void setGap(BigDecimal gap) {
		this.gap = gap;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
    
    
}