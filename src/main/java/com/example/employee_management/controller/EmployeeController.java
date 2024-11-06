package com.example.employee_management.controller;



import com.example.employee_management.exception.DatabaseException;
import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
        try {
        	System.out.println("Hello " + employee.toString());
            Employee savedEmployee = employeeService.saveEmployee(employee);
            return ResponseEntity.ok(savedEmployee);
        } catch (DatabaseException e) {
            return ResponseEntity.internalServerError()
                .body("Error saving employee: " + e.getMessage());
        }
    }

    @GetMapping("/displayAll")
    @ResponseBody
    public ResponseEntity<?> getAllEmployees() {
        try {
            return ResponseEntity.ok(employeeService.getAllEmployees());
        } catch (DatabaseException e) {
            return ResponseEntity.internalServerError()
                .body("Error fetching employees: " + e.getMessage());
        }
    }

    @GetMapping("/display/{employeeId}")
    @ResponseBody
    public ResponseEntity<?> getEmployee(@PathVariable String employeeId) {
        try {
            return employeeService.getEmployeeById(employeeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        } catch (DatabaseException e) {
            return ResponseEntity.internalServerError()
                .body("Error fetching employee: " + e.getMessage());
        }
    }
}