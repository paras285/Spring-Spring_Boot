package com.paras.Advisor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.paras.controllers.ExceptionHandlerEmployeeController;
import com.paras.exceptions.EmployeeNotFoundException;
import com.paras.exceptions.EmployeeUpdationException;

@ControllerAdvice(basePackageClasses=ExceptionHandlerEmployeeController.class)
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler({EmployeeNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody String handleEmployeeNotFoundException(){
		return "Oops! The User you are trying to fetch is not available";
	}
	
	@ExceptionHandler({EmployeeUpdationException.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody String handleEmployeeUpdationException(){
		return "Oops! Looks like some error. Please try after some time";
	}
}
