<%@page import="com.yedam.service.BoardService"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
	.reply span {
		display: inline-block;
	}
	.reply ul {
		list-style-type: none;
	}
</style>

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

<!-- 댓글 관련 -->
<div class="container reply">
	<!-- 댓글 등록 -->
	<div class="header">
		댓글내용: <input class="col-sm-8" id="reply">
		<button class="col-sm-2" id="addReply">댓글등록</button>
	</div>
	
	<!-- 댓글 목록 -->
	<div class="content">
		<ul>
			<li>
				<span class="col-sm-2">글번호</span>
				<span class="col-sm-5">내용</span>
				<span class="col-sm-2">작성자</span>
				<span class="col-sm-2">삭제</span>
			</li>
			<!-- <li>
				<span class="col-sm-2">3</span>
				<span class="col-sm-5">댓글입니다.</span>
				<span class="col-sm-2">user01</span>
				<span class="col-sm-2"><button>삭제</button></span>
			</li> -->
		</ul>
	</div>
	
	<!-- 댓글 페이징 -->
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item">
				<a class="page-link" href="#" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
				</a>
		    </li>
		    <li class="page-item"><a class="page-link" href="#">1</a></li>
		    <li class="page-item"><a class="page-link" href="#">2</a></li>
		    <li class="page-item"><a class="page-link" href="#">3</a></li>
		    <li class="page-item">
				<a class="page-link" href="#" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
				</a>
		    </li>
		</ul>
	</nav>
	
</div>




<script>
	const bno = "${boardvo.boardNo}";
	const logId = "${logId}";
	
	document.querySelector('input[value="수정"]').addEventListener('click', function(e) {
		location.href = "modifyBoard.do?searchCondition=${searchCondition}&keyword=${keyword}&page=${page}&bno=${boardvo.boardNo}";
	});
	
	document.querySelector('input[value="삭제"]').addEventListener('click', function(e) {
		location.href = "deleteBoard.do?searchCondition=${searchCondition}&keyword=${keyword}&page=${page}&bno=${boardvo.boardNo}";
	});
</script>

<script src="js/replyService.js"></script>
<script src="js/reply.js"></script>


