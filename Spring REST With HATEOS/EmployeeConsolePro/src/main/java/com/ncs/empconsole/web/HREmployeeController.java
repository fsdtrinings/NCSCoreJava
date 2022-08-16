package com.ncs.empconsole.web;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.empconsole.dto.HREmployeeResponseDTO;
import com.ncs.empconsole.exception.OutofRangeSalaryException;
import com.ncs.empconsole.model.Department;
import com.ncs.empconsole.model.Employee;
import com.ncs.empconsole.model.Project;
import com.ncs.empconsole.service.DepartmentService;
import com.ncs.empconsole.service.EmployeeService;
import com.ncs.empconsole.service.ProjectService;
import com.ncs.empconsole.util.HREmployeeDTOConverstion;

@RestController
@RequestMapping("/empconsole/hr")
@Validated
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:4200"},allowedHeaders = "*")
public class HREmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	ProjectService projectService;
	
	
	public HREmployeeController() {
		System.out.println("HR Employee Controller constructor called");
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return empService.getAllEmployees();
	}

	@GetMapping("/employee/id/{id}")
	public ResponseEntity<HREmployeeResponseDTO> getEmployeeById(@PathVariable int id)throws IllegalArgumentException,NoSuchElementException
	{
		System.out.println("path varible : "+id);
		try {
			Employee output = empService.getEmployeeDetails(id);
			
			
			HREmployeeResponseDTO dto = HREmployeeDTOConverstion.convertToHRReponse(output);
			
			
			return new ResponseEntity<HREmployeeResponseDTO>(dto,HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(" --->> inside catch ");
			throw new NoSuchElementException(e.getMessage());
		}
	}
	
	@GetMapping("/employee") // ..../employee/hr/employee?name=ramesh
	public Employee getEmployeeByName(@RequestParam String name)
	{
		System.out.println("path varible : "+name);
		Employee e =  empService.getEmployeeDetails(name);
		System.out.println(e);
		return e;
	}
	
	@PutMapping("/employee/{searchEmpId}/project")
	public Employee updateEmployee(@PathVariable int searchEmpId,@RequestParam int projectId)
	{
		return empService.updateProject(searchEmpId, projectId);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee e)throws OutofRangeSalaryException
	{
		
		Employee savedEmployee = empService.addEmployee(e);
		
		return new ResponseEntity<Employee>(savedEmployee,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/employees/salary") 
	public ResponseEntity<List<Employee>> getEmployeeBySalaryRange(@RequestParam int r1,@RequestParam int r2)
	{
		
		List<Employee> list =  empService.getAllEmployees(r1, r2);
		System.out.println(list);
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	} 
	
	@PostMapping("/department")
	public Department addDepartment(@RequestBody Department department)
	{
		return departmentService.addDepartment(department);
	}
	
	@GetMapping("/department/{dCode}")
	public Department getDepartmentById(@PathVariable int dCode)
	{
		return departmentService.getDepartmentByCode(dCode);
	}
	
	@PutMapping("/employee/{searchEmpId}/department")
	public Employee updateEmployeeDepartment(@PathVariable int searchEmpId,@RequestParam int dcode)
	{
		System.out.println(" HR @ REST Controller ");
		System.out.println(" Searched Emp Id :- "+searchEmpId);
		System.out.println("D code "+dcode);
		Department d = departmentService.getDepartmentByCode(dcode);
		
		if(d != null)
		{
			System.out.println("--->> inside d "+d);
			Employee e = empService.updateDepartment(searchEmpId, d);
			return e;
		}
		
		return null;
	}
	
	@PostMapping("/project")
	public Project addProject(@RequestBody Project project)
	{
		return projectService.addProject(project);
	}
	
	@GetMapping("/project/{pid}")
	public ResponseEntity<Project> getProjetById(@PathVariable int pid)throws Exception
	{
		Project p =  projectService.getProject(pid);
		if(p != null)
		{
			return new ResponseEntity<Project>(p,HttpStatus.OK);
		}
		else
		{
			throw new Exception("Invalid Project ID");
		}
	}
	
	@PutMapping("/project/{pid}")
	public ResponseEntity<Set<Employee>> allocateEmployeeToProject(@PathVariable int pid, @RequestParam int empId)throws Exception
	{
		 Set<Employee> workingEmployee = null;
		 
		  
		 Employee e = empService.getEmployeeDetails(empId);
		 
		 Project p = projectService.getProject(pid);
		 
		 // write exception handling code if e or p is null
		 
		 if(e != null & p != null)
		 {
			 workingEmployee = projectService.allocateProject(p, e);
			 return new ResponseEntity<Set<Employee>>(workingEmployee,HttpStatus.OK);
		 }
		 else 
		 {
			 throw new Exception("Invalid Project ID or no Employee Allocated");
		 }
		 
	}
	
	@GetMapping("/project/{pid}/employees")
	public ResponseEntity<Set<Employee>> getAllWorkingEmployees(@PathVariable int pid)throws Exception
	{
		Set<Employee> workingEmployees =  projectService.getProjectResource(pid);
		
		if(workingEmployees!=null || workingEmployees.size()>0)
		{
			
			for (Employee employee : workingEmployees) {
				
				/*
				Link empLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(
						HREmployeeController.class)
						.getEmployeeById(employee.getEmpId())
						).withSelfRel();
				*/
				Link empLink = WebMvcLinkBuilder.linkTo(HREmployeeController.class).slash("/employee/id/"+employee.getEmpId()).withSelfRel();
				employee.add(empLink);
				
			}
			
			
			 return new ResponseEntity<Set<Employee>>(workingEmployees,HttpStatus.OK);
		}
		 else 
		 {
			 throw new Exception("Invalid Project ID or no Employee Allocated");
		 }
	}
	
}//end class




















