<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<c:set var="sessionId" value="${ sid }"/>
	<c:set var="name" value="${ name }"/>
	<jsp:include page="../market_header.jsp"/>
	
	<div class="jumbotron">
		<div class="container text-center">
			<h1 class="display-3">게시판</h1>
		</div>
	</div>
	<div class="container">
		<form name="newWrite" action="BoardWriteAction.do" class="form-horizontal" method="post" onsubmit="return checkForm()">
			<input name="id" type="hidden" class="form-control" value="${id}">
			<div class="form-group row">
				<label class="col-sm-2 control-label">성명</label>
				<div class="col-sm-3">
					<input name="name" type="text" class="form-control" value="${name}" placeholder="name">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">제목</label>
				<div class="col-sm-5">
					<input name="subject" type="text" class="form-control" placeholder="subject">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">내용</label>
				<div class="col-sm-5">
					<input name="content" type="text" class="form-control" placeholder="content">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-10 col-sm-offset-2">
					<input type="submit" class="btn btn-primary" value="등록">
					<input type="reset" class="btn btn-primary" value="취소">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="../market_footer.jsp"/>
</body>
<script>
	function checkForm(){
		const form = document.newWrite;
		let check = true;
		if(!form.name.value){
			check = false;
		}
		if(!form.subject.value){
			check = false;
		}
		if(!form.content.value){
			check = false;
		}
		if(!check){
			alert("입력되지 않은 값이 있습니다.")
			return false;
		}
		else{
			return true;
		}
	}
</script>
</html>