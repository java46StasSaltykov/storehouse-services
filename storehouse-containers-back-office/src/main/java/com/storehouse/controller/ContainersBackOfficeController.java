package com.storehouse.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.storehouse.model.*;
import com.storehouse.service.ContainersService;

@RestController
@RequestMapping(value = "/containers")
public class ContainersBackOfficeController {
	
	@Autowired
	ContainersService service;
	
	@GetMapping(value = "/all")
	List<ContainerMeasurementDto> getAllContainers() {
		//TODO
		return null;
	} 

	@GetMapping(value = "/container")
	ContainerMeasurementDto getCurrentContainerInfo(@PathVariable ("number") int number) {
		//TODO
		return null;
	}
	
	@GetMapping(value = "/{product}")
	ContainerDto getProductContainer(@PathVariable ("product") String productName) {
		//TODO
		return null;
	}
	
	@GetMapping(value = "/threshold")
	List<ContainerMeasurementDto> getContainersByThreshold(int threshold) {
		//TODO
		return null;
	}
	
	
}
