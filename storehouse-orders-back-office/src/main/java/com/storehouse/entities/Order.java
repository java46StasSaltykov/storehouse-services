package com.storehouse.entities;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {
	
	long number;
	LocalDate placementDate;
	String product;
	int amount;
	String measurementUnit;
	int containerNumber;
	boolean open;
	
	public static final String NUMBER = "number";
	public static final String PLACEMENT_DATE = "placementDate";
	public static final String PRODUCT = "product";
	public static final String AMOUNT = "amount";
	public static final String MEASUREMENT_UNIT = "measurementUnit";
	public static final String CONTAINER_NUMBER = "containerNumber";
	public static final String OPEN = "open";
	
	
	public Order(long number, LocalDate placementDate, String product, int amount, String measurementUnit,
			int containerNumber, boolean open) {
		this.number = number;
		this.placementDate = placementDate;
		this.product = product;
		this.amount = amount;
		this.measurementUnit = measurementUnit;
		this.containerNumber = containerNumber;
		this.open = open;
	}
	
	public long getNumber() {
		return number;
	}
	public LocalDate getPlacementDate() {
		return placementDate;
	}
	public String getProduct() {
		return product;
	}
	public int getAmount() {
		return amount;
	}
	public String getMeasurementUnit() {
		return measurementUnit;
	}
	public int getContainerNumber() {
		return containerNumber;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, containerNumber, measurementUnit, number, open, placementDate, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return amount == other.amount && containerNumber == other.containerNumber
				&& Objects.equals(measurementUnit, other.measurementUnit) && number == other.number
				&& open == other.open && Objects.equals(placementDate, other.placementDate)
				&& Objects.equals(product, other.product);
	}

}
