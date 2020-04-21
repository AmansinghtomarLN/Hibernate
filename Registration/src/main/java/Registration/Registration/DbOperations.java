package Registration.Registration;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DbOperations {
	
// Method Used To Create The Hibernate's SessionFactory Object
	public static SessionFactory getSessionFactory() {
// Creating Configuration Instance & Passing Hibernate Configuration File
		Configuration con= new Configuration().configure().addAnnotatedClass(Registration.class);


		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); 

		// Creating Hibernate Session Factory Instance
		SessionFactory sf= con.buildSessionFactory(reg);		
		return sf;
	}

// Method 1: This Method Used To Create A New Student Record In The Database Table
	public static Integer createRecord(Registration r) {
		Session session = getSessionFactory().openSession();

		//Creating Transaction Object  
		Transaction tx = session.beginTransaction();
		session.save(r);

		// Transaction Is Committed To Database
		tx.commit();

		// Closing The Session Object
		session.close();
		return r.getId();
	}

// Method 2: This Method Is Used To Update A Record In The Database Table
	public static void updateRecord(Registration r) {
		Session session = getSessionFactory().openSession();

		//Creating Transaction Object  
		Transaction tx = session.beginTransaction();
		Registration re = (Registration) session.load(Registration.class, r.getId());
		re.setName(r.getName());
		re.setMobile(r.getMobile());

		// Transaction Is Committed To Database
		tx.commit();

		// Closing The Session Object
		session.close();
	}
	
// Method 3 : This Method Is Used To Delete A Particular Record From The Database Table
	public static void deleteRecord(Integer id) {
		Session session= getSessionFactory().openSession();

		//Creating Transaction Object  
		Transaction tx = session.beginTransaction();
		Registration r= findRecordById(id);
		session.delete(r);

		// Transaction Is Committed To Database
		tx.commit();

		// Closing The Session Object
		session.close();

	}
	
// Method 4 : This Method To Find Particular Record In The Database Table
	public static Registration findRecordById(Integer id) {
		Session session = getSessionFactory().openSession();
		Registration r = (Registration) session.load(Registration.class, id);

		// Closing The Session Object
		session.close();
		return r;
	}

// Method 5: This Method Is Used To Delete All Records From The Database Table
	public static void deleteAllRecords() {
		Session session = getSessionFactory().openSession();

		//Creating Transaction Object  
		Transaction tx= session.beginTransaction();
		Query queryObj = session.createQuery("DELETE FROM Registration");
		queryObj.executeUpdate();

		// Transaction Is Committed To Database
		tx.commit();

		// Closing The Session Object
		session.close();
	}
	
// Method 6: This Method Is Used To Display The Records From The Database Table
	@SuppressWarnings("unchecked")
	public static List<Registration> displayRecords() {
		Session session = getSessionFactory().openSession();
		List<Registration> studentsList = session.createQuery("FROM Registration").list();

		// Closing The Session Object
		session.close();
		return studentsList;
	}
	
}
