package com.doit.order.wrapper;

import java.util.List;

import com.doit.order.rest.AlternativeMobilePhoneDetail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlternativeMobilePhoneWrapper {
	private List<AlternativeMobilePhoneDetail> result;

	public List<AlternativeMobilePhoneDetail> getResult() {
		return result;
	}

	public void setResult(List<AlternativeMobilePhoneDetail> result) {
		this.result = result;
	}
}
