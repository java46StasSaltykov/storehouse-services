package com.storehouse.service;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static com.storehouse.entities.Order.*;
import java.time.LocalDate;
import java.util.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.storehouse.entities.Order;
import com.storehouse.model.OrderDto;
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
	public List<Order> getOpenOrders() {
		Query query = new Query().addCriteria(Criteria.where(OPEN).is(true));
		return mongoTemplate.find(query, Order.class);
	}

	@Override
	public List<Order> getOrdersByDateWithStatus(LocalDate from, LocalDate to, boolean open) {
		List<OrderDto> res = new ArrayList<>();
		if (open == true) {
			
		} else if (open == false) {
			
		}
		return null;
	}

	@Override
	public Order placeOrder(Order order) {
		return repo.insert(order);
	}

	@Override
	public Order updateOrder(long orderNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order closeOrder(long orderNumber) {
		Order orderToClose = repo.findById(orderNumber).get();
		orderToClose.setOpen(false);
		return repo.save(orderToClose);
	}

}
