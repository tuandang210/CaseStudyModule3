<%--
  Created by IntelliJ IDEA.
  User: 233linhnam
  Date: 6/4/2021
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
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
            <h1 style="margin: 10px; float:left">Order Detail</h1>
        </div>
    </div><br>

    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">Property</th>
            <th style="text-align: left" scope="col">Data</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Order Id:</td>
            <td style="text-align: left">${requestScope["orderDetail"].getOrderId()}</td>
        </tr>
        <tr>
            <td>User Id:</td>
            <td style="text-align: left">${requestScope["orderDetail"].getUserId()}</td>
        </tr>
        <tr>
            <td>Person Id:</td>
            <td style="text-align: left">${requestScope["orderDetail"].getPersonId()}</td>
        </tr>
        <tr>
            <td>Price:</td>
            <td style="text-align: left">${requestScope["orderDetail"].getPrice()}</td>
        </tr>
        <tr>
            <td>Hours:</td>
            <td style="text-align: left">${requestScope["orderDetail"].getHours()}</td>
        </tr>
        <tr>
            <td>Start Hour:</td>
            <td style="text-align: left">${requestScope["orderDetail"].getStartHour()}</td>
        </tr>
        </tbody>
    </table>
</div><br>
<footer class="site-footer">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-6">
                <h6>About</h6>
                <p class="text-justify">S??? M???NH C???A CODEGYM <br>Ph??t tri???n c??c gi???i ph??p h???c t???p hi???n ?????i v??
                    hi???u qu??? th??ng qua c??c m?? h??nh ????o t???o ti??n ti???n tr??n n???n t???ng c??ng ngh??? gi??o d???c v?? s???
                    c???ng t??c s??u r???ng gi???a c??c b??n li??n quan, ?????c bi???t l?? doanh nghi???p trong th???i ?????i C??ng nghi???p
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
</body>
</html>