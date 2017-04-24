package TCRealEstate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Scanner;

public class RealEstateMain {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner (System.in);
		System.out.println("1. Restore data from disk "+
		                   "2. Set up new application");     
		int choice;
		RealEstate theRealEstate=null;
		
		choice = keyboard.nextInt();
		if (choice ==1){
			try{
			     ObjectInputStream in = new ObjectInputStream(new FileInputStream("realestate.ser"));
			     theRealEstate = (RealEstate)in.readObject();
			}
			catch(IOException io){
				System.out.println("couldn't restore data ..... contact IT immediately....");
				System.exit(1);
			}
			catch(ClassNotFoundException notfound){
				System.out.println("couldn't restore data.... class versions don't match... contact IT");
				System.exit(1);
			}
			
		}
		
		else{
			//instantiate a new instance of the RealEstate
		     theRealEstate = new RealEstate("TC RealEstate Agency");
		}
		
		
		while (true){
			choice = menu();
			//now process the choice
			switch (choice){
			case 0:  
				    System.out.println("exiting the application");
				    //now store all the data on disk
				    try{
				             ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream("realestate.ser") );
				 
				             out.writeObject(theRealEstate);
				             System.out.println("all data stored on disk in realestate.ser");
				             System.exit(0);  //end application - all is well
				    }
				    catch(IOException io){
				    	System.out.println("data couldn't be stored ---- contact IT immediately!!!");
				    }
				    break;
			case 1:  //add an owner
				//get information from the user
				Owner anOwner = setUpOwner();
				//add the owner to the application
				if (anOwner ==null){
					System.out.println("owner wasn't set up properly");
					
				}
				else{
					theRealEstate.addOwner(anOwner);
				}
				break;
			case 2: //find information about an Owner
				System.out.println("enter owner id:");
				String id = keyboard.next();
				Owner theOwner = theRealEstate.getOwner(id);
				System.out.println(theOwner);
				break;
			        
			
			case 3:
				System.out.println(theRealEstate.getSortedListOfOwners());
				       
			     break;
			     
			case 6:  //add a branch
				Branch aBranch = getBranchInfo();
				theRealEstate.addBranch(aBranch);
				break;
			case 7:   //find a branch
				
				break;
			case 8: //list all branches
				System.out.println(theRealEstate.getBranches());
				break;
			case 9: //remove a branch
				break;
			case 10: //modify branch information
				break;
			case 11: //get branches sorted by name
				Branch[] sorted = theRealEstate.getBranchesByName();
				for (int i=0;i<sorted.length;i++){
					System.out.println(sorted[i]);
				}
				break;
			case 20: //add agent
				String  firstname,lastname,phoneNumber,branchID;
		    	LocalDate birthdate,hiredate;
		    	char gender;
		    	double salary;
		    	Integer agentID;
		    	
		    	
		    	System.out.println("Enter AgentID: ");
		    	agentID = keyboard.nextInt();
		    	System.out.println("First Name: ");
		    	firstname = keyboard.next();
		    	System.out.println("Last Name: ");
		    	lastname = keyboard.next();
		    	System.out.println("Phone Number: ");
		    	phoneNumber = keyboard.next();
		    	System.out.println("Birth Date: yyyy-mm-dd: ");
		    	String dob = keyboard.next();
		       	birthdate = LocalDate.parse(dob);  //converts String to LocalDate
		       	System.out.println("Hire Date: yyyy-mm-dd");
		        String hire = keyboard.next();
		        hiredate = LocalDate.parse(hire);
		        System.out.println("Gender M or F: ");
		        gender = keyboard.next().charAt(0);
		        System.out.println("Salary: ");
		        salary = keyboard.nextDouble();
		        System.out.println("Branch ID: ");
		        branchID = keyboard.next();
		        
				theRealEstate.addAgent(agentID, firstname, lastname, phoneNumber, branchID, birthdate, hiredate, gender, salary);
				break;
			case 21:  //list agents
				System.out.println(theRealEstate.getAgents());
				break;
			case 30: //add property
				break;
			case 31: //list properties
				break;
		}//end switch
		

	}
	}
	
	public static int menu(){
		Scanner userInput = new Scanner(System.in);
		int choice ;
		do{
		System.out.println("1.Add an owner" +
		                   "\n2.Find an owner " +
				           "\n3.List owners in sorted order" +
		                   "\n4.Remove an Owner" +
				           "\n5.Modify Owner Information" +
				           "\n6.Add a Branch" +
				           "\n7.Find a Branch" +
				           "\n8.List all branches" +
				           "\n9.Remove a Branch" +
				           "\n10.Modify Branch Information" +
				           "\n11.Get Branches Sorted by Name" +
				           "\n20. Add an Agent" +
				           "\n21. List Agents "+
				           "\n30.Add a Property" +
				           "\n31. List information about a Property" +
				           "\n100. Restore real estate data from disk" +
				           "\n0. Exit"
				);
		
		choice = userInput.nextInt();
		} while (choice < 0 || choice > 100); //must be a valid choice
		return choice;
	}
	
	 private static Owner setUpOwner(){
		 Owner theOwner = null;
		 Scanner keyIn = new Scanner(System.in);
		 OwnerType[] types = OwnerType.values();
		 System.out.println("Enter the owner type");
		 
		 int typeChoice = -1;
		 while (typeChoice < 1 || typeChoice > types.length){
			 System.out.println("must choice one of the available types");
			 for (int i=0;i<types.length;i++){
				 System.out.println((i+1) + ":" + types[i].name());
			 }
			 typeChoice = keyIn.nextInt();
		 }
		 OwnerType ownType = types[typeChoice-1];
		 
		 //set up the Address field
		 
		 Address address;
		 
		 System.out.println("Enter street:");
		 //flush the buffer
		 keyIn.nextLine();
		 String street = keyIn.nextLine();
		 System.out.println("Enter city:");
		 String city = keyIn.nextLine();
		 System.out.println("Enter state - full name:");
		 String state = keyIn.nextLine();
		 System.out.println("ZipCode:");
		  
		 String zip = keyIn.next(); 
		 System.out.println("what type of address?");
		 
		 //retrieve all current types of addresses
		 AddressType[] addTypes = AddressType.values();
		 typeChoice = -1;
		 while (typeChoice < 1 || typeChoice > addTypes.length){
			 System.out.println("must choice one of the available types");
			 for (int i=0;i<addTypes.length;i++){
				 System.out.println((i+1) + ":" + addTypes[i].name());
			 }
			 typeChoice = keyIn.nextInt();
		 }
		 
		 AddressType addType = addTypes[typeChoice-1];
		 
		 //instantiate the address based on user input
		 address = new Address(street,city,state,zip,addType.name());
		 
		 //now get rest of Owner data
		 System.out.println("PhoneNumber:");
		 
		 String phoneNumber = keyIn.next();
		 
			
		 
		 
		 switch (ownType){
		 case BUSINESS:
			  System.out.println("Enter business name");
			  keyIn.nextLine(); //flush the buffer
			  String businessName = keyIn.nextLine();
			  
			  System.out.println("Contact FirstName:");
			  String contactFirstName = keyIn.next();
			  System.out.println("Contact LastName:");
			  String contactLastName= keyIn.next();
			  System.out.println("Contact PhoneNumber:");
			  String contactPhoneNumber = keyIn.next();
			  theOwner = new BusinessOwner(
					   address, phoneNumber, ownType.name(),  businessName,  
						 contactFirstName,  contactLastName,  contactPhoneNumber	);  
					  
			   break;		  
			 
		 case PRIVATE:
			 System.out.println("Owner FirstName:");
			 String firstName = keyIn.next();
			 System.out.println("Owner LastName:");
			 String lastName = keyIn.next();
			 theOwner = new PrivateOwner( address, phoneNumber,
						 ownType.name(), firstName,  lastName	);
			 break;
			 
		 }
		 
		 
		 return theOwner;  //will be null if didn't get the correct data values
	 }
	 
     private static Branch getBranchInfo(){
    	 Scanner keyIn = new Scanner(System.in);
    	 String branchid,branchname, phonenumber,
    	 street,city,state,zip;
    	 System.out.println("Enter branchid: ");
    	 branchid = keyIn.next();
    	 System.out.println("Enter branch name: ");
    	 branchname = keyIn.next();
    	 System.out.println("Enter phone number: ");
    	 phonenumber = keyIn.next();
    	 System.out.println("Enter street: ");
    	 //clear the return code from the input buffer
    	 keyIn.nextLine();
    	 //now store the next item of data keyed in by user
    	 street = keyIn.nextLine();
    	 System.out.println("Enter city: ");
    	 city = keyIn.nextLine();
    	 System.out.println("Enter state: ");
    	 state = keyIn.nextLine();
    	 System.out.println("Enter zip: ");
    	 zip = keyIn.next();
    	 
    	 Branch aBranch= new Branch(branchid,branchname,phonenumber,
    			 street,city,state,zip);
    	 return aBranch;
    	 
    	 
     }
     
     
     
}  //end class definition
