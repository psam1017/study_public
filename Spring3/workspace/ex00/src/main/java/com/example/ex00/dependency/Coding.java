package com.example.ex00.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@Data
@Getter
@RequiredArgsConstructor
public class Coding {
	// 코딩을 하기 위해서는 Computer가 필요하다.
	// Computer computer = new Computer(); // 의존 관계가 너무 단단해진다!
	
	// 1. 필드 주입
	// 1) 굉장히 편하게 주입할 수 있으나 순환 참조(서로가 서로를 참조하여 무한 루프) 시 오류가 발생하지 않기 때문에 Stack Overflow가 발생할 수 있다.
	// 2) private으로 선언한다.
	// 3) final은 붙이지 않기 때문에 다른 곳에서 변형할 수 있다.
	// 단, @Data 선언을 하면 생성자가 자동으로 만들어지기 때문에 오류가 나지 않는다. -> 이렇게 되면 유연성이 떨어진다.
	// -> 간단한 테스트, 특히 단위 테스트를 할 때 종종 쓴다.
	
	// ★Null Pointer Exception 오류가 안 생긴다. -> Stack Overflow가 생길 수 있다.
	// ★final을 사용할 수 없다.
	// @Autowired
	// private Computer computer;
	
	
	
	// 2. Setter 주입
	// 필드 주입과 거의 유사한 특징을 가진다.
	// 1) Stack Overflow 발생 가능
	// 2) final 사용 불가능
	// 3) setter는 public이기 때문에 외부에서 직접 주입이 가능하다.
	// 기존에 주입 받았던 객체를 변경해야 할 때 사용하는데
	//     -> 그런 상황이 잘 오지 않는다.
	//     -> setter를 대체할 수 있는 것들이 많다.
	// -> 잘 쓰이지 않는다.
	
	// private Computer computer;
	// 
	// @Autowired
	// public void setComputer(Computer computer) {
	// 	this.computer = computer;
	// }
	

	
	// 3. ★생성자 주입
	// -> 메모리에 올리면서 주입받는다. Null Pointer Exception이 발생할 수 있다.
	// 순환 참조 시 컴파일러가 인지할 수 있기 때문에 Null Pointer Exception이 발생할 수 있다. -> 순환 참조를 막을 수 있다.
	// 메모리에 할당하면서 초기값으로 주입되므로 final 키워드를 사용할 수 있다.
	// 그리고 다른 곳에서는 변형할 수 없다. -> 객체를 안전하게 지킬 수 있다.
	// -> 주로 사용한다. 근데 내가 직접 만들지는 않고, annotation으로 만든다.
	// 
	// private final Computer computer;
	// 
	// @Autowired
	// public Coding(Computer computer) {
	// 	super();
	// 	this.computer = computer;
	// }
	
	
	
	// ★결론
	// 1. 모든 필드로 생성자를 만들 때, class 위에서 @AllArgsConstructor를 선언한다.
	// 2. 필요한 필드로 생성자를 만들 때, class 위에서 @RequireArgsConstructor를 선언한다.
	//     -> final 키워드로 선언하거나 @NonNull에 대하여 생성자를 만들어준다.
	// -> 앞으로는 @RequireArgsConstructor와 final 키워드를 자주 사용할 것이다.
	
	@Autowired
	private final Computer computer;
	
	@NonNull
	private Computer another;
}
