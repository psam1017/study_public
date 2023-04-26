package ch07_inheritance;

public class Constructor1 {

	// 생성자는 인수로 초기값을 만들기 위해 사용한다.
	// 생성자는 리턴 타입이 없다.
	// 생성자를 만들지 않으면 컴파일러가 기본 생성자를 자동으로 만든다.
	// 하지만 매개변수 생성자를 만들면, 컴파일러는 기본 생성자를 만들어주지 않는다.
	// 따라서 매개변수 생성자와 기본 생성자를 둘 다 생성하려면, 직접 각각 만들어주어야 한다.
	
	// ★생성자는 상속되지 않는다. -> 업캐스팅에서도 차이가 발생
	// -> 자식 클래스에서 생성자를 만들지 않으면 오류 발생. 부모 클래스의 생성자를 바로 사용할 수 없음.
	
	
	
	// this : 해당 클래스를 가리키는 참조변수. 매개변수와 구분할 때 유용하다.
	// super : 부모 클래스를 가리키는 참조변수. 상속 받은 자식 클래스와 구분할 때, 부모 클래스를 호출할 때 등에 유용하다.
	
	//this.name = name;
	//-> 해당 클래스에서 만든 인스턴스 변수 name에 지역변수 name을 저장한다.
	
	//super.method();
	//-> 상위 클래스에서 만든 method 메소드를 실행한다.
	
	
	
	//public SportCar(String color, int speedLimit) {
	//	super(color);
	//	this.speedLimit = speedLimit;
	//}
	//-> 상위 클래스에서 이미 만든 매개변수 생성자(Stinrg color)를 실행하고, 나머지 인수를 인스턴스에 저장.
	
	//자식 클래스의 객체가 만들어지면, 자식 클래스의 생성자가 자동으로 실행이 되고, 그 이전에 부모 클래스의 생성자가 자동으로 실행한다.
	//부모 클래스의 생성자를 명시하지 않으면, 부모 클래스의 기본 생성자가 자동으로 실행된다. -> 기본 생성자가 없으면 오류가 발생한다.
	
}
