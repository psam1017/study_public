package ch08_abstract_interface_innerclass.interfaceWork;

public interface Calc {
	
	// public static final이 생략됨.
	double PI = 3.14;
	int ERROR = -999999999;
	
	int add(int num1, int num2);
	int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
}
