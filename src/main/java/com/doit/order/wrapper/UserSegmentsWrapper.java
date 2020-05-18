package com.doit.order.wrapper;

import java.util.List;

import com.doit.order.rest.UserSegmentsDetail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSegmentsWrapper {
	private List<UserSegmentsDetail> result;

	public List<UserSegmentsDetail> getResult() {
		return result;
	}

	public void setResult(List<UserSegmentsDetail> result) {
		this.result = result;
	}
}
