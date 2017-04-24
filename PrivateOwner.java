package TCRealEstate;

import java.io.Serializable;

import exceptions.MissingDataException;

public class PrivateOwner  extends Owner implements Serializable{
	
	private String firstName;
	private String lastName;
	
	public PrivateOwner( Address address, String phoneNumber,
		String ownerType,String firstName, String lastName){
		
		super(address, phoneNumber,ownerType);
		if (firstName == null || lastName ==  null){
			throw new MissingDataException();
			
		}
		this.firstName = firstName;
		this.lastName =lastName;
	}
	
	public PrivateOwner (  String street, String city,String state, String zip,String addressType, String phoneNumber,
		String ownerType,String firstName, String lastName){
		this(new Address(  street, city, state, zip,addressType),
			phoneNumber,ownerType,firstName,lastName	
				);
	}
	
	//copy constructor
	public PrivateOwner(PrivateOwner p){
		super(p);  //set up the Owner fields of the PrivateOwner
		this.firstName = p.firstName;
		this.lastName = p.lastName;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(super.toString());
		buffer.append("Private Owner:" + firstName);
		buffer.append(" " + lastName);
		return buffer.toString();
		
	}

}
