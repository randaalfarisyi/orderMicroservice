package com.doit.order.wrapper;

import java.util.List;

import com.doit.order.rest.AddrRegionDetail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddrRegionWrapper {
	private List<AddrRegionDetail> result;

	public List<AddrRegionDetail> getResult() {
		return result;
	}

	public void setResult(List<AddrRegionDetail> result) {
		this.result = result;
	}
}
