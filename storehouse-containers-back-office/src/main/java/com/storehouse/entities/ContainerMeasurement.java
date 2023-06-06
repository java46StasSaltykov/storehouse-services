package com.storehouse.entities;

import java.time.LocalDateTime;
import com.storehouse.model.ContainerMeasurementDto;
import jakarta.persistence.*;

@Entity
@Table(name = "containerMeasurement", indexes = { @Index(columnList = "container_id") })
public class ContainerMeasurement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@ManyToOne
	@JoinColumn(name = "container_id")
	public Container container;
	
	public LocalDateTime timeStamp;
	public int currentStatus;

	public ContainerMeasurement(Container container, LocalDateTime timeStamp, int currentStatus) {
		this.container = container;
		this.timeStamp = timeStamp;
		this.currentStatus = currentStatus;
	}

	public ContainerMeasurement() {}

	public int getId() {
		return id;
	}

	public Container getContainer() {
		return container;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public int getCurrentStatus() {
		return currentStatus;
	}


}
