package com.storehouse.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
//import telran.exceptions.NotFoundException;

import org.springframework.transaction.annotation.Transactional;

import com.storehouse.model.*;
import com.storehouse.repo.*;
import com.storehouse.entities.*;

@Service
public class ContainersServiceImpl implements ContainersService {
	ContainerRepository containerRepository;
	ContainerMeasurementRepository containerMeasurementRepository;

	Logger LOG = LoggerFactory.getLogger(ContainersServiceImpl.class);

	public ContainersServiceImpl(ContainerRepository containerRepository,
			ContainerMeasurementRepository containerMeasurementRepository) {

		this.containerRepository = containerRepository;
		this.containerMeasurementRepository = containerMeasurementRepository;
	}

	@Override
	@Transactional
	public void addContainer(ContainerDto containerDto) {

		Container container = new Container(containerDto.number, containerDto.product, containerDto.measureUnit,
				containerDto.capacity);
		containerRepository.save(container);
		LOG.debug("created column with id {}", container.id);
	}

	@Override
	@Transactional
	public void addContainersFull(ContainerMeasurementDto containerMeasurementDto) {
	Container container = new Container(containerMeasurementDto.container.number, containerMeasurementDto.container.product, containerMeasurementDto.container.measureUnit, containerMeasurementDto.container.capacity);
	ContainerMeasurement containerMeasurement = new ContainerMeasurement(container, containerMeasurementDto.timeStamp, containerMeasurementDto.currentStatus);
//			containerMeasurement.container,
//			containerMeasurementDto.currentStatus);
	
	containerMeasurementRepository.save(containerMeasurement);
		
		
	}

	@Override
	public List<ContainerMeasurementDto> getAllContainers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContainerMeasurementDto getCurrentContainerInfo(int number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContainerDto getProductContainer(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContainerMeasurementDto> getContainersByThreshold(int threshold) {
		// TODO Auto-generated method stub
		return null;
	}

}
