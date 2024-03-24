package com.cabbookingapp.api.serviceimpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cabbookingapp.api.Iservice.IDriverService;
import com.cabbookingapp.api.constants.DriverStatus;
import com.cabbookingapp.api.exception.DriverExceptions;
import com.cabbookingapp.api.exception.UserExceptions;
import com.cabbookingapp.api.models.DriverModel;
import com.cabbookingapp.api.models.UserModel;
import com.cabbookingapp.api.repository.DriverRepository;
import com.cabbookingapp.api.repository.UserRepository;
import com.cabbookingapp.api.utils.DistanceUtil;
import com.cabbookingapp.api.utils.LocationPair;

@Service
public class DriverServiceImpl implements IDriverService {

	private DriverRepository driverRepository;
	private UserRepository userRepository;

	public DriverServiceImpl(DriverRepository driverRepository, UserRepository userRepository) {
		this.driverRepository = driverRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void addDriver(DriverModel driver) {

		if (checkDriverExist(driver.getUsername())) {
			throw new DriverExceptions("Driver name already exist/used...");
		} else {
			this.driverRepository.addDriver(driver);
		}

	}

	@Override
	public boolean checkDriverExist(String username) {

		return this.driverRepository.existsDriver(username);
	}

	@Override
	public void updateDriverStatus(String username, DriverStatus status) {
		if (checkDriverExist(username)) {

			this.driverRepository.updateDriverStatusByUsername(username, status);

		} else {
			throw new DriverExceptions("No Driver Found....");
		}
	}

	@Override
	public void findNearestDrivers(String username, LocationPair source, LocationPair desination) {

		if (!this.userRepository.userExists(username)) {
			throw new UserExceptions("Invalid Username....");
		}

		if (source.getLatitude() == desination.getLatitude() && source.getLongtitude() == desination.getLongtitude()) {
			throw new DriverExceptions("Source and Destination Can't be same place");
		}

		List<DriverModel> drivers = this.driverRepository.findAllAvailableDrivers().stream().filter(d -> {
			return DistanceUtil.calculateDistance(source, d.getSourceLocation()) < 5;
		}).toList();

		if (!drivers.isEmpty()) {

			UserModel userByUserName = this.userRepository.getUserByUserName(username);
			userByUserName.setSource(source);
			userByUserName.setDestination(desination);
			HashMap<String, DriverModel> dr = new HashMap<>();
			for (DriverModel driver : drivers) {
				dr.put(driver.getUsername(), driver);

			}

			userByUserName.setAvailableDrivers(dr);
			
			this.userRepository.addUser(userByUserName);
		}
//			else {
//			UserModel u = userRepository.getUserByUserName(username);
//			List<RideModel> rides = new ArrayList<>();
//			for (DriverModel driver : drivers) {
//				RideModel r = new RideModel();
//				r.setDestination(desination);
//				r.setSource(source);
//				r.setUser(u);
//				r.setDriver(driver);
//				rides.add(r);
//
//			}
//
//			UserRideSession.getRidesSession().put(username, rides);
//		}

	}

}
