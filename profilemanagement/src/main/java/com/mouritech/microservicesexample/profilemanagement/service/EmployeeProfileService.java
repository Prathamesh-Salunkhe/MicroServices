package com.mouritech.microservicesexample.profilemanagement.service;
import java.util.List;

import com.mouritech.microservicesexample.profilemanagement.domain.EmployeeProfile;

public interface EmployeeProfileService {
	
	void addEmployeeProfile(EmployeeProfile empProfile);
	List<EmployeeProfile> getEmployeeProfiles();

}