package com.doit.order.response;

import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import com.doit.order.model.ProductTypeModel;
import com.doit.order.model.SchedulerModel;

public class ProductTypeDetailResponse {
	private String uuid;
	private String name;
	private long borrowingAmount;
	private long borrowingTerm;
	private long tenor;
	private double serviceFeeRate;
	private double interestRate;
	private long overdueRate;
	private double penaltyRate;
	private double targetNpl;
	private ProductTypeModel productType;
	private List<SchedulerModel> scheduler;
	
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
	public long getBorrowingAmount() {
		return borrowingAmount;
	}
	public void setBorrowingAmount(long borrowingAmount) {
		this.borrowingAmount = borrowingAmount;
	}
	public long getBorrowingTerm() {
		return borrowingTerm;
	}
	public void setBorrowingTerm(long borrowingTerm) {
		this.borrowingTerm = borrowingTerm;
	}
	public long getTenor() {
		return tenor;
	}
	public void setTenor(long tenor) {
		this.tenor = tenor;
	}
	public double getServiceFeeRate() {
		return serviceFeeRate;
	}
	public void setServiceFeeRate(double serviceFeeRate) {
		this.serviceFeeRate = serviceFeeRate;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public long getOverdueRate() {
		return overdueRate;
	}
	public void setOverdueRate(long overdueRate) {
		this.overdueRate = overdueRate;
	}
	public double getPenaltyRate() {
		return penaltyRate;
	}
	public void setPenaltyRate(double penaltyRate) {
		this.penaltyRate = penaltyRate;
	}
	public double getTargetNpl() {
		return targetNpl;
	}
	public void setTargetNpl(double targetNpl) {
		this.targetNpl = targetNpl;
	}
	public ProductTypeModel getProductType() {
		return productType;
	}
	public void setProductType(ProductTypeModel productType) {
		this.productType = productType;
	}
	public List<SchedulerModel> getScheduler() {
		return scheduler;
	}
	public void setScheduler(List<SchedulerModel> scheduler) {
		this.scheduler = scheduler;
	}
}
