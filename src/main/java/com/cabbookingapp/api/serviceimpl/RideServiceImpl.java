package com.cabbookingapp.api.serviceimpl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.cabbookingapp.api.Iservice.IRideService;
import com.cabbookingapp.api.constants.DriverStatus;
import com.cabbookingapp.api.constants.RideStatus;
import com.cabbookingapp.api.constants.UserStatus;
import com.cabbookingapp.api.exception.RideException;
import com.cabbookingapp.api.exception.UserExceptions;
import com.cabbookingapp.api.models.DriverModel;
import com.cabbookingapp.api.models.RideModel;
import com.cabbookingapp.api.models.UserModel;
import com.cabbookingapp.api.repository.DriverRepository;
import com.cabbookingapp.api.repository.RideRepository;
import com.cabbookingapp.api.repository.UserRepository;

@Service
public class RideServiceImpl implements IRideService {

	private UserRepository userRepository;
	private DriverRepository driverRepository;
	private RideRepository riderepository;

	public RideServiceImpl(UserRepository userRepository, DriverRepository driverRepository,
			RideRepository riderepository) {
		this.userRepository = userRepository;
		this.driverRepository = driverRepository;
		this.riderepository = riderepository;
	}

	@Override
	public synchronized void rideBooking(String username, String drivername) {

		if (userRepository.userExists(username) == true && driverRepository.existsDriver(drivername) == true) {
			UserModel u = userRepository.getUserByUserName(username);

			if (!u.getAvailableDrivers().containsKey(drivername)) {
				throw new RideException("Ride Failed , Please try again");
			}
			DriverModel d = u.getAvailableDrivers().get(drivername);
			u.getAvailableDrivers().clear();
			if (u.getStatus().toString().equals("AVAILABLE") && d.getStatus().toString().equals("AVAILABLE")) {
				RideModel ride = new RideModel();
				ride.setDriver(d);
				ride.setUser(u);
				ride.setDate(LocalDateTime.now());
				ride.setRideStatus(RideStatus.IN_RIDE);
				ride.setSource(u.getSource());
				ride.setDestination(u.getDestination());

				this.userRepository.updateUsernameStatusByUsername(username, UserStatus.IN_RIDE);
				this.driverRepository.updateDriverStatusByUsername(drivername, DriverStatus.IN_RIDE);
				this.driverRepository.updateDriverLocationByUsername(drivername, ride.getDestination());
				this.riderepository.add(ride);

				System.out.println("Ride Successfully booked for " + u.getUsername());

			}

			else {
				throw new RideException("Ride Failed , Please try again");
			}
		} else {
			throw new UserExceptions("User/Driver not found");
		}

	}

}
