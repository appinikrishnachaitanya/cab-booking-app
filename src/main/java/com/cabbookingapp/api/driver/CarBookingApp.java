package com.cabbookingapp.api.driver;

import com.cabbookingapp.api.constants.DriverStatus;
import com.cabbookingapp.api.models.CarModel;
import com.cabbookingapp.api.models.DriverModel;
import com.cabbookingapp.api.models.UserModel;
import com.cabbookingapp.api.repository.DriverRepository;
import com.cabbookingapp.api.repository.RideRepository;
import com.cabbookingapp.api.repository.UserRepository;
import com.cabbookingapp.api.serviceimpl.DriverServiceImpl;
import com.cabbookingapp.api.serviceimpl.RideServiceImpl;
import com.cabbookingapp.api.serviceimpl.UserServiceImpl;
import com.cabbookingapp.api.threads.BookRideThread;
import com.cabbookingapp.api.utils.LocationPair;

public class CarBookingApp {

	public static void main(String args[]) {

		// instance of repo class
		UserRepository u = new UserRepository();
		DriverRepository d = new DriverRepository();

		// instance of service classes
		DriverServiceImpl driverServiceImpl = new DriverServiceImpl(d, u);
		UserServiceImpl userServiceImpl = new UserServiceImpl(u);

		// creating the users
		UserModel u1 = new UserModel("Abhishek", 23, 'M');
		UserModel u2 = new UserModel("Rahul", 29, 'M');
		UserModel u3 = new UserModel("Nandini", 22, 'F');
		// adding the users
		userServiceImpl.addUser(u1);
		userServiceImpl.addUser(u2);
		userServiceImpl.addUser(u3);

		// to check users are added to the user data store

//		System.out.println(userServiceImpl.checkUser("Abhishek"));
//		System.out.println(userServiceImpl.checkUser("Rahul"));
//		System.out.println(userServiceImpl.checkUser("Nandini"));

		// creating the Cars & DriverModel
		CarModel c1 = new CarModel("Swift", "KA-01-12345");
		CarModel c2 = new CarModel("Swift", "KA-01-12346");
		CarModel c3 = new CarModel("Swift", "KA-01-12347");
		DriverModel d1 = new DriverModel("Driver1", 'M', 22, c1, new LocationPair(10, 1));
		DriverModel d2 = new DriverModel("Driver2", 'M', 29, c2, new LocationPair(11, 10));
		DriverModel d3 = new DriverModel("Driver3", 'M', 24, c3, new LocationPair(5, 3));
		// adding the users
		driverServiceImpl.addDriver(d1);
		driverServiceImpl.addDriver(d2);
		driverServiceImpl.addDriver(d3);

//		System.out.println(driverServiceImpl.checkDriverExist("Driver1"));
//		System.out.println(driverServiceImpl.checkDriverExist("Driver2"));
//		System.out.println(driverServiceImpl.checkDriverExist("Driver3"));

		// finding the ride
		driverServiceImpl.findNearestDrivers("Abhishek", new LocationPair(10, 0), new LocationPair(10, 1));
		driverServiceImpl.findNearestDrivers("Rahul", new LocationPair(10, 0), new LocationPair(15, 3));
		driverServiceImpl.findNearestDrivers("Nandini", new LocationPair(15, 6), new LocationPair(20, 4));

		// checking available rides for each user
		System.out.println("Abhishek : " + u1.getAvailableDrivers());
		System.out.println("Rahul : " + u2.getAvailableDrivers());
		System.out.println("Nandini : " + u3.getAvailableDrivers());

		// multithreading case
		RideRepository r = new RideRepository();
		RideServiceImpl rideservice = new RideServiceImpl(u, d, r);
		BookRideThread b1 = new BookRideThread("Rahul", "Driver1");
		b1.setRideService(rideservice);
		BookRideThread b2 = new BookRideThread("Abhishek", "Driver1");
		b2.setRideService(rideservice);
		Thread t1 = new Thread(b1);
		Thread t2 = new Thread(b2);
		t1.start();
		t2.start();

	}
}
