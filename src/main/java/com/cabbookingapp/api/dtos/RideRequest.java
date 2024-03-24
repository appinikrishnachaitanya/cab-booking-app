package com.cabbookingapp.api.dtos;

import com.cabbookingapp.api.utils.LocationPair;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RideRequest {

	private String username;
	private LocationPair source;
}
