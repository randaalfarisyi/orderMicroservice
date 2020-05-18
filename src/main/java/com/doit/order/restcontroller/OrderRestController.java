package com.doit.order.restcontroller;

import com.doit.order.repository.OrderDB;
import com.doit.order.response.BorrowerListResponse;
import com.doit.order.response.BorrowerResponse;
import com.doit.order.response.OrderListResponse;
import com.doit.order.response.OrderResponse;
import com.doit.order.service.OrderService;
import com.doit.order.service.ProductTypeService;
import com.doit.order.model.OrderModel;
import com.doit.order.model.ProductTypeModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")

public class OrderRestController {
    @Autowired
    OrderService orderService;
    
    @GetMapping(value ="/orders")
    public List<OrderListResponse> getAllOrders() throws IOException {
    	List<OrderListResponse> orders = orderService.getAllOrder();
    	return orders;

    }
    
    @GetMapping(value = "/order/{uuid}")
    public OrderResponse orderView(@PathVariable("uuid") String uuid) throws IOException {
    	OrderResponse order = orderService.getOrderDetailByUuid(uuid);
        return order;
    }
    
    @GetMapping(value = "/borrowers")
    public List<BorrowerListResponse> getAllBorrower() throws IOException {
    	List<BorrowerListResponse> borrowers = orderService.getAllBorrower();
    	return borrowers;
    }
    
    @GetMapping(value = "/borrower/{uuid}")
    public BorrowerResponse borrowerView(@PathVariable("uuid") String uuid) throws IOException {
    	BorrowerResponse borrower = orderService.getBorrowerDetailByUuidBorrower(uuid);
        return borrower;
    }


}
