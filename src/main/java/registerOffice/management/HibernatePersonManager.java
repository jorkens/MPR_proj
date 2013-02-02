package registerOffice.management;

import java.util.List;

import org.hibernate.Session;

import registerOffice.businessObjects.clients.Driver;

public class HibernatePersonManager 
	implements ManagerInterface<Driver>{

	Session session;
	
	public HibernatePersonManager(Session session)
	{
		this.session=session;
	}
	
	@Override
	public Driver get(int id) {
		
		List<Driver> result = 
				session.getNamedQuery("Driver.id")
					.setInteger("id", id).list();
		if(result.size()==0)
			return null;
		
		Driver returnValue = new Driver(
				result.get(0).getName(), 
				result.get(0).getPesel(),
				result.get(0).getAddress());
		returnValue.setId(result.get(0).getId());
		return returnValue;
	}

	@Override
	public List<Driver> getAll() {
		List<Driver> result =
				session.getNamedQuery("Driver.all")
				.list();
		return result;
	}

	@Override
	public boolean save(Driver obj) {
		
		try{
			session.beginTransaction();
			session.persist(obj);
			session.getTransaction().commit();
			return true;
		}catch(Exception ex){}
		
		return false;
	}

	@Override
	public boolean delete(Driver obj) {
		
		try
		{
			session.beginTransaction();
			session.getNamedQuery("Driver.delete")
			.setInteger("id", obj.getId())
			.executeUpdate();
			
			session.getTransaction().commit();
			return true;
		}catch(Exception ex)
		{}
		
		return false;
	}

}
