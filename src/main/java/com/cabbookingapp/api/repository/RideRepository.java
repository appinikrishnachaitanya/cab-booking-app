package com.cabbookingapp.api.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.cabbookingapp.api.models.RideModel;


@Repository
public class RideRepository {

	public List<RideModel> rideDataStore;

	public RideRepository() {
		this.rideDataStore = new ArrayList<>();
	}

	public void add(RideModel ride) {
		this.rideDataStore.add(ride);
	}

}
