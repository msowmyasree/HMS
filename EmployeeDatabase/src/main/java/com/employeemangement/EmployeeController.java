package com.employeemangement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





@ComponentScan
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/add" ,method = RequestMethod.POST)
	public String addAccount(@RequestBody EmployeeDetails field)  {
		EmployeeDetails employeeDetails=employeeService.addAccount(field);
		
		return "Account Created Successfully "+(employeeDetails.getId());
	}
	


//	@DeleteMapping("/employee/{id}")
	@RequestMapping(path="/employee/{id}")
	public String deleteEmployee(@PathVariable long id) {
	   employeeService.deleteEmployeeById(id);
	   return "Deleted successfully";
	}
	
//	@GetMapping("/profile/{id}")
	@RequestMapping(value="/profile/{id}",produces = "application/xml")
	
     public EmployeeDetails getEmployeeDetailsById(@PathVariable long id )throws RecordNotFoundException {

        return  employeeService.getEmployeeDetailsById(id);

    }
	
//	@PutMapping("/update/{id}")
//	public EmployeeDetails updateBook(@RequestBody EmployeeDetails employeeDetails) {
//		return employeeService.updateEmployee(employeeDetails);
//		
//	}
	@PutMapping(path="/update/{id}",consumes={"application/json"})

    public void updateAccount(@RequestBody EmployeeDetails field)  {

        employeeService.update( field);

    }
	
	@ExceptionHandler(value = RecordNotFoundException.class)
 public ResponseEntity<String> exception(RecordNotFoundException exception) {
        return new ResponseEntity<>( "RECORD NOT FOUND", HttpStatus.OK);    
    }
	
	@GetMapping("/emp/salary")
	public List<EmployeeDetails> getEmployeeSalary(){
		return employeeService.getEmployeeSalary();
	}
	
	
    
	
	
	


	

}
