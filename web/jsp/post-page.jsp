<%--
  Created by IntelliJ IDEA.
  User: ABDERRAHIM
  Date: 23/01/2019
  Time: 13:38
--%>
<html>
<head>
    <%@include file="Header.jsp" %>
</head>
<body class="white">

<!--Main Navigation-->
<header>

    <!-- Navbar -->
    <%@include file="Navbar.jsp" %>
    <!-- Navbar -->

</header>

<!--Main Navigation-->

<!--Main layout-->
<main class="mt-5 pt-5">
    <div class="container">

        <!--Search button-->
        <div class="row mb-4 mt-2">
            <div class="col-6 mt-4">
                <form class="form-inline  mr-auto " action="blog">
                    <input class="form-control mr-sm-2 my-0" type="text" value="${keyword}" placeholder="Search"
                           aria-label="Search"
                           name="keyword">
                    <button class="btn btn-red btn-rounded btn-md my-0" style="margin-left : -8px; border-radius : 3px;"
                            type="submit"><i class="fas fa-search"></i></button>
                </form>
            </div>
            <!--Search button-->

            <!--Add blog-->
            <div class="col-md-6 text-right mt-2">

                <a class="btn btn-red ${empty sessionScope.donnateur ? 'invisible': ''}" href="addBlog">New Blog</a>

            </div>
            <!--Add blog-->

        </div>

        <!--Section: Post-->
        <section class="mt-4">

            <!--Grid row-->
            <div class="row">

                <!--Grid column-->
                <div class="col-md-8 mb-4">

                    <!--Featured Image-->
                    <div class="card mb-4 wow fadeIn">

                        <img src="${article.getPathImgBlog().substring(55)}" style="width:100%; height: 300px;"
                             class="img-fluid" alt="blood donor">

                    </div>
                    <!--/.Featured Image-->

                    <!--Card-->
                    <div class="card mb-4 wow fadeIn">

                        <!--Card content-->

                    </div>
                    <!--/.Card-->

                    <!--Card-->
                    <div class="card mb-4 wow fadeIn">

                        <!--Card content-->
                        <div class="card-body">

                            <blockquote class="blockquote">
                                <p class="mb-0">${quote}</p>
                            </blockquote>

                            <!--Title of the blog-->
                            <p class="h5 my-4">${article.getTitreBlog()}</p>

                            <p>${article.getContenueBlog()}</p>

                            <p></p>

                            <p></p>

                        </div>

                    </div>
                    <!--/.Card-->

                    <!--Card-->
                    <div class="card mb-4 wow fadeIn">

                        <div class="card-header font-weight-bold">
                            <span>About author</span>
                            <span class="pull-right">
                                    <a href="">
                                        <i class="fab fa-facebook-f mr-2"></i>
                                    </a>
                                    <a href="">
                                        <i class="fab fa-twitter mr-2"></i>
                                    </a>
                                    <a href="">
                                        <i class="fab fa-instagram mr-2"></i>
                                    </a>
                                    <a href="">
                                        <i class="fab fa-linkedin-in mr-2"></i>
                                    </a>
                                </span>
                        </div>

                        <!--Card content-->
                        <div class="card-body">

                            <div class="media d-block d-md-flex mt-3">
                                <img class="d-flex mb-3 mx-auto z-depth-1"
                                     src="https://www.ispecimen.com/wp-content/uploads/2016/01/blood-156063_960_720.png"
                                     alt="Generic placeholder image"
                                     style="width: 100px;">
                                <div class="media-body text-center text-md-left ml-md-3 ml-0">
                                    <h5 class="mt-0 font-weight-bold">${author}
                                    </h5>
                                    At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis
                                    praesentium voluptatum deleniti atque corrupti
                                    quos dolores et quas molestias excepturi sint occaecati cupiditate non provident,
                                    similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et
                                    dolorum
                                    fuga.
                                </div>
                            </div>

                        </div>

                    </div>
                    <!--/.Card-->


                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-md-4 mb-4">

                    <!--Card: Jumbotron-->
                    <div class="card blue-gradient mb-5 wow fadeIn">

                        <!-- Content -->
                        <div class="card-body text-white text-center">

                            <h4 class="mb-4">
                                <strong>Giving blood saves lives</strong>
                            </h4>
                            <p>
                                <strong>But it's always in high demand.</strong>
                            </p>
                            <p class="mb-4">
                                <strong>You can be a hero by saving someone's life. You can check the need for blood
                                    in your city and participate in them.
                                    There is no great joy than saving a soul.</strong>
                            </p>
                            <a href="faq"
                               class="btn btn-outline-white btn-md">Check OUR FAQ
                                <i class="fas fa-graduation-cap ml-2"></i>
                            </a>

                        </div>
                        <!-- Content -->
                    </div>

                    <!--Card-->
                    <div class="card mb-4 wow fadeIn mt-0">

                        <div class="card-header">Related articles</div>

                        <!--Card content-->
                        <div class="card-body">

                            <ul class="list-unstyled">
                                <c:if test="${not empty blogs}">
                                    <c:forEach items="${blogs}" var="blog">
                                        <c:if test="${not empty blog}">
                                            <li class="media mt-3">
                                                <img class="d-flex mr-3" style="width:100px; height: 100px;"
                                                     src="${blog.getPathImgBlog().substring(55)}"
                                                     alt="Generic placeholder image">
                                                <div class="media-body">
                                                    <a href="blog?id=${blog.getIdBlog()}">
                                                        <h6 class="mt-0 mb-1 font-weight-bold">${blog.getTitreBlog().substring(0, (blog.getTitreBlog().length() < 23) ? blog.getTitreBlog().length(): 23)}...</h6>
                                                    </a>
                                                        ${blog.getContenueBlog().substring(0, (blog.getContenueBlog().length() < 40) ? blog.getContenueBlog().length(): 40)}
                                                    (...)
                                                </div>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </ul>


                        </div>

                    </div>
                    <!--/.Card-->

                </div>
                <!--Grid column-->

            </div>
            <!--Grid row-->

        </section>
        <!--Section: Post-->

    </div>
</main>
<!--Main layout-->
<%@include file="Footer.jsp" %>
</body>
</html>
