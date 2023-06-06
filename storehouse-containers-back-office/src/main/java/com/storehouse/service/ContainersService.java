package com.storehouse.service;
import java.util.List;
import com.storehouse.model.*;

public interface ContainersService {
	void addContainer(ContainerDto containerDto);
	void addContainersFull(ContainerMeasurementDto containerMeasurementDto);
	List<ContainerMeasurementDto> getAllContainers();
	ContainerMeasurementDto getCurrentContainerInfo(int number);
	ContainerDto getProductContainer(String productName);
	List<ContainerMeasurementDto> getContainersByThreshold(int threshold); 
}
