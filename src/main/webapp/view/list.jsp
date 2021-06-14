<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 페이지</title>
<style type="text/css">
	a{text-decoration: none;}
	table{width: 600px; border-collapse: collapse;; text-align: center;}
	table, th, td{border: 1px solid black; padding: 5px; margin: auto;}
	div{ width: 600px; margin: 100px auto; text-align: center;}
</style>
</head>
<body>
	<div>
		<h1 style="text-align: center">방명록</h1>
		<hr>
		<p style="text-align: center">
			[<a href="${pageContext.request.contextPath}/MyController?cmd=write">방명록쓰기</a>]
		</p>
		<form method="post">
			<table>
				<thead style="background-color: #99ccff">
					<tr>
						<th style="width: 10%">번호</th>
						<th style="width: 20%">작성자</th>
						<th style="width: 40%">제목</th>
						<th style="width: 30%">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty list}">
							<tr>
								<td colspan="4"><h2>원하는 정보가 존재하지 않습니다</h2></td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="k" items="${list}" varStatus="vs">
								<tr>
									<td>${vs.count}</td>
									<td>${k.name }</td>
									<td><a href="${pageContext.request.contextPath}/MyController?cmd=onelist&idx=${k.idx}">${k.title}</a></td>
									<td>${k.reg.substring(0,10)}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>