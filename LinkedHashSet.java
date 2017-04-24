package TCRealEstate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedHashSet {
	
	private ArrayList<LinkedList> hashSet;
	private LinkedList<PropForRent> insertOrder;
	
	public LinkedHashSet(){
		hashSet = new ArrayList<LinkedList>(16);
		for (int i = 0; i < hashSet.size(); i++){
			hashSet.set(i, new LinkedList());
		}
		insertOrder = new LinkedList<PropForRent>();
	}
	
	public boolean add(PropForRent p){
		int hashCode = p.hashCode();
		if (hashSet.get(hashCode % 16).isEmpty()){
			hashSet.set(hashCode % 16, new LinkedList<PropForRent>());
			hashSet.get(hashCode % 16).add(p);
			insertOrder.add(p);
			return true;
		}else {
			LinkedList<PropForRent> bucket = hashSet.get(hashCode % 16);
			for(PropForRent prop : bucket){
				if (p.equals(prop)){
					return false;
				}//end if
			}//end for
			hashSet.get(hashCode % 16).add(p);
			insertOrder.add(p);
			return true;
		}//end else
	}//end method
	
	public boolean contains(PropForRent p){
		if (hashSet.get(p.hashCode() % 16) != null){
			LinkedList<PropForRent> bucket = hashSet.get(p.hashCode() % 16);
			for (PropForRent prop : bucket){
				if (p.equals(prop)){
					return true;
				}
			}
			return false;
		}else{//there is no property with that hashCode
			return false;
		}
	}
	
	public boolean remove(PropForRent p){
		if (hashSet.get(p.hashCode() % 16) != null){
			LinkedList<PropForRent> bucket = hashSet.get(p.hashCode() % 16);
			for (PropForRent prop : bucket){
				if (p.equals(prop)){
					hashSet.remove(p.hashCode() % 16);
					insertOrder.remove(p);
					return true;
				}
			}
			return false;
		}
		return false;
	}
	
	public Iterator iterator(){
		return insertOrder.iterator();
	}
	
	public boolean isEmpty(){
		for(LinkedList<PropForRent> bucket : hashSet){
			if (bucket != null){
				return false;
			}
		}
		return true;
	}
	
	public LinkedList<PropForRent> find(int hashCode){
		return hashSet.get(hashCode % 16);
	}
	

}
