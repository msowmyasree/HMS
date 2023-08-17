package com.example.demo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.employeemangement.EmployeeDetails;
import com.employeemangement.EmployeeRepo;
import com.employeemangement.EmployeeService;

class EmployeeDatabaseApplicationTests {
	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepo employeeRepo;
	
	
	@Test
	public void deleteEmployee() {
		EmployeeDetails empdetails=new EmployeeDetails(1,"sowmya","java",60000);
		employeeService.deleteEmployeeById(empdetails.getId());
		verify(employeeRepo,times(1)).deleteById(empdetails.getId());
	}


	
	
}
