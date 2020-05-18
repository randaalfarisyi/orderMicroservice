package com.doit.order.response;

import java.util.Date;
import java.util.List;

import com.doit.order.response.OrderBorrower;
import com.doit.order.model.OrderModel;
import com.doit.order.rest.EmergencyContactSegmentsDetail;


public class OrderResponse {
	private long id;
	private String uuid;
	private String uuidBorrower;
	private Long repayAmount;
	private Date dueDate;
	private Date createdTime;
	private Long borrowingAmount;
	private String nameProductType;
	private String nameProductCategory;
	private String status;
	private String borrowerName;
	private String borrowerGender;
	private Date borrowerBirthDate;
	private String borrowerEmail;
	private String borrowerNumber;
	private String borrowerAddress;
	private String borrowerHomePhone;
	private String borrowerWorkPlace;
	private String borrowerWorkPhone;
	private String borrowerBirthPlace;
	private String borrowerAge;
	private List<OrderBorrower> listOrderBorrower;
	private List<EmergencyContactSegmentsDetail> listContactEmergency;
	
	public String getBorrowerGender() {
		return borrowerGender;
	}
	public void setBorrowerGender(String borrowerGender) {
		this.borrowerGender = borrowerGender;
	}
	public List<EmergencyContactSegmentsDetail> getListContactEmergency() {
		return listContactEmergency;
	}
	public void setListContactEmergency(List<EmergencyContactSegmentsDetail> listContactEmergency) {
		this.listContactEmergency = listContactEmergency;
	}
	public List<OrderBorrower> getListOrderBorrower() {
		return listOrderBorrower;
	}
	public void setListOrderBorrower(List<OrderBorrower> listOrderBorrower2) {
		this.listOrderBorrower = listOrderBorrower2;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public long getId() {
		return id;
	}
	public void setId(long l) {
		this.id = l;
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
	public Long getBorrowingAmount() {
		return borrowingAmount;
	}
	public void setBorrowingAmount(Long borrowingAmount) {
		this.borrowingAmount = borrowingAmount;
	}
	public String getNameProductType() {
		return nameProductType;
	}
	public void setNameProductType(String uuidProductType) {
		this.nameProductType = uuidProductType;
	}
	public String getNameProductCategory() {
		return nameProductCategory;
	}
	public void setNameProductCategory(String uuidProductCategory) {
		this.nameProductCategory = uuidProductCategory;
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

	public Date getBorrowerBirthDate() {
		return borrowerBirthDate;
	}
	public void setBorrowerBirthDate(Date borrowerBirthDate) {
		this.borrowerBirthDate = borrowerBirthDate;

	}
	public String getBorrowerEmail() {
		return borrowerEmail;
	}
	public void setBorrowerEmail(String borrowerEmail) {
		this.borrowerEmail = borrowerEmail;
	}
	public String getBorrowerNumber() {
		return borrowerNumber;
	}
	public void setBorrowerNumber(String borrowerNumber) {
		this.borrowerNumber = borrowerNumber;
	}
	public String getBorrowerAddress() {
		return borrowerAddress;
	}
	public void setBorrowerAddress(String borrowerAddress) {
		this.borrowerAddress = borrowerAddress;
	}
	public String getBorrowerHomePhone() {
		return borrowerHomePhone;
	}
	public void setBorrowerHomePhone(String borrowerHomePhone) {
		this.borrowerHomePhone = borrowerHomePhone;
	}
	public String getBorrowerWorkPlace() {
		return borrowerWorkPlace;
	}
	public void setBorrowerWorkPlace(String borrowerWorkPlace) {
		this.borrowerWorkPlace = borrowerWorkPlace;
	}
	public String getBorrowerWorkPhone() {
		return borrowerWorkPhone;
	}
	public void setBorrowerWorkPhone(String borrowerWorkPhone) {
		this.borrowerWorkPhone = borrowerWorkPhone;
	}

	public String getBorrowerBirthPlace() {
		return borrowerBirthPlace;
	}
	public void setBorrowerBirthPlace(String borrowerBirthPlace) {
		this.borrowerBirthPlace = borrowerBirthPlace;
	}
	public String getBorrowerAge() {
		return borrowerAge;
	}
	public void setBorrowerAge(String borrowerAge) {
		this.borrowerAge = borrowerAge;
	}
	
	
	
}
