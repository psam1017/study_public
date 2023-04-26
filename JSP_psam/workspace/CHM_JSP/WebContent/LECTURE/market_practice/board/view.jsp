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
	<c:set var="sid" value="${ sid }"/>
	<c:set var="pageNum" value="${ pageNum }"/>
	<c:set var="board" value="${ board }"/>
	<jsp:include page="../market_header.jsp"/>
	
	<div class="jumbotron">
		<div class="container text-center">
			<h1 class="display-3">게시판</h1>
		</div>
	</div>
	<div class="container">
		<form name="newUpdate" action="BoardUpdateAction.do?num=${ board.getNum() }&pageNum=${pageNum}" class="form-horizontal" method="post">
			<input name="id" type="hidden" class="form-control" value="${board.getId()}">
			<div class="form-group row">
				<label class="col-sm-2 control-label">성명</label>
				<div class="col-sm-3">
					<input name="name" type="text" class="form-control" value="${board.getName()}" placeholder="name">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">제목</label>
				<div class="col-sm-5">
					<input name="subject" type="text" class="form-control" placeholder="subject" value="${board.getSubject() }">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label">내용</label>
				<div class="col-sm-5">
					<input name="content" type="text" class="form-control" placeholder="content" value="${board.getContent() }">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-10 col-sm-offset-2">
					<c:if test="${ board.getId() eq sid }">
						<a class="btn btn-primary" href="BoardDeleteAction.do?num=${board.getNum()}&pageNum=${pageNum}">삭제</a>
						<input type="submit" class="btn btn-primary" value="수정">
					</c:if>
					<a class="btn btn-primary" href="BoardListAction.do?pageNum=${ pageNum }">목록</a>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="../market_footer.jsp"/>
</body>
</html>