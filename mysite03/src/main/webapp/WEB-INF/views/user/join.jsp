<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/user.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="user">

				<form id="join-form" name="joinForm" method="post"
					action="${pageContext.request.contextPath }/user/join">
					<label class="block-label" for="name">이름</label> <input id="name"
						name="name" type="text" value="${userVo.name}">

					<p style="padding: 3px 0 0 0; text-align: left; color: #ff0000">
						<spring:hasBindErrors name="userVo">
							<!--  bean의 이름 class명 앞을 소문자로 넣기 -->
							<c:if test="${errors.hasFieldErrors('name') }">
								<strong>${errors.getFieldError('name').defaultMessage }</strong>
							</c:if>
						</spring:hasBindErrors>

					</p>

					<label class="block-label" for="email">이메일</label> <input
						id="email" name="email" type="text" value=""> <input
						type="button" value="중복체크">
					<p style="padding: 3px 0 0 0; text-align: left; color: #ff0000">
						<spring:hasBindErrors name="userVo">
							<!--  bean의 이름 class명 앞을 소문자로 넣기 -->
							<c:if test="${errors.hasFieldErrors('email') }">
								<strong>${errors.getFieldError('email').defaultMessage }</strong>
							</c:if>
						</spring:hasBindErrors>

					</p>

					<label class="block-label">패스워드</label> <input name="password"
						type="password" value="">
					
					<p style="padding: 3px 0 0 0; text-align: left; color: #ff0000">
						<spring:hasBindErrors name="userVo">
							<!--  bean의 이름 class명 앞을 소문자로 넣기 -->
							<c:if test="${errors.hasFieldErrors('password') }">
								<strong>${errors.getFieldError('password').defaultMessage }</strong>
							</c:if>
						</spring:hasBindErrors>

					</p>

					<fieldset>
						<legend>성별</legend>
						<label>여</label> <input type="radio" name="gender" value="female"
							checked="checked"> <label>남</label> <input type="radio"
							name="gender" value="male">
					</fieldset>

					<fieldset>
						<legend>약관동의</legend>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>

					<input type="submit" value="가입하기">

				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>