<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>삭제화면(deleteForm.jsp)</h3>

<form action="deleteBoard.do" method="post">
	<input type="hidden" name="bno" value="${boardvo.boardNo }">
	<input type="hidden" name="page" value="${page.page }">
	<input type="hidden" name="searchCondition" value="${searchCondition }">
	<input type="hidden" name="keyword" value="${keyword }">
	
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${boardvo.boardNo }</td>
			<th>조회</th>
			<td>${boardvo.viewCnt }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${boardvo.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">${boardvo.content }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3">${boardvo.writer }</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="submit" value="삭제" class="btn btn-success">
				<input type="reset" value="취소" class="btn btn-warning">
			</td>
		</tr>
	</table>

</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>


<script>
	document.querySelector('input[value="취소"]').addEventListener('click', function(e) {
		location.href = "board.do?searchCondition=" + ${searchCondition } + "&keyword=" + ${keyword } + "&page=" + ${page } + "&bno=" + ${boardvo.boardNo };
	});
</script>
    