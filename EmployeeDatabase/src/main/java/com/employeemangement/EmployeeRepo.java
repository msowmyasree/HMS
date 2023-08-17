package com.employeemangement;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




public interface EmployeeRepo extends JpaRepository<EmployeeDetails, Long> {

	   

	public	Optional<EmployeeDetails> getEmployeeDetailsById(long id);
	
	@Query(value="select * from employee_details where salary>2000",nativeQuery=true)
	   List<EmployeeDetails> getEmployeeSalaryLessThan2000();
		

	}


