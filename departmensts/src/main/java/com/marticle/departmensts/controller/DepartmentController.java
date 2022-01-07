package com.marticle.departmensts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marticle.departmensts.entity.DepartmentEntity;
import com.marticle.departmensts.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	@PostMapping("/")
	public ResponseEntity<Void> saveCustomer(@RequestBody DepartmentEntity departmentEnt) {

	
		departmentService.saveCustomer(departmentEnt);
		return ResponseEntity.status(HttpStatus.CREATED).header("creation status", "created").build();

	}
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentEntity>getDepartmentById(@PathVariable long id)
	{
		
		DepartmentEntity dept=departmentService.findDepartmentById(id);
		return ResponseEntity.ok(dept);
	}
	@GetMapping("/")
	public ResponseEntity<List<DepartmentEntity>>getDepartmentList()
	{
		List<DepartmentEntity>dept=departmentService.findAllDepartment();
		return ResponseEntity.ok(dept);
		}
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteDepartmentById(@PathVariable() Long id)
	{
		String body="record deleted ";
		Boolean delStatus=departmentService.deleteDepartmentById(id);
		if(!delStatus)
		{
			body="not record";
		}
		return ResponseEntity.ok().body(body);
	}
	@PutMapping("/")
	public ResponseEntity<String>updateDepartment(@RequestBody DepartmentEntity dept)
	{
	DepartmentEntity deptNew=new DepartmentEntity();
    deptNew.setDepartmentCode("a");
    deptNew.setDepartmentName("Hr");
    String strUpdStatus="data update ";
    departmentService.updateDepartment(dept);
    return ResponseEntity.ok().body("ok");
	}
}
