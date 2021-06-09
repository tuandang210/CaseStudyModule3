<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/6/2021
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
<h1>List type service </h1>
<form method="post" action="/login?action=login">
    <input hidden name="passWord" value="${passWord}">
    <input hidden name="userName" value="${userName}">
    <button type="submit">back home</button>
</form>
<a href="/typeServices?action=create">|| create new ||</a>
<p style="color: red"><c:out value="${message}"/></p>
<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${types}" var="service_id">
        <tr>
            <td><c:out value="${service_id.id}"/></td>
            <td><c:out value="${service_id.name}"/></td>
            <td><a href="/typeServices?action=edit&type_id=${service_id.id}">Edit</a></td>
            <td><a href="/typeServices?action=delete&type_id=${service_id.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
