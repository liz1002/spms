<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input.btn{
		font-size: 17px;
		background: #ccc;
		color: #fff;
		border: 1px solid #ccc;
		padding: 5px;
	}
	input.btn:hover {
		text-shadow: 1px 1px 1px #ccc;
	}
</style>
<link href="${pageContext.request.contextPath}/css/common.css" type="text/css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script>

 	var progress = "${spms.progress}";
	$(function() {
		$("#f1").submit(function() {
			var result = checkInputEmpty($("input[name], textarea, select"));
			if(result == false){
				return false;
			}
		})
		
		$("select").val(progress).attr("selected", "selected");
	})
</script>
</head>
<body>
	<form id="f1" action="update.do" method="post">
		<input type="hidden" name="no" value="${spms.no}">
		<p>
			<label>프로젝트 이름</label>
			<input type="text" name="name" value="${spms.name}">
			<span class="error">프로젝트 이름을 입력하세요.</span>
		</p>
		<p>
			<label>프로젝트 내용</label>
			<textarea rows="10" cols="60" name="content">${spms.content}</textarea>
			<span class="error">프로젝트 내용을 입력하세요.</span>
		</p>
		<p>
			<label>시작 날짜</label>
			<input type="date" name="startdate" value="${spms.startdate}">
			<span class="error">시작 날짜를 선택하세요.</span>
		</p>
		<p>
			<label>종료 날짜</label>
			<input type="date" name="enddate" value="${spms.enddate}">
			<span class="error">종료 날짜를 선택하세요.</span>
		</p>
		<p>
			<label>상태</label>
			<select name="progress">
				<option>준비</option>
				<option>진행중</option>
				<option>종료</option>
				<option>보류</option>
			</select>
		</p>
		<p>
			<input type="submit" value="수정" class="btn">
			<input type="reset" value="취소" class="btn">
		</p>
	</form>
</body>
</html>