package TCRealEstate;

import java.io.Serializable;
import java.time.LocalDate;

public class Agent implements Serializable,Comparable<Agent> {
   
   

private Integer agentID;
   private String firstName;
   private String lastName;
   private String phoneNumber;
   private Branch branch;
   private LocalDate hireDate;
   private LocalDate dateOfBirth;
   private char gender;
   private double salary;
   
   public Agent(int agentID, String firstName, String lastName,
			String phoneNumber,Branch branch, LocalDate hireDate, LocalDate dateOfBirth,
			char gender, double salary) {
		
		this.agentID = agentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.branch = branch;
		this.hireDate = hireDate;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.salary = salary;
		
	}
   
   public int compareTo(Agent a){
	   return this.agentID.compareTo(a.agentID);
   }

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public Branch getBranch() {
	return branch;
}

public void setBranch(Branch branch) {
	this.branch = branch;
}

public double getSalary() {
	return salary;
}

public void setSalary(double salary) {
	this.salary = salary;
}

public Integer getAgentID() {
	return agentID;
}

public String getFirstName() {
	return firstName;
}

public LocalDate getHireDate() {
	return hireDate;
}

public LocalDate getDateOfBirth() {
	return dateOfBirth;
}

public char getGender() {
	return gender;
}

@Override
public String toString() {
	return "\nAgent [agentID=" + agentID + ", firstName=" + firstName
			+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
			+ ", branch=" + branch + ", hireDate=" + hireDate
			+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
			+ ", salary=" + salary + "]";
}


public Agent clone(){
	
	return new Agent( agentID, firstName,lastName,
			 phoneNumber, branch.clone(),  hireDate, dateOfBirth,
			 gender,  salary);		
			
			
		
}
}
