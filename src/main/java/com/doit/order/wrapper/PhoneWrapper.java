package com.doit.order.wrapper;

import java.util.List;

import com.doit.order.rest.PhoneDetail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneWrapper {
	private List<PhoneDetail> result;

	public List<PhoneDetail> getResult() {
		return result;
	}

	public void setResult(List<PhoneDetail> result) {
		this.result = result;
	}
}
