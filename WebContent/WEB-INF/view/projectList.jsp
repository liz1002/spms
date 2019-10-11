<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, th, td{
		border: 1px solid black;
		border-collapse: collapse;
		padding: 10px;
		text-align: center;
	}
	a{
		text-decoration: none;
		color: black;
	}
	p>a{
		font-size: 17px;
		background: #ccc;
		color: #fff;
		border: 1px solid #ccc;
		padding: 5px;
	}
	a:hover {
		text-shadow: 1px 1px 1px #ccc;
	}
</style>
</head>
<body>
	<p>
		<a href="add.do">새 프로젝트 등록</a>
	</p>
	<table>
		<tr>
			<th>프로젝트 이름</th>
			<th>시작 날짜</th>
			<th>종료 날짜</th>
			<th>상태</th>
		</tr>
		<c:forEach var="spms" items="${list}">
			<tr>
				<td><a href="detail.do?no=${spms.no}">${spms.name}</a></td>
				<td>${spms.startdate}</td>
				<td>${spms.enddate}</td>
				<td>${spms.progress}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>