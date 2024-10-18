<%@page import="com.yedam.service.BoardService"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>상세페이지(board.jsp)</h3>

<%
	BoardVO board = (BoardVO) request.getAttribute("boardvo");
	String pg = (String) request.getAttribute("page");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	String wdate = sdf.format(board.getUpdateDate());
	
	String sc = (String) request.getAttribute("searchCondition");
	String kw = (String) request.getAttribute("keyword");
	kw = kw == null ? "" : kw;
%>
0
<table class="table">
	<tr>
		<th>글번호</th>
		<td><%=board.getBoardNo() %></td>
		<th>조회수</th>
		<td><%=board.getViewCnt() %></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3"><%=board.getTitle() %></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3">
			<textarea readonly rows="4" cols="30" class="form-control"><%=board.getContent() %></textarea>
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="3"><%=board.getWriter() %></td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td colspan="3"><%=wdate %></td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="submit" value="수정" class="btn btn-warning">
			<input type="button" value="삭제" class="btn btn-danger">
		</td>
	</tr>
</table>

<jsp:include page="../includes/footer.jsp"></jsp:include>

<script>
	document.querySelector('input[value="수정"]').addEventListener('click', function(e) {
		location.href = 'modifyBoard.do?searchCondition=<%=sc %>&keyword=<%=kw %>&page=<%=pg %>&bno=<%=board.getBoardNo() %>';
	});
	
	document.querySelector('input[value="삭제"]').addEventListener('click', function(e) {
		location.href = 'deleteBoard.do?searchCondition=<%=sc %>&keyword=<%=kw %>&page=<%=pg %>&bno=<%=board.getBoardNo() %>';
	});
</script>