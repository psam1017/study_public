/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2022-12-28 14:55:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1670410614250L));
    _jspx_dependants.put("jar:file:/C:/Users/HP/Desktop/Coding/Spring3_psam/workspace/board/src/main/webapp/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098678690000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<title>Board</title>\r\n");
      out.write("	<meta charset=\"utf-8\" />\r\n");
      out.write("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"/resources/assets/css/main.css\" />\r\n");
      out.write("	<style>\r\n");
      out.write("		body {transform: scale(0.8); margin-top: -50px;}\r\n");
      out.write("		.uploadResult{\r\n");
      out.write("			width: 100%\r\n");
      out.write("		}\r\n");
      out.write("		.uploadResult ul{\r\n");
      out.write("			display: flex;\r\n");
      out.write("			justify-content: center;\r\n");
      out.write("		}\r\n");
      out.write("		.uploadResult ul li{\r\n");
      out.write("			list-style: none;\r\n");
      out.write("		}\r\n");
      out.write("	</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"is-preload\">\r\n");
      out.write("	<!-- Main -->\r\n");
      out.write("	<div id=\"main\">\r\n");
      out.write("		<div class=\"wrapper\">\r\n");
      out.write("			<div class=\"inner\">\r\n");
      out.write("\r\n");
      out.write("				<!-- Elements -->\r\n");
      out.write("				<header class=\"major\">\r\n");
      out.write("					<h1>Board</h1>\r\n");
      out.write("					<p>게시글 등록</p>\r\n");
      out.write("				</header>\r\n");
      out.write("				<!-- Table -->\r\n");
      out.write("				<h3><a href=\"/board/list\" class=\"button small\">목록 보기</a></h3>\r\n");
      out.write("				<div class=\"content\">\r\n");
      out.write("					<div class=\"form\">\r\n");
      out.write("						<form method=\"post\" action=\"#\" id=\"registForm\" name=\"registForm\" enctype=\"multipart/form-data\">\r\n");
      out.write("							<div class=\"fields\">\r\n");
      out.write("								<div class=\"field\">\r\n");
      out.write("									<h4>제목</h4>\r\n");
      out.write("									<input name=\"title\" placeholder=\"Title\" type=\"text\" />\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"field\">\r\n");
      out.write("									<h4>내용</h4>\r\n");
      out.write("									<textarea name=\"content\" rows=\"6\" placeholder=\"Content\" style=\"resize:none\"></textarea>\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"field\">\r\n");
      out.write("									<h4>작성자</h4>\r\n");
      out.write("									<input name=\"writer\" placeholder=\"Writer\" type=\"text\" />\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"field\">\r\n");
      out.write("									<h4>첨부파일</h4>\r\n");
      out.write("									<input name=\"multipartFiles\" type=\"file\" multiple/>\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"field\">\r\n");
      out.write("									<div class=\"uploadResult\">\r\n");
      out.write("										<ul></ul>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<ul class=\"actions special\">\r\n");
      out.write("								<li><input type=\"submit\" class=\"button\" value=\"등록\" /></li>\r\n");
      out.write("							</ul>\r\n");
      out.write("						</form>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div> \r\n");
      out.write("</body>\r\n");
      out.write("<!-- Scripts -->\r\n");
      out.write("<script src=\"/resources/assets/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"/resources/assets/js/jquery.dropotron.min.js\"></script>\r\n");
      out.write("<script src=\"/resources/assets/js/browser.min.js\"></script>\r\n");
      out.write("<script src=\"/resources/assets/js/breakpoints.min.js\"></script>\r\n");
      out.write("<script src=\"/resources/assets/js/util.js\"></script>\r\n");
      out.write("<script src=\"/resources/assets/js/main.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("	$(document).ready(function(e){\r\n");
      out.write("		let uploadResult = $(\".uploadResult ul\");\r\n");
      out.write("		let regex = new RegExp(\"(.*/)\\.(exe|sh|zip|alz)$\");\r\n");
      out.write("		let maxSize = 1024 * 1024 * 20;\r\n");
      out.write("		\r\n");
      out.write("		function showUploadResult(files){\r\n");
      out.write("			let str = \"\";\r\n");
      out.write("			$(files).each(function(i, file){\r\n");
      out.write("				let fileName = \"\";\r\n");
      out.write("				if(!file.fileType){\r\n");
      out.write("					fileName = \"attach.png\";\r\n");
      out.write("				}\r\n");
      out.write("				else{\r\n");
      out.write("					fileName = encodeURIComponent(file.uploadPath + \"/t_\" + file.uuid + \"_\" + file.fileName);\r\n");
      out.write("				}\r\n");
      out.write("					str += \"<li data-filename='\" + file.fileName + \"' data-uuid='\" + file.uuid + \"' data-uploadpath='\" + file.uploadPath + \"' data-filetype='\" + file.fileType + \"'>\";\r\n");
      out.write("					str += \"<div>\";\r\n");
      out.write("					str += \"<img src='/display?fileName=\" + fileName + \"' width='100'>\";\r\n");
      out.write("					str += \"</div>\";\r\n");
      out.write("					str += \"<span>\" + file.fileName + \"</span>\";\r\n");
      out.write("					str += \"</li>\";\r\n");
      out.write("			});\r\n");
      out.write("			uploadResult.append(str);\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		$(\"input[type='file']\").change(function(e){\r\n");
      out.write("			$(\".uploadResult ul li\").remove();\r\n");
      out.write("			let formData = new FormData();\r\n");
      out.write("			let $inputFile = $(this);\r\n");
      out.write("			let files = $inputFile[0].files;\r\n");
      out.write("			\r\n");
      out.write("			for(let i = 0; i < files.length; i++){\r\n");
      out.write("				if(!checkExtension(files[i].name, files[i].size)){\r\n");
      out.write("					return false;\r\n");
      out.write("				}\r\n");
      out.write("				formData.append(\"multipartFiles\", files[i]);\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url : \"/upload\",\r\n");
      out.write("				processData : false,\r\n");
      out.write("				contentType : false,\r\n");
      out.write("				data : formData,\r\n");
      out.write("				type : \"post\",\r\n");
      out.write("				dataType : \"json\",\r\n");
      out.write("				success : function(result){\r\n");
      out.write("					console.log(result);\r\n");
      out.write("					showUploadResult(result);\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		$(\"input[type='submit']\").on(\"click\", function(e){\r\n");
      out.write("			e.preventDefault();\r\n");
      out.write("			let $form = $(\"form[name='registForm']\");\r\n");
      out.write("			let str = \"\";\r\n");
      out.write("			$(\".uploadResult ul li\").each(function(i, li){\r\n");
      out.write("				str += \"<input type='hidden' name='files[\" + i + \"].uuid' value='\" + $(li).data(\"uuid\") + \"'>\";\r\n");
      out.write("				str += \"<input type='hidden' name='files[\" + i + \"].uploadPath' value='\" + $(li).data(\"uploadpath\") + \"'>\";\r\n");
      out.write("				str += \"<input type='hidden' name='files[\" + i + \"].fileName' value='\" + $(li).data(\"filename\") + \"'>\";\r\n");
      out.write("				str += \"<input type='hidden' name='files[\" + i + \"].fileType' value='\" + ($(li).data(\"filetype\") || false) + \"'>\";\r\n");
      out.write("			});\r\n");
      out.write("			$form.append(str).submit();\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		function checkExtension(fileName, fileSize){\r\n");
      out.write("			if(regex.test(fileName)){\r\n");
      out.write("				alert(\"업로드할 수 없는 형식의 파일입니다.\");\r\n");
      out.write("				return false;\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			if(fileSize >= maxSize){\r\n");
      out.write("				alert(\"파일 용량이 초과되었습니다.\");\r\n");
      out.write("				return false;\r\n");
      out.write("			}\r\n");
      out.write("			return true;\r\n");
      out.write("		}\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
