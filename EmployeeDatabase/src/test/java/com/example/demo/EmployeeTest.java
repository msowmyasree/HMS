package com.example.demo;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.employeemangement.EmployeeDetails;
import com.employeemangement.EmployeeRepo;
import com.employeemangement.EmployeeService;
@RunWith(SpringRunner.class)
@SpringBootTest(classes= {com.employeemangement.EmployeeDatabaseApplication.class})
 class EmployeeTest {
	
	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepo employeeRepo;
	
	@Test
	public void addEmployeeTest() {
		EmployeeDetails empdetails=new EmployeeDetails(1,"divya","hr",600000);
		
		when(employeeRepo.save(empdetails)).thenReturn(empdetails);
		
	
		assertEquals(empdetails,employeeService.addAccount(empdetails));
	}
//	
//	@Test
//	public void getEmployee() {
//		when(employeeRepo.findAll()).thenReturn(Stream.of(new EmployeeDetails(1,"sowmya","java")).collect(Collectors.toList()));
//		assertEquals(1,employeeService.get)
//	}
	
	@Test
	public void deleteEmployee() {
		EmployeeDetails empdetails=new EmployeeDetails(1,"sowmya","java",60000);
		employeeService.deleteEmployeeById(empdetails.getId());
		verify(employeeRepo,times(1)).deleteById(empdetails.getId());
	}
	@Test
	public void getEmployee() {
		when(employeeRepo.findAll()).thenReturn(Stream.of(new EmployeeDetails(67,"dalen","aws",70000)).collect(Collectors.toList()));
		assertEquals(1,employeeService.getAllEmployees().size());
	}

	
	
}
