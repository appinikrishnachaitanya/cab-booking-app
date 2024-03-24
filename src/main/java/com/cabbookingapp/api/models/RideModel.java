package com.cabbookingapp.api.models;

import java.time.LocalDateTime;

import com.cabbookingapp.api.constants.RideStatus;
import com.cabbookingapp.api.utils.LocationPair;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RideModel {

	private UserModel user;
	private DriverModel driver;
	private LocalDateTime date;
	private RideStatus rideStatus;
	private LocationPair source;
	private LocationPair destination;

	@Override
	public String toString() {
		return "RideModel [user=" + user + ", driver=" + driver + ", date=" + date + ", rideStatus=" + rideStatus + "]";
	}

}
