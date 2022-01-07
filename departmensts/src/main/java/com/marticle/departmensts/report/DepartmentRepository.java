package com.marticle.departmensts.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marticle.departmensts.entity.DepartmentEntity;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long>{



	DepartmentEntity findDepartmentById(long id);
	

}
