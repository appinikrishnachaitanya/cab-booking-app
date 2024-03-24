package com.cabbookingapp.api.serviceimpl;

import org.springframework.stereotype.Service;

import com.cabbookingapp.api.Iservice.IUserService;
import com.cabbookingapp.api.exception.UserExceptions;
import com.cabbookingapp.api.models.UserModel;
import com.cabbookingapp.api.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void addUser(UserModel user) {

		if (checkUser(user.getUsername())) {
			throw new UserExceptions("User Name Already Exist...");
		} else {
			userRepository.addUser(user);
		}

	}

	@Override
	public boolean checkUser(String username) {

		return this.userRepository.userExists(username);
	}

}
