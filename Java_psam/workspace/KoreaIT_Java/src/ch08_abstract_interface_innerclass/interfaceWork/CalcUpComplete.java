package ch08_abstract_interface_innerclass.interfaceWork;

public class CalcUpComplete implements CalcUp {

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1 - num2;
	}

	@Override
	public int times(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public int divide(int num1, int num2) {
		if(num2 != 0)
			return num1 / num2;
		else {
			System.out.println("0으로 나눌 수 없습니다.");
			return ERROR;
		}
	}
}
