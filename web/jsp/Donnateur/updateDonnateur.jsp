<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 22/01/2019
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../Header.jsp" %>
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
                        <strong>Update Donnateur</strong>
                    </h5>
                    <div class="card-body">
                        <c:if test="${flashMessageFaild ne null}">
                            <div class="alert alert-danger" role="alert">
                                    ${flashMessageFaild}
                            </div>
                        </c:if>
                        <form method="post" action="/updateDonnateur">
                            <input name="update" type="hidden" value="update">
                            <input type="hidden" name="id" value="<c:out value="${donnateur.idDonnateur}"/>">
                            <div class="row row-space">
                                <div class="form-group required col-sm-6">
                                    <label  class='control-label'>Full Name</label>
                                    <h6 class="mt-2">${donnateur.nomDonnateur} ${donnateur.prenomDonnateur}</h6>
                                </div>
                                <div class="form-group required col-sm-6">
                                    <label class='control-label'>Cin</label>
                                    <h6 class="mt-2">${donnateur.cinDonnateur}</h6>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group required col-sm-6">
                                    <label for="tele" class='control-label'>Phone Number</label>
                                    <input type="text" name="tele" class="form-control" id="tele" value="<c:out value="${donnateur.teleDonnateur}"/>">
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                                <div class="form-group required col-sm-6">
                                    <label for="email" class='control-label'>Email</label>
                                    <input type="email" name="email" class="form-control" id="email" value="<c:out value="${donnateur.emailDonnateur}"/>">
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <%--<div class="row">--%>
                                <%--<div class="form-group required col-sm-12">--%>
                                    <%--<label for="password" class='control-label'>Password</label>--%>
                                    <%--<input type="password" name="password" class="form-control" id="password" placeholder="Password">--%>
                                    <%--<!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <div class="row row-space">
                                <div class="form-group required col-sm-6">
                                    <label  for="groupSang" class="mt-4">Blood Group</label>
                                    <select class="browser-default custom-select form-control" name="groupSang" id="groupSang">
                                        <c:forEach items="${sangs}" var="sang">
                                            <option value="<c:out value="${sang.idGroupe}"/>"
                                                    <c:if test="${donnateur.idGroupeSangDonnateur eq sang.idGroupe}">
                                                        selected
                                                    </c:if>
                                            > <c:out value="${sang.nameGroupe}"/>  </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group required col-sm-6">
                                    <label for="ville" class="mt-4">City</label>
                                    <select class="browser-default custom-select form-control" name="ville" id="ville">
                                        <option selected value="">Choisir ville</option>
                                        <c:forEach items="${villes}" var="ville">
                                            <option value="<c:out value="${ville.idVille}"/>"
                                                    <c:if test="${ville.idVille eq donnateur.idVilleDonnateur}">
                                                        selected
                                                    </c:if>
                                            ><c:out value="${ville.nomVille}"/></option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <!-- Submit -->
                            <div class="row">
                                <div class="form-group col-sm-4">
                                    <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect"
                                            type="submit" style="border-color: #D92228 !important; color: #D92228 !important;">
                                        Update
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
<%@ include file="../Footer.jsp" %>
</body>
</html>



<%--<div class="container col-md-8">--%>

    <%--<br><br>--%>

    <%--<!-- Card -->--%>
    <%--<div class="card card-cascade wider reverse">--%>

        <%--<!-- Card content -->--%>
        <%--<div class="card-body card-body-cascade">--%>

            <%--<!-- Title -->--%>
            <%--<div class="section-title text-center wow zoomIn mt-5 font-weight-bold">--%>
                <%--<h1>Update Donnateur</h1>--%>
            <%--</div>--%>
            <%--<div class="row">--%>
                    <%--<div class="col-md-12" class="font-weight-bold"><h6 class="mt-4">Full name</h6></div>--%>
                    <%--<div class="col-md-12"><h6 class="mt-2">${donnateur.nomDonnateur} ${donnateur.prenomDonnateur}</h6></div>--%>
            <%--</div>--%>
            <%--<div class="row">--%>
                    <%--<!-- cin -->--%>
                    <%--<div class="col-md-12" class="font-weight-bold"><h6 class="mt-4">Cin</h6></div>--%>
                    <%--<div class="col-md-12" ><h6 class="mt-2">${donnateur.cinDonnateur}</h6></div>--%>

            <%--</div>--%>

            <%--<form action="updateDonnateur" method="post" >--%>
                <%--<input type="hidden" name="id" value="<c:out value="${donnateur.idDonnateur}"/>">--%>
                <%--<!-- Nom input -->--%>
                <%--&lt;%&ndash;<label for="nom" class="mt-4">Nom Donnateur</label>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<input type="text" id="nom" name="nom" class="form-control " value="<c:out value="${donnateur.nomDonnateur}"/>">&ndash;%&gt;--%>

                <%--&lt;%&ndash;<!-- Prenom input -->&ndash;%&gt;--%>
                <%--&lt;%&ndash;<label for="prenom" class="mt-4">Prenom Donnateur</label>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<input type="text" id="prenom" name="prenom" class="form-control " value="<c:out value="${donnateur.prenomDonnateur}"/>">&ndash;%&gt;--%>

                <%--&lt;%&ndash;<!-- cin input -->&ndash;%&gt;--%>
                <%--&lt;%&ndash;<label for="cin" class="mt-4">Cin Donnateur</label>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<input type="text" id="cin" name="cin" class="form-control " value="<c:out value="${donnateur.cinDonnateur}"/>">&ndash;%&gt;--%>

                <%--<!-- email input -->--%>
                <%--<label for="email" class="mt-4">Email Donnateur</label>--%>
                <%--<input type="email" id="email" name="email" class="form-control" value="<c:out value="${donnateur.emailDonnateur}"/>">--%>

                <%--<!-- tele input -->--%>
                <%--<label for="tele" class="mt-4">Numero Gsm Donnateur</label>--%>
                <%--<input type="text" id="tele" name="tele" class="form-control " value="<c:out value="${donnateur.teleDonnateur}"/>">--%>

                <%--<!-- password input -->--%>
                <%--&lt;%&ndash;<label for="password" class="mt-4">Password Donnateur</label>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<input type="password" id="password" name="password" class="form-control">&ndash;%&gt;--%>

                <%--<!-- ville -->--%>
                <%--<label for="ville" class="mt-4">Ville Donnateur</label>--%>
                <%--<select class="browser-default custom-select" name="ville" id="ville">--%>
                    <%--<c:forEach items="${villes}" var="ville">--%>
                        <%--<option value="<c:out value="${ville.idVille}"/>"--%>
                                <%--<c:if test="${ville.idVille eq donnateur.idVilleDonnateur}">--%>
                                    <%--selected--%>
                                <%--</c:if>--%>
                        <%--><c:out value="${ville.nomVille}"/></option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>

                <%--<!-- groupe Sang -->--%>
                <%--<label  for="groupSang" class="mt-4">Groupe Sang Donnateur</label>--%>
                <%--<select class="browser-default custom-select" name="groupSang" id="groupSang">--%>
                    <%--<c:forEach items="${sangs}" var="sang">--%>
                        <%--<option value="<c:out value="${sang.idGroupe}"/>"--%>
                                <%--<c:if test="${donnateur.idGroupeSangDonnateur eq sang.idGroupe}"> selected </c:if>--%>
                        <%--> <c:out value="${sang.nameGroupe}"/>  </option>--%>
                    <%--</c:forEach>--%>
                <%--</select>--%>

                <%--<input name="update" type="hidden" value="update">--%>

                <%--<!-- Submit -->--%>
                <%--<button type="submit" class="btn btn-red my-1 mt-5">Modifier</button>--%>

            <%--</form>--%>
        <%--</div>--%>

    <%--</div>--%>
    <%--<!-- Card -->--%>



<%--</div>--%>

    <%--<%@include file="../Footer.jsp"%>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>
