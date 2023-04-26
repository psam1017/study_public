package ch08_abstract_interface_innerclass.interfaceWork;

public class Interface3 {
	public static void main(String[] args) {
		
		int num1 = 10, num2 = 5;
		
		CalcComplete calc = new CalcComplete();
		
		System.out.println(calc.add(num1, num2));
		System.out.println(calc.substract(num1, num2));
		System.out.println(calc.times(num1, num2));
		System.out.println(calc.divide(num1, num2));
		calc.showInfo();
		
		System.out.print("\n\n\n");
		
		CalcUpComplete calcUp = new CalcUpComplete();
		int[] arr = {1, 2, 3, 4, 5};
		
		calcUp.description();
		System.out.println(CalcUp.total(arr));
	}
}
