package com.cabbookingapp.api.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.cabbookingapp.api.constants.UserStatus;
import com.cabbookingapp.api.models.DriverModel;
import com.cabbookingapp.api.models.UserModel;
import com.cabbookingapp.api.utils.LocationPair;

@Repository
public class UserRepository {

	private HashMap<String, UserModel> userDataStore;

	public UserRepository() {
		this.userDataStore = new HashMap<>();
	}

	// add the user to datastore

	public void addUser(UserModel user) {

		this.userDataStore.put(user.getUsername(), user);

	}

	// check valid user

	public boolean userExists(String username) {
		return this.userDataStore.containsKey(username);
	}

	// get the User

	public UserModel getUserByUserName(String username) {
		return this.userDataStore.get(username);
	}

	public void updateUsernameStatusByUsername(String username, UserStatus status) {
		UserModel user = this.userDataStore.get(username);
		user.setStatus(status);
		this.userDataStore.put(username, user);
	}

}
