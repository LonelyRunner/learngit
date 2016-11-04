<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- import导入绝对路径 -->
<c:catch var="error01">
	<c:import url="http://www.baidu.com"></c:import>
</c:catch>
<c:out value="${error01}"></c:out>
<hr/>
<!-- 导入当前路径下的learnJsp.txt -->
<c:catch var="error02">
	<c:import url="learnJsp.txt" charEncoding="GBK"></c:import>
</c:catch>
<c:out value="${error02}"></c:out>
<hr>
<!--  将请求的文件以string的方式保存 -->
<c:catch var="error03">
	<c:import url="learnJsp.txt" charEncoding="GBK" var="str" scope="session"></c:import>
</c:catch>
<c:out value="${error03}"></c:out>
<c:out value="${sessionScope.str}"></c:out>
<hr>
<!-- 导入不同application下面的jsp页面 content项目名字必须以'/'开头 -->
<c:catch var="error04">
	<c:import url="" context=""></c:import>
</c:catch>
<c:out value="${error04}"></c:out>

<hr>
</body>
</html>