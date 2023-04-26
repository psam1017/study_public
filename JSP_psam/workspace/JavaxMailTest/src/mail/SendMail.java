package mail;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static void main(String[] args) {

			// 이메일 전송 정보. ★hostEmail은 SMTP 설정이 되어 있어야 함.
			// hostEmail과 password는 listener로 서블릿 초기화할 때 저장한 객체의 값을 사용
			String memberEmail = "qkrtjdals960@naver.com";
			String host = "mw-002.cafe24.com";
			String hostEmail = "noreply@ggomsu.com";
			String password = "비밀번호";
			int port = 587; // cafe24 보내는 메일 서버. 465와 props 설정이 달라짐에 주의.
			
			// 이메일 인증 키 생성. 작성할 제목 및 내용과 함께 저장
			String emailSubject = "꼼수닷컴 인증번호입니다";
			String authKey = String.valueOf(new Random().nextInt(888888) + 111111);
			String emailContent = "html태그로 이메일 작성" + authKey;
			
			// 이메일 전송를 prpoerty로 저장
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.ssl.trust", "true");
			props.put("mail.debug", "true");
			
			// 이메일 전송 세션 생성
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(hostEmail, password);
				}
			});
			System.out.println("실행");
			// 이메일 전송
			MimeMessage msg = new MimeMessage(session);
			
			try {
				msg.setFrom(new InternetAddress(hostEmail, "꼼수닷컴"));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(memberEmail));
				
				msg.setSubject(emailSubject);
				msg.setContent(emailContent, "text/html; charset=UTF-8;");
				
				Transport.send(msg);
				
				// 성공. 세션에 인증키를 저장 후 사용자가 인증키를 올바르게 입력했는지 비교
				System.out.println("성공");
			} catch (Exception e) { // 인코딩 문제로 실패
				System.out.println("실패");
				e.printStackTrace();
			}
			
		}
}
