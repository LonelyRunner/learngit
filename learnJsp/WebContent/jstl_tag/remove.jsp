<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>remove标签</title>
</head>
<body>
	<!-- remove标签只能移除一个变量值  而不能移除对象的属性值 -->
	<c:set var="firstName">李</c:set>
	<c:set var="lastName">圣杰</c:set>
	<c:remove var="firstName"/>
	<c:out value="${firstName}"></c:out>
	<c:out value="${lastName}"></c:out>
</body>
</html>