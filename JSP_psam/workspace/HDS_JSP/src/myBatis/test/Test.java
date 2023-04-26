package myBatis.test;

import myBatis.memberDAO.MemberDAO;
import myBatis.memberVO.MemberVO;

public class Test {
	public static void main(String[] args) {
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		vo.setId("psm1234");
		vo.setPw("1234");
		vo.setName("박성민");
		vo.setAge(20);
		
		// 오류가 발생해서, google에서 jdbc url이라고 검색하여 경로를 해결하였음.
		if(!dao.checkId(vo.getId())) {
			dao.join(vo);
			System.out.println("가입 성공");
		}
		
		if(dao.login("psm1234", "1234")) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 실패");
		}
		
		System.out.println(dao.findId("박성민", "1234"));
		
		// 질의 결과가 여러 줄일 때, list에 행 수만큼 add를 수행한다.
		// list에 담긴 결과들을 하나씩 꺼내기 위해 람다식을 사용했다.
		dao.findMember().forEach(member -> {
			System.out.print(member.getId() + ", ");
			System.out.print(member.getPw() + ", ");
			System.out.print(member.getName() + ", ");
			System.out.println(member.getAge());
		});
		
		vo.setName("홍길동");
		vo.setAge(25);
		
		if(dao.update(vo)) {
			System.out.println("수정 성공");
		}
		System.out.println(dao.findId("박성민", "1234"));
		
		if(dao.delete(vo.getId())) {
			System.out.println("삭제 성공");
		}
	}
}
