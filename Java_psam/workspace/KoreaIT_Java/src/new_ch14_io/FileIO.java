package new_ch14_io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {
	public static void main(String[] args) throws IOException{
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		fis = new FileInputStream(".\\sample_file\\fis.txt");
		fos = new FileOutputStream(".\\sample_file\\fos.txt");
		
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int data = 0;
		while((data = bis.read()) != -1) { // read 메소드에 인자 값으로 읽을 길이를 지정할 수도 있다. ex -> bis.read(new byte[10])
			char c = (char)data;
			System.out.print(c);
			bos.write(c);
		}

		bis.close();
		bos.close();
	}
}
