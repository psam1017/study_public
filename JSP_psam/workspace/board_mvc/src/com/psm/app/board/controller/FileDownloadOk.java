package com.psm.app.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psm.app.action.Action;
import com.psm.app.action.ActionForward;

public class FileDownloadOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String saveFoler = "C:\\Users\\HP\\Desktop\\Coding\\JSP_psam\\workspace\\board_mvc\\WebContent\\app\\upload";
		String fileName = req.getParameter("fileName");
		ActionForward forward;
		
		InputStream in = null;
		OutputStream out = null;
		File file = null;
		boolean check = true;

		try {
			// 파일 디렉토리, 첫 번째 인자의 하위 디렉토리
			file = new File(saveFoler, fileName);
			in = new FileInputStream(file);
		} catch (Exception e) {
			check = false;
			System.out.println("파일 접근에서 문제 발생" + e);
		}
		
		resp.setContentType("application/ocatat-stream"); // 파일 다운로드를 위한 전송 데이터 타입 설정
		resp.setHeader("Content-Description", "JSP Generated Data"); // 헤더에 담을 데이터의 내용 설명 수정
		
		if(check) {
			try {
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
				resp.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
				resp.setHeader("Content-Type", "application/ocatat-stream;charset=UTF-8");
				resp.setHeader("Content-length", "" + file.length());
				
				out = resp.getOutputStream();
				byte[] b = new byte[(int)(file.length())];
				int data = 0;
				
				while((data = in.read(b)) > 0) {
					out.write(b, 0, data);
				}
			} catch (Exception e) {
				System.out.println("파일 접근 후 가져올 때 문제 발생" + e);
			} finally {
				try {
					if(in != null) {
						in.close();
					}
					if(out != null) {
						out.close();
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				
			}
		}
		
		return null;
	}

}
