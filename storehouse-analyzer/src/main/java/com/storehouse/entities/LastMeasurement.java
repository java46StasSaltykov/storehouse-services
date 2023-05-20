package com.storehouse.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class LastMeasurement {
	
	@Id
	public int containerNumber;
	public int status;
	
	public LastMeasurement(int containerNumber, int status) {
		this.containerNumber = containerNumber;
		this.status = status;
	}

	public LastMeasurement() {};
	
}
