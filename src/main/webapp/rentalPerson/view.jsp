<%--Created by IntelliJ IDEA.--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <style>
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

        .col-sm-4:hover{
            border: white;
        }
        .col-sm-4{
            border: 5px solid white;
        }

        #firstRow {
            width: 20%;
        }

        .title {
            font-size: 22px;
            font-weight: bold;
        }

        table {
            background-color: plum;
            border: 5px solid plum;
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
                        <button type="submit">Home</button>
                    </form>
                </li>
                <li>
                    <form method="post" action="/employee">
                        <button type="submit">Back to Employee List</button>
                    </form>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="/"><span class="glyphicon glyphicon-log-in"></span> Sign out</a></li>
            </ul>
        </div>
    </div>
</nav>

<div id = "delete-form" align="center" style = "width: 50%; position: relative; left: 25%">
        <fieldset>
            <br/>
            <p class="title">Employee Information</p>
            <table align="center" width="75%" height="50%">
                <tr id="firstRow">
                    <td rowspan="5"><img src="${rental.urlImage}" alt="Not available" style="object-fit: cover"></td>
                    <td colspan="2"><p class="title">${rental.id}. ${rental.name}</p></td>
                </tr>
                <tr>
                    <td><p><b>Age: </b></p></td>
                    <td><p>${rental.age}</p></td>
                </tr>
                <tr>
                    <td><p><b>Gender: </b></p></td>
                    <td><p>${rental.gender}</p></td>
                </tr>
                <tr>
                    <td><p><b>Status: </b></p></td>
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
                    <td><p><b>Phone: </b></p></td>
                    <td><p>${rental.phone}</p></td>
                </tr>
            </table>
            <br/>
        </fieldset>
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
