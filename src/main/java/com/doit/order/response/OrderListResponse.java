package com.doit.order.response;

import java.util.Date;

public class OrderListResponse {
	
	private String uuid;
	private String name;
	private long repaid_amount;
	private long applied_amount;
	private long disbursed_amount;
	private Date lending_date;
	private Date repaid_date;
	private int overdue_day;
	private String product_type;
	private String product_category;
	private String status;
	
	
	
	
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getRepaid_amount() {
		return repaid_amount;
	}
	public void setRepaid_amount(long repaid_amount) {
		this.repaid_amount = repaid_amount;
	}
	public long getApplied_amount() {
		return applied_amount;
	}
	public void setApplied_amount(long applied_amount) {
		this.applied_amount = applied_amount;
	}
	public long getDisbursed_amount() {
		return disbursed_amount;
	}
	public void setDisbursed_amount(long disbursed_amount) {
		this.disbursed_amount = disbursed_amount;
	}
	public Date getLending_date() {
		return lending_date;
	}
	public void setLending_date(Date lending_date) {
		this.lending_date = lending_date;
	}
	public Date getRepaid_date() {
		return repaid_date;
	}
	public void setRepaid_date(Date repaid_date) {
		this.repaid_date = repaid_date;
	}
	public int getOverdue_day() {
		return overdue_day;
	}
	public void setOverdue_day(int overdue_day) {
		this.overdue_day = overdue_day;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
