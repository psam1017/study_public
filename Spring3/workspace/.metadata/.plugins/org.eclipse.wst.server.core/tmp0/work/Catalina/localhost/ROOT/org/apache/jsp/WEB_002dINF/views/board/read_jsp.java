/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2022-12-28 15:28:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class read_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
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
      out.write("		div.line{border-bottom: 1px solid black;}\r\n");
      out.write("		h4.reply-h4{margin-bottom: 0px;}\r\n");
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
      out.write("					<p>게시글 상세보기</p>\r\n");
      out.write("				</header>\r\n");
      out.write("				<!-- Table -->\r\n");
      out.write("				<h3><a href=\"/board/list");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${criteria.params}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" class=\"button small\">목록 보기</a></h3>\r\n");
      out.write("				<div class=\"content\">\r\n");
      out.write("					<div class=\"form\">\r\n");
      out.write("						<form action=\"/board/remove\" name=\"deleteForm\">\r\n");
      out.write("							<div class=\"fields\">\r\n");
      out.write("								<div class=\"field\">\r\n");
      out.write("									<h4>번호</h4>\r\n");
      out.write("									<input type=\"text\" name=\"bno\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.bno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" readonly>\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"field\">\r\n");
      out.write("									<h4>제목</h4>\r\n");
      out.write("									<input type=\"text\" name=\"title\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" readonly>\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"field\">\r\n");
      out.write("									<h4>내용</h4>\r\n");
      out.write("									<textarea name=\"content\" rows=\"6\" style=\"resize: none;\" readonly>");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("</textarea>\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"field\">\r\n");
      out.write("									<h4>작성자</h4>\r\n");
      out.write("									<input type=\"text\" name=\"writer\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.writer}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" readonly>\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"field\">\r\n");
      out.write("									<h4>첨부파일</h4>\r\n");
      out.write("									<div class=\"uploadResult\">\r\n");
      out.write("										<ul></ul>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<ul class=\"actions special\">\r\n");
      out.write("								<li>\r\n");
      out.write("									<input type=\"button\" class=\"button\" value=\"수정\" onclick=\"location.href='/board/modify");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${criteria.params}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&bno=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.bno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\"/>\r\n");
      out.write("									<input type=\"submit\" class=\"button\" value=\"삭제\"/>\r\n");
      out.write("								</li>\r\n");
      out.write("							</ul>\r\n");
      out.write("							<ul class=\"icons\" style=\"margin:0;\">\r\n");
      out.write("								<li>\r\n");
      out.write("									<span class=\"icon solid fa-envelope\"></span>\r\n");
      out.write("									<strong>댓글</strong>\r\n");
      out.write("								</li>\r\n");
      out.write("								<!-- \r\n");
      out.write("								<li style=\"display : block;\">\r\n");
      out.write("									<strong>작성자</string>\r\n");
      out.write("									<p>댓글 내용</p>\r\n");
      out.write("									<strong>댓글 작성 시간</strong>\r\n");
      out.write("									<div class=\"line\"></div>\r\n");
      out.write("								</li>\r\n");
      out.write("								 -->\r\n");
      out.write("							</ul>\r\n");
      out.write("							<a class=\"button primary small register\" style=\"display:block; margin-bottom:30px;\">댓글 등록</a>\r\n");
      out.write("							<div class=\"fields register-form\" style='display:none;'>\r\n");
      out.write("								<div class=\"field\">\r\n");
      out.write("									<h4 class=\"reply-h4\">작성자</h4>\r\n");
      out.write("									<input type=\"text\" name=\"replier\" placeholder=\"Replier\">\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"field\">\r\n");
      out.write("									<h4 class=\"reply-h4\">댓글</h4>\r\n");
      out.write("									<textarea name=\"reply\" rows=\"6\" placeholder=\"Reply\" style=\"resize:none;\"></textarea>\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"field registerButtons\" style=\"text-align:right;\">\r\n");
      out.write("									<a href=\"javascript:void(0)\" class=\"button primary small finish\">등록</a>\r\n");
      out.write("									<a href=\"javascript:void(0)\" class=\"button primary small cancel\">취소</a>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<ul class=\"replies\">\r\n");
      out.write("							</ul>\r\n");
      out.write("						</form>\r\n");
      out.write("						<div class=\"paging\" style=\"text-align: center;\">\r\n");
      out.write("						</div>\r\n");
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
      out.write("<script src=\"/resources/assets/js/reply.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("	/*	\r\n");
      out.write("	let bno = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.bno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("	console.log(\"JS Test\");\r\n");
      out.write("	replyService.add({\r\n");
      out.write("		bno : bno,\r\n");
      out.write("		reply : \"모듈화 테스트\",\r\n");
      out.write("		replier : \"모듈테스터\"\r\n");
      out.write("	}, function(result){\r\n");
      out.write("		console.log(result);\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	replyService.getList({bno: bno, page: 1}, function(list){\r\n");
      out.write("		console.log(list);\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	replyService.remove(50, function(result){\r\n");
      out.write("		alert(result);\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	replyService.modify({\r\n");
      out.write("		reply : \"댓글 수정 테스트\",\r\n");
      out.write("		rno : 51\r\n");
      out.write("	}, function(result){\r\n");
      out.write("		alert(result);\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	replyService.getReply(51, function(reply){\r\n");
      out.write("		console.log(reply);\r\n");
      out.write("	});\r\n");
      out.write("	*/\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("	let page = 1;\r\n");
      out.write("	let bno = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.bno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("	const repliesUL = $(\"ul.replies\");\r\n");
      out.write("\r\n");
      out.write("	showList(page);\r\n");
      out.write("	\r\n");
      out.write("	function showReplyPage(total){\r\n");
      out.write("		let endNum = Math.ceil(page / 10.0) * 10; // 0.1 ~ 1.0 -> 1 ... (n-1).1 ~ n.0 -> n\r\n");
      out.write("		let startNum = endNum - 9;\r\n");
      out.write("		let prev = startNum != 1;\r\n");
      out.write("		let next = false;\r\n");
      out.write("		let str = \"\";\r\n");
      out.write("		\r\n");
      out.write("		if(endNum * 10 < total){\r\n");
      out.write("			next = true;\r\n");
      out.write("		}\r\n");
      out.write("		else{\r\n");
      out.write("			endNum = Math.ceil(total / 10.0)\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		if(prev){\r\n");
      out.write("				str += `<a class='changePage' href=` + (startNum - 1) + `><code>&lt;</code></a>`;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		for(let i = startNum; i <= endNum; i++){\r\n");
      out.write("			if(page == i){\r\n");
      out.write("				str += `<code>` + i + `</code>`;\r\n");
      out.write("			}\r\n");
      out.write("			else{\r\n");
      out.write("				str += `<a class='changePage' href=` + i + `><code>` + i + `</code></a>`;\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		if(next){\r\n");
      out.write("				str += `<a class='changePage' href=` + (endNum + 1) + `><code>&gt;</code></a>`;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		$(\"div.paging\").html(str);\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	function showList(page){\r\n");
      out.write("		replyService.getList({\r\n");
      out.write("			bno : bno,\r\n");
      out.write("			page : page\r\n");
      out.write("		}, function(result){\r\n");
      out.write("			let list = result.list;\r\n");
      out.write("			let total = result.total;\r\n");
      out.write("			let str = \"\";\r\n");
      out.write("			for(let i = 0; i < list.length; i++){\r\n");
      out.write("				let check = list[i].replyDate == list[i].updateDate;\r\n");
      out.write("				let date = check ? list[i].replyDate : list[i].updateDate;\r\n");
      out.write("				str += \"<li id='\" + list[i].rno +\"' style='display : block;'>\"\r\n");
      out.write("					+ \"<div style='display:flex; justify-content:space-between;'>\"\r\n");
      out.write("					+ \"<strong style='display:block;'>\" + list[i].replier + \"</strong>\"\r\n");
      out.write("					+ \"<div>\"\r\n");
      out.write("					+ \"<a href='\" + list[i].rno + \"' class='modify-ready'>수정</a>\"\r\n");
      out.write("					+ \"<a href='\" + list[i].rno + \"' class='modify-finish' style='display:none;'>수정완료</a>\"\r\n");
      out.write("					+ \"&nbsp;&nbsp;&nbsp;<a href='\" + list[i].rno + \"' class='remove'>삭제</a>\"\r\n");
      out.write("					+ \"</div>\"\r\n");
      out.write("					+ \"</div>\"\r\n");
      out.write("					+ \"<p class='\" + list[i].rno + \"'>\"\r\n");
      out.write("					+ list[i].reply + \"</p><strong style='display : block; text-align : right;'>\"\r\n");
      out.write("					+ (check ? '' : '*') + replyService.displayTime(date) + \"</strong>\"\r\n");
      out.write("					+ \"<div class='line'></div></li>\";\r\n");
      out.write("			}\r\n");
      out.write("			repliesUL.html(str);\r\n");
      out.write("			showReplyPage(total);\r\n");
      out.write("		});\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	$(\"div.paging\").on(\"click\", \"a.changePage\", function(e){\r\n");
      out.write("		e.preventDefault();\r\n");
      out.write("		page = $(this).attr(\"href\");\r\n");
      out.write("		showList(page);\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	$(\"a.finish\").on(\"click\", function(e){\r\n");
      out.write("		e.preventDefault();\r\n");
      out.write("		\r\n");
      out.write("		replyService.add({\r\n");
      out.write("			bno: bno,\r\n");
      out.write("			reply: $(\"textarea[name='reply']\").val(),\r\n");
      out.write("			replier: $(\"input[name='replier']\").val()\r\n");
      out.write("		}, function(){\r\n");
      out.write("			$(\"textarea[name='reply']\").val(\"\");\r\n");
      out.write("			$(\"input[name='replier']\").val(\"\");\r\n");
      out.write("			showList(page);\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	$(\"a.register\").on(\"click\", function(e){\r\n");
      out.write("		e.preventDefault();\r\n");
      out.write("		$(\"div.register-form\").show();\r\n");
      out.write("		$(this).hide();\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	$(\"a.cancel\").on(\"click\", function(e){\r\n");
      out.write("		e.preventDefault();\r\n");
      out.write("		$(\"div.register-form\").hide();\r\n");
      out.write("		$(\"a.register\").show();\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	// 이벤트 위임\r\n");
      out.write("	// DOM으로 추가한 태그들은 이벤트가 발생하지 않는다.\r\n");
      out.write("	// 이런 경우 기존의 태그에 이벤트를 걸어준다.\r\n");
      out.write("	// 그리고 새롭게 추가될 태그의 선택자를 on 메소드에 아래와 같이 전달한다(jQuery에서는 on 메소드로만 가능하다).\r\n");
      out.write("	// on(\"이벤트명\", \"자식요소 선택자\", callback function)\r\n");
      out.write("	// 그러면 기존 태그의 이벤트는 새롭게 추가된 자식 요소에 위임된다.\r\n");
      out.write("	\r\n");
      out.write("	let isWriting = false;\r\n");
      out.write("	$(\"ul.replies\").on(\"click\", \"a.modify-ready\", function(e){\r\n");
      out.write("		e.preventDefault();\r\n");
      out.write("		if(isWriting){\r\n");
      out.write("			alert(\"이미 수정 중인 댓글이 있습니다.\");\r\n");
      out.write("			return;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		let finish = $(\"a.modify-finish\");\r\n");
      out.write("		let rno = $(this).attr(\"href\");\r\n");
      out.write("		const p = $(\"li#\" + rno).find(\"p.\" + rno);\r\n");
      out.write("		const remove = $(\"a.remove\");\r\n");
      out.write("		\r\n");
      out.write("		$(this).hide();\r\n");
      out.write("		for(let i = 0; i < finish.length; i++){\r\n");
      out.write("			if(finish[i].getAttribute(\"href\") == rno){\r\n");
      out.write("				$(remove[i]).attr(\"class\", \"modify-cancel\");\r\n");
      out.write("				$(remove[i]).text(\"취소\");\r\n");
      out.write("				$(finish[i]).show();\r\n");
      out.write("				break;\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		p.html(\"<textarea class='\" + rno + \"' style='resize:none;'>\" + p.text() + \"</textarea>\");\r\n");
      out.write("		isWriting = true;\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	$(\"ul.replies\").on(\"click\", \"a.modify-finish\", function(e){\r\n");
      out.write("		e.preventDefault();\r\n");
      out.write("		let rno = $(this).attr(\"href\");\r\n");
      out.write("		const p = $(\"li#\" + rno).find(\"p.\" + rno);\r\n");
      out.write("		\r\n");
      out.write("		replyService.modify({\r\n");
      out.write("			reply: $(\"textarea.\" + rno).val(),\r\n");
      out.write("			rno : $(this).attr(\"href\")\r\n");
      out.write("		}, function(){\r\n");
      out.write("			alert(\"수정 완료!\");\r\n");
      out.write("			p.html($(\"textarea.\" + rno).val());\r\n");
      out.write("			\r\n");
      out.write("			$(this).hide();\r\n");
      out.write("			$(this).prev().show();\r\n");
      out.write("			\r\n");
      out.write("			showList(page);\r\n");
      out.write("			isWriting = false;\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	$(\"ul.replies\").on(\"click\", \"a.modify-cancel\", function(e){\r\n");
      out.write("		e.preventDefault();\r\n");
      out.write("		\r\n");
      out.write("		let rno = $(this).attr(\"href\");\r\n");
      out.write("		const p = $(\"li#\" + rno).find(\"p.\" + rno);\r\n");
      out.write("		p.html($(\"textarea.\" + rno).text());\r\n");
      out.write("		\r\n");
      out.write("		$(this).attr(\"class\", \"remove\");\r\n");
      out.write("		$(this).text(\"삭제\");\r\n");
      out.write("		\r\n");
      out.write("		$(this).prev().hide();\r\n");
      out.write("		$(this).prev().prev().show();\r\n");
      out.write("		\r\n");
      out.write("		isWriting = false;\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	$(\"ul.replies\").on(\"click\", \"a.remove\", function(e){\r\n");
      out.write("		e.preventDefault();\r\n");
      out.write("		\r\n");
      out.write("		if(confirm(\"정말 삭제하시겠습니까?\")){\r\n");
      out.write("			replyService.remove($(this).attr(\"href\"), function(){\r\n");
      out.write("				showList();\r\n");
      out.write("			});\r\n");
      out.write("		}\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function(e){\r\n");
      out.write("	let uploadResult = $(\".uploadResult ul\");\r\n");
      out.write("	\r\n");
      out.write("	$.getJSON(\"files\", {bno: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.bno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"}, function(files){\r\n");
      out.write("		showUploadResult(files);\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	function showUploadResult(files){\r\n");
      out.write("		let str = \"\";\r\n");
      out.write("		$(files).each(function(i, file){\r\n");
      out.write("			let fileName = \"\";\r\n");
      out.write("			let fileNameOriginal = encodeURIComponent(file.uploadPath + \"/\" + file.uuid + \"_\" + file.fileName);\r\n");
      out.write("			if(!file.fileType){\r\n");
      out.write("				fileName = \"attach.png\";\r\n");
      out.write("			}\r\n");
      out.write("			else{\r\n");
      out.write("				fileName = encodeURIComponent(file.uploadPath + \"/t_\" + file.uuid + \"_\" + file.fileName);\r\n");
      out.write("			}\r\n");
      out.write("				str += \"<li data-filename='\" + file.fileName + \"' data-uuid='\" + file.uuid + \"' data-uploadpath='\" + file.uploadPath + \"' data-filetype='\" + file.fileType + \"'>\";\r\n");
      out.write("				str += \"<div>\";\r\n");
      out.write("				str += \"<a href='/download?fileName=\" + fileNameOriginal + \"'>\";\r\n");
      out.write("				str += \"<img src='/display?fileName=\" + fileName + \"' width='100'>\";\r\n");
      out.write("				str += \"</a>\";\r\n");
      out.write("				str += \"</div>\";\r\n");
      out.write("				str += \"<span>\" + file.fileName + \"</span>\";\r\n");
      out.write("				str += \"</li>\";\r\n");
      out.write("		});\r\n");
      out.write("		uploadResult.append(str);\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	$(\"input[type='submit']\").on(\"click\", function(e){\r\n");
      out.write("		e.preventDefault();\r\n");
      out.write("		$(\".uploadResult ul li\").each(function(i, li){\r\n");
      out.write("			var fileName = encodeURIComponent($(li).data(\"filetype\") ? \r\n");
      out.write("				$(li).data(\"uploadpath\") + \"/t_\" + $(li).data(\"uuid\") + \"_\" + $(li).data(\"filename\") : \r\n");
      out.write("				$(li).data(\"uploadpath\") + \"/\" + $(li).data(\"uuid\") + \"_\" + $(li).data(\"filename\"));\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url : \"/delete\",\r\n");
      out.write("				type: \"post\",\r\n");
      out.write("				data : {fileName: fileName, fileType: $(li).data(\"filetype\")},\r\n");
      out.write("				success: function(){\r\n");
      out.write("					document.deleteForm.submit();\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    boolean _jspx_th_c_005fout_005f0_reused = false;
    try {
      _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fout_005f0.setParent(null);
      // /WEB-INF/views/board/read.jsp(54,74) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.content}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
      if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      _jspx_th_c_005fout_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fout_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fout_005f0_reused);
    }
    return false;
  }
}
