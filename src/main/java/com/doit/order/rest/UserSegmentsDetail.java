package com.doit.order.rest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSegmentsDetail {
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("uuid")
	private String uuid;
	
	@JsonProperty("fullName")
	private String fullName;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("birthCity")
	private String birthCity;

	@JsonProperty("birthDate")
	private Date birthDate;
	
	@JsonProperty("religion")
	private String religion;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("education")
	private String education;
	
	@JsonProperty("homeAddrDetails")
	private String homeAddrDetails;

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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getHomeAddrDetails() {
		return homeAddrDetails;
	}

	public void setHomeAddrDetails(String homeAddrDetails) {
		this.homeAddrDetails = homeAddrDetails;
	}

}

