package com.employeemangement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeeService {
	
	


	@Autowired
	private EmployeeRepo employeeRepo;
	
public EmployeeDetails getEmployeeDetailsById(long id) {
		
		Optional<EmployeeDetails> fields = employeeRepo.getEmployeeDetailsById(id);
		return  fields.get();
	}

	public EmployeeDetails addAccount(EmployeeDetails empdetails) {
		return employeeRepo.save(empdetails);
		
	}
	 public void deleteEmployeeById(long id) {
	      employeeRepo.deleteById(id);
	   }
	 
//	public EmployeeDetails updateEmployee(EmployeeDetails employeeDetails) {
//		return employeeRepo.save(employeeDetails);
//	}
	 public void update(EmployeeDetails field) {

         employeeRepo.save(field);

     }
	 
	 
	 public EmployeeDetails getEmployeeById(long id) {
//			LOGGER.info("inside bookid service --");
			Optional<EmployeeDetails> empdetails = employeeRepo.getEmployeeDetailsById(id);
			return  empdetails.get();
		}
	 public List<EmployeeDetails> getAllEmployees(){
		 return employeeRepo.findAll();
	 }
	 public List<EmployeeDetails> getEmployeeSalary(){
			return employeeRepo.getEmployeeSalaryLessThan2000();
		}
	

}
