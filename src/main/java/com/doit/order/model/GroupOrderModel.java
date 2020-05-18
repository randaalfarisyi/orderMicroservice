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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "groupOrder")
public class GroupOrderModel {
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
	@Column(name = "installmentTerm", nullable = false)
	private int installmentTerm;
	
	@NotNull
	@Column(name = "installmentTenor", nullable = false)
	private int installmentTenor;
	
	@OneToMany(mappedBy = "groupOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderModel> groupOrder;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<OrderModel> getGroupOrder() {
		return groupOrder;
	}

	public void setGroupOrder(List<OrderModel> groupOrder) {
		this.groupOrder = groupOrder;
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
