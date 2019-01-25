<%--
  Created by IntelliJ IDEA.
  User: Anass
  Date: 24/01/2019
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->

    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css"/>
    <%@include file="Header.jsp" %>

    <style>
        *{
            font-size: 16px;
        }
        .glyphicon-tint { color:#e74c3c;}
        .glyphicon-comment { color:#27ae60;}
    </style>
</head>
<body>
<%@include file="Navbar.jsp" %>
<main>

    <div class="container">
        <br><br><br>
        <div class="row mb-4 mt-3">

            <div class="col-6">
                <form class="form-inline md-form mr-auto d-none" action="blog">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search"
                           name="keyword">
                    <button class="btn btn-red btn-rounded btn-md my-0" type="submit">Search</button>
                </form>
            </div>


            <div class="col-md-6 text-right mt-3">

                <a class="btn btn-red ${empty sessionScope.centre ? 'invisible': ''}" href="addRequest" style="font-size: 15px;">New Request</a>

            </div>

        </div>
        <!--Section: Requests-->
        <section>
            <c:forEach items="${requests}" var="request">
                <div class="well">
                    <div class="media">
                        <div class="pull-left col-xs-2 col-xs-3 text-center">
                            <img class="media-object img-responsive img-rounded" src="${request.pathImgRequest.substring(55)}">
                        </div>
                        <div class="media-body">
                            <h2 class="media-heading">${request.titleRequest}</h2>
                            <p class="text-right">By ${request.centerName}</p>
                            <p>${request.descriptionRequest}</p>
                            <ul class="list-inline list-unstyled">
                                <li><span><i class="glyphicon glyphicon-calendar"></i> ${request.dateRequest} </span></li>
                                <li>|</li>
                                <li><span><i class="glyphicon glyphicon-map-marker"></i> ${request.nameVilleRequest} </span></li>
                                <li>|</li>
                                <li><span><i class="glyphicon glyphicon-tint"></i> ${request.sangGroups} </span></li>
                                <li>|</li>
                                <span><i class="glyphicon glyphicon-comment"></i> 2 comments</span>
                                <li>|</li>
                                <li>
                                    <!-- Use Font Awesome http://fortawesome.github.io/Font-Awesome/ -->
                                    <span><i class="fa fa-facebook-square"></i></span>
                                    <span><i class="fa fa-twitter-square"></i></span>
                                    <span><i class="fa fa-google-plus-square"></i></span>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

            </c:forEach>

            <!--Pagination-->

            ${pg.showPagination("requests")}

            <!--Pagination-->
        </section>

    </div>
</main>

<%@include file="Footer.jsp" %>

</body>
</html>
