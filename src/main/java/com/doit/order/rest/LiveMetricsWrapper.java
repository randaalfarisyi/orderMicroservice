package com.doit.order.rest;

import java.util.List;

import com.doit.order.model.ProductTypeModel;

public class LiveMetricsWrapper {
	public LiveMetricsWrapper(Long order, Long disburse, Long outstanding_over, Long outstanding_notover,
			Long order_month, Long repaid_month, Long active, Integer d1d2, Integer d3d7, Integer d8d30,
			Integer d31d90, Integer d91) {
		super();
		this.order = order;
		this.disburse = disburse;
		this.outstanding_over = outstanding_over;
		this.outstanding_notover = outstanding_notover;
		this.order_month = order_month;
		this.repaid_month = repaid_month;
		this.active = active;
		this.d1d2 = d1d2;
		this.d3d7 = d3d7;
		this.d8d30 = d8d30;
		this.d31d90 = d31d90;
		this.d91 = d91;
	}
	private Long order;
	private Long disburse;
	private Long outstanding_over;
	private Long outstanding_notover;
	private Long order_month;
	private Long repaid_month;
	private Long active;
	private Integer d1d2;
	private Integer d3d7;
	private Integer d8d30;
	private Integer d31d90;
	private Integer d91;
	public Long getOrder() {
		return order;
	}
	public void setOrder(Long order) {
		this.order = order;
	}
	public Long getDisburse() {
		return disburse;
	}
	public void setDisburse(Long disburse) {
		this.disburse = disburse;
	}
	public Long getOutstanding_over() {
		return outstanding_over;
	}
	public void setOutstanding_over(Long outstanding_over) {
		this.outstanding_over = outstanding_over;
	}
	public Long getOutstanding_notover() {
		return outstanding_notover;
	}
	public void setOutstanding_notover(Long outstanding_notover) {
		this.outstanding_notover = outstanding_notover;
	}
	public Long getOrder_month() {
		return order_month;
	}
	public void setOrder_month(Long order_month) {
		this.order_month = order_month;
	}
	public Long getRepaid_month() {
		return repaid_month;
	}
	public void setRepaid_month(Long repaid_month) {
		this.repaid_month = repaid_month;
	}
	public Long getActive() {
		return active;
	}
	public void setActive(Long active) {
		this.active = active;
	}
	
	public Integer getD1d2() {
		return d1d2;
	}
	public void setD1d2(Integer d1d2) {
		this.d1d2 = d1d2;
	}
	public Integer getD3d7() {
		return d3d7;
	}
	public void setD3d7(Integer d3d7) {
		this.d3d7 = d3d7;
	}
	public Integer getD8d30() {
		return d8d30;
	}
	public void setD8d30(Integer d8d30) {
		this.d8d30 = d8d30;
	}
	public Integer getD31d90() {
		return d31d90;
	}
	public void setD31d90(Integer d31d90) {
		this.d31d90 = d31d90;
	}
	public Integer getD91() {
		return d91;
	}
	public void setD91(Integer d91) {
		this.d91 = d91;
	}
	
	
	
	
	
	
	
}
