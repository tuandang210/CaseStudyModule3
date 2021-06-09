<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/4/2021
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<center>
    <h1>Employee Management</h1>
    <form method="post" action="/login?action=login">
        <input hidden name="passWord" value="${passWord}">
        <input hidden name="userName" value="${userName}">
        <button type="submit">Back Home Page</button>
    </form>
</center>

    <p>Sort by:
        <button><a href="/employee?sort=personId&type=asc">Sort By ID asc</a></button>
        <button><a href="/employee?sort=personId&type=desc">Sort By ID desc</a></button>
        <button><a href="/employee?sort=name&type=asc">Sort By Name asc</a></button>
        <button><a href="/employee?sort=name&type=desc">Sort By Name desc</a></button>
        <button><a href="/employee?sort=age&type=asc">Sort By Age asc</a></button>
        <button><a href="/employee?sort=age&type=desc">Sort By Age desc</a></button>
    </p>
    <table border="1" cellpadding="5" class="table table-hover">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Status</th>
            <th>Phone</th>
            <th>Image</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="rental" items="${rentals}">
            <tr>
                <td><c:out value="${rental.id}"/></td>
                <td><a href="/employee?action=viewEmployee&employeeId=${rental.id}">${rental.name}</a></td>
                <td><c:out value="${rental.age}"/></td>
                <td><c:out value="${rental.gender}"/></td>
                <td>
                    <c:if test="${rental.status == true}">
                        <p>Available</p>
                    </c:if>
                    <c:if test="${rental.status == false}">
                        <p>N/A</p>
                    </c:if>
                </td>
                <td><c:out value="${rental.phone}"/></td>
                <td><a href="${rental.urlImage}"><img src="${rental.urlImage}" alt="Not available" width=100 height=160></a>
                </td>
                <td><a style="margin-left: -10px" href="/orders?action=create">Create Order</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
