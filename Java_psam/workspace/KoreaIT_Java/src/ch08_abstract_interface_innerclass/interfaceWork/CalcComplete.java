package ch08_abstract_interface_innerclass.interfaceWork;

public class CalcComplete extends Calculator{

	@Override
	public int times(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public int divide(int num1, int num2) {
		if(num2 != 0)
			return num1 / num2;
		else
			return Calc.ERROR;
	}
	
	public void showInfo() {
		System.out.println("this extends Calculator implements Calc");
	}
	
}
