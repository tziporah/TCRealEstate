package TCRealEstate;

import java.io.Serializable;

public class PropForRent implements Serializable , Comparable<PropForRent>{
   private String propertyID;
   private Integer unitID;
   private Integer numBedrooms;
   private Integer numBathrooms;
   private Integer squareFeet;
   private Double monthlyRent;
   private Boolean isAvailable;
   private Condition unitCondition;
   private Boolean petsAllowed;
   
public PropForRent(String propertyID, Integer unitID, Integer numBedrooms,
		Integer numBathrooms, Integer squareFeet, Double monthlyRent,
		Boolean isAvailable, Condition unitCondition, Boolean petsAllowed) {
	
	this.propertyID = propertyID;
	this.unitID = unitID;
	this.numBedrooms = numBedrooms;
	this.numBathrooms = numBathrooms;
	this.squareFeet = squareFeet;
	this.monthlyRent = monthlyRent;
	this.isAvailable = isAvailable;
	this.unitCondition = unitCondition;
	this.petsAllowed = petsAllowed;
}

public Double getMonthlyRent() {
	return monthlyRent;
}

public void setMonthlyRent(Double monthlyRent) {
	this.monthlyRent = monthlyRent;
}

public Boolean getIsAvailable() {
	return isAvailable;
}

public void setIsAvailable(Boolean isAvailable) {
	this.isAvailable = isAvailable;
}

public Condition getUnitCondition() {
	return unitCondition;
}

public void setUnitCondition(Condition unitCondition) {
	this.unitCondition = unitCondition;
}

public Boolean getPetsAllowed() {
	return petsAllowed;
}

public void setPetsAllowed(Boolean petsAllowed) {
	this.petsAllowed = petsAllowed;
}

public String getPropertyID() {
	return propertyID;
}

public Integer getUnitID() {
	return unitID;
}

public Integer getNumBedrooms() {
	return numBedrooms;
}

public Integer getNumBathrooms() {
	return numBathrooms;
}

public Integer getSquareFeet() {
	return squareFeet;
}

@Override
public String toString() {
	return "PropForRent [propertyID=" + propertyID + ", unitID=" + unitID
			+ ", numBedrooms=" + numBedrooms + ", numBathrooms=" + numBathrooms
			+ ", squareFeet=" + squareFeet + ", monthlyRent=" + monthlyRent
			+ ", isAvailable=" + isAvailable + ", unitCondition="
			+ unitCondition + ", petsAllowed=" + petsAllowed + "]";
}

public int compareTo(PropForRent rental){
	if (this.propertyID.equals(rental.getPropertyID())
			&& this.unitID.equals(rental.getUnitID())
			)
		return 0;  //same rental
	else{
		if (this.propertyID.equals(rental.getPropertyID()))
		{
			return this.unitID.compareTo(rental.getUnitID());
		}
		else{
			return this.propertyID.compareTo(rental.getPropertyID());
		}
	}
}

public int hashCode(){
	return (this.propertyID + this.unitID).hashCode();
}

public boolean equals(Object o){
	if (o == null){
		return false;
	}
	else if(o instanceof PropForRent){
		PropForRent other = (PropForRent) o;
		if (this.getPropertyID() == other.getPropertyID() && this.getUnitID() == other.getUnitID()){
			return true;
		}
		else{
			return false;
		}
	}
	else{ //o not a propforrent
		return false;
	}
}


   
   
   
}
