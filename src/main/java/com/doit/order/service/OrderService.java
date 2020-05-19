package com.doit.order.service;

import java.util.Optional;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.doit.order.model.OrderModel;
import com.doit.order.response.BorrowerListResponse;
import com.doit.order.response.BorrowerResponse;
import com.doit.order.response.OrderListResponse;
import com.doit.order.response.OrderResponse;




public interface OrderService {
	List<OrderListResponse> getAllOrder() throws IOException;
	
	OrderModel getOrderDetailByUuid1(String uuid) throws IOException;

	List<OrderModel> getAllOrder1() throws IOException;
	
	OrderResponse getOrderDetailByUuid(String uuid) throws IOException;

	List<BorrowerListResponse> getAllBorrower() throws IOException;

	List<OrderModel> getOrderDetailByUuidBorrower(String uuidBorrower);

	BorrowerResponse getBorrowerDetailByUuidBorrower(String uuidBorrower) throws IOException;

	List<OrderModel> submitOrder(String borrowerUuid, String productTypeUuid, String productCategoryUuid) throws ParseException;
	
	long countRepaymentAmount(OrderModel order);

}
