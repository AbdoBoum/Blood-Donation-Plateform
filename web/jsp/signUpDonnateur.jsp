<%--
  Created by IntelliJ IDEA.
  User: Anass
  Date: 23/01/2019
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <%@include file="Header.jsp" %>
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
<!--- Navbar -->
<%@ include file="Navbar.jsp" %>

<!--- Contenue -->
<div class="container col-md-8" style="margin-top: 100px;">

    <c:if test="${not empty isInserted}">
        <c:choose>
            <c:when test="${isInserted == 'succes'}">
                <h5 class='h5 text-center  mt-4'>
                    <div class='alert alert-success'>Demand inserted</div>
                </h5>
            </c:when>
            <c:when test="${isInserted == 'failure'}">
                <h5 class="h5 text-center mt-4">
                    <div class="alert alert-danger">Something goes wrong</div>
                </h5>
            </c:when>
            <c:otherwise>
                <h5 class="h5 text-center mt-4">
                    <div class="alert alert-danger">Please complete all fields</div>
                </h5>
            </c:otherwise>
        </c:choose>
    </c:if>

    <div class="row">
        <div class="col col-md-12">

            <div class="wrapper wrapper--w790">
                <div class="card">
                    <h5 class="card-header white-text text-center py-4" style="background-color: #8B191C;">
                        <strong>Sign Up</strong>
                    </h5>
                    <div class="card-body">
                        <form method="post" action="addDonnateur">
                            <div class="row row-space">
                                <div class="form-group required col-sm-6">
                                    <label for="prenom" class='control-label'>First Name</label>
                                    <input type="text" name="prenom" class="form-control" id="prenom" placeholder="First Name">
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                                <div class="form-group required col-sm-6">
                                    <label for="nom" class='control-label'>Last Name</label>
                                    <input type="text" name="nom" class="form-control" id="nom" placeholder="Last Name">
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group required col-sm-12">
                                    <label for="cin" class='control-label'>Cin</label>
                                    <input type="text" name="cin" class="form-control" id="cin" placeholder="CIN">
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <div class="row ">
                                <div class="form-group required col-sm-12">
                                    <label for="tele" class='control-label'>Phone Number</label>
                                    <input type="text" name="tele" class="form-control" id="tele" placeholder="Phone Number">
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group required col-sm-12">
                                    <label for="email" class='control-label'>Email</label>
                                    <input type="email" name="email" class="form-control" id="email" placeholder="Email">
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
                                    <label  for="groupSang" class="mt-4">Blood Group</label>
                                    <select class="browser-default custom-select form-control" name="groupSang" id="groupSang">
                                        <option selected>Choisir groupe Sang</option>
                                        <c:forEach items="${sangs}" var="sang">
                                            <option value="<c:out value="${sang.idGroupe}"/> "> <c:out value="${sang.nameGroupe}"/>  </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group required col-sm-6">
                                    <label for="ville" class="mt-4">City</label>
                                    <select class="browser-default custom-select form-control" name="ville" id="ville">
                                        <option selected>Choisir ville</option>
                                        <c:forEach items="${villes}" var="ville">
                                            <option value="<c:out value="${ville.idVille}"/>"><c:out value="${ville.nomVille}"/></option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <!-- Submit -->
                            <div class="row">
                                <div class="form-group col-sm-4">
                                    <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect"
                                            type="submit" style="border-color: #D92228 !important; color: #D92228 !important;">
                                        Sign up
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

<!--- FOOTER -->
<%@ include file="Footer.jsp" %>
</body>
</html>
