<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.zh.sweb.entity.Person" %><%--
  Created by IntelliJ IDEA.
  User: ZH
  Date: 2017/3/30
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
      //1. 获取application域对象中得到IOC容器
      ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
      //2.从IOC容器中得到Bean
      Person p = ctx.getBean(Person.class);
      //使用Bean
      p.sayhello();
    %>
  </body>
</html>
