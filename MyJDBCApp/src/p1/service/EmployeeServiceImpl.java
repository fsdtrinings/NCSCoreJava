package p1.service;

import java.sql.SQLException;
import java.util.List;

import p1.dao.EmployeeDAO;
import p1.dao.EmployeeDAOImpl;
import p1.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	EmployeeDAO empDAO;
	
	public EmployeeServiceImpl() {
		empDAO = new EmployeeDAOImpl();
	}
	
	@Override
	public boolean saveEmployee(Employee e) throws SQLException{
		// add security code 
		// add data validation code 
		// add other business contraint on employee to be add
		
		boolean status = empDAO.saveEmployee(e);
		return status;
	}

	@Override
	public Employee getEmployeeByID(int id) throws SQLException {
		
		Employee output = empDAO.getEmployeeByID(id);
		
		return output;
	}

	@Override
	public List<Employee> getAllEmploye()throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee doLinkProjectWithEmployee(int empId, int projetId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateSalary(int salary, String designation) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
