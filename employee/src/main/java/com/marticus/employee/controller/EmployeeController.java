package com.marticus.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marticus.employee.entity.Employee;

import com.marticus.employee.repository.EmployeeRepository;
import com.marticus.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public ResponseEntity<List<Employee>> getEmployeeAll()
	{
		List<Employee> employeeEntity = employeeService.findAllEmployees();
		return ResponseEntity.ok(employeeEntity);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id)
	{
		Employee employeeEntity = employeeService.findById(id);
		return ResponseEntity.ok(employeeEntity);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getEmployeeByEmpName(@PathVariable("empname") String empname)
	{
		List<Employee> employeeEntity = employeeService.findAllEmployeesByName(empname);
		return ResponseEntity.ok(employeeEntity);
	}
	
	
	
//	@PostMapping("/")
//	public ResponseEntity<Void>saveCustomer(@RequestBody EmployeeEntity employeeEntity)
//	{
//		
//		employeeService.saveCustomer(employeeEntity);
//		return ResponseEntity.status(HttpStatus.CREATED).header("Records", "Created").build();
//	}
	
	
	

	
	
	
	
	
	
	
	
	

}
