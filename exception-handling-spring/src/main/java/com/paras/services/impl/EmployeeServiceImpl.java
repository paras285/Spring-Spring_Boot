package com.paras.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paras.bo.Employee;
import com.paras.daos.EmployeeDao;
import com.paras.exceptions.EmployeeNotFoundException;
import com.paras.exceptions.EmployeeUpdationException;
import com.paras.services.EmployeeService;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public Employee saveEmployee(Employee employee) throws EmployeeUpdationException {
		return employeeDao.saveEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
		List<Employee> employeeList = getAllEmployees();
		Employee employee = null;
		for(Employee empl:employeeList){
			if(empl.getId() == id){
				employee = empl;
				break;
			}
		}
		if(employee!=null){
			return employee;
		}else{
			throw new EmployeeNotFoundException("Employee does not Exist");
		}
	}

	@Override
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}

}
