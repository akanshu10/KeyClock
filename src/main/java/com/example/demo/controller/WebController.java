package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.annotation.security.RolesAllowed;

@RestController
public class WebController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	@RolesAllowed("admin")
	public boolean add(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/employee/{employeeId}")
	@RolesAllowed("user")
	public Employee getEmployee(@PathVariable("employeeId") int employeeId) {
		return employeeService.getEmployee(employeeId);
	}
	
	@GetMapping("/employee")
	@RolesAllowed("admin")
	public List<Employee> getAll(){
		return employeeService.getAllEmployee();
	}
}
