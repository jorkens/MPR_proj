package registerOffice.management.conditions;

import registerOffice.businessObjects.clients.Driver;

public class GetByPeselCondition extends Condition<Driver>{

	private String pesel;
	
	public GetByPeselCondition(String pesel)
	{
		this.pesel=pesel;
	}
	
	@Override
	protected boolean check(Driver obj) {
		
		return obj.getPesel().equalsIgnoreCase(pesel);
	}

}
