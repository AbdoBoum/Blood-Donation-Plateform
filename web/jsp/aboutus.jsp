<%--
  Created by IntelliJ IDEA.
  User: Anass
  Date: 29/01/2019
  Time: 02:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="Header.jsp" %>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style>
        body { -webkit-font-smoothing: antialiased; text-rendering: optimizeLegibility; font-family: 'Overpass', sans-serif; letter-spacing: 0px; font-size: 17px; color: #8d8f90; font-weight: 400; line-height: 32px; background-color: #edefef; }
        h1, h2, h3, h4, h5, h6 { color: #25292a; margin: 0px 0px 10px 0px; font-family: 'Overpass', sans-serif; font-weight: 700; letter-spacing: -1px; line-height: 1; }
        h1 { font-size: 34px; }
        h2 { font-size: 28px; line-height: 38px; }
        h3 { font-size: 22px; line-height: 32px; }
        h4 { font-size: 20px; }
        h5 { font-size: 17px; }
        h6 { font-size: 12px; }
        p { margin: 0 0 20px; line-height: 1.7; }
        p:last-child { margin: 0px; }
        ul, ol { }
        a { text-decoration: none; color: #8d8f90; -webkit-transition: all 0.3s; -moz-transition: all 0.3s; transition: all 0.3s; }
        a:focus, a:hover { text-decoration: none; color: #f85759; }



        .page-header { background: url(https://i.ibb.co/DC3pgk0/20180109164144-donazione-sangue.png)no-repeat; position: relative; background-size: cover; }
        .page-caption { padding-top: 170px; padding-bottom: 174px; }
        .page-title { font-size: 46px; line-height: 1; color: #fff; font-weight: 600; text-align: center; }

        .card-section { position: relative; bottom: 60px; }
        .card-block { padding: 80px; }
        .section-title { margin-bottom: 60px; }
    </style>
</head>
<body>
<%@include file="Navbar.jsp" %>

<!-- page-header -->
<div class="page-header">
    <div class="container">
        <div class="row">
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                <div class="page-caption">
                    <h1 class="page-title">About BLOOD BROTHERS</h1>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /.page-header-->
<!-- news -->
<div class="card-section">
    <div class="container">
        <div class="card-block bg-white mb30">
            <div class="row">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <!-- section-title -->
                    <div class="section-title mb-0">
                        <h2>All About BLOOD BROTHERS.</h2>
                        <p>The Blood Brothers web application answers people's frequently asked questions about blood donation in a FAQ area, blood centers can express their needs and manage their inventory and visualize them through graphs and report alarms of lack of stock of blood that will be broadcast to others blood centers and also sent to users of the platform.
                            <br>
                            Users have a space where they can write articles, share their experiences with blood donation, give feedback that will ban stereotypes and reinforce the spirit of belonging. At most volunteers we will operate charity clubs in schools that are numerous as well as volunteer groups on social networks.. </p>
                    </div>
                    <!-- /.section-title -->
                </div>
            </div>
        </div>

    </div>
</div>
</div>
<%@include file="Footer.jsp" %>
</body>
</html>
