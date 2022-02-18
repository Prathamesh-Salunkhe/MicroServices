package com.mouritech.feigndemo.feignclientexample;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "employee-service"/*,url = "http://localhost:8081"*/)
public interface EmployeeServiceClient {
	
	@RequestMapping(value = "/employees",method = RequestMethod.GET)
	public List<Employee> getAllEmployees();
	
	
	@RequestMapping(value = "/employee/{empid}",method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("empid") int empid);

}
