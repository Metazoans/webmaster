<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>로그인 화면(loginForm.jsp)</h3>

<form action="loginForm.do" method="post">
<table class="table">
	<tr>
		<th class="col-sm-2">아이디</th>
		<td><input type="text" name="logId" class="form-control">
	</tr>
	<tr>
		<th class="col-sm-2">비밀번호</th>
		<td><input type="password" name="logPw" class="form-control">
	</tr>
	<tr>
		<td align="center" colspan="2">
			<button type="submit" class="btn btn-primary">로그인</button>
		</td>
	</tr>
</table>
</form>


<jsp:include page="../includes/footer.jsp"></jsp:include>