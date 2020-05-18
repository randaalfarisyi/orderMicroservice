package com.doit.order.model;

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
@Table(name = "report")
public class ReportModel {
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String uuid;
	
	@NotNull
	@Column(name = "period", nullable = false)
	private String period;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uuidProductType", referencedColumnName = "uuid", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ProductTypeModel productType;
	
	@NotNull
	@Column(name = "totalDisbursed", nullable = false)
	private long totalDisbursed;
	
	@NotNull
	@Column(name = "totalOrder", nullable = false)
	private long totalOrder;
	
	@NotNull
	@Column(name = "totalServiceFee", nullable = false)
	private long totalServiceFee;
	
	@NotNull
	@Column(name = "totalOutstanding", nullable = false)
	private long totalOutstanding;
	
	@NotNull
	@Column(name = "totalOutstandingOverdue", nullable = false)
	private long totalOutstandingOverdue;
	
	@NotNull
	@Column(name = "totalOutstandingNotOverdue", nullable = false)
	private long totalOutstandingNotOverdue;
	
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

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public ProductTypeModel getProductType() {
		return productType;
	}

	public void setProductType(ProductTypeModel productType) {
		this.productType = productType;
	}

	public long getTotalDisbursed() {
		return totalDisbursed;
	}

	public void setTotalDisbursed(long totalDisbursed) {
		this.totalDisbursed = totalDisbursed;
	}

	public long getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(long totalOrder) {
		this.totalOrder = totalOrder;
	}

	public long getTotalServiceFee() {
		return totalServiceFee;
	}

	public void setTotalServiceFee(long totalServiceFee) {
		this.totalServiceFee = totalServiceFee;
	}

	public long getTotalOutstanding() {
		return totalOutstanding;
	}

	public void setTotalOutstanding(long totalOutstanding) {
		this.totalOutstanding = totalOutstanding;
	}

	public long getTotalOutstandingOverdue() {
		return totalOutstandingOverdue;
	}

	public void setTotalOutstandingOverdue(long totalOutstandingOverdue) {
		this.totalOutstandingOverdue = totalOutstandingOverdue;
	}

	public long getTotalOutstandingNotOverdue() {
		return totalOutstandingNotOverdue;
	}

	public void setTotalOutstandingNotOverdue(long totalOutstandingNotOverdue) {
		this.totalOutstandingNotOverdue = totalOutstandingNotOverdue;
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
