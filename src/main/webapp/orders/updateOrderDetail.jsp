<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
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
                <li><form style="margin-left: 10px" method="post" action="/orders"><button>List Order</button></form></li>
            </ul>
        </div>
    </div>
</nav>

<div align="center">
    <div class="container-fluid" style="background-color: #e3f2fd">
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <h1 style="margin: 10px; float:left">Edit Order</h1>
        </div>
    </div>
    <h1>
        <c:if test="${message!= null}">
            <p style="color: red"><c:out value="${message}"/></p>
        </c:if>
    </h1>

    <form method="post" action="/orders?action=edit&&id=${orderDetail.orderId}">

        <table class="table">
            <thead class="thead-light">
            <tr>
                <th style="text-align: right" scope="col">Property</th>
                <th scope="col">Data</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td style="text-align: right">User Id:</td>
                <td><input type="text" name="userId" value="${orderDetail.userId}"></td>
            </tr>
            <tr>
                <td style="text-align: right">Person Id:</td>
                <td><input type="text" name="personId" value="${orderDetail.personId}"></td>
            </tr>
            <tr>
                <td style="text-align: right">Price:</td>
                <td><input type="text" name="price" value="${orderDetail.price}"></td>
            </tr>
            <tr>
                <td style="text-align: right">Hours:</td>
                <td><input type="text" name="hours" value="${orderDetail.hours}"></td>
            </tr>
            <tr>
                <td style="text-align: right">Start Hour:</td>
                <td><input type="text" name="startHour" value="${orderDetail.startHour}"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button style="width: 100px; height: 50px" class="btn btn-success">Edit</button>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
    <footer class="site-footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-6">
                    <h6>About</h6>
                    <p class="text-justify">SỨ MỆNH CỦA CODEGYM <br>Phát triển các giải pháp học tập hiện đại và
                        hiệu quả thông qua các mô hình đào tạo tiên tiến trên nền tảng công nghệ giáo dục và sự
                        cộng tác sâu rộng giữa các bên liên quan, đặc biệt là doanh nghiệp trong thời đại Công nghiệp
                        4.0.</p>
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
</div>
</body>
</html>