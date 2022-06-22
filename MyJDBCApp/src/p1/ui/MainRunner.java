package p1.ui;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import p1.dto.EmployeeDTO;
import p1.model.Employee;
import p1.model.Project;
import p1.service.EmployeeService;
import p1.service.EmployeeServiceImpl;
import p1.service.ProjectService;
import p1.service.ProjectServiceImpl;

public class MainRunner {

	Scanner sc = new Scanner(System.in);
	
	EmployeeService empService;
	ProjectService projectService;
	
	public MainRunner() {
		empService = new EmployeeServiceImpl();
		projectService = new ProjectServiceImpl();
	}
	
	public static void main(String[] args) {
		
		MainRunner app = new MainRunner();
		
		while(true)
		{
			System.out.println("\n=======================================================");
			System.out.println("0. EXIT");
			System.out.println("1. Insert Employee ");
			System.out.println("2. Add Project");
			System.out.println("3. Add Project to Employee");
			System.out.println("4. View All Employee");
			System.out.println("5. View Employee By ID ");
			System.out.println("6. Delete Employee By ID ");
			System.out.println("8. Employee Details from Projects"); 
			
			
			System.out.println("\n Enter Ur Option :- ");
			int userOption = new Scanner(System.in).nextInt();
			
			switch(userOption)
			{
				
				case 0:	System.exit(0);
						break;
				case 1:	app.saveEmployee();
						break;
				case 2:	app.addProject();
						break;
				case 3: break;
				
				
				case 4: app.viewAllEmployee();
						break;	
				case 5:	app.viewEmployeeetails();
						break;
						
				// deleteEmployee
				case 6: app.deleteEmp();
						break;
						
				// project Id , project Name , Employee Id, employee email
				case 8: try {
					app.getEmployeeDetailsFromProject();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						break;
                // Project Id , total Salary , 
				
				// insert employees in batch 	

				// convert all DML queries in transactions
			}
			
		}//end of while
	}//end of main
	
	
	private void getEmployeeDetailsFromProject() throws SQLException {
		System.out.println("Project Number: ");
		int one = new Scanner(System.in).nextInt();
		
		Project p=projectService.getProjectById(one);
		for(Employee e:empService.getAllEmploye()) {
			
			if(p.getProjectNumber()==e.getProjectInfo()) {
				System.out.println(e);
			}
			
		}
		
		
		
	}



	private void deleteEmp() {
		System.out.println("Enter Employee Number to be Deleted :- ");
		int empNumber = Integer.parseInt(sc.nextLine());
		
		boolean status=empService.deleteEmp(empNumber);
		System.out.println("Employee "+empNumber+" changed: "+status);
		
	}

	private void viewAllEmployee() {
		try {
			List<Employee> list=empService.getAllEmploye();
			System.out.println(list);
			
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void addProject() {
		
		System.out.println("code");
		int one = new Scanner(System.in).nextInt();
		System.out.println("name");
		String two = new Scanner(System.in).next();
		System.out.println("cost");
		int three = new Scanner(System.in).nextInt();
		
		Project p = new Project(one, two, three);
		try {
			boolean status=projectService.addProject(p);
			if(status == true)
			{
				System.out.println(p.getProjectNumber()+" Saved in the Database "+p);
			}
			
			else
			{
				throw new Exception("Unknown SQL Exception ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()+"\n contact to customer care");
			System.out.println("\n\n care@ncshr.com");
		}
		
	}

	public void viewEmployeeetails()
	{
		System.out.println("Enter Employee ID to be Searched :- ");
		int searchId = Integer.parseInt(sc.nextLine());
		
		try {
			Employee e = empService.getEmployeeByID(searchId);
			if(e != null)
			{
				
				Project p = projectService.getProjectById(e.getProjectInfo());
				if(p != null)
				{
					EmployeeDTO dtoObject = new EmployeeDTO();
					dtoObject.setEmpId(e.getEmpId());
					dtoObject.setEmpName(e.getName());
					dtoObject.setEmailId(e.getEmail());
					dtoObject.setProjectName(p.getProjectName());
					dtoObject.setProjectHeadEmail(p.getProjectHeadEmail());
					
					//System.out.println(dtoObject);
					printEmployeeInfo(dtoObject);
				}
				else
				{
					EmployeeDTO dtoObject = new EmployeeDTO();
					dtoObject.setEmpId(e.getEmpId());
					dtoObject.setEmpName(e.getName());
					dtoObject.setEmailId(e.getEmail());
					dtoObject.setProjectName("No Project Allocated");
					dtoObject.setProjectHeadEmail("No Project Allocated");
					
					//System.out.println(dtoObject);
					printEmployeeInfo(dtoObject);
				}
			}
			else
			{
				System.out.println(" Wrong Employee ID !!!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception "+e.getMessage());
		}
	}
	
	public void printEmployeeInfo(EmployeeDTO dto)
	{
		System.out.println("______________________________________");
		System.out.println("Employee Id :- "+dto.getEmpId());
		System.out.println("Employee Name :- "+dto.getEmpName());
		System.out.println("Employee Email :- "+dto.getEmailId());
		System.out.println("Project Name :- "+dto.getProjectName());
		System.out.println("Project Head :- "+dto.getProjectHeadEmail());
		System.out.println("************************************************");
	}
	
	
	public void saveEmployee()
	{
		// code to insert values for Employee
		
		System.out.println("code");
		int one = new Scanner(System.in).nextInt();
		System.out.println("name");
		String two = new Scanner(System.in).next();
		System.out.println("salary");
		int three = new Scanner(System.in).nextInt();
		
		Employee e = new Employee(one, two, three);
		try {
			boolean status = empService.saveEmployee(e);
			if(status == true)
			{
				System.out.println(e.getEmpId()+" Saved in the Database "+e);
			}
			else
			{
				throw new Exception("Unknown SQL Exception ");
			}
		}
		catch (Exception e2) {
			System.out.println(e2.getMessage()+"\n contact to customer care");
			System.out.println("\n\n care@ncshr.com");
		}
		
	}
	
	
}//end of class
