<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>등록화면(boardForm.jsp)</h3>

<%
	String msg = (String) request.getAttribute("msg");
%>
<%if(msg != null) { %>
<p style="color:red;"><%=msg %></p>
<%} %>
<form action="addBoard.do" method="post">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" class="form-control"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" rows="3" cols="30" class="form-control"></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" class="form-control"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="저장" class="btn btn-success">
				<input type="reset" value="취소" class="btn btn-warning">
			</td>
		</tr>
	</table>
</form>


<jsp:include page="../includes/footer.jsp"></jsp:include>