package p1.ui;

import java.util.Scanner;

import p1.model.Employee;
import p1.service.EmployeeService;
import p1.service.EmployeeServiceImpl;

public class MainRunner {

	Scanner sc = new Scanner(System.in);
	
	EmployeeService empService;
	
	public MainRunner() {
		empService = new EmployeeServiceImpl();
	}
	
	public static void main(String[] args) {
		
		MainRunner app = new MainRunner();
		
		//while(true)
		//{
			System.out.println("\n\n ============== Link Panel =====================");
			System.out.println("1. Insert Employee ");
			System.out.println("2. Add Project");
			System.out.println("3. Add Project to E,ployee");
			System.out.println("4. View All Employee");
			System.out.println("5. View Employee By ID ");
			System.out.println("0. EXIT");
			
			System.out.println("\n Enter Ur Option :- ");
			int userOption = new Scanner(System.in).nextInt();
			
			switch(userOption)
			{
				case 1:
						app.saveEmployee();
						break;
				case 0:
					System.exit(0);
			}
			
		//}//end of while
	}//end of main
	
	public void saveEmployee()
	{
		// code to insert values for Employee
		
		System.out.println("code");
		int one = new Scanner(System.in).nextInt();
		System.out.println("Name");
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
