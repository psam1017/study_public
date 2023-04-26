package summerNote;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload")
public class UploadSummernoteImageFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doProcess(request, response);
	}
	
	@SuppressWarnings("unchecked")
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		// cos, json-simple jar 필요
		
		JSONObject json = new JSONObject();
		
		// multipart config
		String contextRoot = req.getSession().getServletContext().getRealPath("/");
		String fileRoot = contextRoot + "upload\\";
		int fileSize = 1024 * 1024 * 5;
		String encoding = "UTF-8";
		System.out.println(fileRoot);
		
		MultipartRequest multi = new MultipartRequest(req, fileRoot, fileSize, encoding, new DefaultFileRenamePolicy());
		
		Enumeration<String> upload = multi.getFileNames();
		
		if(upload.hasMoreElements()) {
			// 사용자가 업로드한 파일 태그의 name
			String name = upload.nextElement();
			
			// 중복 시 변경된 이름
			String systemName = multi.getFilesystemName(name);
			
			// 저장한 파일 이름을 vo에 set하고 db에 접근하여 저장하는 로직
			System.out.println(fileRoot + systemName);
			
			if(systemName != null) {
				json.put("url", "/SummernoteTest/upload/" + systemName);
				json.put("responseCode", "success");
			}
			else {
				json.put("responseCode", "error");
			}
		}
		else {
			json.put("responseCode", "error");
		}
		
		PrintWriter out = resp.getWriter();
		out.print(json.toJSONString());
		out.close();
	}
}
