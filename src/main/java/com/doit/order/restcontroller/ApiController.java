package com.doit.order.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doit.order.service.ProductCategoryService;
import com.doit.order.service.ProductTypeService;
import com.doit.order.model.OrderModel;
import com.doit.order.model.ProductCategoryModel;
import com.doit.order.model.ProductTypeModel;
import com.doit.order.model.SchedulerModel;
import com.doit.order.rest.BaseResponse;
import com.doit.order.service.OrderService;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
	@Autowired
	private ProductTypeService productTypeService;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/product-type/all")
	public BaseResponse<List<ProductTypeModel>> retrieveAllProductType() {
		BaseResponse<List<ProductTypeModel>> response = new BaseResponse<List<ProductTypeModel>>();
		List<ProductTypeModel> productType = productTypeService.getAllActiveProductType();
		if (productType.size() == 0) {
			response.setStatus(500);
			response.setMessage("Product Type tidak ditemukan");
		} else {
			response.setStatus(200);
			response.setMessage("success");
			response.setResult(productType);
		}
		return response;
	}
	
	@GetMapping(value = "/product-category/all")
	public BaseResponse<List<ProductCategoryModel>> retrieveAllProductCategory() {
		BaseResponse<List<ProductCategoryModel>> response = new BaseResponse<List<ProductCategoryModel>>();
		List<ProductCategoryModel> productCategory = productCategoryService.getAllActiveProductCategory();
		if (productCategory.size() == 0) {
			response.setStatus(500);
			response.setMessage("Product Category tidak ditemukan");
		} else {
			response.setStatus(200);
			response.setMessage("success");
			response.setResult(productCategory);
		}
		return response;
	}
	
	@GetMapping(value = "/order/{uuidBorrower}")
	public BaseResponse<List<OrderModel>> retrieveAllOrderByBorrower(@PathVariable("uuidBorrower") String uuidBorrower) {
		BaseResponse<List<OrderModel>> response = new BaseResponse<List<OrderModel>>();
		List<OrderModel> order = orderService.getOrderDetailByUuidBorrower(uuidBorrower);
		if (order.size() == 0) {
			response.setStatus(500);
			response.setMessage("Order tidak ditemukan");
		} else {
			response.setStatus(200);
			response.setMessage("success");
			response.setResult(order);
		}
		return response;
	}
	
//	@PostMapping(value = "/order/submit/{uuidBorrower}")
//	public BaseResponse<OrderModel> submitOrder(@PathVariable("uuidBorrower") String uuidBorrower,
//			@RequestBody ProductTypeModel productType,
//			@RequestBody ProductCategoryModel productCategory) {
//		
//	}
}
