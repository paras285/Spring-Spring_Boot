package com.paras.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.paras.bo.Employee;
import com.paras.exceptions.EmployeeNotFoundException;
import com.paras.exceptions.EmployeeUpdationException;
import com.paras.services.EmployeeService;

@RestController
@RequestMapping("/responseStatus")
public class ResponseStatusEmployeeController {

	@Autowired
	@Qualifier("employeeService")
	EmployeeService empService;
	
	@PostMapping(value="/employees")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee createEmployee(@RequestBody Employee employee) throws EmployeeUpdationException{
		return empService.saveEmployee(employee);
	}
	
	@GetMapping(value="/employees")
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}
	
	@GetMapping(value="/employees/{id}")
	public Employee getAllEmployees(@PathVariable int id){
		try{
			return empService.getEmployeeById(id);
		}catch(Exception exception){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee not Found");
		}
	}
	
	@PutMapping(value="/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee updatedEmployee,@PathVariable int id){
		Employee employee = null;
		try{
			employee = empService.getEmployeeById(id);
		}catch(EmployeeNotFoundException exception){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee not Found");
		}
			employee.setFirstName(updatedEmployee.getFirstName());
			employee.setLastName(updatedEmployee.getLastName());
			employee.setProfession(updatedEmployee.getProfession());
		try{
			return empService.saveEmployee(employee);
		}catch(EmployeeUpdationException excption){
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Employee Updation Failed");
		}
	}
	
	@DeleteMapping(value="/employees/{id}")
	public String deleteEmployee(@PathVariable int id){
		try{
			empService.getEmployeeById(id);
		}catch(EmployeeNotFoundException exception){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee not Found");
		}
			empService.deleteEmployee(id);
		return "Employee deleted successfully";
	}

}
