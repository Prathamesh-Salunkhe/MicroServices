package com.mouritech.feigndemo.feignclientexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AppController {
	
	@Autowired
	private EmployeeServiceClient employeeServiceClient;
	
	@GetMapping("/fetchemployees")
	public ResponseEntity<?> getEmployees(){
		return ResponseEntity.ok(employeeServiceClient.getAllEmployees());
	}

	@GetMapping("/employees/{empid}")
	public ResponseEntity<?> getEmployee(@PathVariable("empid") int empid){
		Employee employee = employeeServiceClient.getEmployee(empid);
		return ResponseEntity.ok(employee);
	}
}