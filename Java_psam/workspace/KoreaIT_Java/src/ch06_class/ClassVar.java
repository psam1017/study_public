package ch06_class;

public class ClassVar {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		// �޸� ���� : �ڵ� ����, ������ ����, ���� ����, �� ����
		// ������ ���� : ���� ������ ���� ����(static) ����.
		// ���� ���� : ���� ������ ����.
		// �� ���� : �ν��Ͻ��� �迭�� ����.
		
		
		
		// Ŭ���� ���� : ��� �ν��Ͻ��� �������� �����ϴ� ����. (ex) ���� �б�, ����Ʈ ���� ����
		// -> ó�� �޸𸮿� �ε��� �� �����ȴ�. ���� ������ �ν��Ͻ��� �������� �ʾƵ� ����� �� �ִ�.
		// -> Ŭ���� ������ �ν��Ͻ��� ���� �����ϴ� ���� �ٶ������� �ʴ�.
		// static �ڷ��� ������;
		
		// �ν��Ͻ� ������ �� �ν��Ͻ��� ���� �ٸ��� ������ �����̴�.
		
		Cars myCar1 = new Cars();
		Cars myCar2 = new Cars();
		
		System.out.println("myCar1�� ���� : " + myCar1.wheel);
		System.out.println("myCar1�� �ӵ� : " + myCar1.speed);
		System.out.println("myCar2�� ���� : " + myCar2.wheel);
		System.out.println("myCar2�� �ӵ� : " + myCar2.speed);

		
		
		// �ν��Ͻ��� ���ؼ� Ŭ���� ������ �ν��Ͻ��� ����
		myCar1.wheel = 6;
		myCar1.speed = 40;
				
		System.out.println("myCar1�� ���� : " + myCar1.wheel);
		System.out.println("myCar1�� �ӵ� : " + myCar1.speed);
		System.out.println("myCar2�� ���� : " + myCar2.wheel);
		System.out.println("myCar2�� �ӵ� : " + myCar2.speed);
	}
}

class Cars{
	static int wheel = 4;
	int speed;
}