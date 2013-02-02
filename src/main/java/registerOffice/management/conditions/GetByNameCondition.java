package registerOffice.management.conditions;

import registerOffice.businessObjects.clients.Driver;

public class GetByNameCondition extends Condition<Driver>{

	private String name;
	
	public GetByNameCondition(String name)
	{
		this.name=name;
	}
	
	@Override
	protected boolean check(Driver obj) {
		
		return obj.getName().equalsIgnoreCase(name);
	}
	
	

}
