<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 20/01/2019
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="Header.jsp"%>
    <!-- DataTables Select CSS -->
    <link href="css/addons/datatables-select.min.css" rel="stylesheet">
    <!-- DataTables Select CSS -->
    <script href="js/addons/datatables-select.min.js" rel="stylesheet"></script>
</head>
<body>
    <%@include file="Navbar.jsp"%>
    <div class="container">
        <br><br>

        <div class="section-title text-center wow zoomIn mt-5 font-weight-bold">
            <h1>Les evenements dispo</h1>
        </div>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Identifiant d'evenement</th>
                    <th scope="col">Titre d'evenement</th>
                    <th scope="col">Desciption d'evenement</th>
                    <th scope="col">Date d'evenement</th>
                    <th scope="col">Centre</th>
                    <th scope="col">Ville</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${events}" var="event">
                <tr>
                    <th scope="row"><c:out value="${event.idEvenement}"></c:out></th>
                    <td><c:out value="${event.titreEvenement}"/></td>
                    <td><c:out value="${event.desciptionEvenement}"/></td>
                    <td><c:out value="${event.dateEvenement}"/></td>
                    <td>
                        <c:forEach items="${centres}" var="centre">
                        <c:if test="${centre.idCentre eq event.idCentre}">
                            <c:out value="${centre.nameCentre}"/>
                        </c:if>
                       </c:forEach>

                    </td>
                    <td>
                        <c:forEach items="${villes}" var="ville">
                            <c:if test="${ ville.idVille eq event.idVille }">
                                <c:out value="${ville.nomVille}"/>
                            </c:if>
                        </c:forEach>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    </div>
    <%@include file="Footer.jsp"%>
    <script type="text/javascript" src="js/addons/datatables-select.min.js"></script>

</body>
</html>