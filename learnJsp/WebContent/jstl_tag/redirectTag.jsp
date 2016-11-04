<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>redirectTag标签的使用</title>
</head>
<body>
	<!-- 打开此jsp页面  直接跳转至firstDemo.jsp页面 -->
	<c:redirect url="firstDemo.jsp">
		<c:param name="username" value="Lily"></c:param>
		<c:param name="password" value="password"></c:param>
	</c:redirect>
</body>
</html>