<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 20/01/2019
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="Header.jsp"%>
    <!-- DataTables Select CSS -->
    <link href="css/addons/datatables-select.min.css" rel="stylesheet">
    <!-- DataTables Select CSS -->
    <script href="js/addons/datatables-select.min.js" rel="stylesheet"></script>
</head>
<body>
<%@include file="Navbar.jsp"%>
<div class="container">
    <br><br>




    <!-- Card -->
    <div class="card card-cascade wider reverse">
        <div class="card-body card-body-cascade">
        <!-- Card content -->
            <c:if test="${events ne null}">


        <!-- Title -->
                <div class="section-title text-center wow zoomIn mt-5 font-weight-bold">
                    <h1>Agenda</h1>
                </div>
                <section class="my-5">


                    <ul class="list-group list-group-flush">
                        <c:forEach items="${events}" var="event">


                            <li class="list-group-item">
                                <div class="row">
                                    <div class="col-md-9">
                                        <div class="media mt-4 px-1">
                                            <img class="card-img-100 d-flex z-depth-1 mr-3" src="<c:out value="${event.imagePathEvenement}"/>"
                                                 alt="Generic placeholder image">
                                            <div class="media-body">
                                                <h6 class="font-weight-bold mt-0">
                                                    <c:out value="${event.titreEvenement}"/>
                                                </h6>
                                                <c:out value="${event.desciptionEvenement}"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="media mt-4 px-1">
                                            <ul class="list-unstyled  mb-0">
                                                <li class="list-item">
                                                    <i class="fas fa-calendar mr-1 mt-2"></i>
                                                        ${event.dateEvenement}
                                                </li>
                                                <li class="list-item">
                                                    <i class="fas fa-home mr-1 mt-2"></i>
                                                    <c:forEach items="${centres}" var="centre">
                                                        <c:if test="${centre.idCentre eq event.idCentre}">
                                                            <c:out value="${centre.nameCentre}"/>
                                                        </c:if>
                                                    </c:forEach></li>
                                                <li class="list-item"><i class="fas fa-map-marker mr-1 mt-2"></i>
                                                    <c:forEach items="${villes}" var="ville">
                                                    <c:if test="${ ville.idVille eq event.idVille }">
                                                        <c:out value="${ville.nomVille}"/>
                                                    </c:if>
                                                    </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </li>

                        </c:forEach>

                    </ul>



                </section>
                <!--Pagination-->
                ${pg}

                <!--Pagination-->

            </c:if>

        <c:if test="${events eq null}">
        <!-- Card -->
        <!-- Grid column -->
        <div class="col-md-10 offset-1 mb-4 mr-5">

            <!--Card-->
            <div class="card mb-5" style="background: #AE1F23">

                <!--Card image-->
                <div class="card-header pt-4" style="background: #AE1F23">
                    <h4 class="card-title white-text">No events available</h4>
                </div>

                <!--Card content-->
                <div class="card-body text-center">
                    <!--Title-->

                    <!--Text-->
                    <p class="card-text white-text">If your life has been impacted as a result of blood donations
                        then we want to hear from you. Help spread the word about the importance of blood donation
                        and share your story.
                    </p>
                    <a href="login" class="btn btn-outline-white btn-md waves-effect">Join us</a>
                </div>

            </div>
            <!--/.Card-->

        </div>
        <!-- Grid column -->
        <!-- Card -->

    </div>

    </c:if>
    </div>

    </div>
    <!-- Card -->
</div>
<%@include file="Footer.jsp"%>
<script type="text/javascript" src="js/addons/datatables-select.min.js"></script>

</body>
</html>