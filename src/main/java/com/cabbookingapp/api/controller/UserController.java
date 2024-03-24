package com.cabbookingapp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabbookingapp.api.models.UserModel;
import com.cabbookingapp.api.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@PostMapping
	public ResponseEntity<String> createuser(@RequestBody UserModel user) {
		this.userService.addUser(user);
		return new ResponseEntity<String>("User saved Successfully", HttpStatus.CREATED);
	}

}
