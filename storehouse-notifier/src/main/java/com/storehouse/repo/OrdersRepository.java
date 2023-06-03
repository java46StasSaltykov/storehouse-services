package com.storehouse.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.storehouse.entities.Order;

public interface OrdersRepository extends MongoRepository<Order, Long> {

}
