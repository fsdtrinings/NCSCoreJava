package p1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import p1.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	Connection con;
	
	public EmployeeDAOImpl() {
		
		con = MySQLConnection.mySql;
	}
	
	@Override
	public boolean saveEmployee(Employee e) throws SQLException{
		
		/* code should be responsible to 
		 * 1) insert employee into DB 
		 * 2) return the status value*/
		
		String query = "insert into ncsemployee(empId,name,salary) values(?,?,?);";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(3, e.getSalary());
		ps.setInt(1, e.getEmpId());
		ps.setString(2,e.getName());
		
		int rowsEffected = ps.executeUpdate();
		
		boolean status = (rowsEffected == 1)?true:false;
		
		return status;
	}

	@Override
	public Employee getEmployeeByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmploye() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee doLinkProjectWithEmployee(int empId, int projetId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
