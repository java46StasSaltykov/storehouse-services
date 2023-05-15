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
import com.storehouse.entities.Order;
import com.storehouse.model.OrderDto;
import com.storehouse.service.OrdersBackOfficeService;

@RestController
@RequestMapping(value = "/orders")
public class OrdersBackOfficeController {
	
	@Autowired
	OrdersBackOfficeService service;
	
	@GetMapping(value = "/open-orders")
	List<OrderDto> getOpenOrders() {
		List<Order> foundOrders = service.getOpenOrders();
		return foundOrders.isEmpty() ? null : convertToDto(foundOrders);
	}

	@GetMapping(value = "/by-date")
	List<OrderDto> getOrdersByDateWithStatus(LocalDate from, LocalDate to, boolean open) {
		//TODO
		return null;
	}
	
	@PostMapping(value = "/new-order")
	OrderDto placeOrder(OrderDto order) {
		Order placed = service.placeOrder(convertToEntity(order));
		return convertToDto(placed);
	}
	
	@PutMapping(value = "/update")
	OrderDto updateOrder(@PathVariable ("number") long orderNumber) {
		//TODO
		return null;
	}
	
	@DeleteMapping (value = "/close-order")
	OrderDto closeOrder(@PathVariable ("number") long orderNumber) {
		Order closed = service.closeOrder(orderNumber);
		return convertToDto(closed);
	}

	private List<OrderDto> convertToDto(List<Order> foundOrders) {
		List<OrderDto> res = new ArrayList<OrderDto>();
		for (Order order : foundOrders) {
			OrderDto dto = convertToDto(order);
			res.add(dto);
		}
		return res;
	}

	private OrderDto convertToDto(Order order) {
		return new OrderDto(order.getNumber(), order.getPlacementDate(), order.getProduct(), order.getAmount(), order.getMeasurementUnit(),
				order.getContainerNumber(), order.isOpen());
	}
	
	private Order convertToEntity(OrderDto order) {
		return new Order(order.number, order.placementDate, order.product, order.amount, order.measurementUnit,
				order.containerNumber, order.open);
	}
	
}
