package com.storehouse.service;

import com.storehouse.model.RefillDto;

public interface OrdersStorageService {
	
	void createNewOrder(RefillDto refill);

}
