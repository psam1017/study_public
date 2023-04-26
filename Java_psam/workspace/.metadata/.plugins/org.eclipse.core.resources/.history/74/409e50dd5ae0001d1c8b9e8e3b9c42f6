package encryptor;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class SimpleEncryptor {

	int iterator = 10000;

	/**
	 * 이 클래스는 사용자가 입력한 패스워드를 암호화하고, 솔트를 생성하고, 저장된 데이터와 비교할 수 있습니다.<p>
	 * 기본 iterator는 10,000으로 지정되어 있으며, 변경할 수 있습니다.
	 */
	public SimpleEncryptor() { ; }
	
	/**
	 * 이 클래스는 사용자가 입력한 패스워드를 암호화하고, 솔트를 생성하고, 저장된 데이터와 비교할 수 있습니다.<p>
	 * 기본 iterator는 10,000으로 지정되어 있으며, 변경할 수 있습니다. 간소한 목적으로 사용하는 경우 1,000 이상이 권장됩니다.
	 */
	public SimpleEncryptor(int iterator) {
		this.iterator = iterator;
	}
	
	/**
	 * DTO를 사용하는 암호화입니다. 암호화된 password와 salt가 dto 타입의 객체 안에 담겨 반환됩니다.
	 * @param inserted : 사용자가 최초로 입력한 비밀번호입니다. 즉, 회원가입할 때 입력한 비밀번호입니다.
	 * @return EncryptionDTO
	 */
	public SimpleEncryptionDTO encrypt(String inserted) {
		
		SimpleEncryptionDTO info = new SimpleEncryptionDTO();
		
		String salt = generateSalt();
		String password = encryptPassword(inserted, salt);
		
		info.setSalt(salt);
		info.setPassword(password);
		
		return info;
	}
	
	/**
	 * DTO를 사용하지 않고 랜덤한 salt값만을 16진수로 표현된 32글자의 String으로 반환합니다.<br>
	 * 이 값을 encryptPassword에 전달하여 password를 암호화하십시오.
	 * @return String
	 */
	public String generateSalt(){
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return bytesToHex(salt);
	}
	
	/**
	 * DTO를 사용하지 않고 salt를 첨가하여 password를 암호화합니다. 이 값을 salt와 함께 DB에 저장하십시오.<br>
	 * @param password : 사용자가 최초로 입력한 비밀번호입니다. 즉, 회원가입할 때 입력한 비밀번호입니다.
	 * @param salt : 서버에서 생성한 난수입니다. generateSalt() 메소드를 사용하여 난수를 생성하십시오.
	 * @return String
	 */
	public String encryptPassword(String password, String salt){
		try {
			KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), iterator, 128);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] encrypted = factory.generateSecret(spec).getEncoded();
			return bytesToHex(encrypted);
		}
		catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			throw new RuntimeException("암호화를 하기 위한 라이브러리가 존재하지 않습니다.");
		}
	}
	
	/**
	 * DTO를 사용하지 않고 입력 받은 비밀번호와 저장된 비밀번호, 솔트를 비교합니다. DB에서 가져온 비밀번호와 솔트를 함께 사용하십시오.
	 * @param inserted : 사용자가 인증을 위해 입력한 비밀번호입니다. 즉, 로그인할 때 입력한 비밀번호입니다.
	 * @param stored : DB에 저장된 비밀번호입니다.
	 * @param salt : DB에 저장된 솔트입니다.
	 * @return boolean
	 * @see 만약 값 중에 null이 있다면 false를 반환할 것입니다.
	 */
	public boolean compare(String inserted, String stored, String salt){
		try {
			KeySpec spec = new PBEKeySpec(inserted.toCharArray(), salt.getBytes(), iterator, 128);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] encrypted = factory.generateSecret(spec).getEncoded();
			String password = bytesToHex(encrypted);
			return password.equals(stored);
		}
		catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			throw new RuntimeException("암호화를 하기 위한 라이브러리가 존재하지 않습니다.");
		}
		catch(NullPointerException e) {
			return false;
		}
	}
	
	/**
	 * DTO를 사용하여 입력 받은 비밀번호와 비교합니다. DB에서 비밀번호와 솔트를 DTO로 가져왔다면 이 메소드를 사용하십시오.
	 * @param inserted : 사용자가 인증을 위해 입력한 비밀번호입니다. 즉, 로그인할 때 입력한 비밀번호입니다.
	 * @param info : DB에서 가져온 비밀번호와 솔트를 가지고 있는 DTO입니다.
	 * @return boolean
	 * @see 만약 값 중에 null이 있다면 false를 반환할 것입니다.
	 */
	public boolean compare(String inserted, SimpleEncryptionDTO info){
		try {
			KeySpec spec = new PBEKeySpec(inserted.toCharArray(), info.getSalt().getBytes(), iterator, 128);
			SecretKeyFactory factory;
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] encrypted;
			encrypted = factory.generateSecret(spec).getEncoded();
			String password = bytesToHex(encrypted);
			return password.equals(info.getPassword());
		}
		catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			throw new RuntimeException("암호화를 하기 위한 라이브러리가 존재하지 않습니다.");
		}
		catch(NullPointerException e) {
			return false;
		}
	}
	
  final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
  
  private static String bytesToHex(byte[] bytes) {
  	char[] hexChars = new char[bytes.length * 2];
  	for (int j = 0; j < bytes.length; j++) {
  		int v = bytes[j] & 0xFF;
  		hexChars[j * 2] = hexArray[v >>> 4];
  		hexChars[j * 2 + 1] = hexArray[v & 0x0F];
  	}
  	return new String(hexChars);
  }
}
