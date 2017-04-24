package TCRealEstate;

import java.io.Serializable;
import exceptions.*;

public class Address implements Serializable {
	private Integer addressID;
	private String street;
	private String city;
	private USState addressState;
	private String zipCode;
	private AddressType addressType;
	
	private static int lastAddressID =0;
	
	//constructor
	public Address (String street, String city,String state, String zip,String addressType){
		if ( street == null || city == null || state == null || zip == null )
		{   //all fields are mandatory / required
			throw new MissingDataException();
		}
		this.addressID = ++lastAddressID;
		this.street = street;
		this.city = city;
		this.addressState= USState.valueOf(state.replaceAll("\\s", ""));
		this.zipCode = zip;
		this.addressType = AddressType.valueOf(addressType );
	}
	
	
	
	//getters
	
	
	//equals method  ---based on zip code
	
	
	//compareTo method  --based on zip code
	
	//toString() method
	
	public String toString(){
		StringBuffer buffer = new StringBuffer("\nAddress:");
		buffer.append(street);
		buffer.append(" " + city);
		buffer.append("," + addressState.getSymbol());
		buffer.append(" " + zipCode);
		return buffer.toString();
	}
	
	//construct a new instance of Address that is a clone of this one
	//but is a deep copy of the Address.
	public Address clone(){
		return new Address(this.street,this.city,this.addressState.name(),this.zipCode,this.addressType.name());
	    
	}

}
