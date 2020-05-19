package com.doit.order.wrapper;

import java.util.List;

import com.doit.order.model.ProductTypeModel;

public class ReportWrapper {

	
	
	public ReportWrapper(Long order_accepted, Long order_rejected, Long total_disburse, Double service_fee_rate,
			Double interest_rate, Long overdue_fee, Double penality_rate, Long total_outstanding_amount,
			Long outstanding_overdue_amount, Long outstanding_notover_amount, Long total_amount, String period,
			Long service_fee, List<String> listOfPeriod) {
		super();
		this.order_accepted = order_accepted;
		this.order_rejected = order_rejected;
		this.total_disburse = total_disburse;
		this.service_fee_rate = service_fee_rate;
		this.interest_rate = interest_rate;
		this.overdue_fee = overdue_fee;
		this.penality_rate = penality_rate;
		this.total_outstanding_amount = total_outstanding_amount;
		this.outstanding_overdue_amount = outstanding_overdue_amount;
		this.outstanding_notover_amount = outstanding_notover_amount;
		this.total_amount = total_amount;
		this.period = period;
		this.service_fee = service_fee;
		this.listOfPeriod = listOfPeriod;
	}
	private Long order_accepted;
	private Long order_rejected;
	private Long total_disburse;
	private Double service_fee_rate;
	private Double interest_rate;
	private Long overdue_fee;
	private Double penality_rate;
	private Long total_outstanding_amount;
	private Long outstanding_overdue_amount;
	private Long outstanding_notover_amount;
	private Long total_amount;
	private String period;
	private Long service_fee;
	private List<String>listOfPeriod;
	public Long getOrder_accepted() {
		return order_accepted;
	}
	public void setOrder_accepted(Long order_accepted) {
		this.order_accepted = order_accepted;
	}
	public Long getOrder_rejected() {
		return order_rejected;
	}
	public void setOrder_rejected(Long order_rejected) {
		this.order_rejected = order_rejected;
	}
	public Long getTotal_disburse() {
		return total_disburse;
	}
	public void setTotal_disburse(Long total_disburse) {
		this.total_disburse = total_disburse;
	}
	public Double getService_fee_rate() {
		return service_fee_rate;
	}
	public void setService_fee_rate(Double service_fee_rate) {
		this.service_fee_rate = service_fee_rate;
	}
	public Double getInterest_rate() {
		return interest_rate;
	}
	public void setInterest_rate(Double interest_rate) {
		this.interest_rate = interest_rate;
	}
	public Long getOverdue_fee() {
		return overdue_fee;
	}
	public void setOverdue_fee(Long overdue_fee) {
		this.overdue_fee = overdue_fee;
	}
	public Double getPenality_rate() {
		return penality_rate;
	}
	public void setPenality_rate(Double penality_rate) {
		this.penality_rate = penality_rate;
	}
	public Long getTotal_outstanding_amount() {
		return total_outstanding_amount;
	}
	public void setTotal_outstanding_amount(Long total_outstanding_amount) {
		this.total_outstanding_amount = total_outstanding_amount;
	}
	public Long getOutstanding_overdue_amount() {
		return outstanding_overdue_amount;
	}
	public void setOutstanding_overdue_amount(Long outstanding_overdue_amount) {
		this.outstanding_overdue_amount = outstanding_overdue_amount;
	}
	public Long getOutstanding_notover_amount() {
		return outstanding_notover_amount;
	}
	public void setOutstanding_notover_amount(Long outstanding_notover_amount) {
		this.outstanding_notover_amount = outstanding_notover_amount;
	}
	public Long getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Long total_amount) {
		this.total_amount = total_amount;
	}
	public Long getService_fee() {
		return service_fee;
	}
	public void setService_fee(Long service_fee) {
		this.service_fee = service_fee;
	}
	public List<String> getListOfPeriod() {
		return listOfPeriod;
	}
	public void setListOfPeriod(List<String> listOfPeriod) {
		this.listOfPeriod = listOfPeriod;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	
	
	
}
