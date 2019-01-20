<%--
  Created by IntelliJ IDEA.
  User: ABDERRAHIM
  Date: 17/01/2019
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="Header.jsp" %>
</head>

<body>
<%@include file="Navbar.jsp" %>

<main>
    <div class="container">
        <br><br><br>
    <div class="row mb-4">
        <div class="col-6">
        <form class="form-inline md-form mr-auto" action="blog">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="keyword">
            <button class="btn btn-red btn-rounded btn-sm my-0" type="submit">Search</button>
        </form>
        </div>


        <div class="col-md-6 text-right mt-3">

                <a class="btn btn-red ${empty sessionScope.donnateur ? 'disabled': ''}" href="addBlog">New Blog</a>

        </div>

    </div>
        <!--Section: Cards-->
        <section class="text-center">

            <!--Grid row-->
            <div class="row mb-4 wow fadeIn">

                <!--Grid column-->
                <div class="col-lg-4 col-md-12 mb-3">

                    <!--Card-->
                    <div class="card">

                        <!--Card image-->
                        <div class="overlay">
                            <div class="embed-responsive embed-responsive-16by9 rounded-top">
                                <img class="embed-responsive-item"
                                     src="https://www.healthline.com/hlcmsresource/images/Blood_Donation-1200x549-facebook.jpg"
                                     allowfullscreen/>
                            </div>
                        </div>

                        <!--Card content-->
                        <div class="card-body">
                            <!--Title-->
                            <h4 class="card-title">Benefits of Donating Blood</h4>
                            <!--Text-->
                            <p class="card-text">There’s no end to the benefits of donating blood for those who need
                                it.According to the American Red Cross,
                                one donation can save as many as three lives</p>
                            <a href="#" target="_blank" class="btn btn-red btn-md">Read More
                                <i class="fa fa-play ml-2"></i>
                            </a>
                        </div>

                    </div>
                    <!--/.Card-->

                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-lg-4 col-md-6 mb-4">

                    <!--Card-->
                    <div class="card">

                        <!--Card image-->
                        <div class="overlay">
                            <div class="embed-responsive embed-responsive-16by9 rounded-top">
                                <img class="embed-responsive-item"
                                     src="https://d1f5w6fv2lvk5u.cloudfront.net/tmc/wp-content/uploads/2017/06/29033601/iStock-690302872.jpg"
                                     allowfullscreen/>
                            </div>
                        </div>

                        <!--Card content-->
                        <div class="card-body">
                            <!--Title-->
                            <h4 class="card-title">Busting blood donation myths</h4>
                            <!--Text-->
                            <p class="card-text">Don’t let these misconceptions stop you from becoming a hero – one bag
                                of blood can save three lives
                                .</p>
                            <a href="#" class="btn btn-red btn-md">Read More
                                <i class="fa fa-play ml-2"></i>
                            </a>
                        </div>

                    </div>
                    <!--/.Card-->

                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-lg-4 col-md-6 mb-4">

                    <!--Card-->
                    <div class="card">

                        <!--Card image-->
                        <div class="overlay">
                            <div class="embed-responsive embed-responsive-16by9 rounded-top">
                                <img class="embed-responsive-item"
                                     src="https://ichef.bbci.co.uk/news/660/cpsprodpb/810A/production/_97043033_gettyimages-539205455.jpg"
                                     allowfullscreen/>
                            </div>
                        </div>

                        <!--Card content-->
                        <div class="card-body">
                            <!--Title-->
                            <h4 class="card-title">Blood donation rules ease for gay</h4>
                            <!--Text-->
                            <p class="card-text">Changes making it easier for gay and bisexual men to give blood have
                                been announced by the Scottish government.

                            </p>
                            <a href="#" target="_blank" class="btn btn-red btn-md">Read More
                                <i class="fa fa-play ml-2"></i>
                            </a>
                        </div>

                    </div>
                    <!--/.Card-->

                </div>
                <!--Grid column-->

            </div>
            <!--Grid row-->

            <!--Grid row-->
            <div class="row mb-4 wow fadeIn">

                <!--Grid column-->
                <div class="col-lg-4 col-md-12 mb-4">

                    <!--Card-->
                    <div class="card">

                        <!--Card image-->
                        <div class="overlay">
                            <div class="embed-responsive embed-responsive-16by9 rounded-top">
                                <img class="embed-responsive-item"
                                     src="https://d1f5w6fv2lvk5u.cloudfront.net/tmc/wp-content/uploads/2017/06/29033601/iStock-690302872.jpg"
                                     allowfullscreen/>
                            </div>
                        </div>

                        <!--Card content-->
                        <div class="card-body">
                            <!--Title-->
                            <h4 class="card-title">Busting blood donation myths</h4>
                            <!--Text-->
                            <p class="card-text">Don’t let these misconceptions stop you from becoming a hero – one bag
                                of blood can save three lives
                                .</p>
                            <a href="#" class="btn btn-red btn-md">Read More
                                <i class="fa fa-play ml-2"></i>
                            </a>
                        </div>

                    </div>
                    <!--/.Card-->

                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-lg-4 col-md-6 mb-4">

                    <!--Card-->
                    <div class="card">

                        <!--Card image-->
                        <div class="overlay">
                            <div class="embed-responsive embed-responsive-16by9 rounded-top">
                                <img class="embed-responsive-item"
                                     src="https://d1f5w6fv2lvk5u.cloudfront.net/tmc/wp-content/uploads/2017/06/29033601/iStock-690302872.jpg"
                                     allowfullscreen/>
                            </div>
                        </div>

                        <!--Card content-->
                        <div class="card-body">
                            <!--Title-->
                            <h4 class="card-title">Busting blood donation myths</h4>
                            <!--Text-->
                            <p class="card-text">Don’t let these misconceptions stop you from becoming a hero – one bag
                                of blood can save three lives
                                .</p>
                            <a href="#" target="_blank" class="btn btn-red btn-md">Read More
                                <i class="fa fa-play ml-2"></i>
                            </a>
                        </div>

                    </div>
                    <!--/.Card-->

                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-lg-4 col-md-6 mb-4">

                    <!--Card-->
                    <div class="card">

                        <!--Card image-->
                        <div class="overlay">
                            <div class="embed-responsive embed-responsive-16by9 rounded-top">
                                <img class="embed-responsive-item"
                                     src="https://d1f5w6fv2lvk5u.cloudfront.net/tmc/wp-content/uploads/2017/06/29033601/iStock-690302872.jpg"
                                     allowfullscreen/>
                            </div>
                        </div>

                        <!--Card content-->
                        <div class="card-body">
                            <!--Title-->
                            <h4 class="card-title">Busting blood donation myths</h4>
                            <!--Text-->
                            <p class="card-text">Don’t let these misconceptions stop you from becoming a hero – one bag
                                of blood can save three lives
                                .</p>
                            <a href="#" target="_blank" class="btn btn-red btn-md">Read More
                                <i class="fa fa-play ml-2"></i>
                            </a>
                        </div>

                    </div>
                    <!--/.Card-->

                </div>
                <!--Grid column-->

            </div>
            <!--Grid row-->

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
