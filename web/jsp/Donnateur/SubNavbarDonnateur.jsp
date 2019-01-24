<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 24/01/2019
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>

<!--Main Navigation-->


<c:if test="${not empty sessionScope.centre}">

    <nav class="navbar fixed-top navbar-expand-lg navbar-dark top-nav-collapse" style="position: absolute; top: 69px; background-color: transparent !important;">
        <div class="container">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav" style="padding-left: 16%;">

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                           aria-expanded="false">Donor management</a>
                        <div class="dropdown-menu dropdown-secondary">
                            <a class="dropdown-item" href="/addDonnateur">Create Donor</a>
                            <a href="" data-toggle="modal" data-target="#updateModal" class="dropdown-item">Update Donor</a>
                            <a href="" data-toggle="modal" data-target="#deleteModel" class="dropdown-item">Delete Donor</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                           aria-expanded="false">Stock management</a>
                        <div class="dropdown-menu dropdown-secondary">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <a class="dropdown-item" href="#">Something else here</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Separated link</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/">Donor management</a>
                    </li>
                </ul>

            </div>
        </div>
    </nav>
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header text-center">
                    <h4 class="modal-title w-100 font-weight-bold">Update Donor</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form method="get" action="/updateDonnateur">
                    <div class="modal-body mx-3">
                        <div class="row ">
                            <div class="form-group required col-sm-12">
                                <label for="id" class='control-label'>Id Donor</label>
                                <input type="text" name="id" class="form-control" id="id" placeholder="Identifiant donnateur">
                                <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                            </div>
                        </div>

                    </div>
                    <div class="modal-footer d-flex justify-content-center">

                            <div class="col-sm-4">
                                <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect"
                                        type="submit" style="border-color: #D92228 !important; color: #D92228 !important;">
                                    update
                                </button>
                            </div>


                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="deleteModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header text-center">
                    <h4 class="modal-title w-100 font-weight-bold">Delete Donor</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form method="post" action="/deleteDonnateur">
                    <div class="modal-body mx-3">
                        <div>
                            <!-- Nom input -->
                            <label for="email" class="mt-4">Email Donor</label>
                            <input type="email" id="email" name="email" class="form-control "/>
                        </div>

                    </div>
                    <div class="modal-footer d-flex justify-content-center">
                        <div class="col-sm-4">
                            <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect"
                                    type="submit" style="border-color: #D92228 !important; color: #D92228 !important;">
                                Delete
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>



    <div aria-live="polite" aria-atomic="true" style="position: absolute; min-height: 200px;">
        <div class="toast" style="position: absolute; top: 0; right: 0;" data-autohide="false">
            <div class="toast-header">
                <svg class="rounded mr-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice"
                     focusable="false" role="img">
                    <rect fill="#007aff" width="100%" height="100%" /></svg>
                <strong class="mr-auto">Bootstrap</strong>
                <small>11 mins ago</small>
                <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="toast-body">
                Hello, world! This is a toast message.
            </div>
        </div>
    </div>



</c:if>



<%--<div class="modal fade show" id="deleteModel" tabindex="-1" aria-labelledby="myModalLabel" role="dialog" aria-labelledby="myModalLabel"--%>
     <%--style="padding-right: 14px; display: block;">--%>
    <%--<div class="modal-dialog" role="document">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-header text-center">--%>
                <%--<h4 class="modal-title w-100 font-weight-bold">Delete Donor</h4>--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                    <%--<span aria-hidden="true">&times;</span>--%>
                <%--</button>--%>
            <%--</div>--%>
            <%--<form method="post" action="/deleteDonnateur">--%>
                <%--<div class="modal-body mx-3">--%>
                    <%--<div>--%>
                        <%--<!-- Nom input -->--%>
                        <%--<label for="email" class="mt-4">Email Donor</label>--%>
                        <%--<input type="email" id="email" name="email" class="form-control "/>--%>
                    <%--</div>--%>

                <%--</div>--%>
                <%--<div class="modal-footer d-flex justify-content-center">--%>
                    <%--<div class="col-sm-4">--%>
                        <%--<button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect"--%>
                                <%--type="submit" style="border-color: #D92228 !important; color: #D92228 !important;">--%>
                            <%--Delete--%>
                        <%--</button>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>



<%--<nav class="navbar navbar-expand-lg navbar-dark default-color">--%>
    <%--<div class="container">--%>
        <%--&lt;%&ndash;<a class="navbar-brand" href="https://mdbootstrap.com/docs/jquery/" target="_blank">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<img src="img/logo.png" style="height: 38px; margin-top: -2px;" class="mr-4">&ndash;%&gt;--%>
        <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
        <%--<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"--%>
                <%--aria-controls="navbarSupportedContent"--%>
                <%--aria-expanded="false" aria-label="Toggle navigation">--%>
            <%--<span class="navbar-toggler-icon"></span>--%>
        <%--</button>--%>
        <%--<div class="collapse navbar-collapse" id="navbarSupportedContent">--%>
            <%--<ul class="navbar-nav mr-auto">--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="/">Home</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="/blog">Blog</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="/requests">Requests</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="/agenda">Agenda</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="/faq">FAQ</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="/about">About us</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="/contact">Contact us</a>--%>
                <%--</li>--%>
            <%--</ul>--%>

        <%--</div>--%>
    <%--</div>--%>

<%--</nav>--%>

<!--Main Navigation-->
