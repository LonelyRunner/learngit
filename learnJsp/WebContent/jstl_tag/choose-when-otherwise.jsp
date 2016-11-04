<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>choose-when-otherwise</title>
</head>
<body>
	<form action="choose-when-otherwise.jsp" method=post>
		<input type="text" value="${param.score}" name="score">
		<input type="submit">
	</form>

	<c:choose>
		<c:when test="${param.score>=90 && param.score<=100 }">
			<c:out value="成绩优秀"></c:out>
		</c:when>
		<c:when test="${param.score>=60 && param.score<=89 }">
			<c:out value="成绩良好"></c:out>
		</c:when>
		<c:when test="${param.score>=0 && param.score<=59 }">
			<c:out value="再接再厉"></c:out>
		</c:when>
		<c:otherwise>
			<c:out value="您的输入不符合逻辑"></c:out>
		</c:otherwise>		
	</c:choose>
	
	<c:choose>
		<c:when test="${param.score==100}">
			<c:out value="Good,You are the best!"></c:out>
		</c:when>
	</c:choose>
</body>
</html>