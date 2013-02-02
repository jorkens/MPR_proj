package registerOffice.management;

import java.util.List;

import registerOffice.businessObjects.clients.Driver;
import registerOffice.management.conditions.Condition;

public interface ManagerInterface<TEntity> {
	
	public TEntity get(int id);
	public List<TEntity> getAll();
	public boolean save(TEntity obj);
	public boolean delete(TEntity obj);
	
	/**
	 * inne metody
	 */

}
