package com.storehouse;

import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.stream.function.StreamBridge;
import com.storehouse.model.*;
import com.storehouse.service.AnalyzerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnalyzerAppl {
	
	@Autowired
	StreamBridge streamBridge;
	@Value("${app.binding.name:container-out-0}")
	String bindingName;
	@Autowired
	AnalyzerService analyzerService;

	public static void main(String[] args) {
		SpringApplication.run(AnalyzerAppl.class, args);
	}

	@Bean
	Consumer <ContainerMeasurementDto> measurementConsumer() {
		return this::meaurementAnalyzing;
	} 
	
	void meaurementAnalyzing(ContainerMeasurementDto measurement) {
		RefillDto refillNeeded = analyzerService.analyzeMeasurement(measurement);
		if (refillNeeded != null) {
			streamBridge.send(bindingName, refillNeeded);
		}
	}
	
}
