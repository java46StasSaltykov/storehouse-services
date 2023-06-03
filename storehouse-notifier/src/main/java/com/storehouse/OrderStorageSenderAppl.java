package com.storehouse;

import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import com.storehouse.model.RefillDto;
import com.storehouse.service.OrdersStorageService;

@SpringBootApplication
@ComponentScan(basePackages = { "com" })
public class OrderStorageSenderAppl {
	
	@Autowired
	OrdersStorageService service;

	public static void main(String[] args) {
		SpringApplication.run(OrderStorageSenderAppl.class, args);
	}

	@Bean
	Consumer <RefillDto> refillConsumer() {
		return this::orderStoringAndSending;
	}
	
	void orderStoringAndSending(RefillDto refill) {
		service.createNewOrder(refill);
	}
	
}
