<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
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

        .divider-text {
            position: relative;
            text-align: center;
            margin-top: 15px;
            margin-bottom: 15px;
        }

        .divider-text span {
            padding: 7px;
            font-size: 12px;
            position: relative;
            z-index: 2;
        }

        .divider-text:after {
            content: "";
            position: absolute;
            width: 100%;
            border-bottom: 1px solid #ddd;
            top: 55%;
            left: 0;
            z-index: 1;
        }

        .btn-facebook {
            background-color: #405D9D;
            color: #fff;
        }

        .btn-twitter {
            background-color: #42AEEC;
            color: #fff;
        }
    </style>
</head>
<body ng-app="myapp">

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
</nav>

<div align="center">
    <div class="container-fluid" style="background-color: #e3f2fd">
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <h1 style="margin: 10px; float:left">Register</h1>
        </div>
    </div>
    <h1><c:if test="${message!= null}">
        <p style="color: red"><c:out value="${message}"/></p>
    </c:if></h1>
</div>


<div align="center" class="card bg-light">
    <article class="card-body mx-auto" style="max-width: 400px;">
        <h4 class="card-title mt-3 text-center">Create Account</h4>
        <p class="text-center">Get started with your free account</p>
        <p>
            <a style="background-color: pink" href="" class="btn btn-block btn-twitter"> <i class="fab fa-twitter"></i>
                  Login via Twitter</a>
            <a style="background-color: hotpink" href="" class="btn btn-block btn-facebook"> <i
                    class="fab fa-facebook-f"></i>   Login via facebook</a>
        </p>
        <p class="divider-text">
            <span class="bg-light">OR</span>
        </p>
        <form method="post">
            <div class="form-group input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                </div>
                <input name="userName" class="form-control" placeholder="Username" type="text">
            </div> <!-- form-group// -->
            <div class="form-group input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                </div>
                <%--                <div style="height: 50px" ng-controller="PasswordController">--%>
                <%--                    <div id="checkPassWord" ng-style="passwordStrength"></div>--%>
                <%--                    <div style="float: left; width: 100px">--%>
                <%--                        <input style="    margin-left: -146px;width: 196px;" id="passWord" placeholder="Password" name="passWord" class="form-control" type="text"--%>
                <%--                               ng-model="password"--%>
                <%--                               onkeyup="checkPassWord()" ng-change="analyze(password)"--%>
                <%--                        />--%>
                <%--                    </div>--%>
                <%--                </div>--%>
                <input name="passWord" id="passWord" class="form-control" onkeyup="checkPassWord()"
                       placeholder="Create password" type="password">
            </div> <!-- form-group// -->
            <div class="form-group input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                </div>
                <div style="color:red;" id="checkPhone"></div>
                <input name="phone" id="phone" value="" onkeyup="checkNumberPhone()" class="form-control"
                       placeholder="Phone number" type="number">
            </div> <!-- form-group// -->
            <div class="form-group input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                </div>
                <input name="gender" class="form-control" placeholder="Gender" type="text">
            </div> <!-- form-group// -->
            <div class="form-group input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                </div>
                <input name="level" readonly value="1" class="form-control">
            </div> <!-- form-group// -->
            <div class="form-group">
                <button style="background-color: deeppink" type="submit" class="btn btn-primary btn-block"> Create
                    Account
                </button>
            </div> <!-- form-group// -->
            <p class="text-center">Have an account? <a href="/">Log In</a></p>
        </form>
    </article>
</div> <!-- card.// -->

</div>
<!--container end.//-->

<br><br>


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

<%--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>--%>
<script src="../css/bootstrap-5.0.1-dist/js/bootstrap.bundle.js"></script>
</body>
</html>
<script>
    function checkNumberPhone() {
        let phone = document.getElementById("phone").value;
        console.log(phone.length)
        if (phone.length === 10) {
            document.getElementById("checkPhone").style.color = "blue";
            document.getElementById("checkPhone").innerHTML = "YES !"
        } else {
            document.getElementById("checkPhone").style.color = "red";
            document.getElementById("checkPhone").innerHTML = "Must be 10 numbers !!!"
        }
    }

    function checkPassWord() {
        let passWord = document.getElementById("passWord").value;
        if (passWord.length > 5) {
            document.getElementById("checkPassWord").style.color = "blue";
            document.getElementById("checkPassWord").innerHTML = "YES !"
        } else {
            document.getElementById("checkPassWord").style.color = "yellow";
            document.getElementById("checkPassWord").innerHTML = "Must be 6 numbers !!!"
        }
    }

    // const myApp = angular.module("myapp", []);
    // myApp.controller("PasswordController", function ($scope) {
    //
    //     const strongRegex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    //     const mediumRegex = new RegExp("^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})");
    //
    //     $scope.passwordStrength = {
    //         "float": "left",
    //         "width": "100px",
    //         "height": "25px",
    //         "margin-left": "95px",
    //         "margin-top": "37px"
    //     };
    //
    //     $scope.analyze = function (value) {
    //         if (strongRegex.test(value)) {
    //             $scope.passwordStrength["background-color"] = "green";
    //         } else if (mediumRegex.test(value)) {
    //             $scope.passwordStrength["background-color"] = "orange";
    //         } else {
    //             $scope.passwordStrength["background-color"] = "red";
    //         }
    //     };
    //
    // });
</script>
