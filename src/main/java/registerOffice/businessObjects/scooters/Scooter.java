package registerOffice.businessObjects.scooters;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import registerOffice.Context;
import registerOffice.businessObjects.clients.Driver;

@Entity
public abstract class Scooter implements ScooterInterface{

	@Id
	@GeneratedValue
	private int id;
	
	
	@ManyToOne
	protected Driver owner;
	
	@Transient
	Context context;
	public Scooter(){
		context =Context.getInstance();
		context.raiseNumberOfCars();
	}
	
	public void printData()
	{
		System.out.println("Owner: "+owner.getName());
		System.out.println(getScooterDetails());
	}
	
	public abstract String getScooterDetails();
	
	public abstract Scooter Clone();
	
	public void setOwner(Driver owner)
	{
		this.owner=owner;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	protected void finalize() throws Throwable {
		context.reduceCars();
		super.finalize();
	}
	
}
