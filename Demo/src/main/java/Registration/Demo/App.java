package Registration.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Persistence p = new Persistence();
        
        p.setName("Amannn");
        p.setPassword("Tomar");
        
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Persistence.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf =con.buildSessionFactory();
        Session s =sf.openSession();
       
        Transaction tx = s.beginTransaction();
        s.save(p);
        tx.commit();
    }
}
