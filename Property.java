package TCRealEstate;

import java.io.Serializable;

import linkedlists.LinkedList;

public class Property implements Serializable,Comparable<Property>{
	private String PropertyID;
	private String PropertyName;
	private String Street;
	private String City;
	private String PropertyState;
	private String Zip;
	private PropertyType propertyType;
	private ZoneType zoning;
	private int NumUnits;
	private Owner owner;
	private Branch branch;
	private Agent agent;
	private LinkedList<PropForRent> rentals;
	
	public Property(String propertyID, String propertyName, String street,
			String city, String propertyState, String zip,
			PropertyType propertyType, ZoneType zoning, int numUnits,
			Owner owner, Branch branch, Agent agent) {
		
		PropertyID = propertyID;
		PropertyName = propertyName;
		Street = street;
		City = city;
		PropertyState = propertyState;
		Zip = zip;
		this.propertyType = propertyType;
		this.zoning = zoning;
		NumUnits = numUnits;
		this.owner = owner;
		this.branch = branch;
		this.agent = agent;
		rentals = new LinkedList<PropForRent>();
	}
	
  
    public int compareTo(Property p){
    	return this.PropertyID.compareTo(p.PropertyID);
    }
}
