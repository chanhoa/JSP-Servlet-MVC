<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/2/2021
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Update</h1>
<form action="${pageContext.request.contextPath}/home-sv">

    <input type="hidden" name="command" value="UPDATE">
    <input type="hidden" name="id" value="${cate.id}">
    Name : <input name="name" value="${cate.categoryName}">
    <input type="submit" class="ui-button" value="save">
</form>
</body>
</html>
