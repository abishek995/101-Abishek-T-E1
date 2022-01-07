package com.marticus.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marticus.employee.VO.EmployeeVO;
import com.marticus.employee.VO.TechnologyVO;
import com.marticus.employee.VO.ProjectVO;
import com.marticus.employee.entity.Employee;
import com.marticus.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private static final String ProjectVO = null;
	@Autowired
	EmployeeRepository employeeRepository;
	
//public void saveCustomer(EmployeeEntity employeeEnt) {
//		
//		
//	employeeRepository.save(employeeEnt);
//	}
	
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}
	
	
public List<Employee> findAllEmployees() {
		
		return employeeRepository.findAll();

	}
	
	
	public Employee findEmployeeByEmpId(String empId) {
		// TODO Auto-generated method stub
		return employeeRepository.findByEmpid(empId);
	}
	
public List<Employee> findAllEmployeesByName(String empName) {
		
		return employeeRepository.findByEmpname(empName);

	}
public List<EmployeeVO> getAllRestData() {
	List<Employee> empList = employeeRepository.findAll();
	 
	List<EmployeeVO> empdata= new ArrayList<EmployeeVO>();
			
	for(Employee employee : empList)
	{
		EmployeeVO emp=new EmployeeVO();
		emp.setEmpId(employee.getEmpid());
		emp.setEmpName(employee.getEmpname());
		
		String projectUrl= "http://localhost:9005/project/"+employee.getProjectid();
		
		
		
		ProjectVO = template.getForObject(projectUrl, ProjectVO.class);
		if(ProjectVO != null)
		{
			String techUrl =  "http://localhost:9005/technology/"+ProjectVO.getTechnologyId();
			technologyVO = template.getForObject(techUrl, TechnologyVO.class);
		    emp.setProjectName(ProjectVO.getProjectName());
		    Object technologyVO;
			
		    {
		    	emp.setTechnology(technologyVO.getName());
		    }
		}
		
		empdata.add(emp);
		//String responseString = employee.getEmpName()+ " | "+projectVO.getProjectName()+" | "+technologyVO.getName()+"\n";
	
		//responseList.add(responseString);
	}
	return empdata                      ;
	
}
	
	
	

}