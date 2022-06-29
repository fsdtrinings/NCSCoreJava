package p1;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class ReadRecords {

	public static void main(String[] args) {
		
		
		
		Session hibernate = HibernateUtil.getHibernateLink();
		
		
		Employee e = (Employee)hibernate.get(Employee.class, 501);
		
		System.out.println(" -->> Read Operaton Called :- "+e);
		
		Transaction t = hibernate.beginTransaction();

		e.setBankAccount(1958247);
		
		t.commit();
		hibernate.close();
		
		System.out.println(" 5. Database commit & hibernate closed ...");
		
	}
}
