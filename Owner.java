package TCRealEstate;
import java.io.Serializable;

import exceptions.*;
public  class Owner   implements Comparable<Owner> , Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ownerID;
	private Address address;
	private String phoneNumber;
	private OwnerType ownerType;
	
	private static int lastOwnerID=0;
	
	public Owner( Address address, String phoneNumber, String ownerType)
	throws MissingDataException{
		//verify that all data is being provided
		if ( address ==null  || ownerType == null){
			throw new MissingDataException();
		}
		
		//set up the OwnerID
		this.ownerID = "O";
		
	    String id = String.valueOf(++lastOwnerID);
	    //maximum size of field is 6 , so 5 digits are left for the number
		int missingDigits = 5 - id.length();
		if(missingDigits < 0 )
		{
			throw new InvalidDataException();
		}
		else{
			for (int i=0;i< missingDigits;i++){
				this.ownerID += String.valueOf(0);//add leading zeros
			}
		}
		//add on the owner number
		this.ownerID+= String.valueOf(lastOwnerID);
		this.address = address;
		if (!verifyPhoneNumber(phoneNumber)){
			throw new InvalidDataException();
		}
	    this.phoneNumber = phoneNumber;
	    this.ownerType = OwnerType.valueOf(ownerType);
	}
	
	public Owner(  String phoneNumber, String ownerType,
			 String street, String city,String state, String zip,String addressType
			){
		//instantiate an Address and invoke the other constructor to complete the job
		this(new Address(   street, city, state, zip,addressType),
		     phoneNumber,  ownerType);
		
	}
	
	//copy constructor
	public Owner(Owner o){
		this.ownerID = o.getOwnerID();
		this.address = o.getAddress();
		this.phoneNumber = o.getPhoneNumber();
		this.ownerType = o.getOwnerType();
	}
	
	//getters
		
	public String getOwnerID() {
		return ownerID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public OwnerType getOwnerType() {
		return ownerType;
	}
	
	public Address getAddress(){
		return address.clone();   //return a clone of the Address field
	}

	//setters
		
	
	
	public void setPhoneNumber(String phoneNumber){
		//verify phone number before setting it
	}
	
	protected boolean verifyPhoneNumber(String phoneNumber){
		//check if not null and if correct length and has only numeric data
		return true;
	}
	
	public int compareTo(Owner o){
		return this.ownerID.compareTo(o.ownerID);
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("\nOwner");
		buffer.append(ownerID);
		buffer.append(" Address: " + address.toString());
		buffer.append(" PhoneNumber: " + phoneNumber);
		return buffer.toString();
	}
	
	
}