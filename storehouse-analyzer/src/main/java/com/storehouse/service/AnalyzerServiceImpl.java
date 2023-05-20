package com.storehouse.service;

import com.storehouse.model.RefillDto;
import com.storehouse.repo.LastMeasurementRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import com.storehouse.entities.LastMeasurement;
import com.storehouse.model.ContainerMeasurementDto;

public class AnalyzerServiceImpl implements AnalyzerService {
	
	@Autowired
	LastMeasurementRepository repo;
	@Value("${app.lack.threshold: 50}")
	int lackThreshold;

	@Override
	@Transactional
	public RefillDto analyzeMeasurement(ContainerMeasurementDto measurement) {
		RefillDto res = null;
		LastMeasurement lastMeasurement = repo.findById(measurement.container.number).orElse(null);
		if (lastMeasurement == null) {
			lastMeasurement = new LastMeasurement(measurement.container.number, measurement.currentStatus);
		} else if (isLack(measurement.currentStatus)) {
			res = new RefillDto
					(measurement.container.number, measurement.container.product, measurement.container.measureUnit, getAmountToAdd(measurement.currentStatus));
		} else if (!isLack(measurement.currentStatus)) {
			// TODO close order... to be written when the 'close order' service is ready.
		}
		repo.save(lastMeasurement);
		return res;
	}

	private int getAmountToAdd(int currentStatus) {
		return 100 - currentStatus;
	}

	private boolean isLack(int currentStatus) {
		return currentStatus < lackThreshold ? true : false;
	}

}
