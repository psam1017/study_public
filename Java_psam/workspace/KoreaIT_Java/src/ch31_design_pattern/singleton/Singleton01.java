package ch31_design_pattern.singleton;

public class Singleton01 {
	public static void main(String[] args) {
		
		Company c1 = Company.getInstance();
		Company c2 = Company.getInstance();
		
		System.out.println(c1 == c2); // 같은 객체라면 true
	}
}
