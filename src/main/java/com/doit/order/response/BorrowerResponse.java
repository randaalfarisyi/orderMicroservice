package com.doit.order.response;

import java.util.List;

public class BorrowerResponse {
	private String name;
	private String age;
	private String gender;
	private String email;
	private String number;
	private String address;
	private String homePhone;
	private String workPlace;
	private String workAddress;
	private String workPhone;
	private int totalOrder;
	private int countNormal;
	private int countInstallment;
	private int overdueCount;
	private int countFinish;
	private List<OrderListResponse> orderHistory;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public int getTotalOrder() {
		return totalOrder;
	}
	public void setTotalOrder(int totalOrder) {
		this.totalOrder = totalOrder;
	}
	public int getCountNormal() {
		return countNormal;
	}
	public void setCountNormal(int countNormal) {
		this.countNormal = countNormal;
	}
	public int getCountInstallment() {
		return countInstallment;
	}
	public void setCountInstallment(int countInstallment) {
		this.countInstallment = countInstallment;
	}
	public int getOverdueCount() {
		return overdueCount;
	}
	public void setOverdueCount(int overdueCount) {
		this.overdueCount = overdueCount;
	}
	public int getCountFinish() {
		return countFinish;
	}
	public void setCountFinish(int countFinish) {
		this.countFinish = countFinish;
	}
	public List<OrderListResponse> getOrderHistory() {
		return orderHistory;
	}
	public void setOrderHistory(List<OrderListResponse> orderHistory) {
		this.orderHistory = orderHistory;
	}
	
	
	

}
