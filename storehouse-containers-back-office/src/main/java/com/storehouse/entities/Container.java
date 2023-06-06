package com.storehouse.entities;

import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name = "containers")
public class Container {
	
	@Id
	public int id;
	public String product;
	public String measureUnit;
	public int capacity;

	public Container(int number, String product, String measureUnit, int capacity) {
		this.id = number;
		this.product = product;
		this.measureUnit = measureUnit;
		this.capacity = capacity;
	}
	
	public Container() {}

	@Override
	public String toString() {
		return "Container [id=" + id + ", product=" + product + ", measureUnit=" + measureUnit + ", capacity="
				+ capacity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacity, id, measureUnit, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Container other = (Container) obj;
		return capacity == other.capacity && id == other.id && Objects.equals(measureUnit, other.measureUnit)
				&& Objects.equals(product, other.product);
	}

	public int getId() {
		return id;
	}

	public String getProduct() {
		return product;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public int getCapacity() {
		return capacity;
	}

}
