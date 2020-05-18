package com.doit.order.wrapper;

import java.util.List;

import com.doit.order.rest.IncomeSegmentsDetail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomeSegmentsWrapper {
	private List<IncomeSegmentsDetail> result;

	public List<IncomeSegmentsDetail> getResult() {
		return result;
	}

	public void setResult(List<IncomeSegmentsDetail> result) {
		this.result = result;
	}
}
