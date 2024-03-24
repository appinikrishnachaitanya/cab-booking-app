package com.cabbookingapp.api.session;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.cabbookingapp.api.models.RideModel;

public class UserRideSession {

	private static ConcurrentHashMap<String, List<RideModel>> ridesSession;

	{
		ridesSession = new ConcurrentHashMap<String, List<RideModel>>();
	}

	private UserRideSession() {

	}

	public static ConcurrentHashMap<String, List<RideModel>> getRidesSession() {
		return ridesSession;
	}

}
