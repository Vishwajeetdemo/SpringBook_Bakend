package com.emp.service;

import java.util.List;

import com.emp.Model.Employee;

public interface EmpInterface {
      
	List<Employee> getEmployeeAll();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
	
}
