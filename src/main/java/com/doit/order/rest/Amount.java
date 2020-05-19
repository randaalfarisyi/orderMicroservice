package com.doit.order.rest;

import java.util.List;

import com.doit.order.model.ProductTypeModel;

public class Amount {
	public Amount(List<ProductTypeModel> listOfOrder, List<String> listOfPeriod) {
		super();
		this.listOfOrder = listOfOrder;
		this.listOfPeriod = listOfPeriod;
	}

	private List<ProductTypeModel>listOfOrder;
	private List<String> listOfPeriod;

	public List<ProductTypeModel> getListOfOrder() {
		return listOfOrder;
	}

	public void setListOfOrder(List<ProductTypeModel> listOfOrder) {
		this.listOfOrder = listOfOrder;
	}

	public List<String> getListOfPeriod() {
		return listOfPeriod;
	}

	public void setListOfPeriod(List<String> listOfPeriod) {
		this.listOfPeriod = listOfPeriod;
	}
	

}
