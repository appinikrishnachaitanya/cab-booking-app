package com.cabbookingapp.api.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.stereotype.Repository;

import com.cabbookingapp.api.constants.DriverStatus;
import com.cabbookingapp.api.models.DriverModel;
import com.cabbookingapp.api.utils.LocationPair;

@Repository
public class DriverRepository {

	private HashMap<String, DriverModel> driverDataStore;

	public DriverRepository() {
		this.driverDataStore = new HashMap<>();
	}

	// add the driver

	public void addDriver(DriverModel driver) {
		driver.setStatus(DriverStatus.AVAILABLE);
		this.driverDataStore.put(driver.getUsername(), driver);
	}

	// get the Driver

	public DriverModel getDriverByUserName(String username) {
		return this.driverDataStore.get(username);
	}

	// find all availableDrivers

	public List<DriverModel> findAllAvailableDrivers() {
		return this.driverDataStore.entrySet().stream()
				.filter(d -> d.getValue().getStatus().toString().equalsIgnoreCase("AVAILABLE")).map(Entry::getValue)
				.toList();
	}

	// check the driver exists

	public boolean existsDriver(String username) {
		return this.driverDataStore.containsKey(username);
	}

	// update the location of the driver
	public void updateDriverLocationByUsername(String username, LocationPair location) {
		DriverModel driver = this.driverDataStore.get(username);
		driver.setSourceLocation(location);
		this.driverDataStore.put(username, driver);
	}

	// update the status of the driver
	public void updateDriverStatusByUsername(String username, DriverStatus driverStatus) {
		DriverModel driver = this.driverDataStore.get(username);
		driver.setStatus(driverStatus);
		this.driverDataStore.put(username, driver);
	}
	
	

}
