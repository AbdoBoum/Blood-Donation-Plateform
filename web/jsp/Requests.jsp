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
<body class="grey lighten-5">
<%@include file="Navbar.jsp" %>
<main>

    <div class="container">
        <br><br><br>
        <div class="row mb-4 mt-3">

            <div class="col-6">
                <form class="form-inline md-form mr-auto" method="post" action="requests">
                    <select class="form-control mr-sm-2 my-0" style="font-size: 15px;"  name="citySelect">
                        <option value="default">Filter By City : </option>
                        <c:forEach items="${villes}" var="ville" >
                            <option value="${ville.nomVille}"><c:out value="${ville.nomVille}"/></option>
                        </c:forEach>
                    </select>
                    <select class="form-control mr-sm-2 my-0" style="font-size: 15px;" name="groupSangSelect">
                        <option value="default">Filter By blood group : </option>
                        <c:forEach items="${groupSangList}" var="groupSang" >
                            <option value="${groupSang.nameGroupe}"><c:out value="${groupSang.nameGroupe}"/></option>
                        </c:forEach>
                    </select>
                    <button class="btn btn-outline-info btn-rounded btn-md my-0 waves-effect" style="border-color: #D92228 !important; font-size: 10px; color: #D92228 !important;"  type="submit">Submit</button>
                </form>
            </div>


            <div class="col-md-6 text-right mt-3">

                <a class="btn btn-red  ${empty sessionScope.centre ? 'invisible': ''}" href="addRequest" style="font-size: 15px;">New Request</a>

            </div>

        </div>
        <!--Section: Requests-->
        <c:if test="${empty requests}">
            <!-- Card -->
            <!-- Grid column -->
            <br><br>
            <div class="col-md-10 offset-1 mb-4">

                <!--Card-->
                <div class="card mb-5" style="border: 1px #AE1F23; background: white">

                    <!--Card image-->
                    <div class="card-header btn-outline-danger pt-4" style="border: 1px #AE1F23; background: white">
                        <h2 class="card-title black-text text-center" style="font-size: 18px;">No request available</h2>
                    </div>

                    <!--Card content-->
                    <div class="card-body text-center">
                    <!--Title-->
                        <!--Text-->
                        <br>
                        <p class="card-text black-text" style="font-size: 15px;">There is no request for the moment but there are a lot of persons that you can help in the future.<br>
                            Don't forget to join us to keep in touch.
                        </p>
                        <br>
                        <a href="login" class="btn btn-outline-danger btn-md waves-effect" style="font-size: 14px;">Join us</a>
                    </div>

                 </div>
            <!--/.Card-->
            </div>
        </c:if>
        <c:if test="${ !empty requests}">
            <section>
                <c:forEach items="${requests}" var="request">
                    <div class="well">
                        <div class="media">
                            <div class="pull-left col-xs-2 col-xs-3 text-center">
                                <img class="media-object img-responsive img-rounded" src="${request.pathImgRequest.substring(25)}">
                            </div>
                            <div class="media-body">
                                <h2 class="media-heading">${request.titleRequest}</h2>
                                <c:if test="${sessionScope.centre.idCentre == request.idCentre}">
                                    <div class="dropdown">
                                        <button class="btn btn-info btn-red dropdown-toggle" style="font-size: 15px; background: #AE1F23; color: white;" type="button" id="dropdownmenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        </button>
                                        <div class="dropdown-menu" aria-labelledby="dropdownmenu">
                                            <a class="dropdown-item" href="#">Update</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">Delete</a>
                                        </div>
                                    </div>
                                </c:if>
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
        </c:if>
    </div>
</main>

<%@include file="Footer.jsp" %>

</body>
</html>
