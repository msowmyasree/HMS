package com.employeemangement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeControllerAdvice {
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Object> handleEmptyRecord(RecordNotFoundException recordNotFoundException)
			{
		return new ResponseEntity<>("cannot find record",HttpStatus.OK);
			}
}
