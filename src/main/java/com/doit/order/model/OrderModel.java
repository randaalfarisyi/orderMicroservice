package com.doit.order.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orderTable")
public class OrderModel implements Serializable{
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String uuid;
	
	@NotNull
	@Column(name = "uuidBorrower", nullable = false)
	private String uuidBorrower;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uuidProductType", referencedColumnName = "uuid", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ProductTypeModel productType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uuidProductCategory", referencedColumnName = "uuid", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ProductCategoryModel productCategory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uuidGroupOrder", referencedColumnName = "uuid", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private GroupOrderModel groupOrder;
	
	@NotNull
	@Column(name = "repayAmount", nullable = false)
	private long repayAmount;
	
	@NotNull
	@Column(name = "lendingDate", nullable = false)
	private Date lendingDate;
	
	@NotNull
	@Column(name = "dueDate", nullable = false)
	private Date dueDate;
	
	@NotNull
	@Column(name="repaymentDate", nullable=true)
	private Date repaymentDate;
	
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
	@Column(name = "status", nullable = false)
	private String status;
	
	@NotNull
	@Column(name = "createdTime", nullable = false)
	private Date createdTime;
	
	@NotNull
	@Column(name = "updatedTime", nullable = false)
	private Date updatedTime;
	
	@NotNull
	@Column(name = "disabled", nullable = false)
	private int disabled;

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

	public String getUuidBorrower() {
		return uuidBorrower;
	}

	public void setUuidBorrower(String uuidBorrower) {
		this.uuidBorrower = uuidBorrower;
	}

	public ProductTypeModel getProductType() {
		return productType;
	}

	public void setProductType(ProductTypeModel productType) {
		this.productType = productType;
	}

	public ProductCategoryModel getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategoryModel productCategory) {
		this.productCategory = productCategory;
	}

	public GroupOrderModel getGroupOrder() {
		return groupOrder;
	}

	public void setGroupOrder(GroupOrderModel groupOrder) {
		this.groupOrder = groupOrder;
	}

	public long getRepayAmount() {
		return repayAmount;
	}

	public void setRepayAmount(long repayAmount) {
		this.repayAmount = repayAmount;
	}

	public Date getLendingDate() {
		return lendingDate;
	}

	public void setLendingDate(Date lendingDate) {
		this.lendingDate = lendingDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getRepaymentDate() {
		return repaymentDate;
	}

	public void setRepaymentDate(Date repaymentDate) {
		this.repaymentDate = repaymentDate;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
}
