package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public boolean addEmployee(Employee employee) {
		employeeDao.save(employee);
		return true;
	}
	
	public Employee getEmployee(int employeeId) {
		return employeeDao.findById(employeeId).get();
	}
	
	public List<Employee> getAllEmployee(){
		return employeeDao.findAll();
	}
}
