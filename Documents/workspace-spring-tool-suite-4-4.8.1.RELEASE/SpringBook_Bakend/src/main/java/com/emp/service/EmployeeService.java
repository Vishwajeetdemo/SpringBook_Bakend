package com.emp.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emp.EmpRepository.EmployeeRepository;
import com.emp.Model.Employee;

@Service
public class EmployeeService implements EmpInterface{

	@Autowired
	private EmployeeRepository empser;
	
	@Override
	public List<Employee> getEmployeeAll(){
		return empser.findAll();
	}
	@Override
	public void saveEmployee(Employee employee) {
		this.empser.save(employee);
	}
	@Override
	public Employee getEmployeeById(long id) {
		return empser.findById(id).orElse(null);
	}
	@Override
	public void deleteEmployeeById(long id) {
		this.empser.deleteById(id);
		
	}
	
	
}
