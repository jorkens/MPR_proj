package registerOffice.management.conditions;

import registerOffice.businessObjects.clients.Driver;

public class GetByAddressCondition extends Condition<Driver>{

	private String address;
	
	public GetByAddressCondition(String address)
	{
		this.address=address;
	}
	@Override
	protected boolean check(Driver obj) {
		// TODO Auto-generated method stub
		return obj.getAddress().equalsIgnoreCase(address);
	}

}
