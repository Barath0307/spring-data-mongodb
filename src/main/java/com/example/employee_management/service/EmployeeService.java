package com.example.employee_management.service;

import com.example.employee_management.exception.DatabaseException;
import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mongodb.MongoException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        try {
            return employeeRepository.save(employee);
        } catch (MongoException e) {
            throw new DatabaseException("Error saving employee: " + e.getMessage(), e);
        }
    }

    public List<Employee> getAllEmployees() {
        try {
            return employeeRepository.findAll();
        } catch (MongoException e) {
            throw new DatabaseException("Error fetching employees: " + e.getMessage(), e);
        }
    }

    public Optional<Employee> getEmployeeById(String employeeId) {
        try {
            return employeeRepository.findById(employeeId);
        } catch (MongoException e) {
            throw new DatabaseException("Error fetching employee: " + e.getMessage(), e);
        }
    }
}