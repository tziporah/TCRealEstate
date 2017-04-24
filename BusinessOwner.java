package TCRealEstate;

import java.io.Serializable;

import exceptions.*;

public class BusinessOwner extends Owner implements Serializable{
   private String businessName;
   private String contactFirstName;
   private String contactLastName;
   private String contactPhoneNumber;
   
   public BusinessOwner(
		    String street, String city,String state, String zip,String addressType,
		   String ownerType, String businessName, String businessPhone,
		String contactFirstName, String contactLastName, String contactPhone){
	   
	   this( new Address(  street,  city, state,  zip,addressType), ownerType,
			   businessName, businessPhone, contactFirstName,contactLastName,contactPhone
			   );
	 
   }
   
   public BusinessOwner(Address address,
		   String phoneNumber,String ownerType, String businessName,
			String contactFirstName, String contactLastName, String contactPhone
		   ){
	   super(address,phoneNumber,ownerType);
	   
	   if(businessName == null || contactFirstName== null || contactLastName == null){
		   throw new MissingDataException(); 
	   }
	   
	   this.businessName = businessName;
	  
	   verifyPhoneNumber(contactPhone);
	 
	   this.contactPhoneNumber = contactPhone;
	   this.contactFirstName= contactFirstName;
	   this.contactLastName = contactLastName;
	   
		   
   }
   
   //copy constructor
   public BusinessOwner(BusinessOwner b){
	   super(b);  //create a copy of the Owner fields of the BusinessOwner
	   //now continue and copy the BusinessOwner components 
	   this.businessName = b.getBusinessName();
	  
	   this.contactFirstName = b.contactFirstName;
	   this.contactLastName = b.contactLastName;
	   this.contactPhoneNumber = b.contactPhoneNumber;
   }
   
   
   //getters
   
   
   
   
   public String getBusinessName() {
	return businessName;
}



public String getContactFirstName() {
	return contactFirstName;
}

public String getContactLastName() {
	return contactLastName;
}

public String getContactPhoneNumber() {
	return contactPhoneNumber;
}
//setters
public void setContactFirstName (String firstName){
	   
   }
   

   public void setContactLastName(String lastName){}
   
   public void setContactPhoneNumber(String phoneNumber){}
   
   
   public String toString(){
	   StringBuffer buffer = new StringBuffer();
	   buffer.append(super.toString());
	   buffer.append("BusinessOwner: " +businessName);
	   buffer.append("Contact: " + contactFirstName);
	   buffer.append(" " + contactLastName);
	   buffer.append(" " + contactPhoneNumber);
	   return buffer.toString();
   }
}
