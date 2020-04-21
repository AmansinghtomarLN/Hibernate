package Registration.Registration;

import java.util.Iterator;
import java.util.List;

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
    	Registration r = new Registration();
 
    	
 //  	for update method   
 //   	r.setId(8);

    	 r.setName("Aaman");
    	 r.setPassword("Tomar");
    	 r.setEmail("amantomar@gmail.com");
    	 r.setMobile("7694000010");
//    	
   DbOperations.createRecord(r); 
//  DbOperations.updateRecord(r);
//   DbOperations.deleteRecord(2); 
// 	 DbOperations.deleteAllRecords();
 
    	 
    	 

    
   
    	 
    }
}
