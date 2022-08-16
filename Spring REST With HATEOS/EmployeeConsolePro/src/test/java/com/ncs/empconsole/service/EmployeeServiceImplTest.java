package com.ncs.empconsole.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ncs.empconsole.exception.OutofRangeSalaryException;
import com.ncs.empconsole.model.Employee;
import com.ncs.empconsole.repository.EmployeeRepository;
import com.ncs.empconsole.util.ValidateEmployee;

@SpringBootTest
class EmployeeServiceImplTest {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ValidateEmployee validateEmployee;
	static int empId ;
	
	@Autowired
	EmployeeService employeeService;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		 
	}

	@BeforeEach
	void setUp() throws Exception {
		empId = 10;
	}

	@AfterEach
	void tearDown() throws Exception {
		

	}

	@Test
	@DisplayName("Test - add Employee")
	void testAddEmployee() {
		// Given 
		Employee sampleData = new Employee();
		sampleData.setName("test");
		sampleData.setDesignation("executive");
		sampleData.setSalary(2500);
		
		Employee expectedEmployee = new Employee();
		expectedEmployee.setName("test");
		expectedEmployee.setDesignation("executive");
		expectedEmployee.setSalary(2500);
		expectedEmployee.setEmpId(empId);
		
		System.out.println("--->> expected Employee "+expectedEmployee);
		
		// action
		Employee actulEmployee = null;
		try {
			actulEmployee = employeeService.addEmployee(sampleData);
		} catch (OutofRangeSalaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--->> actual Employee "+actulEmployee);
		// verify
		assertEquals(expectedEmployee, actulEmployee);
	}

	@Test
	@DisplayName("test-Get Employee BAsed on ID")
	void testGetEmployeeDetailsInt() {
		
		// Given 
		Employee expectedEmployee = new Employee();
		expectedEmployee.setName("test");
		expectedEmployee.setDesignation("executive");
		expectedEmployee.setSalary(2500);
		expectedEmployee.setEmpId(empId);
		
		
		// when - then
		Employee actualOutput = employeeService.getEmployeeDetails(empId);
		
		assertEquals(expectedEmployee, actualOutput);
	}
	/*
	@Test
	void testGetEmployeeDetailsString() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllEmployees() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllEmployeesIntInt() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateProject() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateDepartment() {
		fail("Not yet implemented");
	}
	*/

}
