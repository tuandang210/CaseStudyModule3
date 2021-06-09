<%--Created by IntelliJ IDEA.--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <style>
        table {
            text-align: center;
        }

        tr:hover {
            background-color: #e3f2fd;
        }

        a:hover {
            color: red;
        }

        b:hover {
            color: red;
        }

        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        /* Add a gray background color and some padding to the footer */
        footer {
            background-color: #f2f2f2;
            padding: 25px;
        }

        th {
            text-align: center;
        }

        button {
            margin-top: 14px;
            border: 0;
            margin-right: 10px;
            color: #9d9d9d;
            background-color: #222222;
        }

        button:hover {
            color: white;
        }

        .sort{
            height: 30px;
            padding:0;
            margin:0;
            background-color: darkgray;
            border: none;
            width: 225px;
        }

        .sort ul, .sort li{
            padding:0;
            margin:0;
        }

        .sort li{
            position: relative;
            float: left;
            list-style: none;
            margin: 0;
            padding:0;
        }

        .sort li a {
            width: 50px;
            height: 30px;
            display: block;
            text-decoration: none;
            text-align: center;
            line-height: 30px;
            background-color: darkgray;
            color: white;
        }

        .sort ul ul li a {
            width: 100px;
            text-align: left;
            padding-left: 10px;
        }

        .sort li a:hover{
            background-color: black;
        }

        .sort ul ul{
            position: absolute;
            top: 30px;
            left: 15px;
            visibility: hidden;
        }

        .sort ul li:hover ul{
            visibility: visible;
        }

        #sort-header{
            width: 75px;
            height: 30px;
            display: block;
            text-decoration: none;
            text-align: center;
            line-height: 30px;
            background-color: white;
            color: black;
        }

        #sort-header:hover{
            background-color: white;
        }

        input[type=text] {
            padding: 3px;
            margin-top: 8px;
            font-size: 17px;
            border: 1px solid grey;
        }

        .search-container {
            position: relative;
            left: 2.5%;
        }

        .search-container button {
            padding: 6px 10px;
            margin-top: 8px;
            margin-right: 16px;
            background: #ddd;
            font-size: 17px;
            border: none;
            cursor: pointer;
        }


        td {
            text-align: center;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand"><b id="tider"
                                       style=" font-size: 35px; color: deeppink; font-family: 'Apple Color Emoji',serif">Tider+</b></a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-left">

                <li>
                    <form method="post" action="/login?action=login">
                        <input hidden name="passWord" value="${passWord}">
                        <input hidden name="userName" value="${userName}">
                        <button type="submit">Home Page</button>
                    </form>
                </li>
                <li>
                    <a href="/employee?action=createEmployee">Add New Employee</a>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="/"><span class="glyphicon glyphicon-log-in"></span> Sign out</a></li>
            </ul>
        </div>
    </div>
</nav>


    <div align="center">
        <caption><h2>List of Employees</h2></caption>
        <div class="search-container">
            <form>
                <input type="text" placeholder="Search By Name" name="search">
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>
        </div>
        <br/>
        <div class = "sort">
            <ul>
                <li><a id = "sort-header">Sort By: </a></li>
                <li>
                    <a>ID</a>
                    <ul>
                        <li><a href = "/employee?sort=personId&type=asc">Ascending</a></li>
                        <li><a href = "/employee?sort=personId&type=desc">Descending</a></li>
                    </ul>
                </li>
                <li>
                    <a>Name</a>
                    <ul>
                        <li><a href = "/employee?sort=name&type=asc">Ascending</a></li>
                        <li><a href = "/employee?sort=name&type=desc">Descending</a></li>
                    </ul>
                </li>
                <li>
                    <a>Age</a>
                    <ul>
                        <li><a href = "/employee?sort=age&type=asc">Ascending</a></li>
                        <li><a href = "/employee?sort=age&type=desc">Descending</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <br/>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
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
                <tr >
                    <td style = "padding-top: 70px;"><c:out value="${rental.id}"/></td>
                    <td style = "padding-top: 70px;"><a href="/employee?action=viewEmployee&employeeId=${rental.id}">${rental.name}</a></td>
                    <td style = "padding-top: 70px;"><c:out value="${rental.age}"/></td>
                    <td style = "padding-top: 70px;"><c:out value="${rental.gender}"/></td>
                    <td style = "padding-top: 70px;">
                        <c:if test="${rental.status == true}">
                            <p>Available</p>
                        </c:if>
                        <c:if test="${rental.status == false}">
                            <p>N/A</p>
                        </c:if>
                    </td>
                    <td style = "padding-top: 70px;"><c:out value="${rental.phone}"/></td>
                    <td><a href = "${rental.urlImage}"><img src = "${rental.urlImage}" alt="Not available" style="object-fit: cover;" width = 100 height = 160></a></td>
                    <td style = "padding-top: 70px;">
                        <a href="/employee?action=editEmployee&employeeId=${rental.id}">Edit</a>
                    </td>
                    <td style = "padding-top: 70px;">
                        <a href="/employee?action=deleteEmployee&employeeId=${rental.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


        </table><br>
        <div class="container">
            <ul style="margin-left: 38%" class="pagination">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">...</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
        </div>



<footer class="site-footer">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-6">
                <h6>About</h6>
                <p class="text-justify">SỨ MỆNH CỦA CODEGYM <br>Phát triển các giải pháp học tập hiện đại và
                    hiệu quả thông qua các mô hình đào tạo tiên tiến trên nền tảng công nghệ giáo dục và sự
                    cộng tác sâu rộng giữa các bên liên quan, đặc biệt là doanh nghiệp trong thời đại Công nghiệp 4.0.
                </p>
            </div>

            <div class="col-xs-6 col-md-3">
                <h6>Categories</h6>
                <ul class="footer-links">
                    <li><a>Javascript</a></li>
                    <li><a>MySQL</a></li>
                    <li><a>PHP</a></li>
                    <li><a>Java</a></li>
                </ul>
            </div>

            <div class="col-xs-6 col-md-3">
                <h6>Quick Links</h6>
                <ul class="footer-links">
                    <li><a>About Us</a></li>
                    <li><a>Contact Us</a></li>
                    <li><a>Contribute</a></li>
                    <li><a>Privacy Policy</a></li>
                </ul>
            </div>
        </div>
        <hr>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-8 col-sm-6 col-xs-12">
                <p class="copyright-text">Copyright &copy; 2021 All Rights Reserved by
                    <a href="#">BotGiatTide</a>.
                </p>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
