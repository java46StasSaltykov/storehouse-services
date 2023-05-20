package com.storehouse.repo;

import org.springframework.data.repository.CrudRepository;

import com.storehouse.entities.LastMeasurement;

public interface LastMeasurementRepository extends CrudRepository<LastMeasurement, Integer> {

}
