package com.doit.order.service;

import java.util.List;

import java.util.Optional;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doit.order.model.GroupOrderModel;
import com.doit.order.model.OrderModel;
import com.doit.order.repository.GroupOrderDB;
import com.doit.order.repository.OrderDB;
import com.doit.order.response.BorrowerListResponse;
import com.doit.order.response.BorrowerResponse;
import com.doit.order.response.OrderBorrower;
import com.doit.order.response.OrderListResponse;
import com.doit.order.response.OrderResponse;
import com.doit.order.rest.BorrowerDetail;
import com.doit.order.rest.EmergencyContactSegmentsDetail;
import com.doit.order.rest.IncomeSegmentsDetail;
import com.doit.order.rest.UserSegmentsDetail;
import com.doit.order.rest.WebService;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDB orderDB;
	
	@Autowired
	private GroupOrderDB groupOrderDB;
	
	@Autowired
	private WebService webService;
	
	@Override
    public OrderResponse getOrderDetailByUuid(String uuid) throws IOException {
		OrderModel orderModel = orderDB.findByUuid(uuid).get();
		List<OrderModel> listOrderModel = orderDB.findByUuidBorrower(orderModel.getUuidBorrower());
		List<OrderBorrower> listOrderBorrower = new ArrayList<>();
		OrderResponse orderResponse = new OrderResponse();
		BorrowerDetail borrowerDetail = webService.getBorrowerByUuid(orderModel.getUuidBorrower());
		UserSegmentsDetail userSegment = webService.getUserSegmentsByUuidBorrower(orderModel.getUuidBorrower());
		IncomeSegmentsDetail work = webService.getIncomeSegmentsByUuidBorrower(orderModel.getUuidBorrower());
		List<EmergencyContactSegmentsDetail> emergencyContactList = webService.getEmergencyContactSegmentsByUuidBorrower(orderModel.getUuidBorrower());
        orderResponse.setId(orderModel.getId());
        orderResponse.setUuid(orderModel.getUuid());
        orderResponse.setBorrowingAmount(orderModel.getAmountDisbursed());
        orderResponse.setRepayAmount(orderModel.getRepayAmount());
		orderResponse.setNameProductCategory(orderModel.getProductCategory().getName());
		orderResponse.setNameProductType(orderModel.getProductType().getName());
		orderResponse.setDueDate(orderModel.getRepaymentDate());
		orderResponse.setCreatedTime(orderModel.getLendingDate());
		
		if (orderModel.getStatus().equalsIgnoreCase("USER_DATA_SUBMITTED")) {
			orderResponse.setStatus("Data Peminjam telah diterima");
		}else if (orderModel.getStatus().equalsIgnoreCase("USER_DATA_COMPLETED")) {
			orderResponse.setStatus("Data Peminjam telah lengkap");
		}else if (orderModel.getStatus().equalsIgnoreCase("RISK_COMPLETED")) {
			orderResponse.setStatus("Verifikasi selesai, menunggu Funding");
		}else if (orderModel.getStatus().equalsIgnoreCase("MANUAL_VERIF_COMPLETED")) {
			orderResponse.setStatus("Verifikasi manual selesai, menunggu Funding");
		}else if (orderModel.getStatus().equalsIgnoreCase("FUNDING_COMPLETED")) {
			orderResponse.setStatus("Funding selesai, menunggu tanda tangan peminjam");
		}else if (orderModel.getStatus().equalsIgnoreCase("DIGISIGN_COMPLETED")){
			orderResponse.setStatus("Tanda tangan digital dikonfrmasi, melakukan financing ");
		}else if (orderModel.getStatus().equalsIgnoreCase("FINANCE_COMPLETED")){
			orderResponse.setStatus("Financing selesai, melakukan penyaluran dana");
		}else if (orderModel.getStatus().equalsIgnoreCase("DISBURSEMENT_COMPLETED")){
			orderResponse.setStatus("Penyaluran dana selesai");
		}else if (orderModel.getStatus().equalsIgnoreCase("CUSTOMER_REPAYMENT")){
			orderResponse.setStatus("Peminjam telah membayar");
		}else {
			orderResponse.setStatus("Order selesai");
		}
		
		orderResponse.setUuidBorrower(orderModel.getUuidBorrower());
		orderResponse.setBorrowerName(userSegment.getFullName());
		orderResponse.setBorrowerAddress(userSegment.getHomeAddrDetails());
		orderResponse.setBorrowerEmail(borrowerDetail.getEmail());
		orderResponse.setBorrowerNumber(borrowerDetail.getMobilePhoneNumber());
		orderResponse.setBorrowerWorkPlace(work.getCompanyName());
		orderResponse.setBorrowerBirthDate(userSegment.getBirthDate());
		orderResponse.setBorrowerBirthPlace(userSegment.getBirthCity());
		String borrowerGen = webService.getMasterData("gender", userSegment.getGender()).getIdValue();
		orderResponse.setBorrowerGender(borrowerGen);
		Date birthDate = userSegment.getBirthDate();
		LocalDate newBirthDate = LocalDate.of(birthDate.getYear(), birthDate.getMonth()+1, birthDate.getDate());
		LocalDate currentDate = LocalDate.now();
		int age = Period.between(newBirthDate, currentDate).getYears() - 1900;
		orderResponse.setBorrowerAge(Integer.toString(age));

		
		for (int i=0; i < listOrderModel.size(); i++){
			OrderModel order = listOrderModel.get(i);
			OrderBorrower orderBorrower = new OrderBorrower();
			orderBorrower.setId(order.getId());
	        orderBorrower.setUuid(order.getUuid());
	        orderBorrower.setBorrowingAmount(order.getAmountDisbursed());
	        orderBorrower.setRepayAmount(order.getRepayAmount());
			orderBorrower.setNameProductCategory(order.getProductCategory().getName());
			orderBorrower.setNameProductType(order.getProductType().getName());
			orderBorrower.setDueDate(order.getRepaymentDate());
			orderBorrower.setCreatedTime(order.getLendingDate());
			//orderBorrower.setStatus(OrderStatus.fromStatusCode(order.getStatus()));
			Date due = order.getDueDate();
			Date repaid = order.getRepaymentDate();
			LocalDate start = LocalDate.of(due.getYear(), due.getMonth()+1, due.getDate());
			LocalDate end = LocalDate.of(repaid.getYear(), repaid.getMonth()+1, repaid.getDate());
			int overdue = Period.between(start, end).getDays();
			if (overdue <= 0) {
				orderBorrower.setOverdue_day(0);
			}else {
				orderBorrower.setOverdue_day(overdue);
			}
			
			if (order.getStatus().equalsIgnoreCase("USER_DATA_SUBMITTED")) {
				orderBorrower.setStatus("Data Peminjam telah diterima");
			}else if (order.getStatus().equalsIgnoreCase("USER_DATA_COMPLETED")) {
				orderBorrower.setStatus("Data Peminjam telah lengkap");
			}else if (order.getStatus().equalsIgnoreCase("RISK_COMPLETED")) {
				orderBorrower.setStatus("Verifikasi selesai, menunggu Funding");
			}else if (order.getStatus().equalsIgnoreCase("MANUAL_VERIF_COMPLETED")) {
				orderBorrower.setStatus("Verifikasi manual selesai, menunggu Funding");
			}else if (order.getStatus().equalsIgnoreCase("FUNDING_COMPLETED")) {
				orderBorrower.setStatus("Funding selesai, menunggu tanda tangan peminjam");
			}else if (order.getStatus().equalsIgnoreCase("DIGISIGN_COMPLETED")){
				orderBorrower.setStatus("Tanda tangan digital dikonfrmasi, melakukan financing ");
			}else if (order.getStatus().equalsIgnoreCase("FINANCE_COMPLETED")){
				orderBorrower.setStatus("Financing selesai, melakukan penyaluran dana");
			}else if (order.getStatus().equalsIgnoreCase("DISBURSEMENT_COMPLETED")){
				orderBorrower.setStatus("Penyaluran dana selesai");
			}else if (order.getStatus().equalsIgnoreCase("CUSTOMER_REPAYMENT")){
				orderBorrower.setStatus("Peminjam telah membayar");
			}else {
				orderBorrower.setStatus("Order selesai");
			}
			listOrderBorrower.add(orderBorrower);
			
		}
		orderResponse.setListOrderBorrower(listOrderBorrower);
		for (int i=0; i < emergencyContactList.size(); i++){
			String genderEmergencyContact = webService.getMasterData("gender", emergencyContactList.get(i).getGender()).getIdValue();
			emergencyContactList.get(i).setGender(genderEmergencyContact);
			String realationshipEmergencyContact = webService.getMasterData("relationship", emergencyContactList.get(i).getRelationship()).getIdValue();
			emergencyContactList.get(i).setRelationship(realationshipEmergencyContact);
			String contactTypeEmergency = webService.getMasterData("contact type", emergencyContactList.get(i).getContactType()).getIdValue();
			emergencyContactList.get(i).setContactType(contactTypeEmergency);
		}
		orderResponse.setListContactEmergency(emergencyContactList);
		

		return orderResponse;
    }
	
	@Override
	public List<OrderListResponse> getAllOrder() throws IOException {
		List<OrderModel> listOrderModel = orderDB.findAll();
		List<OrderListResponse> listOrderResponse = new ArrayList<>();
		
		for (int i=0; i < listOrderModel.size(); i++){
			
			OrderModel orderModel = listOrderModel.get(i);
			OrderListResponse orderListResponse = new OrderListResponse();
			UserSegmentsDetail userSegment = webService.getUserSegmentsByUuidBorrower(orderModel.getUuidBorrower());
			
			if (userSegment == null) {
				orderListResponse.setName("");
			}else {
				orderListResponse.setName(userSegment.getFullName());
			}
			
			orderListResponse.setApplied_amount(orderModel.getAmountApply());
			orderListResponse.setDisbursed_amount(orderModel.getAmountDisbursed());
			orderListResponse.setRepaid_amount(orderModel.getRepayAmount());
			orderListResponse.setLending_date(orderModel.getLendingDate());
			orderListResponse.setRepaid_date(orderModel.getRepaymentDate());
			orderListResponse.setUuid(orderModel.getUuid());
			orderListResponse.setProduct_type(orderModel.getProductType().getName());
			orderListResponse.setProduct_category(orderModel.getProductCategory().getName());
			Date due = orderModel.getDueDate();
			Date repaid = orderModel.getRepaymentDate();
			LocalDate start = LocalDate.of(due.getYear(), due.getMonth()+1, due.getDate());
			LocalDate end = LocalDate.of(repaid.getYear(), repaid.getMonth()+1, repaid.getDate());
			int overdue = Period.between(start, end).getDays();
			if (overdue <= 0) {
				orderListResponse.setOverdue_day(0);
			}else {
				orderListResponse.setOverdue_day(overdue);
			}
			
			if (orderModel.getStatus().equalsIgnoreCase("USER_DATA_SUBMITTED")) {
				orderListResponse.setStatus("Data Peminjam telah diterima");
			}else if (orderModel.getStatus().equalsIgnoreCase("USER_DATA_COMPLETED")) {
				orderListResponse.setStatus("Data Peminjam telah lengkap");
			}else if (orderModel.getStatus().equalsIgnoreCase("RISK_COMPLETED")) {
				orderListResponse.setStatus("Verifikasi selesai, menunggu Funding");
			}else if (orderModel.getStatus().equalsIgnoreCase("MANUAL_VERIF_COMPLETED")) {
				orderListResponse.setStatus("Verifikasi manual selesai, menunggu Funding");
			}else if (orderModel.getStatus().equalsIgnoreCase("FUNDING_COMPLETED")) {
				orderListResponse.setStatus("Funding selesai, menunggu tanda tangan peminjam");
			}else if (orderModel.getStatus().equalsIgnoreCase("DIGISIGN_COMPLETED")){
				orderListResponse.setStatus("Tanda tangan digital dikonfrmasi, melakukan financing ");
			}else if (orderModel.getStatus().equalsIgnoreCase("FINANCE_COMPLETED")){
				orderListResponse.setStatus("Financing selesai, melakukan penyaluran dana");
			}else if (orderModel.getStatus().equalsIgnoreCase("DISBURSEMENT_COMPLETED")){
				orderListResponse.setStatus("Penyaluran dana selesai");
			}else if (orderModel.getStatus().equalsIgnoreCase("CUSTOMER_REPAYMENT")){
				orderListResponse.setStatus("Peminjam telah membayar");
			}else {
				orderListResponse.setStatus("Order selesai");
			}
			
			listOrderResponse.add(orderListResponse);
			
		}
		
		
        return listOrderResponse;
    }
	
	public List<BorrowerListResponse> getAllBorrower() throws IOException {
		List<BorrowerDetail> listBorrower = webService.getAllBorrower();
		List<BorrowerListResponse> listBorrowerResponse = new ArrayList<>();
		LocalDate currentDate = LocalDate.now();
		
		for (int i=0; i < listBorrower.size(); i++){
			BorrowerDetail borrowerDetail = listBorrower.get(i);
			BorrowerListResponse borrowerResponse = new BorrowerListResponse();
			UserSegmentsDetail userSegment = webService.getUserSegmentsByUuidBorrower(borrowerDetail.getUuid());
			int count = 0;
			int countInstall = 0;
			List<OrderModel> listOrderModel = orderDB.findByUuidBorrower(borrowerDetail.getUuid());
			
			
			borrowerResponse.setEmail(borrowerDetail.getEmail());
			borrowerResponse.setNumber(borrowerDetail.getMobilePhoneNumber());
			if (listOrderModel == null || userSegment == null ) {
				borrowerResponse.setCountOrder(0);
				borrowerResponse.setUmur("");
				borrowerResponse.setNama("");
				borrowerResponse.setGender("");
			}
			else {
				borrowerResponse.setUuid(borrowerDetail.getUuid());
				String type = "";
				int termInstallment = 0;
				for (int j=0; j < listOrderModel.size(); j++){
					type = listOrderModel.get(j).getProductType().getName();
					termInstallment = listOrderModel.get(j).getGroupOrder().getInstallmentTerm();
					if (type.equalsIgnoreCase("Normal Loan")) {
						count += 1;
					}else if (type.equalsIgnoreCase("Installment Loan")) {
						countInstall += 1;						
					}
				}
				borrowerResponse.setCountOrder(count + countInstall);
				Date birthDate = userSegment.getBirthDate();
				LocalDate newBirthDate = LocalDate.of(birthDate.getYear(), birthDate.getMonth()+1, birthDate.getDate());
				int age = Period.between(newBirthDate, currentDate).getYears() - 1900;
				borrowerResponse.setUmur(Integer.toString(age));
				borrowerResponse.setNama(userSegment.getFullName());
				String borrowerGen = webService.getMasterData("gender", userSegment.getGender()).getIdValue();
				borrowerResponse.setGender(borrowerGen);
			}
			
			
			listBorrowerResponse.add(borrowerResponse);
		}
		
		return listBorrowerResponse;
		
	}
	
	@Override
	public BorrowerResponse getBorrowerDetailByUuidBorrower(String uuidBorrower) throws IOException {
		BorrowerDetail borrowerDetail = webService.getBorrowerByUuid(uuidBorrower);
		UserSegmentsDetail userSegment = webService.getUserSegmentsByUuidBorrower(borrowerDetail.getUuid());
		IncomeSegmentsDetail work = webService.getIncomeSegmentsByUuidBorrower(borrowerDetail.getUuid());
		BorrowerResponse borrowerResponse = new BorrowerResponse();
		
		LocalDate currentDate = LocalDate.now();
		List<OrderModel> listOrderModel = orderDB.findByUuidBorrower(uuidBorrower);
		List<OrderListResponse> listOrderResponse = new ArrayList<>();
		int countTotalOverdue = 0;
		int totalFinish = 0;
		int totalNormal = 0;
		int totalInstallment = 0;
			for (int i=0; i < listOrderModel.size(); i++){
				OrderModel orderModel = listOrderModel.get(i);
				OrderListResponse orderListResponse = new OrderListResponse();
				
				orderListResponse.setApplied_amount(orderModel.getAmountApply());
				orderListResponse.setDisbursed_amount(orderModel.getAmountDisbursed());
				orderListResponse.setRepaid_amount(orderModel.getRepayAmount());
				orderListResponse.setLending_date(orderModel.getLendingDate());
				orderListResponse.setRepaid_date(orderModel.getRepaymentDate());
				orderListResponse.setUuid(orderModel.getUuid());
				orderListResponse.setProduct_type(orderModel.getProductType().getName());
				orderListResponse.setProduct_category(orderModel.getProductCategory().getName());
				String productType = orderListResponse.getProduct_type();
				if (productType.equalsIgnoreCase("Normal Loan")) {
					totalNormal += 1;
				}else {
					totalInstallment += 1;
				}
				Date due = orderModel.getDueDate();
				Date repaid = orderModel.getRepaymentDate();
				LocalDate start = LocalDate.of(due.getYear(), due.getMonth()+1, due.getDate());
				LocalDate end = LocalDate.of(repaid.getYear(), repaid.getMonth()+1, repaid.getDate());
				int overdue = Period.between(start, end).getDays();
				if (overdue <= 0) {
					orderListResponse.setOverdue_day(0);
				}else {
					orderListResponse.setOverdue_day(overdue);
					countTotalOverdue += 1;
				}
				
				if (orderModel.getStatus().equalsIgnoreCase("USER_DATA_SUBMITTED")) {
					orderListResponse.setStatus("Data Peminjam telah diterima");
				}else if (orderModel.getStatus().equalsIgnoreCase("USER_DATA_COMPLETED")) {
					orderListResponse.setStatus("Data Peminjam telah lengkap");
				}else if (orderModel.getStatus().equalsIgnoreCase("RISK_COMPLETED")) {
					orderListResponse.setStatus("Verifikasi selesai, menunggu Funding");
				}else if (orderModel.getStatus().equalsIgnoreCase("MANUAL_VERIF_COMPLETED")) {
					orderListResponse.setStatus("Verifikasi manual selesai, menunggu Funding");
				}else if (orderModel.getStatus().equalsIgnoreCase("FUNDING_COMPLETED")) {
					orderListResponse.setStatus("Funding selesai, menunggu tanda tangan peminjam");
				}else if (orderModel.getStatus().equalsIgnoreCase("DIGISIGN_COMPLETED")){
					orderListResponse.setStatus("Tanda tangan digital dikonfrmasi, melakukan financing ");
				}else if (orderModel.getStatus().equalsIgnoreCase("FINANCE_COMPLETED")){
					orderListResponse.setStatus("Financing selesai, melakukan penyaluran dana");
				}else if (orderModel.getStatus().equalsIgnoreCase("DISBURSEMENT_COMPLETED")){
					orderListResponse.setStatus("Penyaluran dana selesai");
				}else if (orderModel.getStatus().equalsIgnoreCase("CUSTOMER_REPAYMENT")){
					orderListResponse.setStatus("Peminjam telah membayar");
				}else {
					orderListResponse.setStatus("Order selesai");
					totalFinish += 1;
				}
				
				listOrderResponse.add(orderListResponse);
				
			}
			borrowerResponse.setOrderHistory(listOrderResponse);
		if (work == null || userSegment == null || borrowerDetail == null) {
			borrowerResponse.setTotalOrder(0);
			borrowerResponse.setCountFinish(0);
			borrowerResponse.setCountInstallment(0);
			borrowerResponse.setCountNormal(0);
			borrowerResponse.setOverdueCount(0);
			borrowerResponse.setName("");
			borrowerResponse.setAddress("");
			borrowerResponse.setWorkAddress("");
			borrowerResponse.setWorkPlace("");
			borrowerResponse.setEmail("");
			borrowerResponse.setNumber("");
			
		}else {
			borrowerResponse.setTotalOrder(listOrderResponse.size());
			borrowerResponse.setCountFinish(totalFinish);
			borrowerResponse.setCountInstallment(totalInstallment);
			borrowerResponse.setCountNormal(totalNormal);
			borrowerResponse.setOverdueCount(countTotalOverdue);
			borrowerResponse.setName(userSegment.getFullName());
			borrowerResponse.setAddress(userSegment.getHomeAddrDetails());
			borrowerResponse.setWorkAddress(work.getWorkAddrDetails());
			borrowerResponse.setWorkPlace(work.getCompanyName());
			borrowerResponse.setEmail(borrowerDetail.getEmail());
			borrowerResponse.setNumber(borrowerDetail.getMobilePhoneNumber());
			Date birthDate = userSegment.getBirthDate();
			LocalDate newBirthDate = LocalDate.of(birthDate.getYear(), birthDate.getMonth()+1, birthDate.getDate());
			int age = Period.between(newBirthDate, currentDate).getYears() - 1900;
			borrowerResponse.setAge(Integer.toString(age));
			borrowerResponse.setName(userSegment.getFullName());
			String borrowerGen = webService.getMasterData("gender", userSegment.getGender()).getIdValue();
			borrowerResponse.setGender(borrowerGen);
		}
		
		return borrowerResponse;
	}


	@Override
	public List<OrderModel> getOrderDetailByUuidBorrower(String uuidBorrower) {
		// TODO Auto-generated method stub
		List<OrderModel> orderModel = orderDB.findByUuidBorrower(uuidBorrower);
		return orderModel;
	}

	@Override
	public OrderModel getOrderDetailByUuid1(String uuid) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> getAllOrder1() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderModel submitOrder(String borrowerUuid, String productTypeUuid, String productCategoryUuid) {
		return null;
	}

}
