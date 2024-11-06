package com.example.employee_management.repository;

	import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_management.model.Employee;
@Repository
	public interface EmployeeRepository extends MongoRepository<Employee, String> {
	}

