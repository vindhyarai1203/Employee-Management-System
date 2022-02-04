package net.javaguides.springboot.controller;
import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeControl {
	private EmployeeService employeeService;

	public EmployeeControl(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	Logger logger =new LoggerFactory.getLogger(EmployeeControl.class);
	//build create employee REST API 
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		logger.info("New Create request received ..");
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
		//Created is used because it create a class
		
		
	}
	
	// build get all employees REST API
	
	@GetMapping
	public List<Employee> getAllEmployees()
	{
		logger.info("Get all emplyees request received ..");
		return employeeService.getAllEmployees();
		
	}
	//build get employee by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId)
	{
		logger.info("Get employee details request received with employee id "+employeeId);
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
		
	}
	
	
	//build update employee details by Id REST API
	// http://localhost:8080/api/employees/1
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id
			,@RequestBody Employee employee)
	{
		logger.info("Update request received from client with employee Id "+id);
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
	}
	 //Build delete employee by REST API
	// http://localhost:8080/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id)
	{
		// delete employee from DB
		logger.info("Delete request received from client with id: "+id);
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee Deleted Succesfully",HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
