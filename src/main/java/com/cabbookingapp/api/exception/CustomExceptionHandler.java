package com.cabbookingapp.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(UserExceptions.class)
	public ResponseEntity<ErrorDto> userCustomExceptions(UserExceptions userExpection, WebRequest path) {
		ErrorDto err = new ErrorDto();
		err.setMessage(userExpection.getMessage());
		err.setPath(path.getContextPath());
		err.setTimestamp(LocalDateTime.now());
		err.setStatus("BAD_REQUEST");

		return new ResponseEntity<ErrorDto>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DriverExceptions.class)
	public ResponseEntity<ErrorDto> DriverCustomExceptions(UserExceptions userExpection, WebRequest path) {
		ErrorDto err = new ErrorDto();
		err.setMessage(userExpection.getMessage());
		err.setPath(path.getContextPath());
		err.setTimestamp(LocalDateTime.now());
		err.setStatus("BAD_REQUEST");

		return new ResponseEntity<ErrorDto>(err, HttpStatus.BAD_REQUEST);
	}

}
