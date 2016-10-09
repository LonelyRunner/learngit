<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
    <h1>新商品添加</h1>
    <s:form action="product_save" method="post" namespace="/" theme="simple">
        <table border="1" width="400">
            <tr>
                <td>商品名称</td>
                <td><s:textfield name="pname"></s:textfield></td>
            </tr>
            <tr>
                <td>商品名称</td>
                <td><s:textfield name="price"></s:textfield></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="添加"></td>
            </tr>
        </table>
    </s:form>
</body>
</html>
