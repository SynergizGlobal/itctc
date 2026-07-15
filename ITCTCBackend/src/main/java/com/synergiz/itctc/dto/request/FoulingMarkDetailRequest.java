package com.synergiz.itctc.dto.request;


import java.math.BigDecimal;

public class FoulingMarkDetailRequest {

    private Long foulingMarkDetailId;

    private String chainageLocation;

    private BigDecimal designValue;

    private BigDecimal measuredValue;

    private BigDecimal differenceValue;

    private String remarks;

	public Long getFoulingMarkDetailId() {
		return foulingMarkDetailId;
	}

	public void setFoulingMarkDetailId(Long foulingMarkDetailId) {
		this.foulingMarkDetailId = foulingMarkDetailId;
	}

	public String getChainageLocation() {
		return chainageLocation;
	}

	public void setChainageLocation(String chainageLocation) {
		this.chainageLocation = chainageLocation;
	}

	public BigDecimal getDesignValue() {
		return designValue;
	}

	public void setDesignValue(BigDecimal designValue) {
		this.designValue = designValue;
	}

	public BigDecimal getMeasuredValue() {
		return measuredValue;
	}

	public void setMeasuredValue(BigDecimal measuredValue) {
		this.measuredValue = measuredValue;
	}

	public BigDecimal getDifferenceValue() {
		return differenceValue;
	}

	public void setDifferenceValue(BigDecimal differenceValue) {
		this.differenceValue = differenceValue;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
    
    
}