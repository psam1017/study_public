package ch08_abstract_interface_innerclass.abstractWork;

public abstract class Car {
	String name = null;
	
	void run() {
		start();
		drive();
		stop();
		end();
	};
	
	abstract void start();
	abstract void drive();
	abstract void stop();
	abstract void end();
}

class Sonata extends Car{
	Sonata() { this.name = "Sonata"; }

	void start() { System.out.println(name + " 시동을 켭니다.");	}
	void drive() { System.out.println(name + " 달립니다.");	}
	void stop() { System.out.println(name + " 멈춥니다."); }
	void end() { System.out.println(name + " 시동을 끕니다."); }
}

class Granduer extends Car{
	Granduer() { this.name = "Granduer"; }
	
	void start() { System.out.println(name + " 시동을 켭니다.");	}
	void drive() { System.out.println(name + " 달립니다.");	}
	void stop() { System.out.println(name + " 멈춥니다."); }
	void end() { System.out.println(name + " 시동을 끕니다."); }
}

class Avante extends Car{
	Avante() { this.name = "Avante"; }
	
	void start() { System.out.println(name + " 시동을 켭니다.");	}
	void drive() { System.out.println(name + " 달립니다.");	}
	void stop() { System.out.println(name + " 멈춥니다."); }
	void end() { System.out.println(name + " 시동을 끕니다."); }
}

class Genesis extends Car{
	Genesis() { this.name = "Genesis"; }
	
	void start() { System.out.println(name + " 시동을 켭니다.");	}
	void drive() { System.out.println(name + " 달립니다.");	}
	void stop() { System.out.println(name + " 멈춥니다."); }
	void end() { System.out.println(name + " 시동을 끕니다."); }
}
