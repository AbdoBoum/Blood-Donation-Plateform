<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: ABDERRAHIM
  Date: 17/01/2019
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <%@include file="Header.jsp" %>
</head>

<body>
<%@include file="Navbar.jsp" %>

<main>
    <div class="container">
        <br><br><br>
    <div class="row mb-4 mt-3">
        <div class="col-6">
        <form class="form-inline md-form mr-auto" action="blog">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="keyword">
            <button class="btn btn-red btn-rounded btn-md my-0" type="submit">Search</button>
        </form>
        </div>


        <div class="col-md-6 text-right mt-3">

                <a class="btn btn-red ${empty sessionScope.donnateur ? 'invisible': ''}" href="addBlog">New Blog</a>

        </div>

    </div>
        <!--Section: Cards-->
        <section class="text-center">

            <c:forEach var="i" begin="0" end="1" step="1">

                <c:if test="${ i == 1}" >
                    <c:set var="i" value="${i+2}"></c:set>
                </c:if>

                <!--Grid row-->
                <div class="row mb-4 wow fadeIn">

                <c:forEach var="j" begin="0" end="2">
                    <!--Grid column-->
                    <div class="col-lg-4 col-md-12 mb-3">

                        <!--Card-->
                        <div class="card">

                            <!--Card image-->
                            <div class="overlay">
                                <div class="embed-responsive embed-responsive-16by9 rounded-top">
                                    <img class="embed-responsive-item"
                                         src="${blogs[i + j].getPathImgBlog().substring(55)}"
                                         allowfullscreen/>
                                </div>
                            </div>

                            <!--Card content-->
                            <div class="card-body ">
                                <!--Title-->
                                <h4 class="card-title">${blogs[i + j].getTitreBlog().substring(0, (blogs[i + j].getTitreBlog().length() < 48) ? blogs[i + j].getTitreBlog().length(): 48)}</h4>
                                <!--Text-->
                                <p class="card-text">${blogs[j].getContenueBlog().substring(0, (blogs[i + j].getContenueBlog().length() < 150) ? blogs[i + j].getContenueBlog().length(): 150)}</p>
                                <a href="#" class="btn btn-red btn-md">Read More
                                    <i class="fa fa-play ml-2"></i>
                                </a>
                            </div>

                        </div>
                        <!--/.Card-->

                    </div>
                    <!--Grid column-->

                </c:forEach>

             </div>
             <!--Grid row-->
            </c:forEach>

            <!--Pagination-->
            <nav class="d-flex justify-content-center wow fadeIn">
                <ul class="pagination pg-red">

                    <!--Arrow left-->
                    <li class="page-item disabled">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>

                    <li class="page-item active">
                        <a class="page-link" href="#">1
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">2</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">3</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">4</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">5</a>
                    </li>

                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </ul>
            </nav>
            <!--Pagination-->

        </section>
        <!--Section: Cards-->

    </div>
    <%@include file="Footer.jsp" %>
</main>


</body>
</html>
