package p1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

	public static void main(String[] args) {
		
		ApplicationContext spring = new ClassPathXmlApplicationContext("ncs-annotation-spring-cofg.xml");
		Employee e = (Employee)spring.getBean("employee");
		
		printEmployeeDetails(e);
		
		
	}
	
	public static void printEmployeeDetails(Employee e)
	{
		System.out.println(e);
		System.out.println(e.getAddress());
		System.out.println(e.getEmployeeInsurance().getSumAssuredAmount());
		
	}
}
