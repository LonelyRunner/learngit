<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>catch标签</title>
</head>
<body>
	<!-- 捕获可能出现的异常 -->
	<c:catch var="error">
		<c:set target="aa" property="bb" value="abcd"></c:set>
	</c:catch>
	<c:out value="${error}"></c:out>
</body>
</html>