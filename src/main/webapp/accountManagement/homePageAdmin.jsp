<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/4/2021
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Admin Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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

        .carousel-inner img {
            width: 100%; /* Set width to 100% */
            margin: auto;
            min-height: 200px;
        }

        /* Hide the carousel text when the screen is less than 600 pixels wide */
        @media (max-width: 600px) {
            .carousel-caption {
                display: none;
            }
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
      .thanh:hover{
          color: deeppink;
          font-family: "Apple Color Emoji", serif;
          font-size: medium;
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
                <li class="active">
                    <button>Home</button>
                </li>
                <li>
                    <form method="post" action="/orders">
                        <button style="height: auto" type="submit">Order List</button>
                    </form>
                </li>
                <li>
                    <form method="get" action="/users">
                        <button style="height: auto" type="submit">Users List</button>
                    </form>
                </li>
                <li>
                    <form method="post" action="/employee">
                        <button type="submit">Rental List</button>
                    </form>
                </li>
                <li>
                    <form method="post" action="/Services">
                        <button type="submit">Services</button>
                    </form>
                </li>
                <li>
                    <form method="post" action="/typeServices">
                        <button type="submit">typeServices</button>
                    </form>
                </li>
                <li>
                    <button><a href="https://www.facebook.com/xoa.hets.9">Contact</a></button>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/"><span class="glyphicon glyphicon-log-in"></span> Sign out</a></li>
            </ul>
        </div>
    </div>
</nav>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
        <li data-target="#myCarousel" data-slide-to="4"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img style="height: 550px; object-fit: cover"
                 src="https://www.wallpapertip.com/wmimgs/139-1399581_mikasa-ackerman-wallpaper-hinh-attack-on-titan.jpg"
                 alt="img">
            <div class="carousel-caption">
                <h3>Mikasa Ackerman 18</h3>
            </div>
        </div>
        <div class="item">
            <img style="height: 550px; object-fit: cover" src="https://wallpapercave.com/wp/wp5170725.jpg" alt="Image">
            <div class="carousel-caption">
                <h3>Queen of pain 20</h3>
            </div>
        </div>
        <div class="item">
            <img style="height: 550px; object-fit: cover" src="https://wallpapercave.com/wp/wp5537291.jpg" alt="Image">
            <div class="carousel-caption">
                <h3>Lina 16</h3>
            </div>
        </div>
        <div class="item">
            <img style="height: 550px; object-fit: cover" src="https://wallpapercave.com/wp/wp2539007.jpg" alt="Image">
            <div class="carousel-caption">
                <h3>Crystal Maiden 17</h3>
            </div>
        </div>
        <div class="item">
            <img style="height: 550px; object-fit: cover" src="https://wallpapercave.com/wp/wp5820989.jpg" alt="Image">
            <div class="carousel-caption">
                <h3>Luna 23</h3>
            </div>
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<div class="container text-center">
    <h3>What We Do</h3><br>
    <div class="row">
        <div class="col-sm-4">
            <img src="https://edgecast.production.backyard.verizonmedia.com/verizonmedia/s3fs-public/styles/featured/public/post/2020/03/27/tinder.png?h=3c8378b6&itok=5NBg_AD7"
                 class="img-responsive" style="width:100%;height: 200px; padding: 5px;object-fit: cover" alt="Image">
            <h4>Current Project</h4>
        </div>
        <div class="col-sm-4">
            <img src="https://cdn.watajob.com/photo/d8/06/d80646d0-4429-11eb-9dce-47010f84228e.jpg"
                 class="img-responsive" style="width:100%;height: 200px; padding: 5px;object-fit: cover" alt="Image">
            <h4>Project 2</h4>
        </div>
        <div style="margin-top: 50px" class="col-sm-4">
            <div class="well">
                <p class="thanh">Chân thành cảm ơn <b>Mr. Quân Nguyễn</b> đã giúp đỡ để chúng tôi hoàn thành project này</p>
            </div>
        </div>
    </div>
</div>
<br>
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