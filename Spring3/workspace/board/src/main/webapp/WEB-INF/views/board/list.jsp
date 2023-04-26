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
	body {transform: scale(0.8);}
			.big-width {display: block;}
			.small-width {display: none;}
			.table-wrapper {overflow-x: hidden;}
			select{
				width:15%;
				display:inline;
			}
			
			input[name='keyword']{
				display:inline;
				width:60%;
			}
			
			.search{
				width:20%;
			}
			
			@media(max-width: 918px){
				body {transform: scale(1); overflow-x: hidden;}
				.writer {display: none;}
				.regDate {display: none;}
				.updateDate {display: none;}
				.big-width {display: none;}
				.small-width {display: block;}
				select{
					width:100%;
				}
				
				input[name='keyword']{
					width:100%;
				}
				
				.search{
					width:100%;
				}
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
					<p>게시판 목록</p>
				</header>
				<!-- Table -->
				<h3><a href="/board/register" class="button small">글 등록</a></h3>
				<div class="table-wrapper">
					<table>
						<thead>
							<tr class="tHead">
								<th class="bno">번호</th>
								<th class="title">제목</th>
								<th class="writer">작성자</th>
								<th class="regDate">작성일</th>
								<th class="updateDate">수정일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="board" items="${boardList}">
								<tr class="tBody">
									<td class="bno"><c:out value="${board.bno}"></c:out></td>
									<!-- 실제로 criteria에 param이 없어도 아래와 같이 쓰면 getter를 쓰는 것과 같다. -->
									<td class="title"><a href="/board/read${pageDTO.criteria.params}&bno=${board.bno}"><c:out value="${board.title}"></c:out></a></td>
									<td class="writer"><c:out value="${board.writer}"></c:out></td>
									<td class="regDate"><c:out value="${board.regDate}"></c:out></td>
									<td class="updateDate"><c:out value="${board.updateDate}"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div style="text-align: center;" class="big-width">
						<c:if test="${pageDTO.prev}">
							<a class="changePage" href="${pageDTO.startPage - 1}"><code>&lt;</code></a>
						</c:if>
						<c:forEach var="num" begin="${pageDTO.startPage}" end="${pageDTO.endPage}" step="1">
							<c:choose>
								<c:when test="${pageDTO.criteria.pageNum == num}">
									<code><c:out value="${num}"/></code>
								</c:when>
								<c:otherwise>
									<a class="changePage" href="${num}"><code><c:out value="${num}"/></code></a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${pageDTO.next}">
							<a class="changePage" href="${pageDTO.endPage + 1}"><code>&gt;</code></a>
						</c:if>
					</div>
					<div style="text-align: center;" class="small-width">
						<c:if test="${pageDTO.criteria.pageNum > 1}">
							<a class="changePage" href="${pageDTO.criteria.pageNum - 1}"><code>&lt;</code></a>
						</c:if>
						<code><c:out value="${pageDTO.criteria.pageNum}"/></code>
						<c:if test="${pageDTO.realEndPage > pageDTO.criteria.pageNum}">
							<a class="changePage" href="${pageDTO.criteria.pageNum + 1}"><code>&gt;</code></a>
						</c:if>
					</div>
					<form name="pageForm" action="/board/list">
						<input type="hidden" name="pageNum" value="${pageDTO.criteria.pageNum}">
						<input type="hidden" name="type" value="${pageDTO.criteria.type}">
						<input type="hidden" name="keyword" value="${pageDTO.criteria.keyword}">
					</form>
					<form name="searchForm" action="/board/list">
						<div class="fields">
							<div class="field" style="text-align: center;">
								<select name="type">
									<option value="" ${pageDTO.criteria.type == '' ? 'selected' : ''}>검색기준</option>
									<option value="TCW" ${pageDTO.criteria.type == 'TCW' ? 'selected' : ''}>통합검색</option>
									<option value="TC" ${pageDTO.criteria.type == 'TC' ? 'selected' : ''}>제목 및 내용</option>
									<option value="W" ${pageDTO.criteria.type == 'W' ? 'selected' : ''}>작성자</option>
									<option value="T" ${pageDTO.criteria.type == 'T' ? 'selected' : ''}>제목만</option>
									<option value="C" ${pageDTO.criteria.type == 'C' ? 'selected' : ''}>내용만</option>
								</select>
								<input type="text" name="keyword" value="${pageDTO.criteria.keyword}">
								<input type="hidden" name="pageNum" value="${pageDTO.criteria.pageNum}">
								<a href="javascript:send()" class="search button primary icon solid fa-search">검색</a>
							</div>
						</div>
					</form>
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
<script>
	// 페이지 이동을 위해 a태그 클릭 시 이벤트 실행
	$("a.changePage").on("click", function(e){
		e.preventDefault();
		let $form = $(document.pageForm);
		$form.find("input[name='pageNum']").val($(this).attr("href"));
		$form.submit();
	});
	
	$(document.searchForm).on("keydown", function(e){
		if(e.keyCode == 13){
		    e.preventDefault();
			send();
		};
	});
	
	function send(){
		let $form = $(document.searchForm);
		
		if(!$form.find("option:selected").val()){
			alert("검색 종류를 선택하세요.");
			return;
		}
		
		if(!$form.find("input[name='keyword']").val()){
			alert("키워드를 입력하세요.");
			return;
		}
		
		$form.submit();
	}	
</script>
</html>
