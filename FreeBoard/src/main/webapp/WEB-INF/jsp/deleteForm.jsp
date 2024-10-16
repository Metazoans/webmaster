<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>삭제화면(deleteForm.jsp)</h3>

<%
	String msg = (String) request.getAttribute("msg");
	String pg = (String) request.getAttribute("page");
	BoardVO board = (BoardVO) request.getAttribute("boardvo");
	
	String sc = (String) request.getAttribute("searchCondition");
	String kw = (String) request.getAttribute("keyword");
	kw = kw == null ? "" : kw;
%>
<%if(msg != null) { %>
<p style="color:red;"><%=msg %></p>
<%} %>

<form action="deleteBoard.do" method="post">
	<input type="hidden" name="bno" value="<%=board.getBoardNo() %>">
	<input type="hidden" name="page" value="<%=pg %>">
	<input type="hidden" name="searchCondition" value="<%=sc %>">
	<input type="hidden" name="keyword" value="<%=kw %>">
	
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><%=board.getBoardNo() %></td>
			<th>조회</th>
			<td><%=board.getViewCnt() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><%=board.getTitle() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><%=board.getContent() %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3"><%=board.getWriter() %></td>
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
		location.href = 'board.do?searchCondition=<%=sc %>&keyword=<%=kw %>&page=<%=pg %>&bno=<%=board.getBoardNo() %>';
	});
</script>
    