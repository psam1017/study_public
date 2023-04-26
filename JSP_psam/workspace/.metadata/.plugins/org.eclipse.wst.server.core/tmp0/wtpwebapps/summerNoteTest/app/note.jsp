<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>SummerNoteExample</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
  <!-- 서머노트를 위해 추가해야할 부분 -->
  <script src="${pageContext.request.contextPath}/assets/summernote/summernote-lite.js"></script>
  <script src="${pageContext.request.contextPath}/assets/summernote/lang/summernote-ko-KR.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/summernote/summernote-lite.css">
  
</head>
<body>
	<div class="container">
		<form action="" method="post" id="contentForm">
			<textarea class="summernote" name="content"></textarea>
			<input type="submit" id="submitBtn" value="작성완료">
		</form>
	</div>
<script>
$(document).ready(function() {
	const contextPath = "${pageContext.request.contextPath}";
	const contentForm = document.getElementById("contentForm");
	const submitBtn = document.getElementById("submitBtn");
	
	// content 전송 영역은 
	submitBtn.addEventListener("click", function(e){
		e.preventDefault();
		contentForm.action = "#";
		contentForm.submit();
	});
	
	// summernote 내용 불러오기. 반드시 초기화 이전에 script 안에서 불러와야 함. 순서에 주의할 것.
	$(".summernote").val("<c:out value='content-ok'></c:out>");
	
	// summernote 초기화
	$('.summernote').summernote({
		// 에디터 높이
		height: 150,
		// 에디터 한글 설정
		lang: "ko-KR",
		// 에디터에 커서 이동 (input창의 autofocus라고 생각하시면 됩니다.)
		focus : true,
		toolbar: [
			// 글꼴 설정
			['fontname', ['fontname']],
			// 글자 크기 설정
			['fontsize', ['fontsize']],
			// 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
			['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
			// 글자색
			['color', ['forecolor','color']],
			// 표만들기
			['table', ['table']],
			// 글머리 기호, 번호매기기, 문단정렬
			['para', ['ul', 'ol', 'paragraph']],
			// 줄간격
			['height', ['height']],
			// 그림첨부, 링크만들기, 동영상첨부
			['insert',['picture','link','video']],
			// 코드보기, 확대해서보기, 도움말
			['view', ['codeview','fullscreen', 'help']]
		],
		// 추가한 글꼴
		fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','궁서','굴림체','굴림','돋음체','바탕체'],
		// 추가한 폰트사이즈
		fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
		callbacks : { //여기 부분이 이미지를 첨부하는 부분
			onImageUpload : function(files, editor, welEditable) {
				for (var i = files.length - 1; i >= 0; i--) {
					uploadSummernoteImageFile(files[i], this);
				}
			}
		}
	});
	
	
	// 파일 전송 콜백함수
    function uploadSummernoteImageFile(file, el) {
		data = new FormData();
		data.append("file", file);
		$.ajax({
			data : data,
			type : "POST",
			url : contextPath + "/upload",
			contentType : false,
			enctype : 'multipart/form-data',
			processData : false,
			dataType : "json",
			success : function(result) {
				$(el).summernote('editor.insertImage', result.url);
			},
			error : function(){
				alert("파일 업로드를 실패했습니다. 관리자에게 문의하세요.");
			}
		});
	}
});


</script>
</body>
</html>