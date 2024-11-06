package com.example.employee_management.model;

	import lombok.Data;
	import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

	@Data
	@Document(collection = "employees")
	public class Employee {
		@Id
	    @JsonProperty("employeeId")
	    private String employeeId;
	    
	    @JsonProperty("employeeName")
	    private String employeeName;
	    
	    @JsonProperty("employeeEmail")
	    private String employeeEmail;
	    
	    @JsonProperty("location")
	    private String location;
	    
	    @Override
	    public String toString() {
	        return "Employee{" +
	                "id='" + employeeId + '\'' +
	                ", name='" + employeeName + '\'' +
	                ", email='" + employeeEmail + '\'' +
	                ", location=" + location +
	                '}';
	    }
	}
