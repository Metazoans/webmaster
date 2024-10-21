<%@page import="com.yedam.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h3>회원목록</h3>
<table class="table">
	<tbody>
		<c:forEach var="member" items="${memberList }">
			<tr>
				<td>${member.memberId }</td>
				<td>${member.memberName }</td>
				<td>${member.phone }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

