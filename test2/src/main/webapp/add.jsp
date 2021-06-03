<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/2/2021
  Time: 12:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/home-sv">

    <input type="hidden" name="command" value="ADD">
    <input type="hidden" name="id" value="${cate.id}">
    Name : <input name="name" value="${cate.categoryName}">
    <input type="submit" class="ui-button" value="add">
</form>

</body>
</html>
