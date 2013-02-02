package registerOffice.management;

import java.util.ArrayList;
import java.util.List;

import registerOffice.businessObjects.clients.Driver;
import registerOffice.businessObjects.scooters.Scooter;

public class DatabaseContext {

	private static List<Driver> drivers=new ArrayList<Driver>();
	private static List<Scooter> scooters=new ArrayList<Scooter>();
	
	public static List<Driver> getPersons() {
		return drivers;
	}
	public static List<Scooter> getScooters() {
		return scooters;
	}
	
	
}
