<%@page import="com.yedam.service.BoardService"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String wdate = sdf.format(${boardvo.updateDate});
</script>

<h3>상세페이지(board.jsp)</h3>

<table class="table">
	<tr>
		<th>글번호</th>
		<td>${boardvo.boardNo }</td>
		<th>조회수</th>
		<td>${boardvo.viewCnt }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${boardvo.title }</td>
		<th>작성자</th>
		<td>${boardvo.writer }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3">
			<textarea readonly rows="4" cols="30" class="form-control">${boardvo.content }</textarea>
		</td>
	</tr>
	<tr>
		<th>img</th>
		<td colspan="3"><img src="images/${boardvo.img }" width="100px"></td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td colspan="3">${boardvo.updateDate}</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" value="수정" class="btn btn-warning">
			<input type="button" value="삭제" class="btn btn-danger">
		</td>
	</tr>
</table>


<script>
	document.querySelector('input[value="수정"]').addEventListener('click', function(e) {
		location.href = "modifyBoard.do?searchCondition=${searchCondition }&keyword=${keyword }&page=${page }&bno=${boardvo.boardNo }";
	});
	
	document.querySelector('input[value="삭제"]').addEventListener('click', function(e) {
		location.href = "deleteBoard.do?searchCondition=${searchCondition }&keyword=${keyword }&page=${page }&bno=${boardvo.boardNo }";
	});
</script>