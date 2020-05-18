package com.doit.order.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "productType")
public class ProductTypeModel implements Serializable{
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String uuid;
	
	@NotNull
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotNull
	@Column(name = "amountApply", nullable = false)
	private long amountApply;
	
	@NotNull
	@Column(name = "amountDisbursed", nullable = false)
	private long amountDisbursed;
	
	@NotNull
	@Column(name = "installment", nullable = false)
	private long installment;
	
	@NotNull
	@Column(name = "borrowingTerm", nullable = false)
	private int borrowingTerm;
	
	@NotNull
	@Column(name = "tenor", nullable = false)
	private int tenor;
	
	@NotNull
	@Column(name = "serviceFeeRate", nullable = false)
	private double serviceFeeRate;
	
	@NotNull
	@Column(name = "interestRate", nullable = false)
	private double interestRate;
	
	@NotNull
	@Column(name = "overdueRate", nullable = false)
	private long overdueRate;
	
	@NotNull
	@Column(name = "penaltyRate", nullable = false)
	private double penaltyRate;
	
	@NotNull
	@Column(name = "targetNpl", nullable = false)
	private double targetNpl;
	
	@NotNull
	@Column(name = "ojkRate", nullable = false)
	private double ojkRate;
	
	@NotNull
	@Column(name = "createdTime", nullable = false)
	private Date createdTime;
	
	@NotNull
	@Column(name = "updatedTime", nullable = false)
	private Date updatedTime;
	
	@NotNull
	@Column(name = "disabled", nullable = false)
	private int disabled;
	
	@OneToMany(mappedBy = "productType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OverdueBillModel> overdueBillList;
	
	@OneToMany(mappedBy = "productType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<SchedulerModel> schedulerList;
	
	@OneToMany(mappedBy = "productType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderModel> orderList;
	
	@OneToMany(mappedBy = "productType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ReportModel> report;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getAmountApply() {
		return amountApply;
	}

	public void setAmountApply(long amountApply) {
		this.amountApply = amountApply;
	}

	public long getAmountDisbursed() {
		return amountDisbursed;
	}

	public void setAmountDisbursed(long amountDisbursed) {
		this.amountDisbursed = amountDisbursed;
	}

	public long getInstallment() {
		return installment;
	}

	public void setInstallment(long installment) {
		this.installment = installment;
	}

	public int getBorrowingTerm() {
		return borrowingTerm;
	}

	public void setBorrowingTerm(int borrowingTerm) {
		this.borrowingTerm = borrowingTerm;
	}

	public int getTenor() {
		return tenor;
	}

	public void setTenor(int tenor) {
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

	public double getOjkRate() {
		return ojkRate;
	}

	public void setOjkRate(double ojkRate) {
		this.ojkRate = ojkRate;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public int getDisabled() {
		return disabled;
	}

	public void setDisabled(int disabled) {
		this.disabled = disabled;
	}

	public List<OverdueBillModel> getOverdueBillList() {
		return overdueBillList;
	}

	public void setOverdueBillList(List<OverdueBillModel> overdueBillList) {
		this.overdueBillList = overdueBillList;
	}

	public List<SchedulerModel> getSchedulerList() {
		return schedulerList;
	}

	public void setSchedulerList(List<SchedulerModel> schedulerList) {
		this.schedulerList = schedulerList;
	}

	public List<OrderModel> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderModel> orderList) {
		this.orderList = orderList;
	}

	public List<ReportModel> getReport() {
		return report;
	}

	public void setReport(List<ReportModel> report) {
		this.report = report;
	}
}
