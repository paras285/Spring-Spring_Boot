package com.paras.services;

import java.util.List;

import com.paras.bo.Employee;
import com.paras.exceptions.EmployeeNotFoundException;
import com.paras.exceptions.EmployeeUpdationException;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee) throws EmployeeUpdationException;

	List<Employee> getAllEmployees();

	Employee getEmployeeById(int id) throws EmployeeNotFoundException;

	void deleteEmployee(int id);
}
