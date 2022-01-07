package com.marticus.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
 
public class Employee{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="Employee_id")
	String empid;
	
	@Column(name="Employee_name")
	String empname;
	
	@Column(name="Project_id")
	String projectid;

}
