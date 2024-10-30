<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="./WEB-INF/includes/header.jsp"></jsp:include>

	<h1>branch test222</h1>

	<!-- MVC 디자인: View(JSP페이지) , Model(DB처리) , 컨트롤 -->
	<!-- Expression Language : EL -->
	<!-- JSP action tag -->
	<!-- JSP Standard Tag Library : JSTL -->
	<p>${logId }</p>
	<c:set var="name" value="Hong"></c:set>
	<c:out value="${name }"></c:out>
	
	<c:set var="age" value="60"></c:set>
	<c:if test="${age >= 20 }">
		<p>성년입니다.</p>
	</c:if>	
	
	<c:choose>
		<c:when test="${age>=60 }">
			<p>노인</p>
		</c:when>
		<c:when test="${age>=20 }">
			<p>청년</p>
		</c:when>
		<c:otherwise>
			<p>미성년</p>
		</c:otherwise>
	</c:choose>
	
	<c:forEach var="i" begin="1" end="5" step="2">
		<p>i의 값은 ${i }입니다.</p>
	</c:forEach>
	
	<c:set var="page" value="boardList.do"></c:set>
	<jsp:forward page="${page }"></jsp:forward>

<jsp:include page="./WEB-INF/includes/footer.jsp"></jsp:include>
	