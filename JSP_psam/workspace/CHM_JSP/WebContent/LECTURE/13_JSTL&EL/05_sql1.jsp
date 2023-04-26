<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sql</title>
</head>
<body>
	<sql:setDataSource
		var="dataSource"
		url="jdbc:mariadb://localhost:12601/sample"
		driver="org.mariadb.jdbc.Driver"
		user="root"
		password="test1234"
	/>
	
	<sql:query var="resultSet" dataSource="${dataSource}">
		SELECT * FROM `member`
	</sql:query>
	
	<table border="1">
		<tr>
			<c:forEach var="columnName" items="${resultSet.columnNames }">
				<th width="100"><c:out value="${columnName }"/></th>
			</c:forEach>
		</tr>
		<c:forEach var="row" items="${resultSet.rowsByIndex }">
			<tr>
				<c:forEach var="item" items="${row}">
					<td>
						<c:if test="${ item != null }">
							<c:out value="${ item }"/>
						</c:if>
						<c:if test="${ item == null }">
							&nbsp;
						</c:if>
					</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	
	<%--
	<c:foreach items=”${items}” var=”item” varStatus=”status”>
		${status.current}      <!– 현재 아이템 –>
		${status.index}        <!– 0부터의 순서 –>
		${status.count}        <!– 1부터의 순서 –>
		${status.first}        <!– 현재 루프가 처음인지 반환 –>
		${status.last}         <!– 현재 루프가 마지막인지 반환 –> 
		${status.begin}        <!– 시작값 –>
		${status.end}          <!– 끝값 –>
		${status.step}         <!– 증가값 –>
	</c:forEach>
	 --%>
</body>
</html>