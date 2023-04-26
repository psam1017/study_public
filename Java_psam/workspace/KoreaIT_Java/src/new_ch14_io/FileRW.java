package new_ch14_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRW {
	
	public static String fileName = "filerw.txt";
	public static String fileSrc = ".\\sample_file\\" + fileName;
	
	public static void main(String[] args) throws IOException{
		
		Writer writer = new Writer();
		Reader reader = new Reader();
		reader.askRead();;
		writer.start();
	}
}

class Writer extends Thread{
	
	private boolean isAppend = true;
	
	public void askAppend() {
		
		String input = JOptionPane.showInputDialog("새로 덮어쓰시겠습니까? 이전 내용은 복구할 수 없습니다.\nyes -> 1");
		if(input == null) {
			;
		}
		else if(input.equals("1")) {
			isAppend = !isAppend;
			System.out.println("--------------------------------------");
			System.out.println("새로운 내용으로 덮어쓰기를 시작합니다.");
			System.out.println("--------------------------------------");
		}
	}
	
	public void run() {
		
		askAppend();
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(FileRW.fileSrc, isAppend);
			BufferedWriter bw = new BufferedWriter(fw);
			
			while(true) {
				String input = JOptionPane.showInputDialog(
						"입력하신 내용이 " + FileRW.fileName + "로 전달됩니다.\n종료하려면 '취소'를 누르세요.");
				if(input != null) {
					char[] chs = input.toCharArray();
					
					for(int i = 0; i < chs.length; i++) {
						char c = chs[i];
						bw.write(c);;
						System.out.print(c);
					}
					
					bw.write("\n");
					System.out.println();
				}
				else if(input == null) {
					bw.close();
					break;
				}
			}
		} catch(FileNotFoundException e) {
			System.out.println("해당 경로에서 파일을 찾지 못 했습니다.");
		} catch(IOException e) {
			System.out.println("IOExceoption이 발생했습니다.");
		}
	}
}

class Reader{
	
	public void askRead() {
		String input = JOptionPane.showInputDialog("지금까지의 내용을 읽으시겠습니까?\nyes -> 1");
		if(input == null) {}
		else if(input.equals("1")) {
			
			FileReader fr = null;
			
			try {
				fr = new FileReader(FileRW.fileSrc);
				BufferedReader br = new BufferedReader(fr);
				
				int data = 0;
				while((data = br.read()) != -1) {
					char c = (char)data;
					System.out.print(c);
				}
				br.close();
			} catch (FileNotFoundException e) {
				System.out.println("해당 경로에서 파일을 찾지 못 했습니다.");
			} catch(IOException e) {
				System.out.println("IOExceoption이 발생했습니다.");
			}
		}
	}
}
