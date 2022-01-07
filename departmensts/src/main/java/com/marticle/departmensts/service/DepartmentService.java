package com.marticle.departmensts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marticle.departmensts.entity.DepartmentEntity;
import com.marticle.departmensts.report.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
public void saveCustomer(DepartmentEntity departmentEnt) {
	departmentRepository.save(departmentEnt);
}
public DepartmentEntity findDepartmentById(long id) {
	return departmentRepository.findDepartmentById(id);
}
public List<DepartmentEntity>findAllDepartment() {
	return departmentRepository.findAll();
}
public Boolean deleteDepartmentById(Long id) {
	DepartmentEntity dept=departmentRepository.findDepartmentById(id);
	if(dept!=null)
	{
		departmentRepository.delete(dept);
	return true;
}
return false;
	
}
public void updateDepartment(DepartmentEntity dept) {
	DepartmentEntity deptdb=departmentRepository.findDepartmentById(dept.getId());
	deptdb.setDepartmentCode(dept.getDepartmentCode());
	deptdb.setDepartmentName(dept.getDepartmentName());
	departmentRepository.save(deptdb);
}
}
