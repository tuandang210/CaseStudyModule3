<%--Created by IntelliJ IDEA.--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit employee</title>
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
<div align="center" style="width: 75%; position: relative; left: 17%">
    <form method="post">
        <table align = "center" class="table table-striped">
            <h2>  Edit Employee </h2>
            <tbody>
            <c:if test="${message != null}">
                <h3 style="color: red"><c:out value="${message}"/></h3>
            </c:if>

            <tr>
                <th>Employee's Name <span style = "color: red">*</span></th>
                <td>
                    <input type="text" name="name" size="50"
                           value="${rental.name}"/>
                    <c:if test="${warningName != null}">
                        <p style="color: red">${warningName}</p>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>Age <span style = "color: red">*</span></th>
                <td>
                    <select name = "age">
                        <c:forEach items="${validAges}"  var="age">
                            <c:if test="${age == rental.age}">
                                <option selected>${age}</option>
                            </c:if>
                            <c:if test="${age != rental.age}">
                                <option>${age}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Gender <span style = "color: red">*</span></th>
                <td>
                    <c:choose>
                        <c:when test="${rental.gender == 'female'}">
                            <input type="radio" id="female" name="gender" value="female" checked> Female<br>
                            <input type="radio" id="male" name="gender" value="male"> Male<br>
                            <input type="radio" id="other" name="gender" value="other"> Other<br />
                        </c:when>
                        <c:when test="${rental.gender == 'male'}">
                            <input type="radio" id="female" name="gender" value="female" > Female<br>
                            <input type="radio" id="male" name="gender" value="male" checked> Male<br>
                            <input type="radio" id="other" name="gender" value="other"> Other<br />
                        </c:when>
                        <c:otherwise>
                            <input type="radio" id="female" name="gender" value="female" > Female<br>
                            <input type="radio" id="male" name="gender" value="male" > Male<br>
                            <input type="radio" id="other" name="gender" value="other" checked> Other<br />
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>Status <span style = "color: red">*</span></th>
                <td>
                    <c:if test="${rental.status == true}">
                        <input type="radio" id="true" name="status" value="true" checked> Available<br>
                        <input type="radio" id="false" name="status" value="false" > Not available<br>
                    </c:if>
                    <c:if test="${rental.status == false}">
                        <input type="radio" id="true" name="status" value="true" > Available<br>
                        <input type="radio" id="false" name="status" value="false" checked> Not available<br>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>Phone <span style = "color: red">*</span></th>
                <td>
                    <input type="text" name="phone" size="10" value="${rental.phone}"/>
                    <c:if test="${warningPhone != null}">
                        <p style="color: red">${warningPhone}</p>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>Image URL <span style = "color: red">*</span></th>
                <td>
                    <input type="text" name="urlImage" size="50"
                           value="${rental.urlImage}"/>
                    <c:if test="${warningImage != null}">
                        <p style="color: red">${warningImage}</p>
                    </c:if>
                </td>
            </tr>
            <tr></tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" class="btn btn-success" value="Save"/>
                </td>
            </tr>
            </tbody>
        </table>

    </form>
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
