package TCRealEstate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import linkedlists.LinkedList;
import linkedlists.LinkedListIterator;
import exceptions.DuplicateDataException;
import exceptions.NotFoundException;

public class RealEstate implements Serializable{
	private String nameofAgency;
	
	private ArrayList<Owner> owners;
	private Branch[] branches;
	private int numBranches;   //must keep track - how many Branches will instantiated
	private LinkedList<Property> properties;
	private LinkedList<Agent> agents;
	
	public RealEstate(String name){
		owners = new ArrayList<Owner>();
		branches = new Branch[15];
		this.nameofAgency = name;
		numBranches=0;
		properties = new LinkedList<Property>();
		agents = new LinkedList<Agent>();
	}
	
	public void addOwner(Owner owner){
		//verify that the Owner is not already in the list
		//throw DuplicateDataException if this Owner is already in the list
		if (owner !=null){
			owners.add(owner);
			
		}
	}
	
	//***************************manage branch data************************
	public void addBranch(Branch b){
		//verify that there is enough space in the Collection
				//to add another item
				if (numBranches < branches.length){		
				//verify that the Branch is not already in the list
				//throw DuplicateDataException if the Branch is already in the list
			    		
				for (int i=0;i<numBranches;i++){
			    	if (branches[i].getBranchID().equals(b.getBranchID())){
			    		throw new DuplicateDataException();
			    	}
			    }
			    
			    //set up a new Branch , add to the list of Branches
			   
				branches[numBranches++] = b;
				
				}
				else{
					//no more space left in array
					throw new ArrayIndexOutOfBoundsException();
				}
	}
	
	public void addBranch(String branchID, String branchName,String phoneNumber,Address addr){
		addBranch(new Branch(branchID,branchName,phoneNumber,addr));
		
		
	}
	
	public Branch getBranch(String branchid){
		//search through the list of Branches and return deep copy
		for (int i=0; i< numBranches;i++){
			if (branches[i].getBranchID().equals(branchid)){
				//found the branch we are looking for
				return new Branch(branches[i].getBranchID(),
						branches[i].getBranchName(),
						branches[i].getBranchPhoneNumber(),
						branches[i].getAddress());
			}
		}
		throw new NotFoundException();
		
	}
	
	public ArrayList<Branch>getBranches(){
		ArrayList<Branch> branchList = new ArrayList<Branch>();
		for (int i=0;i< numBranches;i++){
			branchList.add(new Branch(branches[i]));
		}
		
		return branchList;
	}
	
	//remove a Branch
	public void removeBranch(String branchID){
		//find the branch
		for (int i=0;i< numBranches;i++){
			if (branches[i].getBranchID().equals(branchID)){
				//found the branch, bump up the branches to remove this one
				for (int j=i;j<branches.length-1;j++){
					branches[j] =branches[j+1];//bump up the data references
				}
				numBranches--;
				return ;  //done
				
			}
		}
		throw new NotFoundException();
	}
	
	//modify Branch information
	public void modifyBranchPhoneNumber(String branchID,String phoneNumber){
		for (int i=0;i< numBranches;i++){
			if (branches[i].getBranchID().equals(branchID)){
				//found the branch
				branches[i].setPhoneNumber(phoneNumber);
				return ;  //done
				
			}
		}
		throw new NotFoundException();
	}
	
	public void modifyBranchAddress(String branchID,Address addr){
		for (int i=0;i< numBranches;i++){
			if (branches[i].getBranchID().equals(branchID)){
				//found the branch
				branches[i].setAddress(addr);
				return ;  //done
				
			}
		}
		throw new NotFoundException();
	}
	
	//sort branches based on branchname
	public Branch[] getBranchesByName(){
		//set up another array copy - this copy will be sorted
		Branch[] copies = new Branch[numBranches];
		//place references to the Branches in this array
		for (int i=0;i<numBranches;i++){
			copies[i]= branches[i];
		}
		//use selection sort the data , then return the sorted data
		
			for (int i=0 ;i< numBranches-1;i++){
				
				Branch nextBranch = copies[i]; 
	                    //assume this contains Branch with "smallest" BranchName
				int smallestRecSubscript = i;
				//compare each element to every other element to see
				//which element contains a reference to the "smallest" Branch Name
				for (int j=i+1;j< numBranches;j++){
					
					if (copies[j].getBranchName().compareTo(nextBranch.getBranchName())<0){
						//found  record referencing a Branch with smaller branch name
						nextBranch = copies[j];
						smallestRecSubscript = j;
					}
				}
				//found the smallest for this "go round"
				if (smallestRecSubscript != i){
					//have to swap the smallest into the correct position
					copies[smallestRecSubscript] = copies[i];
					copies[i] = nextBranch;
				}
			}
			return copies;
		}


		
		
		
		
	
	
	
	//return deep copy
	public Owner getOwner(String ownerID){
      for (Owner o : owners){
    	  if (o.getOwnerID().equalsIgnoreCase(ownerID)){
    		  if (o.getOwnerType().equals(OwnerType.BUSINESS)){
    			  return new BusinessOwner((BusinessOwner)o);
    		  }
    		  else 
    			  if (o.getOwnerType().equals(OwnerType.PRIVATE)){
    				  return new PrivateOwner((PrivateOwner)o);
    			  }
    			  else{
    				  return null;  //types don't match
    			  }
    	  }
      }
      return null;  //not found
	}
	

	
	public String getSortedListOfOwners(){
		StringBuffer buffer = new StringBuffer();
		Collections.sort(owners);
		for (Owner o: owners){
			buffer.append(o.toString());  //polymorphism
			
		}
		
		return buffer.toString();
	}
	
	public void addAgent(int id, String firstName, String lastName,
			String phoneNumber, String branchID, LocalDate dob,LocalDate hireDate,
			char gender, double salary){
		Branch theBranch= null;  //references the Branch to which this agent is assigned
		//first verify that we can find the branch - data should remain consistent
		//search through the list of Branches 
				for (int i=0; i< numBranches;i++){
					if (branches[i].getBranchID().equals(branchID)){
						theBranch = branches[i];
						break; //no need to search further
					}
				} //end search
				if (theBranch ==null){//couldn't find a Branch with that id
				    throw new NotFoundException();
				}
		//make sure the agentID is not a duplicate
			    if (!agentIDExists(id)){
			    	//instantiate the Agent
				    Agent theAgent = new Agent(id,firstName,lastName,phoneNumber,theBranch,hireDate,dob,gender,salary);			
				      //assuming all is well , add to list
			        agents.add(theAgent);
			    }
			    else{
			    	throw new DuplicateDataException();
			    }	
		
	    
	
	}
	
	private boolean agentIDExists(Integer agentID){
		LinkedListIterator<Agent> iter = agents.iterator();
		while (iter.hasNext()){
			Agent a = iter.next();
			if (a.getAgentID().equals(agentID)){
				return true;
			}
			
		}
		return false;
	}
	
	public ArrayList<Agent> getAgents(){
		ArrayList<Agent> list = new ArrayList<Agent>();
		LinkedListIterator<Agent> iter = agents.iterator();
		while (iter.hasNext()){
			Agent theAgent = iter.next();
			list.add(theAgent.clone());
		}
		return list;
	}

}
