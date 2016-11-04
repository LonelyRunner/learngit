<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forTokens标签</title>
</head>
<body>
	<% 
		String telphoneNumber = "010-88648895-321"; 
		request.setAttribute("telphoneNumber", telphoneNumber);
	%>
	<!-- 
		delims分隔符 
		items需要分割的对象 
		var保存当前遍历的对象 
	-->
	<c:forTokens items="${telphoneNumber}" delims="-" var="number">
		<c:out value="${number }"></c:out><br>
	</c:forTokens>
</body>
</html>