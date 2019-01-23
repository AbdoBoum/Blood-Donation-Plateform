<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 22/01/2019
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../Header.jsp"%>
</head>

<body>
    <%@include file="../Navbar.jsp"%>
    <div class="container col-md-8  pt-5 ">

        <br><br>


        <div class="card card-cascade wider reverse">

            <!-- Card content -->
            <div class="card-body card-body-cascade">

                <!-- Title -->
                <div class="section-title text-center wow zoomInfont-weight-bold">
                    <h1>Donnateur Management</h1>
                </div>
                <%--alert--%>
                <c:if test="${flashMessageSuccess ne null}">
                    <div class="alert alert-success" role="alert">
                            ${flashMessageSuccess}
                    </div>
                </c:if>

                <c:if test="${flashMessageFaild ne null}">
                    <div class="alert alert-danger" role="alert">
                            ${flashMessageFaild}
                    </div>
                </c:if>

                <div class="row mt-5">
                    <div class="col-md-3 offset-2"><a href="/addDonnateur" class="btn btn-success">Create Donnateur</a></div>
                    <div class="col-md-3"><a href="" data-toggle="modal" data-target="#updateModal" class="btn btn-warning">Update Donnateur</a></div>
                    <div class="col-md-3"><a href="" data-toggle="modal" data-target="#deleteModel" class="btn btn-danger">Delete Donnateur</a></div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../Footer.jsp"%>
</body>
</html>
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title w-100 font-weight-bold">Update Donnateur</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="/updateDonnateur">
            <div class="modal-body mx-3">
                <div>
                    <!-- Nom input -->
                    <label for="id" class="mt-4">Id Donnateur</label>
                    <input type="text" id="id" name="update" class="form-control ">
                </div>

            </div>
            <div class="modal-footer d-flex justify-content-center">
                <input type="submit" class="btn btn-warning" value="Update"/>
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
                <h4 class="modal-title w-100 font-weight-bold">Delete Donnateur</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="post" action="/managementDonnateur">
                <div class="modal-body mx-3">
                    <div>
                        <!-- Nom input -->
                        <label for="email" class="mt-4">Email Donnateur</label>
                        <input type="email" id="email" name="email" class="form-control "/>
                        <input type="hidden" name="delete" value="true"/>
                    </div>

                </div>
                <div class="modal-footer d-flex justify-content-center">
                    <input type="submit" class="btn btn-danger" value="Delete"/>
                </div>
            </form>
        </div>
    </div>
</div>