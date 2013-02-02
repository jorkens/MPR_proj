package registerOffice.businessObjects.clients;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import registerOffice.Context;
import registerOffice.businessObjects.scooters.*;


@Entity
@Table(name = "Osoby")
@NamedQueries({
	@NamedQuery(
			name="Driver.all",
			query="from Driver p"
			),
	@NamedQuery(
			name="Driver.id",
			query="from Driver p where id= :id"
			),
	@NamedQuery(
			name="Driver.delete",
			query="Delete from Driver p where id=:id"
			)
})
public class Driver {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="Imie")
	private String name;
	
	@OneToMany(mappedBy="owner", cascade = CascadeType.PERSIST)
	private List<Scooter> scooters;
	
	private String pesel;
	private String address;
	
	@Transient
	Context context;
	
	public Driver(String name, String pesel, String address)
	{
		this(name,pesel);
		this.address=address;
	}
	public Driver(String name, String pesel)
	{
		context= Context.getInstance();
		context.raisenumberOfPeople();
		this.pesel=pesel;
		this.name=name;
		this.scooters=new ArrayList<Scooter>();
	}
	
	public Driver(String name) {
		
		this(name,"");
	}
	
	public Driver()
	{
		
		this("","");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Scooter> getCars() {
		return scooters;
	}
	public void setCars(List<Scooter> cars) {
		this.scooters = cars;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	protected void finalize() throws Throwable {
		context.reducePeople();
		super.finalize();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
