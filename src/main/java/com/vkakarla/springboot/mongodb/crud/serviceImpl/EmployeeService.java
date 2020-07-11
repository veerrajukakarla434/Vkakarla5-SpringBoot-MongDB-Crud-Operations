package com.vkakarla.springboot.mongodb.crud.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vkakarla.springboot.mongodb.crud.documents.Employee;
import com.vkakarla.springboot.mongodb.crud.repo.EmployeeRepository;
import com.vkakarla.springboot.mongodb.crud.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	

	@Override
	public void saveEmployee(Employee employee) {

		employeeRepository.save(employee);

	}

	@Override
	public void updateEmployee(Employee employee) {

		employeeRepository.save(employee);
	}
	
	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> empList = null;
		empList = employeeRepository.findAll();
		return empList;
	}

	@Override
	public void deleteEmployees(String employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
