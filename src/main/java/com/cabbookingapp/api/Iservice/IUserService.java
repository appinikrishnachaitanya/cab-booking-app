package com.cabbookingapp.api.Iservice;

import com.cabbookingapp.api.models.UserModel;

public interface IUserService {

	public void addUser(UserModel user);
	
	public boolean checkUser(String username);

}
