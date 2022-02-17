package com.mouritech.microservicesexample.profilemanagement.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.microservicesexample.profilemanagement.domain.EmployeeProfile;
import com.mouritech.microservicesexample.profilemanagement.service.EmployeeProfileService;

@RestController
@RequestMapping(value = "/")
public class EmployeeProfileController {
	
	@Autowired
	private EmployeeProfileService emplProfileService;
	
	@PostMapping
	public void addEmployeeProfile(@RequestBody EmployeeProfile empProfile) {
		emplProfileService.addEmployeeProfile(empProfile);
	}
	
	@GetMapping
	public List<EmployeeProfile> getEmployeeProfiles() {

		return emplProfileService.getEmployeeProfiles();
	}
}