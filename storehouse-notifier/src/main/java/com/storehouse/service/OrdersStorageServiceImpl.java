package com.storehouse.service;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import com.storehouse.entities.Order;
import com.storehouse.model.RefillDto;
import com.storehouse.repo.OrdersRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class OrdersStorageServiceImpl implements OrdersStorageService {
	
	@Autowired
	JavaMailSender mailSender;
	@Autowired
	OrdersRepository repo;
	@Value("${MANAGER_MAIL}")
	String supplyManagerMail;
	@Value("${app.mail.subject: Order created for container number }")
	String subject;

	@Override
	public void createNewOrder(RefillDto refill) {
		long newOrderNumber = getNewOrderNumber();
		Order order = new Order(newOrderNumber, LocalDate.now(), refill.product, refill.amountToAdd, refill.measureUnit, refill.containerNumber, true);
		repo.save(order);
		sendOrder(order);
	}

	private long getNewOrderNumber() {
		long number = ThreadLocalRandom.current().nextLong(100000000, 1000000000);
		return repo.existsById(number) ? getNewOrderNumber() : number;
	}

	private void sendOrder(Order order) {
		SimpleMailMessage orderMail = new SimpleMailMessage();
		orderMail.setFrom("container-sensor@storehouse.com");
		orderMail.setTo(supplyManagerMail);
		orderMail.setSubject(subject + order.containerNumber);
		orderMail.setText(getMailText(order));
		mailSender.send(orderMail);
	}

	private String getMailText(Order order) {
		String res = String.format("New order created on %s./n "
				+ "Container %d,/n"
				+ "Product %s,/n"
				+ "Amount to order %d %s", order.placementDate , order.containerNumber, order.product, order.amount, order.measurementUnit);
		return res;
	}

}
