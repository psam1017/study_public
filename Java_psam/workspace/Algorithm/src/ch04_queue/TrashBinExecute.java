package ch04_queue;

public class TrashBinExecute {
	public static void main(String[] args) {
		
		// ring buffer는 휴지통과 같이 오래된 데이터를 버리는 용도의 프로그램에 적합하다.
		
		TrashBin<String> bin = new TrashBin<>(5);
		
		bin.put("시안1");
		bin.put("시안2");
		bin.put("시안3");
		bin.put("시안_최종");
		
		System.out.println("\n=====파일 4개를 버렸습니다.=====\n");
		bin.show();
		
		bin.put("시안_최종2");
		bin.put("시안_진짜_최종");
		bin.put("시안_final");
		
		System.out.println("\n=====파일 3개를 더 버렸습니다.=====\n");
		bin.show();
		
		System.out.println("\n=====파일 '시안_final'을 복구합니다.=====\n");
		System.out.println("복구 결과 : " + bin.restore(1));
		
		System.out.println("\n=====휴지통을 비웁니다.=====\n");
		bin.clear();
		
		System.out.println("\n=====휴지통 청소 결과=====\n");
		bin.show();
	}
}
