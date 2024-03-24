package com.cabbookingapp.api.models;

import java.util.HashMap;
import java.util.List;

import com.cabbookingapp.api.constants.UserStatus;
import com.cabbookingapp.api.utils.LocationPair;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

	private String username;
	private int age;
	private char gender;
	private UserStatus status;
	private HashMap<String, DriverModel> availableDrivers;
	private LocationPair source;
	private LocationPair destination;

	public UserModel(String username, int age, char gender) {
		super();
		this.username = username;
		this.age = age;
		this.gender = gender;
		this.status = UserStatus.AVAILABLE;
		this.availableDrivers = new HashMap<>();
	}

	@Override
	public String toString() {
		return "UserModel [username=" + username + ", age=" + age + ", gender=" + gender + "]";
	}

}
