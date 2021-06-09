<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/6/2021
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forgot Password</title>
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

    .divider-text span {
      padding: 7px;
      font-size: 12px;
      position: relative;
      z-index: 2;
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
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/"><span class="glyphicon glyphicon-log-in"></span> Back</a></li>
      </ul>
    </div>
  </div>
</nav><br><br><br>
<div align="center" style="height: 300px; width: 50%; margin-left: 32%">
  <div class="col-md-9 m-auto" >
    <c:if test="${message != null}">
      <h3 style="color: red"><c:out value="${message}"/></h3>
    </c:if>
    <div class="card">
      <div style="height: 50px; padding: 15px; background-color: lightpink" class="card-header bg-info"> <b>Forgot Password</b></div>
      <div class="card-body">
        <form class="form-horizontal" method="post" action="/users?action=ForgotPassword" >
          <p>  <label class="control-label">Username:</label>
            <input class="form-control" name="userName">
          </p>
          <p>  <label class="control-label">Phone:</label>
            <input class="form-control" name="phone">
          </p>
          <p><button type="submit" class="btn btn-warning">Send mail</button></p>
        </form>
      </div>
    </div>
  </div>
</div>
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
</body>
</html>

