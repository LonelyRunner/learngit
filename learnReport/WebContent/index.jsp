<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>  
<%@ page import="bean.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp+servlet生成报表</title>
</head>
<body>
	<form action="showReport" method="post">
		<input type="submit" value="生成报表">
	</form>
	
	<table border=1 bgcolor="#677635">
		<tr>
			<td colspan="5" align=center>利润表</td>
		</tr>
		<tr>
			<th>序号</th>
			<th>商品名称</th>
			<th>商品数量</th>
			<th>交易笔数</th>
			<th>盈利额</th>
		</tr>
		<%
			List<Profit> list = (List<Profit>)session.getAttribute("profits");	
			if(list!=null && list.size()>0){
				for(int i=0;i<list.size();i++){
		%>
					<tr>
						<td><%= i+1 %></td>
						<td><%= list.get(i).getGoodsName() %></td>
						<td><%= list.get(i).getTradingNum() %></td>
						<td><%= list.get(i).getTimes() %></td>
						<td><%= list.get(i).getProfit() %></td>
					</tr>
		<%			
			}
		}
		%>
	</table>
</body>
</html>