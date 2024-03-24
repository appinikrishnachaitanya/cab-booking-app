package com.cabbookingapp.api.utils;

import com.cabbookingapp.api.constants.AppConstants;

public class DriverValidations {

	public static boolean isValidCarNumber(String number) {
		if (number.length() != 11) {
			return false;
		} else {
			String[] segements = number.split("-");
			if (segements.length != 3) {
				return false;
			} else {
				if (!AppConstants.stateCodes.contains(segements[0])) {
					return false;
				}
			}
		}

		return true;
	}

}
