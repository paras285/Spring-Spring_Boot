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

import com.paras.bo.Employee;
import com.paras.exceptions.EmployeeNotFoundException;
import com.paras.exceptions.EmployeeUpdationException;
import com.paras.services.EmployeeService;

@RestController
@RequestMapping("/controllerAdvice")
public class ControllerAdviceEmployeeController {


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
	public Employee getAllEmployees(@PathVariable int id) throws EmployeeNotFoundException{
		return empService.getEmployeeById(id);
	}
	
	@PutMapping(value="/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee updatedEmployee,@PathVariable int id) throws EmployeeNotFoundException, EmployeeUpdationException{
		Employee employee = empService.getEmployeeById(id);
		if(employee == null){
			throw new EmployeeNotFoundException("Employee not found");
		}
			employee.setFirstName(updatedEmployee.getFirstName());
			employee.setLastName(updatedEmployee.getLastName());
			employee.setProfession(updatedEmployee.getProfession());
		return empService.saveEmployee(employee);
	}
	
	@DeleteMapping(value="/employees/{id}")
	public String deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException{
		Employee employee = empService.getEmployeeById(id);
		if(employee == null){
			throw new EmployeeNotFoundException("Employee does not exist");
		}
		empService.deleteEmployee(id);
		return "Employee delteted Successfully";
	}

}
