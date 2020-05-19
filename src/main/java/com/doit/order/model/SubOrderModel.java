package com.doit.order.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subOrder")
public class SubOrderModel {
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String uuid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uuidOrder", referencedColumnName = "uuid", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private OrderModel order;
	
	@NotNull
	@Column(name = "installmentTerm", nullable = false)
	private int installmentTerm;
	
	@NotNull
	@Column(name = "installmentTenor", nullable = false)
	private int installmentTenor;
	
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

	public OrderModel getOrder() {
		return order;
	}

	public void setOrder(OrderModel order) {
		this.order = order;
	}

	public int getInstallmentTerm() {
		return installmentTerm;
	}

	public void setInstallmentTerm(int installmentTerm) {
		this.installmentTerm = installmentTerm;
	}

	public int getInstallmentTenor() {
		return installmentTenor;
	}

	public void setInstallmentTenor(int installmentTenor) {
		this.installmentTenor = installmentTenor;
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
