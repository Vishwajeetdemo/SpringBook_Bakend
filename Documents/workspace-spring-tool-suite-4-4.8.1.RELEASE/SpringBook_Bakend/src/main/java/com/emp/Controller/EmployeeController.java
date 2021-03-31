package com.emp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp.Model.Employee;
import com.emp.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;
	
	@GetMapping("/")
	public String ViewHomePage(Model model) {
		model.addAttribute("listEmployee", empservice.getEmployeeAll());
		return "index";
	}
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee= new Employee();
		model.addAttribute("employee",employee);
		return "new_employee";
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		empservice.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value="id") long id, Model model) {
		
		Employee employee= empservice.getEmployeeById(id);
		
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value="id") long id) {
		
		this.empservice.deleteEmployeeById(id);
		return "redirect:/";
	}
	
	
	
}
