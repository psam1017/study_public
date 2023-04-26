package ch31_design_pattern.singleton;

public class Singleton02 {
	public static void main(String[] args) {
		
		MySingleton ms1 = MySingleton.getInstance();
		MySingleton ms2 = MySingleton.getInstance();
		
		System.out.println(ms1);
		System.out.println(ms2);
		
		ms1.setPage(10);
		
		System.out.println(ms1.getPage());
		System.out.println(ms2.getPage());
		
		ms1 = null;
		ms2 = null;
	}
}
