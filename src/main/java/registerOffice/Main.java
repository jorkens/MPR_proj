package registerOffice;

import java.sql.SQLPermission;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import registerOffice.businessObjects.clients.*;
import registerOffice.businessObjects.scooters.DriverScooter;
import registerOffice.businessObjects.scooters.Scooter;
import registerOffice.businessObjects.scooters.BigScooter;
import registerOffice.management.*;
import registerOffice.management.conditions.Condition;
import registerOffice.management.conditions.GetByAddressCondition;
import registerOffice.management.conditions.GetByNameCondition;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		ManagerInterface<Driver> hib= 
				new HibernatePersonManager(session);
				
		
		Driver andrzej = new Driver("Andrzej", "31234", "Dluga 1");
		Scooter burg = new DriverScooter("Burgman","gda1234");
		Scooter suzuki = new DriverScooter("Suzuki","gda5678");
		burg.setOwner(andrzej);
		suzuki.setOwner(andrzej);
		andrzej.getCars().add(burg);
		andrzej.getCars().add(suzuki);
		
		hib.save(andrzej);
		
		List<Driver>results = hib.getAll();
		
		for(Driver p :results)
		{
			System.out.println(p.getName());
		}		
	}
}
