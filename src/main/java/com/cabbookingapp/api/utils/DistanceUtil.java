package com.cabbookingapp.api.utils;

public class DistanceUtil {

	public static int calculateDistance(LocationPair p1, LocationPair p2) {
		double part1 =  Math.pow( (double) (p2.getLatitude() - p1.getLatitude()), 2);
		double part2 =  Math.pow( (double) (p2.getLongtitude() - p1.getLongtitude()), 2);
		return (int) Math.sqrt(part1 + part2);
		
	}

}
