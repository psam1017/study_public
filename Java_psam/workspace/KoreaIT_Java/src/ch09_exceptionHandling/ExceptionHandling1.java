package ch09_exceptionHandling;

public class ExceptionHandling1 {
	
//	Tip : F11 -> Debug / Ctrl + F11 -> Run
//	
//	에러 : 개발자가 조치할 수 없는 수준의 오류
//	예외 : 개발자가 조치할 수 있는 수준의 오류
//	
//	예외처리 : Exception 예외가 발생할 것을 대비하여 미리 예측해 이를 소스에서 제어하고 처리하도록 만드는 것
//	- 예외가 발생할 수 있음을 인식하는 것부터 시작.
//	- try ~ catch ~ finally
//		-> finally : 인터넷 연결, 파일 입출력 등에서 유용함. ExceptionHandling3, 4, 참고
//	
//	
//	
//	객체지향 언어인 JAVA는 예외도 객체로 다루어 처리한다.
//	- Throwable <- Exception <- ...
//		-> 모든 예외처리는 Exception을 상속하므로 Exception만으로도 예외처리가 가능하다.
//		-> 상속 및 다형성 활용이 가능하다.
//	
//	Exception의 주요 메소드 : getMessage(), toString(), printStackTrace()
//	
//	
//	
//	예외를 고의로 발생시키기 : throw Exception 인스턴스, 또는 throw 참조변수
//		-> ExceptionHandling6 참고.
//	
//	예외를 호출한 메소드 및 클래스로 넘기기 : 클래스 또는 메소드명 뒤에 throws Exception
//		-> ExceptionHandling7 참고.
//	
//	
//	
//	프로그램에서 예외가 발생한 경우 사용자가 어떻게 예외를 처리하기가 힘들다.
//	현실적으로, 예외가 발생하면 이를 기록(LOG)으로 남겨 개발자가 예외를 확인할 수 있어야 한다.
//		또한, 사용자에게는 예외 발생 메시지를 보이지 않는 것이 더 좋기 때문이기도 하다.
//		-> ExceptionLog1, 2 참고.
}
