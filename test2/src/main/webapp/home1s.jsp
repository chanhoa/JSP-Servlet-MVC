<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/1/2021
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách đồ uống</title>
</head>
<body>

<h1>Danh sách menu</h1>


<c:forEach items="${list}" var="t">
    <c:url var="tempLink" value="home-sv">
        <c:param name="command" value="LOAD"/>
        <c:param name="id" value="${t.id}"/>
    </c:url>
    <c:url var="deleteLink" value="home-sv">
        <c:param name="command" value="DELETE"/>
        <c:param name="id" value="${t.id}"/>
    </c:url>

    <ul>${t.id} -- ${t.categoryName}   <a href="${tempLink}">Update</a>
        |
        <a href="${deleteLink}"
           onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
            Delete</a></ul>
</c:forEach>
<input type="button" value="Add "
       onclick="window.location.href='add.jsp'; return false;"
       class="add-student-button"
/>

</body>
</html>
