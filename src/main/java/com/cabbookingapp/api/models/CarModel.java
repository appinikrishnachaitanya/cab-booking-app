package com.cabbookingapp.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarModel {

	private String name;
	private String carNumber;

	@Override
	public String toString() {
		return "CarModel [name=" + name + ", carNumber=" + carNumber + "]";
	}

}
