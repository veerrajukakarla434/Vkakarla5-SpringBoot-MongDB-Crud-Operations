package com.vkakarla.springboot.mongodb.crud.service;

import java.util.List;

import com.vkakarla.springboot.mongodb.crud.documents.Employee;

public interface IEmployeeService {

	  public List<Employee> getAllEmployees();
	  public void saveEmployee(Employee employee);
	  public void updateEmployee(Employee employee);
	  public void deleteEmployees(String employeeId);
	
}
