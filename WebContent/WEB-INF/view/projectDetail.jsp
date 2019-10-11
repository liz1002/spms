<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(function() {
		$("#delete").click(function() {
			if (confirm("삭제하시겠습니까?") != true){
			    return false;
			}
		})
	})
</script>
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
	<table>
		<tr>
			<th>프로젝트 이름</th>
			<td>${spms.name}</td>
		</tr>
		<tr>
			<th>프로젝트 내용</th>
			<td>${spms.content}</td>
		</tr>
		<tr>
			<th>시작 날짜</th>
			<td>${spms.startdate}</td>
		</tr>
		<tr>
			<th>종료 날짜</th>
			<td>${spms.enddate}</td>
		<tr>
			<th>상태</th>
			<td>${spms.progress}</td>
		</tr>
	</table>
	<p>
		<a href="update.do?no=${spms.no}">수정</a>
		<a href="delete.do?no=${spms.no}" id="delete">삭제</a>
		<a href="list.do">돌아가기</a>
	</p>
</body>
</html>