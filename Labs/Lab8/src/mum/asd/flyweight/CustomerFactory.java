package mum.asd.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CustomerFactory {

	private static Map<String, Customer> list = new HashMap<>();
	static {
		list.put("SR", new Customer("SR"));
		list.put("PP", new Customer("PP"));
		list.put("MK", new Customer("MK"));
	}
	
	
	private CustomerFactory() {
	}
	
	
	
	public static Customer getInstance(String location) {
		if(list.containsKey(location)) {
			return list.get(location);
		}
		return null;
	}
}
