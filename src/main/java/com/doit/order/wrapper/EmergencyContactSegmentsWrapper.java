package com.doit.order.wrapper;

import java.util.List;

import com.doit.order.rest.EmergencyContactSegmentsDetail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmergencyContactSegmentsWrapper {
	private List<EmergencyContactSegmentsDetail> result;

	public List<EmergencyContactSegmentsDetail> getResult() {
		return result;
	}

	public void setResult(List<EmergencyContactSegmentsDetail> result) {
		this.result = result;
	}
}
