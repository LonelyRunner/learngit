<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>out标签详解</title>
</head>
<body>
	<!-- 输出常量 -->
	<c:out value="this is out 标签 常量"></c:out>
	<br>
	<!-- 定义一个变量 -->
	<% session.setAttribute("name", "一个sb"); %>
	<!-- 输出变量 -->
	<c:out value="${sessionScope.name}"></c:out>
	<br>
	<!-- 如果变量未定义  default可以默认作为输出 -->
	<c:out value="${sessionScope.abc }" default="ABCDEFG"></c:out>
	<br>
	<!-- 对特殊符号进行转义 escapeXml对特殊符号进行转义 -->
	<c:out value="&ltout标签&gt" escapeXml="false"></c:out>
	<br>
</body>
</html>