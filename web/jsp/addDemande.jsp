<%--
  Created by IntelliJ IDEA.
  User: Anass
  Date: 17/01/2019
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            background-color: #AE1F23;
            color: white;
        }
    </style>
</head>
<body>
<!--- Navbar -->
<%@ include file="Navbar.jsp" %>

<c:if test="${empty sessionScope.centre}">
    <c:redirect url="login"></c:redirect>
</c:if>

<!--- Contenue -->
<div class="container col-md-8" style="margin-top: 100px;">

    <div class="section-title text-center wow zoomIn mt-5 font-weight-bold">
        <h1 class="h1-responsive">Create a Request</h1>
    </div>

    <c:if test="${not empty isInserted}">
        <c:choose>
            <c:when test="${isInserted == 'succes'}">
                <h5 class='h5 text-center  mt-4'>
                    <div class='alert alert-success'>Request inserted</div>
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
            <form action="addRequest" method="post" enctype="multipart/form-data">
                <div class="form-group required">
                    <label for="titleInput" class='control-label'>Request Title</label>
                    <input type="text" name="titleInput" class="form-control" id="titleInput" placeholder="">
                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                </div>
                <div class="form-group required">
                    <label for="groupSangSelect" class='control-label'>Blood Type</label>
                    <select class="form-control" id="groupSangSelect" multiple="multiple" name="groupSangSelect">
                        <c:forEach items="${groupSangList}" var="groupSang" >
                            <option value="${groupSang.nameGroupe}"><c:out value="${groupSang.nameGroupe}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group required">
                    <label for="urgentSelect" class='control-label'>Is Urgent ?</label>
                    <select class="form-control" id="urgentSelect" name="urgentSelect">
                        <option value="No">No</option>
                        <option value="Yes">Yes</option>
                    </select>
                </div>
                <div class="form-group required">
                    <label for="villeSelect" class='control-label'>City</label>
                    <select class="form-control" id="villeSelect" name="villeSelect">
                        <c:forEach items="${villes}" var="ville" >
                            <option value="${ville.nomVille}"><c:out value="${ville.nomVille}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group required">
                    <label for="description" class='control-label'>Request Description</label>
                    <textarea class="form-control" id="description" rows="7" name="description"></textarea>
                </div>

                <div class="form-group">
                    <label for="inputFile">Image</label>
                    <input name="inputFile" type="file" class="form-control-file" id="inputFile" aria-describedby="fileHelp">
                    <!--<small id="fileHelp" class="form-text text-muted">This is some placeholder block-level help text for the above input. It's a bit lighter and easily wraps to a new line.</small>-->
                </div>
                <!-- Submit -->
                <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect"
                        type="submit" style="border-color: #D92228 !important; color: #D92228 !important;">
                    Send
                </button>
            </form>
        </div>

    </div>

</div>

<!--- FOOTER -->
<%@ include file="Footer.jsp" %>
</body>
</html>

