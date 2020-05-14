package com.paras.daos.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.paras.bo.Employee;
import com.paras.daos.EmployeeDao;
import com.paras.exceptions.EmployeeUpdationException;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	Map<Integer,Employee> employeeMap = new HashMap<>();
	

	@Override
	public Employee saveEmployee(Employee employee) throws EmployeeUpdationException {
		if(employeeMap.size() > 5){
			throw new EmployeeUpdationException("Max Limit reached");
		}
		employeeMap.put(employee.getId(),employee);
		return employee;
	}


	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		employeeMap.forEach((id,employee)->{
			employeeList.add(employee);
		});
		return employeeList;
	}


	@Override
	public void deleteEmployee(int employeeId) {
			employeeMap.remove(employeeId);
	}

}
