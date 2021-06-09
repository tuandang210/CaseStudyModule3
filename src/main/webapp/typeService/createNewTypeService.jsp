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
</head>
<body>
<h1>Create new type service </h1>
<link href="../css/editStyle.css" rel="stylesheet" type="text/css">

<p style="color: red"><c:out value="${message}"/></p>
<a href="/">|| back home ||</a>
<a href="/typeServices">|| back list type of service ||</a>
<form method="post" >
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="type_name"></td>
        </tr>
        <tr><td></td>
            <td><button type="reset">reset</button>     <button type="submit">submit</button></td>
        </tr>
    </table>
</form>

</body>
</html>
