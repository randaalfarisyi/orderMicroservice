package com.doit.order.wrapper;

import java.util.List;

import com.doit.order.rest.BorrowerDetail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BorrowerWrapper {
	private List<BorrowerDetail> result;

	public List<BorrowerDetail> getResult() {
		return result;
	}

	public void setResult(List<BorrowerDetail> result) {
		this.result = result;
	}
}
