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
<h1>Create new person service </h1>
<p style="color: red"><c:out value="${message}"/></p>
<a href="/">|| back home ||</a>
<a href="/PersonServices">|| back list person service ||</a>
<form method="post">
    <table>
        <tr>
            <td>Person ID:</td>
            <td><select name="person_id">
                <c:forEach items="${personIDs}" var="person_id">
                    <option value="${person_id}"><c:out value="${person_id}"/></option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td>Service ID:</td>
            <td><select name="service_id">
                <c:forEach items="${serviceIDs}" var="service_id">
                    <option value="${service_id}"><c:out value="${service_id}"/></option>
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
