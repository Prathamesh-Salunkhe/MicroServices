package com.mouritech.feigndemo.employeeservice;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
private static List<Employee> employeeList = new ArrayList<>();
	
	static {
		employeeList.add(new Employee(1, "Ram", 35000));
		employeeList.add(new Employee(2, "Shyam", 45000));
		employeeList.add(new Employee(3, "Sonu", 75000));
		employeeList.add(new Employee(4, "Deepak", 55000));
	}
	@GetMapping("/employees")
	public ResponseEntity<?> getEmployees(){
		return ResponseEntity.ok(employeeList);
	}
	
	@GetMapping("/employees/{empid}")
	public ResponseEntity<?> getEmployee(@PathVariable("empid") int empid){
		Employee employee = findEmployee(empid);
		if(employee == null) {
			return ResponseEntity.badRequest().body("Invalid Employee Id");
		}
		return ResponseEntity.ok(employee);
		
	}
	private Employee findEmployee(int empid) {

		return employeeList.stream()
				.filter(employee -> employee.getEmpid().equals(empid))
				.findFirst().orElse(null);
	}
}
