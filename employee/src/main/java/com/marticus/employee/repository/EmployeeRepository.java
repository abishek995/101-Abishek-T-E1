package com.marticus.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marticus.employee.entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	
   List<Employee> findByEmpname(String name);
	
    Employee findById(int id);
	
	Employee findByEmpid(String  id);


}
