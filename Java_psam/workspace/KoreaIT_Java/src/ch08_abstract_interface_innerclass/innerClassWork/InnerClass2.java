package ch08_abstract_interface_innerclass.innerClassWork;

public class InnerClass2 {
	
	class InstanceInner{}
	static class StaticInner{}
	
	InstanceInner ii1 = new InstanceInner();
	StaticInner st1 = new StaticInner();
	
	// 스태틱 멤버는 인스턴스 클래스에 접근 불가. 내부 스태틱 클래스에 접근 가능.
	@SuppressWarnings("unused")
	static void StaticMethod() {
		StaticInner st2 = new StaticInner();
//		InstanceInner ii2 = new InstanceInner();
	}
	
	// 인스턴스 멤버는 모두 접근 가능. 아래의 메소드를 실행한다는 것은 즉 InnerClass2의 인스턴스가 만들어졌다는 뜻.
	@SuppressWarnings("unused")
	void instanceMethod() {
		StaticInner st3 = new StaticInner();
		InstanceInner ii3 = new InstanceInner();
	}
}
