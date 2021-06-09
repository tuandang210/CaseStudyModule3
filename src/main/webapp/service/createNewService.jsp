<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/6/2021
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../css/editStyle.css" rel="stylesheet" type="text/css">

</head>
<body>
<h1>Create new type service </h1>
<p style="color: red"><c:out value="${message}"/></p>
<a href="/">|| back home ||</a>
<a href="/Services">|| back list service ||</a>
<form method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="service_name"></td>
        </tr>
        <tr>
            <td>Type:</td>
            <td><select name="type_id">
                <c:forEach items="${typeServices}" var="service_id">
                    <option value="${service_id.getId()}"><c:out value="${service_id.getName()}"/></option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="reset">reset</button>
                <button type="submit">submit</button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
