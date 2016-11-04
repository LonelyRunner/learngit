<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="person" class="com.imooc.bean.Person" scope="page"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>set标签</title>
</head>
<body>
	<!-- set:存值到scope中 -->
	<!-- 将you存到page中  you的值为"zhangsan" -->
	<c:set value="zhangsan" var="you" scope="page"></c:set>
	<c:out value="${pageScope.you}"></c:out>
	
	<c:set var="he" scope="session">LiSi</c:set>
	<c:out value="${sessionScope.he}"></c:out>
	<br>
	<!-- 将值存到javaBean中  注意上面的jsp:javaBean标签-->
	<c:set target="${pageScope.person}" property="username" value="郑豪"></c:set>
	<c:out value="${person.username }"></c:out>
	
	<c:set target="${pageScope.person}" property="gender" value="true"></c:set>
	<c:out value="${person.gender }"></c:out>
	
	<c:set target="${pageScope.person}" property="age" value="24"></c:set>
	<c:out value="${person.age }"></c:out>
	
	<c:set target="${pageScope.person}" property="username">张三</c:set>
	<c:out value="${person.username }"></c:out>
	
	<c:set target="${pageScope.person}" property="gender">false</c:set>
	<c:out value="${person.gender }"></c:out>
	
	<c:set target="${pageScope.person}" property="age">18</c:set>
	<c:out value="${person.age }"></c:out>
	
</body>
</html>