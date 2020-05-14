package com.paras.daos;

import java.util.List;

import com.paras.bo.Employee;
import com.paras.exceptions.EmployeeUpdationException;

public interface EmployeeDao {

	Employee saveEmployee(Employee employee) throws EmployeeUpdationException;

	List<Employee> getAllEmployees();

	void deleteEmployee(int id);

}
