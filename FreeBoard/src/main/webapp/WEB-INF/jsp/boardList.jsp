<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>글목록(boardLilst.jsp)</h3>

<form action="boardList.do" class="row g-3">
	<div class="col-md-3">
		<select name="searchCondition" class="form-select">
			<option selected value="">선택하세요.</option>
			<option value="T" ${searchCondition=="T" ? "selected" : "" } >제목</option>
			<option value="W" ${searchCondition=="W" ? "selected" : "" }  >작성자</option>
			<option value="TW" ${searchCondition=="TW" ? "selected" : "" }  >제목 & 작성자</option>
		</select>
	</div>
	<div class="col-md-4">
		<input type="text" class="form-control" name="keyword" value='${keyword}'>
	</div>
	<div class="col-md-5">
		<button type="submit" class="btn btn-primary">조 회</button>
	</div>
</form>

<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="board" items="${boardList }">
			<tr>
				<td><c:out value="${board.boardNo }" ></c:out></td>
				<td><a href='board.do?searchCondition=${searchCondition }&keyword=${keyword }&page=${page.page }&bno=${board.boardNo}'>${board.title }</a></td>
				<td><c:out value="${board.writer }" ></c:out></td>
				<td><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
				<td><c:out value="${board.viewCnt }" ></c:out></td>
			</tr>
		</c:forEach>
		
	</tbody>
</table>


<!-- paging -->
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${page.prev }">
				<li class="page-item">
					<a class="page-link" href="boardList.do?searchCondition=${searchCondition }&keyword=${keyword }&page=${page.startPage - 1 }">Prev</a>
				</li>
			</c:when>
			<c:otherwise>
			<li class="page-item disabled">
				<a class="page-link" href="boardList.do?searchCondition=${searchCondition }&keyword=${keyword }&page=${page.startPage }">Prev</a>
			</li>
			</c:otherwise>
		</c:choose>
		
		<!-- 페이지출력 -->
		<c:forEach var="p" begin="${page.startPage }" end="${page.endPage }">
			<c:choose>
				<c:when test="${page.page == p }">
					<li class="page-item active" aria-current="page">
						<span class="page-link">${p }</span>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item">
						<a class="page-link" href="boardList.do?searchCondition=${searchCondition }&keyword=${keyword }&page=${p }">${p }</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<!-- 다음페이지 -->
		
		<c:choose>
			<c:when test="${page.next }">
				<li class="page-item">
					<a class="page-link" href="boardList.do?searchCondition=${searchCondition }&keyword=${keyword }&page=${page.endPage + 1 }">Next</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled">
					<a class="page-link" href="boardList.do?searchCondition=${searchCondition }&keyword=${keyword }&page=${page.endPage }">Next</a>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>

<jsp:include page="../includes/footer.jsp"></jsp:include>
