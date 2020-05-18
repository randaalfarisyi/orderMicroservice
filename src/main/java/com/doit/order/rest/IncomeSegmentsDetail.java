package com.doit.order.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomeSegmentsDetail {
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("uuid")
	private String uuid;
	
	@JsonProperty("companyName")
	private String companyName;
	
	@JsonProperty("industry")
	private String industry;
	
	@JsonProperty("position")
	private String position;
	
	@JsonProperty("monthlyIncome")
	private String monthlyIncome;
	
	@JsonProperty("workAddrDetails")
	private String workAddrDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public String getWorkAddrDetails() {
		return workAddrDetails;
	}

	public void setWorkAddrDetails(String workAddrDetails) {
		this.workAddrDetails = workAddrDetails;
	}
}
