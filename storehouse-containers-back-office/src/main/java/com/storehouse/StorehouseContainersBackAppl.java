package com.storehouse;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.storehouse.model.*;
import com.storehouse.service.ContainersService;

@SpringBootApplication
@ComponentScan(basePackages = { "com" })
public class StorehouseContainersBackAppl {
	@Autowired
	ContainersService service;
	@Value("${spring.jpa.hibernate.ddl-auto: create}")
	String ddlAutoProp;
	@Value("${integration.test: true}")
	boolean isIntegrationTest;
	@Value("${integration.test.amount.containers: 10}")
	int nContainers;
	ThreadLocalRandom tlr = ThreadLocalRandom.current();
	

	public static void main(String[] args) {
		SpringApplication.run(StorehouseContainersBackAppl.class, args);
	}

	@PostConstruct
	void dbInit() {
		initDb();
	}

	private void initDb() {
		System.out.println("entered initDB\n ***********************");
		createContainers();
		createContainerMeasurement();
		System.out.println("finished initDB");
	}

	private void createContainerMeasurement() {
		IntStream.rangeClosed(1, nContainers).forEach(i -> service.addContainersFull(
				new ContainerMeasurementDto(new ContainerDto(i, "prod" + i, "unit" + i, 100), 50 + (i * 4))));

	}

	private void createContainers() {
		IntStream.rangeClosed(1, nContainers)
				.forEach(i -> service.addContainer(new ContainerDto(i, "prod" + i, "unit" + i, 100)));
	}

}
