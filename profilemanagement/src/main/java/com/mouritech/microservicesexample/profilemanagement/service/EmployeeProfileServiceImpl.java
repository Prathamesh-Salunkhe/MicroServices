package com.mouritech.microservicesexample.profilemanagement.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.microservicesexample.profilemanagement.domain.EmployeeProfile;
import com.mouritech.microservicesexample.profilemanagement.repository.EmployeeProfileRepository;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService{
	
	@Autowired
	private EmployeeProfileRepository empProfileRepo;

	@Override
	public void addEmployeeProfile(EmployeeProfile empProfile) {
		empProfileRepo.save(empProfile);
		
	}

	@Override
	public List<EmployeeProfile> getEmployeeProfiles() {

		return empProfileRepo.findAll();
	}

}