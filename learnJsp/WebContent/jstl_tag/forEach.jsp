<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>froEach标签</title>
</head>
<body>
	<!-- 定义一个集合 -->
	<%
		List<String> fruits = new ArrayList<String>();
		fruits.add("apple");
		fruits.add("orange");
		fruits.add("pear");
		fruits.add("watermelon");
		fruits.add("banana");
		fruits.add("grape");
		request.setAttribute("fruits", fruits);
	%>
	<!-- 
		forEach中各属性的解释
		var : 相当于java中for(String string : strList)中的string
		items : 当前遍历的集合
		begin : 遍历的开始位置
		end : 遍历的结束位置
		step : 遍历的步长  默认为1
		varStatus : 遍历当前对象的状态 四个属性 
			index-在原先集合中的位置  0开始
			count-在当前集合中的位置  1开始
			first-在当前集合中是否第一个元素  boolean类型
			last-在当前集合中是否为最后一个元素 boolean类型
	 -->
	<!-- 全部遍历 -->
	<c:forEach var="fruit" items="${fruits}">
		<c:out value="${fruit}"></c:out><br/>
	</c:forEach>
	<hr>
	<!-- 部分遍历 -->
	<c:forEach var="fruit" items="${fruits}" begin="2" end="4">
		<c:out value="${fruit}"></c:out><br/>
	</c:forEach>
	<hr/>
	<!-- 指定步长遍历 -->
	<c:forEach var="fruit" items="${fruits}" step="2">
		<c:out value="${fruit}"></c:out><br/>
	</c:forEach>
	<!-- 当前对象的状态 -->
	<c:forEach var="fruit" items="${fruits}" varStatus="curFruStatus">
		<c:out value="${fruit}当前状态"></c:out><br/>
		<c:out value="index在原先集合中的位置:${curFruStatus.index}"></c:out><br/>
		<c:out value="count在当前集合中的位置:${curFruStatus.count}"></c:out><br/>
		<c:out value="first是否第一个元素:${curFruStatus.first}"></c:out><br/>
		<c:out value="last是否最后一个元素:${curFruStatus.last}"></c:out><br/>
	</c:forEach>
</body>
</html>