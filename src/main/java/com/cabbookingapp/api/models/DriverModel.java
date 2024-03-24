package com.cabbookingapp.api.models;

import com.cabbookingapp.api.constants.DriverStatus;
import com.cabbookingapp.api.utils.LocationPair;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverModel {

	private String username;
	private char gender;
	private int age;
	private CarModel car;
	private LocationPair sourceLocation;
	private DriverStatus status;

	

	public DriverModel(String username, char gender, int age, CarModel car, LocationPair sourceLocation) {
		super();
		this.username = username;
		this.gender = gender;
		this.age = age;
		this.car = car;
		this.sourceLocation = sourceLocation;
		this.status = DriverStatus.AVAILABLE;
	}
	
	@Override
	public String toString() {
		return "DriverModel [username=" + username + ", gender=" + gender + ", age=" + age + ", car=" + car
				+ ", sourceLocation=" + sourceLocation + ", status=" + status + "]";
	}

}
