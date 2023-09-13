<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="navigation">
	<ul>
		<c:choose>
			<c:when test="${empty authUser }">
				<li><a>로그인해라</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath }">홈으로</a></li>
			</c:otherwise>
		</c:choose>
		<li><a href="${pageContext.request.contextPath }/guestbook">방명록</a></li>
		<li><a href="${pageContext.request.contextPath }/board?begin=1&i=1">게시판</a></li>
	</ul>
</div>