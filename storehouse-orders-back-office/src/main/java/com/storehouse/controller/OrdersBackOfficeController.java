package com.storehouse.controller;

import java.time.LocalDate;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.storehouse.model.OrderDto;
import com.storehouse.service.OrdersBackOfficeService;

@RestController
@RequestMapping(value = "/orders")
public class OrdersBackOfficeController {
	
	@Autowired
	OrdersBackOfficeService service;
	
	@GetMapping(value = "/open-orders")
	List<OrderDto> getOpenOrders() {
		//TODO
		return null;
	}
	
	@GetMapping(value = "/by-date")
	List<OrderDto> getOrdersByDateWithStatus(LocalDate from, LocalDate to, boolean open) {
		//TODO
		if (open) {
			
		} else {
			
		}
		return null;
	}
	
	@PostMapping(value = "/new-order")
	OrderDto placeOrder(OrderDto order) {
		//TODO
		return null;
	}
	
	@PutMapping(value = "/update")
	OrderDto updateOrder(@PathVariable ("number") long orderNumber) {
		//TODO
		return null;
	}
	
	@DeleteMapping (value = "/close-order")
	OrderDto closeOrder(@PathVariable ("number") long orderNumber) {
		//TODO
		return null;
	}

}
