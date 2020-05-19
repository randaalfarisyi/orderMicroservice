package com.doit.order.wrapper;

import java.util.HashMap;
import java.util.List;

import com.doit.order.model.OrderModel;
import com.doit.order.model.ProductTypeModel;

public class LiveMetricsWrapper {
	
	public LiveMetricsWrapper(Long total_order, Long total_disburse, Long outstanding_over, Long outstanding_notover,
			Long order_accepted, Long order_disburse, Integer d1d2, Integer d3d7, Integer d8d30, Integer d31d90,
			Integer d91, Long amount_apply) {
		super();
		this.total_order = total_order;
		this.total_disburse = total_disburse;
		this.outstanding_over = outstanding_over;
		this.outstanding_notover = outstanding_notover;
		this.order_accepted = order_accepted;
		this.order_disburse = order_disburse;
		this.d1d2 = d1d2;
		this.d3d7 = d3d7;
		this.d8d30 = d8d30;
		this.d31d90 = d31d90;
		this.d91 = d91;
		this.amount_apply = amount_apply;
	}
	private Long total_order;
	private Long total_disburse;
	private Long outstanding_over;
	private Long outstanding_notover;
	private Long order_accepted;
	private Long order_disburse;
	private Integer d1d2;
	private Integer d3d7;
	private Integer d8d30;
	private Integer d31d90;
	private Integer d91;
	private Long amount_apply;
	public Long getTotal_order() {
		return total_order;
	}
	public void setTotal_order(Long total_order) {
		this.total_order = total_order;
	}
	public Long getTotal_disburse() {
		return total_disburse;
	}
	public void setTotal_disburse(Long total_disburse) {
		this.total_disburse = total_disburse;
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
	public Long getOrder_accepted() {
		return order_accepted;
	}
	public void setOrder_accepted(Long order_accepted) {
		this.order_accepted = order_accepted;
	}
	public Long getOrder_disburse() {
		return order_disburse;
	}
	public void setOrder_disburse(Long order_disburse) {
		this.order_disburse = order_disburse;
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
	public Long getAmount_apply() {
		return amount_apply;
	}
	public void setAmount_apply(Long amount_apply) {
		this.amount_apply = amount_apply;
	}
	
	
	
}
