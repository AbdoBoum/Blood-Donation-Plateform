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
    <%@include file="../Header.jsp"%>
</head>
    <%@include file="../Navbar.jsp"%>

<div class="container col-md-8">

    <br><br>

    <div class="section-title text-center wow zoomIn mt-5 font-weight-bold">
        <h1>Ajouter un donnateur</h1>
    </div>
    <form action="addDonnateur" method="post" >

        <!-- Nom input -->
        <label for="nom" class="mt-4">Nom Donnateur</label>
        <input type="text" id="nom" name="nom" class="form-control " value="<c:out value="${donnateur.nomDonnateur}"/>">

        <!-- Prenom input -->
        <label for="prenom" class="mt-4">Prenom Donnateur</label>
        <input type="text" id="prenom" name="prenom" class="form-control " value="<c:out value="${donnateur.prenomDonnateur}"/>">

        <!-- cin input -->
        <label for="cin" class="mt-4">Cin Donnateur</label>
        <input type="text" id="cin" name="cin" class="form-control " value="<c:out value="${donnateur.cinDonnateur}"/>">

        <!-- email input -->
        <label for="email" class="mt-4">Email Donnateur</label>
        <input type="email" id="email" name="email" class="form-control" value="<c:out value="${donnateur.emailDonnateur}"/>">

        <!-- tele input -->
        <label for="tele" class="mt-4">Numero Gsm Donnateur</label>
        <input type="text" id="tele" name="tele" class="form-control " value="<c:out value="${donnateur.teleDonnateur}"/>">

        <!-- password input -->
        <%--<label for="password" class="mt-4">Password Donnateur</label>--%>
        <%--<input type="password" id="password" name="password" class="form-control">--%>

        <!-- ville -->
        <label for="ville" class="mt-4">Ville Donnateur</label>
        <select class="browser-default custom-select" name="ville" id="ville">
            <c:forEach items="${villes}" var="ville">
                <option value="<c:out value="${ville.idVille}"/>"
                <c:if test="${donnateur.idVilleDonnateur}==${ville.idVille}">
                    selected
                </c:if>
                ><c:out value="${ville.nomVille}"/></option>
            </c:forEach>
        </select>

        <!-- groupe Sang -->
        <label  for="groupeSang" class="mt-4">Groupe Sang Donnateur</label>
        <select class="browser-default custom-select" name="groupeSang" id="groupeSang">
            <c:forEach items="${sangs}" var="sang">
                <option value="<c:out value="${sang.idGroupe}"/> "
                <c:if test="${donnateur.idGroupeSangDonnateur} == ${sang.idGroupe}"> selected</c:if>
               > <c:out value="${sang.nameGroupe}"/>  </option>
            </c:forEach>
        </select>

        <!-- Submit -->
        <button type="submit" class="btn btn-red my-1 mt-5">Modifier</button>

    </form>
</div>

    <%@include file="../Footer.jsp"%>
<body>

</body>
</html>
