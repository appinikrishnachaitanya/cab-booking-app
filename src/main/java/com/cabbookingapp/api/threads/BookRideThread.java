package com.cabbookingapp.api.threads;

import org.springframework.beans.factory.annotation.Autowired;

import com.cabbookingapp.api.serviceimpl.RideServiceImpl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRideThread implements Runnable {

	@Autowired
	private RideServiceImpl rideService;

	private String username;
	private String drivername;

	public BookRideThread(String username, String drivername) {
		this.username = username;
		this.drivername = drivername;
	}

	@Override
	public void run() {

		rideService.rideBooking(username, drivername);

	}

}
