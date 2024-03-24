package com.cabbookingapp.api.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cabbookingapp.api.models.UserModel;
import com.cabbookingapp.api.repository.DriverRepository;
import com.cabbookingapp.api.repository.RideRepository;
import com.cabbookingapp.api.repository.UserRepository;
import com.cabbookingapp.api.serviceimpl.DriverServiceImpl;
import com.cabbookingapp.api.serviceimpl.RideServiceImpl;
import com.cabbookingapp.api.serviceimpl.UserServiceImpl;

@SpringBootTest

public class UserServiceTest {

	@Mock
	DriverRepository driverRepository;
	@Mock
	UserRepository userRepository;
	@InjectMocks
	UserServiceImpl userService;
	@InjectMocks
	DriverServiceImpl driverService;
	
	@Mock
	RideRepository riderRepository;
	
	@InjectMocks
	RideServiceImpl riderService;

	@Test
	void testAddUser_NewUser_Success() {
		UserModel u1 = new UserModel("Abhishek", 23, 'M');

		when(userRepository.userExists("dummy")).thenReturn(false);

		userService.addUser(u1);

		verify(userRepository).addUser(u1);

	}

	@Test
	void testCheckUser_UserExists_ReturnsTrue() {
		String username = "Abhishek";
		// mock
		when(userRepository.userExists("Abhishek")).thenReturn(true);
		// act
		boolean result = userService.checkUser(username);
		// assert
		assertThat(result).isTrue();

	}

	@Test
	void testCheckUser_UserExists_ReturnsFalse() {
		String username = "Abhishek";
		// mock
		when(userRepository.userExists("Abhishek")).thenReturn(false);
		// act
		boolean result = userService.checkUser(username);
		// assert
		assertThat(result).isFalse();

	}

}
