<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td>${param.title }</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">${param.contents }</div>
						</td>
					</tr>
				</table>
				<div class="bottom">
					<a href="${pageContext.request.contextPath }/board?begin=1&i=1">글목록</a>
					<c:choose>
						<c:when test="${empty authUser }">

						</c:when>
						<c:when test="${authUser.getNo() == param.userNo }">
							<a
								href="${pageContext.request.contextPath }/board?a=updateboardorreplyform&no=${param.no}&userNo=${param.userNo}&title=${param.title}&contents=${param.contents}&groupNo=${param.groupNo}&depth=${param.depth}&orderNo=${param.orderNo}">글수정</a>
						</c:when>
						<c:otherwise>

						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${empty authUser }">
						</c:when>
						<c:otherwise>
							<a
						href="${pageContext.request.contextPath }/board?a=addreplyform&userNo=${param.userNo}&groupNo=${param.groupNo}&depth=${param.depth}&no=${param.no}&title=${param.title}&contents=${param.contents}&orderNo=${param.orderNo}">답글달기</a>
						</c:otherwise>
					</c:choose>
	
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>