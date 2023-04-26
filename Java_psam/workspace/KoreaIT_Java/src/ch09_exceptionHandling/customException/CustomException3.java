package ch09_exceptionHandling.customException;

public class CustomException3 {
	public static void main(String[] args) {
		
		MyScore ms = new MyScore();
		
		try {
			ms.setScore(-10);
		}
		catch(MyException me) {
			System.out.println(me.getMessage());
		}
	}
}

@SuppressWarnings("serial")
class MyException extends Exception{
	
	public MyException(String msg) { super(msg); }
}

class MyScore{
	
	private int score;
	
	public void setScore(int s) throws MyException{
		
		if(s < 0)
			throw new MyException("점수는 음수가 될 수 없습니다.");
		else {
			this.score = s;
			System.out.println(this.score);
		}
	}
}