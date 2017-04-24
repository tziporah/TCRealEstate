package TCRealEstate;

import java.util.Iterator;

public class PropertyMain {

    public static void main(String[] args)
	{
		LinkedHashSet list = new LinkedHashSet();
		System.out.println("is empty? " + list.isEmpty());
		
		PropForRent prop1 = new PropForRent("11111", 0001, 5, 4, 500, 987.50, true, Condition.E, false);
		PropForRent prop2 = new PropForRent("11112", 0002, 7, 5, 1000, 1500.00, false, Condition.E, true);
		PropForRent prop3 = new PropForRent("11113", 0003, 8, 4, 600, 900.50, true, Condition.G, false);
		PropForRent prop4 = new PropForRent("11123", 0403, 8, 4, 600, 900.50, true, Condition.G, false);
		//System.out.println("Contains prop1? " + list.contains(prop1));
		list.add(prop1);
		list.add(prop2);
		list.add(prop3);
		list.add(prop4);
		System.out.println("Contains prop1? " + list.contains(prop1));
		System.out.println("remove prop1? " + list.remove(prop1));
		System.out.println("Contains prop1? " + list.contains(prop1));
		Iterator<PropForRent> iter = list.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}		
		System.out.println(list.find(2));
	}

}
