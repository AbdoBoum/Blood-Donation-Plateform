<%--
  User: ABDERRAHIM BOUMAHDI
  Time: 12:45
--%>

<html>
<head>
    <%@include file="Header.jsp" %>
    <style>
        .form-group.required .control-label:after {
            content: " *";
            color: red;
        }

        .form-control:focus {
            border-color: #AE1F23;
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(255, 0, 0, 0.6);
        }

        select option:hover {
            background-color: #AE1F23;
            color: white;
        }
    </style>
</head>
<body>
<!--- Navbar -->
<%@ include file="Navbar.jsp" %>

<c:if test="${empty sessionScope.donnateur}">
    <c:redirect url="login"></c:redirect>
</c:if>

<!--- Contenue -->
<div class="container col-md-8" style="margin-top: 100px;">

    <div class="section-title text-center wow zoomIn mt-5 font-weight-bold">
        <h1 class="h1-responsive">Profile</h1>
    </div>

    <div class="row">
        <div class="col col-md-12">
            <form action="/profile" method="post" >
                <div class="form-group required">
                    <label for="prenom" class='control-label'>First Name</label>
                    <input type="text" name="prenom" class="form-control" id="prenom" placeholder=""
                           value="${sessionScope.donnateur.prenomDonnateur}">
                </div>
                <div class="form-group required">
                    <label for="nom" class='control-label'>Last Name</label>
                    <input type="text" name="nom" class="form-control" id="nom" placeholder=""
                           value="${sessionScope.donnateur.nomDonnateur}">
                </div>
                <div class="form-group required">
                    <label for="cin" class='control-label'>CIN</label>
                    <input type="text" name="cin" class="form-control" id="cin" placeholder=""
                           value="${sessionScope.donnateur.cinDonnateur}">
                </div>
                <div class="form-group required">
                    <label for="email" class='control-label'>Email</label>
                    <input type="text" name="email" class="form-control" id="email" placeholder=""
                           value="${sessionScope.donnateur.emailDonnateur}">
                </div>
                <div class="form-group required">
                    <label for="phone" class='control-label'>Phone Number</label>
                    <input type="text" name="phone" class="form-control" id="phone" placeholder=""
                           value="${sessionScope.donnateur.teleDonnateur}">
                </div>
                <div class="form-group required">
                    <label for="groupSangSelect" class='control-label'>Blood Type</label>
                    <select class="form-control" id="groupSangSelect" name="groupSangSelect">
                        <c:forEach items="${groupSangList}" var="groupSang">
                            <option value="${groupSang.idGroupe}"
                                    <c:if test="${donnateur.idGroupeSangDonnateur eq groupSang.idGroupe}">
                                        selected
                                    </c:if>
                            ><c:out value="${groupSang.nameGroupe}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group required">
                    <label for="villeSelect" class='control-label'>City</label>
                    <select class="form-control" id="villeSelect" name="villeSelect">
                        <c:forEach items="${villes}" var="ville">
                            <option value="${ville.idVille}"
                                    <c:if test="${donnateur.idVilleDonnateur eq ville.idVille}">
                                        selected
                                    </c:if>
                            ><c:out value="${ville.nomVille}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group required">
                    <label for="password" class='control-label'>Password</label>
                    <input type="password" name="password" class="form-control" id="password" placeholder=""
                           value="${sessionScope.donnateur.passwordDonnateur}">
                </div>

                <!-- Update button -->
                <div class="row">
                    <div class="form-group col-md-3">
                        <button class="btn btn-outline-red btn-rounded btn-block z-depth-0 my-4 waves-effect"
                                type="submit">
                            Update
                        </button>
                    </div>

                    <div class="form-group col-md-3">
                        <button class="btn btn-outline-red btn-rounded btn-block z-depth-0 my-4 waves-effect"
                                href="#">
                            Delete
                        </button>
                    </div>

                </div>
            </form>
        </div>

    </div>

</div>

<!--- FOOTER -->
<%@ include file="Footer.jsp" %>
<%@include file="Toastr.jsp"%>
</body>
</html>
