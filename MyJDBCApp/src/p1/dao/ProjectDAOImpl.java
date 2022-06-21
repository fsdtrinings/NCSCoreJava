package p1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import p1.model.Project;

public class ProjectDAOImpl implements ProjectDAO {

	Connection con;

	public ProjectDAOImpl() {
		
		con = MySQLConnection.mySql;
	}

	@Override
	public boolean addProject(Project p) throws SQLException{
	String query = "insert into project(projectNumber,porjectName,cost) values(?,?,?);";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setInt(1, p.getProjectNumber());
		ps.setString(2,p.getProjectName());
		ps.setInt(3, p.getCost());
		
		int rowsEffected = ps.executeUpdate(); // for DML (insert,update ,delete)
		
		boolean status = (rowsEffected == 1)?true:false;
		
		return status;
	}

	@Override
	public Project getProjectById(int projectId)throws SQLException {

		Project outputProject = null;
		
		String query = "select * from project where projectNumber = ?"; // DQL 
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, projectId);
		
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			String projectName = rs.getString(2);
			String projectHeadEmail = rs.getString("projectHeadEmail");
		
			outputProject = new Project();
			outputProject.setProjectNumber(projectId);
			outputProject.setProjectName(projectName);
			outputProject.setProjectHeadEmail(projectHeadEmail);
		}
		
		
		return outputProject;
	}

	@Override
	public boolean getProject(Project p) throws SQLException {
Project outputProject = null;
		
		String query = "select * from project where projectNumber = ?"; // DQL 
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, projectId);
		
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			String projectName = rs.getString(2);
			String projectHeadEmail = rs.getString("projectHeadEmail");
		
			outputProject = new Project();
			outputProject.setProjectNumber(projectId);
			outputProject.setProjectName(projectName);
			outputProject.setProjectHeadEmail(projectHeadEmail);
		}
		
		
		return outputProject;
	}

}
