package ch08_abstract_interface_innerclass.innerClassWork;

public class AnonymousClass3 {
	public static void main(String[] args) {
		
		Anony3 anony = new Anony3();
		
		anony.p.wake();
		anony.method1();
		// 객체를 생성하는 시점에서 오버라이딩
		// study를 추가한 익명 자식 클래스
		anony.method2(new Person(){
			void study() {
				System.out.println("method2 : 학생은 공부");
			}
			
			@Override
			void wake() {
				System.out.println("method2 : 10시에 기상");
				study();
			}
		});

	}
}

// 기존의 클래스
class Person{
	void wake() {
		System.out.println("Origin Person : 8시에 기상");
	}
}

class Anony3{
	
	// 기존의 클래스를 인스턴스 클래스로 생성하면서 오버라이딩
	// work를 추가한 익명 자식 클래스(extends나 implements를 하지 않아도 상속 및 구현한 것으로 취급함)
	Person p = new Person() {
		void work(){
			System.out.println("Anony Person : 열심히 일하는 중");
		}

		@Override
		void wake() {
			System.out.println("Anony Person : 7시 55분에 기상");
			work();
		}
	};
	
	// 기존의 클래스를 지역 클래스로 생성하면서 오버라이딩
	// walk를 추가한 익명 자식 클래스
	void method1() {
		Person localVar = new Person() {
			void walk() {
				System.out.println("method1 : 걸어서 출근");
			}

			@Override
			void wake() {
				System.out.println("method1 : 7시 50분에 기상");
				walk();
			}
		};
		localVar.wake();
	}
	
	// 기존의 클래스 오버라이딩을 생성하는 시점으로 미룸.
	void method2(Person p) {
		p.wake();
	}
}