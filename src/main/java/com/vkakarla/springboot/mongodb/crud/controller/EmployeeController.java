package com.vkakarla.springboot.mongodb.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vkakarla.springboot.mongodb.crud.documents.Employee;
import com.vkakarla.springboot.mongodb.crud.serviceImpl.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@ApiOperation(value = "saveEmployeesAPI", notes = "Curd Operations on MongoDb and Spring Boot - SaveEmployee Event", response = Employee.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully Saved Employee", response = Employee.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = Employee.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Employee.class) })
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> saveEmployee(@RequestBody Employee employee) {

		employeeService.saveEmployee(employee);
		return new ResponseEntity<Object>("Successfully Saved", HttpStatus.OK);
	}
	
	

	@ApiOperation(value = "getAllEmployeesAPI", notes = "Curd Operations on MongoDb and Spring Boot", response = Employee.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully Fetched All Employees", response = Employee.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = Employee.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Employee.class) })
	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getAllEmployees() {

		List<Employee> empList = null;
		empList = employeeService.getAllEmployees();
		return new ResponseEntity<Object>(empList, HttpStatus.OK);
	}
	
	
	

	@ApiOperation(value = "updateEmployeeAPI", notes = "Curd Operations on MongoDb and Spring Boot", response = Employee.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully Fetched All Employees", response = Employee.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = Employee.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Employee.class) })
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee empinput) {

		employeeService.updateEmployee(empinput);
		return new ResponseEntity<Object>("Update Employee Successfully", HttpStatus.OK);
	}

	
	
	@ApiOperation(value = "deleteEmployeeAPI", notes = "Curd Operations on MongoDb and Spring Boot", response = Employee.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Successfully Deleted Employee", response = Employee.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = Employee.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Employee.class) })
	@RequestMapping(value = "/deleteEmployees/{employeeId}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Object> deleteEmployee(@PathVariable String employeeId) {

		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<Object>("Deleted Employee Successfully", HttpStatus.OK);
	}

}
