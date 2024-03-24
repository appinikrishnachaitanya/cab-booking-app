package com.cabbookingapp.api.Iservice;

import java.util.List;

import com.cabbookingapp.api.constants.DriverStatus;
import com.cabbookingapp.api.models.DriverModel;
import com.cabbookingapp.api.utils.LocationPair;

public interface IDriverService {

	public void addDriver(DriverModel driver);

	public boolean checkDriverExist(String username);

	public void updateDriverStatus(String username, DriverStatus status);

	public void findNearestDrivers(String username, LocationPair source, LocationPair desination);

}
