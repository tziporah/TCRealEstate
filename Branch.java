package TCRealEstate;

import java.io.Serializable;

import exceptions.MissingDataException;

public class Branch implements Serializable, Comparable<Branch>{
	
	private String branchID;
	private String branchName;
	private String branchPhoneNumber;
	private Address address;
	
	
	
	public Branch(String branchID, String branchName, String phoneNumber,Address address){
	  if (branchID == null || branchName == null || phoneNumber == null || address == null){
		     throw new MissingDataException();
	  }
	  this.branchID = branchID;
	  this.branchName = branchName;
	  this.branchPhoneNumber = phoneNumber;
	  this.address = address;
	}
	
	public Branch(String branchID, String branchName, String phoneNumber,String street, String city,
			String usstate, String zip){
		this(branchID,branchName,phoneNumber,new Address(street,city,usstate,zip,"BILLING"));
		
	}
	
	//copy constructor
	public Branch(Branch aBranch){
		this(aBranch.getBranchID(),aBranch.getBranchName(),
				aBranch.getBranchPhoneNumber(),aBranch.getAddress());
	}
	
	//getters and setters
	

	public void setPhoneNumber(String phoneNumber){}
	public String getBranchID() {
		return branchID;
	}

	public String getBranchName() {
		return branchName;
	}

	public String getBranchPhoneNumber() {
		return branchPhoneNumber;
	}

	public Address getAddress() {
		return address.clone();
	}

	public void setAddress(Address address){
		this.address = address;  //new address
	}
	
	//equals ()  based on branchID
	
	public boolean equals(Object o){
		if (o == null){
			return false;
		}
		if  (!( o instanceof Branch)){
			return false;
		}
		Branch aBranch =(Branch)(o); //typecast
		
		return (this.branchID.equalsIgnoreCase(aBranch.branchID));
	}
	
	//compareTo()  based on branchID
	public int compareTo(Branch aBranch){
		return this.branchID.compareTo(aBranch.branchID);
	}

	@Override
	public String toString() {
		return "\nBranch [branchID=" + branchID + ", branchName=" + branchName
				+ ", branchPhoneNumber=" + branchPhoneNumber + ", address="
				+ address + "]";
	}
	
	
	public Branch clone(){
		return new Branch (  branchID,branchName ,branchPhoneNumber ,
				  address.clone());
				
			
		
	}

	
	
	
	

}
