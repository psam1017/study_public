<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Board</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="/resources/assets/css/main.css" />
	<style>
		body {transform: scale(0.8); margin-top: -50px;}
		div.line{border-bottom: 1px solid black;}
		h4.reply-h4{margin-bottom: 0px;}
		.uploadResult{
			width: 100%
		}
		.uploadResult ul{
			display: flex;
			justify-content: center;
		}
		.uploadResult ul li{
			list-style: none;
		}
	</style>
</head>
<body class="is-preload">
	<!-- Main -->
	<div id="main">
		<div class="wrapper">
			<div class="inner">

				<!-- Elements -->
				<header class="major">
					<h1>Board</h1>
					<p>게시글 상세보기</p>
				</header>
				<!-- Table -->
				<h3><a href="/board/list${criteria.params}" class="button small">목록 보기</a></h3>
				<div class="content">
					<div class="form">
						<form action="/board/remove" name="deleteForm">
							<div class="fields">
								<div class="field">
									<h4>번호</h4>
									<input type="text" name="bno" value="${board.bno}" readonly>
								</div>
								<div class="field">
									<h4>제목</h4>
									<input type="text" name="title" value="${board.title}" readonly>
								</div>
								<div class="field">
									<h4>내용</h4>
									<textarea name="content" rows="6" style="resize: none;" readonly><c:out value="${board.content}"/></textarea>
								</div>
								<div class="field">
									<h4>작성자</h4>
									<input type="text" name="writer" value="${board.writer}" readonly>
								</div>
								<div class="field">
									<h4>첨부파일</h4>
									<div class="uploadResult">
										<ul></ul>
									</div>
								</div>
							</div>
							<ul class="actions special">
								<li>
									<input type="button" class="button" value="수정" onclick="location.href='/board/modify${criteria.params}&bno=${board.bno}'"/>
									<input type="submit" class="button" value="삭제"/>
								</li>
							</ul>
							<ul class="icons" style="margin:0;">
								<li>
									<span class="icon solid fa-envelope"></span>
									<strong>댓글</strong>
								</li>
								<!-- 
								<li style="display : block;">
									<strong>작성자</string>
									<p>댓글 내용</p>
									<strong>댓글 작성 시간</strong>
									<div class="line"></div>
								</li>
								 -->
							</ul>
							<a class="button primary small register" style="display:block; margin-bottom:30px;">댓글 등록</a>
							<div class="fields register-form" style='display:none;'>
								<div class="field">
									<h4 class="reply-h4">작성자</h4>
									<input type="text" name="replier" placeholder="Replier">
								</div>
								<div class="field">
									<h4 class="reply-h4">댓글</h4>
									<textarea name="reply" rows="6" placeholder="Reply" style="resize:none;"></textarea>
								</div>
								<div class="field registerButtons" style="text-align:right;">
									<a href="javascript:void(0)" class="button primary small finish">등록</a>
									<a href="javascript:void(0)" class="button primary small cancel">취소</a>
								</div>
							</div>
							<ul class="replies">
							</ul>
						</form>
						<div class="paging" style="text-align: center;">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> 
</body>
<!-- Scripts -->
<script src="/resources/assets/js/jquery.min.js"></script>
<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
<script src="/resources/assets/js/browser.min.js"></script>
<script src="/resources/assets/js/breakpoints.min.js"></script>
<script src="/resources/assets/js/util.js"></script>
<script src="/resources/assets/js/main.js"></script>
<script src="/resources/assets/js/reply.js"></script>
<script>
	/*	
	let bno = "${board.bno}";
	console.log("JS Test");
	replyService.add({
		bno : bno,
		reply : "모듈화 테스트",
		replier : "모듈테스터"
	}, function(result){
		console.log(result);
	});
	
	replyService.getList({bno: bno, page: 1}, function(list){
		console.log(list);
	});
	
	replyService.remove(50, function(result){
		alert(result);
	});
	
	replyService.modify({
		reply : "댓글 수정 테스트",
		rno : 51
	}, function(result){
		alert(result);
	});
	
	replyService.getReply(51, function(reply){
		console.log(reply);
	});
	*/
</script>
<script>
	let page = 1;
	let bno = "${board.bno}";
	const repliesUL = $("ul.replies");

	showList(page);
	
	function showReplyPage(total){
		let endNum = Math.ceil(page / 10.0) * 10; // 0.1 ~ 1.0 -> 1 ... (n-1).1 ~ n.0 -> n
		let startNum = endNum - 9;
		let prev = startNum != 1;
		let next = false;
		let str = "";
		
		if(endNum * 10 < total){
			next = true;
		}
		else{
			endNum = Math.ceil(total / 10.0)
		}
		
		if(prev){
				str += `<a class='changePage' href=` + (startNum - 1) + `><code>&lt;</code></a>`;
		}
		
		for(let i = startNum; i <= endNum; i++){
			if(page == i){
				str += `<code>` + i + `</code>`;
			}
			else{
				str += `<a class='changePage' href=` + i + `><code>` + i + `</code></a>`;
			}
		}
		
		if(next){
				str += `<a class='changePage' href=` + (endNum + 1) + `><code>&gt;</code></a>`;
		}
		
		$("div.paging").html(str);
	}
	
	function showList(page){
		replyService.getList({
			bno : bno,
			page : page
		}, function(result){
			let list = result.list;
			let total = result.total;
			let str = "";
			for(let i = 0; i < list.length; i++){
				let check = list[i].replyDate == list[i].updateDate;
				let date = check ? list[i].replyDate : list[i].updateDate;
				str += "<li id='" + list[i].rno +"' style='display : block;'>"
					+ "<div style='display:flex; justify-content:space-between;'>"
					+ "<strong style='display:block;'>" + list[i].replier + "</strong>"
					+ "<div>"
					+ "<a href='" + list[i].rno + "' class='modify-ready'>수정</a>"
					+ "<a href='" + list[i].rno + "' class='modify-finish' style='display:none;'>수정완료</a>"
					+ "&nbsp;&nbsp;&nbsp;<a href='" + list[i].rno + "' class='remove'>삭제</a>"
					+ "</div>"
					+ "</div>"
					+ "<p class='" + list[i].rno + "'>"
					+ list[i].reply + "</p><strong style='display : block; text-align : right;'>"
					+ (check ? '' : '*') + replyService.displayTime(date) + "</strong>"
					+ "<div class='line'></div></li>";
			}
			repliesUL.html(str);
			showReplyPage(total);
		});
	}
	
	$("div.paging").on("click", "a.changePage", function(e){
		e.preventDefault();
		page = $(this).attr("href");
		showList(page);
	});
	
	$("a.finish").on("click", function(e){
		e.preventDefault();
		
		replyService.add({
			bno: bno,
			reply: $("textarea[name='reply']").val(),
			replier: $("input[name='replier']").val()
		}, function(){
			$("textarea[name='reply']").val("");
			$("input[name='replier']").val("");
			showList(page);
		});
	});
	
	$("a.register").on("click", function(e){
		e.preventDefault();
		$("div.register-form").show();
		$(this).hide();
	});
	
	$("a.cancel").on("click", function(e){
		e.preventDefault();
		$("div.register-form").hide();
		$("a.register").show();
	});
	
	// 이벤트 위임
	// DOM으로 추가한 태그들은 이벤트가 발생하지 않는다.
	// 이런 경우 기존의 태그에 이벤트를 걸어준다.
	// 그리고 새롭게 추가될 태그의 선택자를 on 메소드에 아래와 같이 전달한다(jQuery에서는 on 메소드로만 가능하다).
	// on("이벤트명", "자식요소 선택자", callback function)
	// 그러면 기존 태그의 이벤트는 새롭게 추가된 자식 요소에 위임된다.
	
	let isWriting = false;
	$("ul.replies").on("click", "a.modify-ready", function(e){
		e.preventDefault();
		if(isWriting){
			alert("이미 수정 중인 댓글이 있습니다.");
			return;
		}
		
		let finish = $("a.modify-finish");
		let rno = $(this).attr("href");
		const p = $("li#" + rno).find("p." + rno);
		const remove = $("a.remove");
		
		$(this).hide();
		for(let i = 0; i < finish.length; i++){
			if(finish[i].getAttribute("href") == rno){
				$(remove[i]).attr("class", "modify-cancel");
				$(remove[i]).text("취소");
				$(finish[i]).show();
				break;
			}
		}
		
		p.html("<textarea class='" + rno + "' style='resize:none;'>" + p.text() + "</textarea>");
		isWriting = true;
	});
	
	$("ul.replies").on("click", "a.modify-finish", function(e){
		e.preventDefault();
		let rno = $(this).attr("href");
		const p = $("li#" + rno).find("p." + rno);
		
		replyService.modify({
			reply: $("textarea." + rno).val(),
			rno : $(this).attr("href")
		}, function(){
			alert("수정 완료!");
			p.html($("textarea." + rno).val());
			
			$(this).hide();
			$(this).prev().show();
			
			showList(page);
			isWriting = false;
		});
	});
	
	$("ul.replies").on("click", "a.modify-cancel", function(e){
		e.preventDefault();
		
		let rno = $(this).attr("href");
		const p = $("li#" + rno).find("p." + rno);
		p.html($("textarea." + rno).text());
		
		$(this).attr("class", "remove");
		$(this).text("삭제");
		
		$(this).prev().hide();
		$(this).prev().prev().show();
		
		isWriting = false;
	});
	
	$("ul.replies").on("click", "a.remove", function(e){
		e.preventDefault();
		
		if(confirm("정말 삭제하시겠습니까?")){
			replyService.remove($(this).attr("href"), function(){
				showList();
			});
		}
	});
</script>
<script>
$(document).ready(function(e){
	let uploadResult = $(".uploadResult ul");
	
	$.getJSON("files", {bno: "${board.bno}"}, function(files){
		showUploadResult(files);
	});
	
	function showUploadResult(files){
		let str = "";
		$(files).each(function(i, file){
			let fileName = "";
			let fileNameOriginal = encodeURIComponent(file.uploadPath + "/" + file.uuid + "_" + file.fileName);
			if(!file.fileType){
				fileName = "attach.png";
			}
			else{
				fileName = encodeURIComponent(file.uploadPath + "/t_" + file.uuid + "_" + file.fileName);
			}
				str += "<li data-filename='" + file.fileName + "' data-uuid='" + file.uuid + "' data-uploadpath='" + file.uploadPath + "' data-filetype='" + file.fileType + "'>";
				str += "<div>";
				str += "<a href='/download?fileName=" + fileNameOriginal + "'>";
				str += "<img src='/display?fileName=" + fileName + "' width='100'>";
				str += "</a>";
				str += "</div>";
				str += "<span>" + file.fileName + "</span>";
				str += "</li>";
		});
		uploadResult.append(str);
	}
	
	$("input[type='submit']").on("click", function(e){
		e.preventDefault();
		$(".uploadResult ul li").each(function(i, li){
			var fileName = encodeURIComponent($(li).data("filetype") ? 
				$(li).data("uploadpath") + "/t_" + $(li).data("uuid") + "_" + $(li).data("filename") : 
				$(li).data("uploadpath") + "/" + $(li).data("uuid") + "_" + $(li).data("filename"));
			$.ajax({
				url : "/delete",
				type: "post",
				data : {fileName: fileName, fileType: $(li).data("filetype")},
				success: function(){
					document.deleteForm.submit();
				}
			});
		});
	});
});
</script>
</html>
