package com.storehouse.service;

import static com.storehouse.entities.Order.*;
import java.time.LocalDate;
import java.util.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.storehouse.entities.Order;
import com.storehouse.repo.OrdersRepository;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.query.*;

@Service
public class OrdersBackOfficeServiceImpl implements OrdersBackOfficeService {
	
	static Logger LOG = LoggerFactory.getLogger(OrdersBackOfficeService.class);
	
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	OrdersRepository repo;
	
	@Override
	public Order getOrder(long orderNumber) {
		return repo.findById(orderNumber).get();
	}

	@Override
	public List<Order> getOpenOrders() {
		Query query = new Query().addCriteria(Criteria.where(OPEN).is(true));
		return mongoTemplate.find(query, Order.class);
	}

	@Override
	public List<Order> getOrdersByDateWithStatus(LocalDate from, LocalDate to, boolean open) {
		Query query = new Query().addCriteria(Criteria.where(PLACEMENT_DATE).gte(from)
				.andOperator(Criteria.where(PLACEMENT_DATE).lte(to)).andOperator(Criteria.where(OPEN).is(open)));
		return mongoTemplate.find(query, Order.class);
	}

	@Override
	public Order placeOrder(Order order) {
		return repo.insert(order);
	}

	@Override
	public Order updateOrder(long orderNumber, Order newOrder) {
		Order existingOrder = repo.findById(orderNumber).get();
		newOrder.number = existingOrder.number;
		return repo.save(newOrder);
	}

	@Override
	public Order closeOrder(long orderNumber) {
		Order orderToClose = repo.findById(orderNumber).get();
		orderToClose.open = false;
		return repo.save(orderToClose);
	}

}
