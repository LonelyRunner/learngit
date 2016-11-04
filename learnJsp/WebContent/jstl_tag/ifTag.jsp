<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>if标签</title>
</head>
<body>
	<form action="ifTag.jsp" method="post">
		<input type=text name="score" value="${param.score}">
		<input type="submit">
	</form>
	<!-- test中存放表达式  通常为EL表达式   var为test的执行结果   scope表示将var的值保存到某一scope中 -->
	<c:if test="${param.score>=90}" var="result" scope="page">
		<c:out value="恭喜你成绩优秀"></c:out>
	</c:if>
	<c:out value="${pageScope.result}"></c:out>
</body>
</html>