package com.doit.order.response;

import java.util.Date;

public class OrderBorrower {
	private Long id;
	private String uuid;
	private String uuidBorrower;
	private Long repayAmount;
	private Date dueDate;
	private Date createdTime;
	private Long borrowingAmount;
	private String nameProductType;
	private String nameProductCategory;
	private String status;
	private int overdue_day;
	
	public int getOverdue_day() {
		return overdue_day;
	}
	public void setOverdue_day(int overdue_day) {
		this.overdue_day = overdue_day;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUuidBorrower() {
		return uuidBorrower;
	}
	public void setUuidBorrower(String uuidBorrower) {
		this.uuidBorrower = uuidBorrower;
	}
	public Long getRepayAmount() {
		return repayAmount;
	}
	public void setRepayAmount(Long repayAmount) {
		this.repayAmount = repayAmount;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Long getBorrowingAmount() {
		return borrowingAmount;
	}
	public void setBorrowingAmount(Long borrowingAmount) {
		this.borrowingAmount = borrowingAmount;
	}
	public String getNameProductType() {
		return nameProductType;
	}
	public void setNameProductType(String nameProductType) {
		this.nameProductType = nameProductType;
	}
	public String getNameProductCategory() {
		return nameProductCategory;
	}
	public void setNameProductCategory(String nameProductCategory) {
		this.nameProductCategory = nameProductCategory;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
