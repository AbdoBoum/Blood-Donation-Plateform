<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 27/01/2019
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../Header.jsp"%>
    <style>
        .form-group.required .control-label:after {
            content:" *";
            color:red;
        }
        .form-control:focus {
            border-color: #AE1F23;
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(255, 0, 0, 0.6);
        }
        select option:hover {
            background: #AE1F23;
            color: white;
        }
    </style>
</head>
<body>

    <%@include file="../Navbar.jsp"%>
    <!--- Contenue -->
    <div class="container col-md-8" style="margin-top: 100px;">


    <div class="row">
        <div class="col col-md-12">

            <div class="wrapper wrapper--w790">
                <div class="card">
                    <h5 class="card-header white-text text-center py-4" style="background-color: #8B191C;">
                        <strong>Create Centre</strong>
                    </h5>
                    <div class="card-body">
                        <c:if test="${flashMessageFaild ne null}">
                            <div class="alert alert-danger" role="alert">
                                    ${flashMessageFaild}
                            </div>
                        </c:if>
                        <form method="post" action="/addCentre">
                            <div class="row row-space">
                                <div class="form-group required col-sm-12">
                                    <label for="nom" class='control-label'>Centre Name</label>
                                    <input type="text" name="nom" class="form-control" id="nom" placeholder="Centre Name" <c:if test="${oldNom ne null}"> value="${oldNom}" </c:if> >
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group required col-sm-12">
                                    <label for="email" class='control-label'>Centre Email</label>
                                    <input type="email" name="email" class="form-control" id="email" placeholder="Email" <c:if test="${oldEmail ne null}"> value="${oldEmail}" </c:if>>
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>

                            <div class="row ">
                                <div class="form-group required col-sm-12">
                                    <label for="tele" class='control-label'>Phone Number</label>
                                    <input type="text" name="tele" class="form-control" id="tele" placeholder="Phone Number" <c:if test="${oldTele ne null}"> value="${oldTele}" </c:if>>
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group required col-sm-12">
                                    <label for="password" class='control-label'>Password</label>
                                    <input type="password" name="password" class="form-control" id="password" placeholder="Password">
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <div class="row row-space">
                                <div class="form-group required col-sm-6">
                                    <div class="row">
                                        <div class="form-group required col-sm-12">
                                            <label for="addresse" class='control-label mt-4'>Centre Adresse</label>
                                            <textarea class="form-control" id="addresse" name="addresse" rows="7" placeholder="Centre adresse"><c:if test="${oldAddresse ne null}">${oldAddresse}</c:if></textarea>
                                            <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group required col-sm-6">
                                    <label for="ville" class="mt-4">City</label>
                                    <select class="browser-default custom-select form-control" name="ville" id="ville">
                                        <option selected value="">Choisir ville</option>
                                        <c:forEach items="${villes}" var="ville">
                                            <option value="<c:out value="${ville.idVille}"/>" <c:if test="${oldVille eq ville.idVille}"> selected="" </c:if> ><c:out value="${ville.nomVille}"/></option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <!-- Submit -->
                            <div class="row">
                                <div class="form-group col-sm-4">
                                    <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect"
                                            type="submit" style="border-color: #D92228 !important; color: #D92228 !important;">
                                        Create
                                    </button>
                                </div>

                            </div>


                        </form>

                    </div>
                </div>
            </div>


        </div>

    </div>

</div>

    <%@include file="../Footer.jsp"%>
</body>
</html>
