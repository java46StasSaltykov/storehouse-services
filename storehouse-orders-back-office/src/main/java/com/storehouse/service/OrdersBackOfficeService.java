package com.storehouse.service;

import java.time.LocalDate;
import java.util.List;
import com.storehouse.entities.*;

public interface OrdersBackOfficeService {
	
	List<Order> getOpenOrders();

	List<Order> getOrdersByDateWithStatus(LocalDate from, LocalDate to, boolean open);
	
	Order placeOrder(Order order);
	
	Order updateOrder(long orderNumber);
	
	Order closeOrder(long orderNumber);
	
}
