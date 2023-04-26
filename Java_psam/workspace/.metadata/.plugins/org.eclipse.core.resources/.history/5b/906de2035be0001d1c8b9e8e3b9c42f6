package test;

import encryptor.SimpleEncryptionDTO;
import encryptor.SimpleEncryptor;

public class Test01 {
	public static void main(String[] args) throws Exception {
		
		// dto를 이용한 암호화 및 인증
		
		// password와 salt를 전달하는 객체인 DTO가 기본으로 제공됩니다.
		// DTO는 getter만 사용할 수 있으며, setter가 필요한 경우 별도의 클래스를 만들어야 합니다.
		
		String password = "password";
		
		SimpleEncryptor encryptor = new SimpleEncryptor();

		SimpleEncryptionDTO dto = encryptor.encrypt(password);
		
		System.out.println("encrypted password : " + dto.getPassword());
		System.out.println("random salt : " + dto.getSalt());
		System.out.println("authentication success : " + encryptor.compare("password", dto));
		System.out.println("authentication fail : " + encryptor.compare("incorrect", dto));
		System.out.println("authentication by null : " + encryptor.compare(null, dto));
	}
}
