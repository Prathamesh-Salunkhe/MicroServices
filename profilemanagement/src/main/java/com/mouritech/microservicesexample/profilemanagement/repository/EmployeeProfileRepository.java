package com.mouritech.microservicesexample.profilemanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.microservicesexample.profilemanagement.domain.EmployeeProfile;

@Repository
public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long>{

}
