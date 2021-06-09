<%--Created by IntelliJ IDEA.--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        table {
            text-align: center;
        }

        a:hover {
            color: red;
        }

        b:hover {
            color: red;
        }

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
            <ul class="nav navbar-nav">
                <li class="active"><a>Home</a></li>
                <li>
                    <form method="post" action="/login?action=login">
                        <input hidden name="passWord" value="${passWord}">
                        <input hidden name="userName" value="${userName}">
                        <button style="margin-left: 10px" type="submit">Homepage</button>
                    </form>
                </li>
                <li>
                    <a style="margin-left: -10px" href="/orders?action=create">Create Order</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid" style="background-color: #e3f2fd">
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <h1 style="margin: 10px; float:left">Employee Detail</h1>
    </div>
</div>
<h1><c:if test="${message!= null}">
    <p style="color: red"><c:out value="${message}"/></p>
</c:if></h1><br>


<div align="center">
    <fieldset>
        <table align="center" width="75%" height="50%">
            <tr id="firstRow">
                <td rowspan="5"><img style="object-fit: cover" src="${rental.urlImage}" alt="Not available" width=200 height=280></td>
                <td colspan="2"><p class="title">${rental.id}. ${rental.name}</p></td>
            </tr>
            <tr>
                <td><p>Age: </p></td>
                <td><p>${rental.age}</p></td>
            </tr>
            <tr>
                <td><p>Gender: </p></td>
                <td><p>${rental.gender}</p></td>
            </tr>
            <tr>
                <td><p>Status: </p></td>
                <td>
                    <c:if test="${rental.status == true}">
                        <p>Available</p>
                    </c:if>
                    <c:if test="${rental.status == false}">
                        <p>Not Available</p>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td><p>Phone: </p></td>
                <td><p>${rental.phone}</p></td>
            </tr>

        </table>
    </fieldset>
</div><br><br>
<footer style="background-color: #D8D4D7" class="site-footer">
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
