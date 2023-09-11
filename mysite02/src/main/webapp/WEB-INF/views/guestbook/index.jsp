<%@page import="java.util.List"%>
<%@page import="com.poscodx.mysite.vo.GuestbookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<GuestbookVo> list = (List<GuestbookVo>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath()%>/assets/css/guestbook.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="guestbook">
				<form action="<%=request.getContextPath()%>/guestbook" method="post">
					<input type="hidden" name="a" value="insert">
					<table>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name"></td>
							<td>비밀번호</td>
							<td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="message" id="message"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul>
					<li>
						<%
						for (int i = 0; i < list.size(); i++) {
						%>
						<table>
							<tr>
								<td><%=i + 1%></td>
								<td><%=list.get(i).getName()%></td>
								<td><%=list.get(i).getDate()%></td>
								<td><a
									href="<%=request.getContextPath()%>/guestbook?a=deleteform&no=<%=list.get(i).getNo()%>">삭제</a></td>
							</tr>
							<tr>
								<td colspan=4><%=list.get(i).getMessage()%></td>
							</tr>
						</table> <br> <%
										 }
									   %>
					</li>
				</ul>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>