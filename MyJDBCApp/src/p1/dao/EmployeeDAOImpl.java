package p1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import p1.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	Connection con;
	ProjectDAO projectDAO ;
	
	public EmployeeDAOImpl() {
		
		con = MySQLConnection.mySql;
		projectDAO = new ProjectDAOImpl();
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
		
		int rowsEffected = ps.executeUpdate(); // for DML (insert,update ,delete)
		
		boolean status = (rowsEffected == 1)?true:false;
		
		return status;
	}

	@Override
	public Employee getEmployeeByID(int id) throws SQLException
	{
		Employee output = null;
		
		String query = "select * from ncsEmployee where empid = ?"; // DQL 
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		
		ResultSet rs =ps.executeQuery();
		System.out.println(rs);
		if(rs!=null)
		{
			while(rs.next()) // its validate whether rs has value or not & if there is any value then points to next value
			{
				int empId = rs.getInt(1);
				String name = rs.getString(2);
				int projectId = rs.getInt(3);
				String email = rs.getString("email");
				int bankAccount = rs.getInt("bankaccount");
				String address= rs.getString("address");
				String designation = rs.getString("designation");
				int salary = rs.getInt("salary");
				
				
				output = new Employee(empId, name, projectId, email, bankAccount, address, designation, salary);
				
				
			}
			
		}
		
		
		return output;
	}

	@Override
	public List<Employee> getAllEmploye() throws SQLException{
		
		List<Employee> list=new ArrayList<>();
		
		PreparedStatement ps=con.prepareStatement("select * from ncsemployee");

		ResultSet rs=ps.executeQuery();
		
		if(rs!=null)
		{
			while(rs.next()) // its validate whether rs has value or not & if there is any value then points to next value
			{
				int empId = rs.getInt(1);
				String name = rs.getString(2);
				int projectId = rs.getInt(3);
				String email = rs.getString(4);
				int bankAccount = rs.getInt(5);
				String address= rs.getString(6);
				String designation = rs.getString(7);
				int salary = rs.getInt(8);
				
				
				//output = new Employee(empId, name, projectId, email, bankAccount, address, designation, salary);
				list.add(new Employee(empId, name, projectId, email, bankAccount, address, designation, salary));
				
				
			}
		}
		
		
		return list;
		
	}

	@Override
	public Employee doLinkProjectWithEmployee(int empId, int projetId)throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
