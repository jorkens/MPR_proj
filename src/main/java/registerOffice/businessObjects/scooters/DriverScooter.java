package registerOffice.businessObjects.scooters;

import javax.persistence.Entity;


@Entity
public class DriverScooter extends Scooter{

	//pole statyczne
	
	//pola prywatne
	
	
	
	private String mark;
	private String registerNumber;
	
	//pola publiczne
	
	//konstruktory
	public DriverScooter(String mark, String registerNumber)
	{
		this.mark=mark;
		this.registerNumber=registerNumber;
	}
	
	public DriverScooter()
	{
		this("","");
	}
	
	//wlasciwosci
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
	
	//metody
	

	@Override
	public String getScooterDetails() {
		// TODO Auto-generated method stub
		return mark+" "+registerNumber;
	}

	@Override
	public Scooter Clone() {
		
		DriverScooter returnValue =new DriverScooter();
		returnValue.setRegisterNumber(this.registerNumber);
		
		return returnValue;
	}
}
