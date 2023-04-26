package ch12_collection.generics;

public class Generics03 {
	public static void main(String[] args) {
		
		System.out.println(GetMethod.<Integer, String>compare(1, "값", 1, "값"));
	}
}

class GetMethod{
	
	// public static generic method
	public static <K, V> boolean compare(K key1, V value1, K key2, V value2){
		
		if(key1.equals(key2) && value1.equals(value2))
			return true;
		
		return false;	
	}
}