package com.doit.order.controller;

import com.doit.order.repository.OrderDB;
import com.doit.order.response.OrderResponse;
import com.doit.order.service.OrderService;
import com.doit.order.model.OrderModel;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    
    @GetMapping(value = "/view/{uuid}")
    public long orderView1(@PathVariable("uuid") String uuid) throws IOException {
        long orderArchive = orderService.getOrderDetailByUuid(uuid).getId();
		return orderArchive;
    }

    public OrderResponse orderView(@PathVariable("uuid") String uuid) throws IOException {
        OrderResponse orderArchive = orderService.getOrderDetailByUuid(uuid);
        return orderArchive;
    }

}
