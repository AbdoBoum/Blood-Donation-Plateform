<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 20/01/2019
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="Header.jsp" %>
    <style>
        .form-group.required .control-label:after {
            content:" *";
            color:red;
        }
        .form-control:focus{
            border-color: #AE1F23;
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(255, 0, 0, 0.6);
        }
        select option:hover {
            background: #AE1F23;
            color: white;
        }


        .custom-file-input:focus ~ .custom-file-label {
            /*border-color: #80bdff;*/
            /*box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);*/
            border-color: #AE1F23;
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(255, 0, 0, 0.6);
        }
    </style>
</head>
<body>

<%@include file="Navbar.jsp"%>
<!--- Contenue -->
<div class="container col-md-8" style="margin-top: 100px;">


    <div class="row">
        <div class="col col-md-12">

            <div class="wrapper wrapper--w790">
                <div class="card">
                    <h5 class="card-header white-text text-center py-4" style="background-color: #8B191C;">
                        <strong>Create Event</strong>
                    </h5>
                    <div class="card-body">
                        <c:if test="${flashMessageFaild ne null}">
                            <div class="alert alert-danger" role="alert">
                                    ${flashMessageFaild}
                            </div>
                        </c:if>
                        <form method="post" action="/addEvent" enctype="multipart/form-data">
                            <div class="row row-space">
                                <div class="form-group required col-sm-12">
                                    <label for="title" class='control-label'>Event title</label>
                                    <input type="text" name="title" class="form-control" id="title" placeholder="Event title" <c:if test="${oldTitle ne null}"> value="${oldTitle}" </c:if> >
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>

                            </div>
                            <div class="row">
                                <div class="form-group required col-sm-12">
                                    <label for="description" class='control-label'>Event Description</label>
                                    <textarea class="form-control" id="description" name="description" rows="7" placeholder="Event Description"><c:if test="${oldDescription ne null}">${oldDescription}</c:if></textarea>
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <div class="row ">
                                <div class="form-group required col-sm-12">
                                    <label for="date" class='control-label'>Event Date</label>
                                    <input type="date" name="date" class="form-control" id="date" <c:if test="${oldDate ne null}"> value="${oldDate}" </c:if>>
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <div class="row ">
                                <div class="form-group required col-sm-12">
                                    <label for="time" class='control-label'>Event time</label>
                                    <input type="time" name="time" class="form-control" id="time" <c:if test="${oldTime ne null}"> value="${oldTime}" </c:if>>
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>
                            </div>
                            <%--<div class="row">--%>
                                <%--<div class="form-group required col-sm-12">--%>
                                    <%--<div class="custom-file">--%>
                                        <%--<input type="file" class="custom-file-input" id="imgInput" name="imgInput"--%>
                                               <%--aria-describedby="imgInput">--%>
                                        <%--<label class="custom-file-label" for="imgInput">Photo de couverture d'evenement</label>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <div class="form-group required col-sm-12 custom-file ">
                                <input type="file" class="custom-file-input" id="imgInput" name="imgInput"
                                       aria-describedby="imgInput" required>
                                <label class="custom-file-label " for="imgInput">Event image cover </label>
                            </div>
                            <%--<div class="row">--%>
                                <%--<div class="form-group required col-sm-12">--%>
                                    <%--<label for="password" class='control-label'>Password</label>--%>
                                    <%--<input type="password" name="password" class="form-control" id="password" placeholder="Password">--%>
                                    <%--<!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="row row-space">--%>
                                <%----%>
                                <%--<div class="form-group required col-sm-12">--%>
                                    <%--<label for="ville" class="mt-4">City</label>--%>
                                    <%--<select class="browser-default custom-select form-control" name="ville" id="ville">--%>
                                        <%--<option selected value="">Choisir ville</option>--%>
                                        <%--<c:forEach items="${villes}" var="ville">--%>
                                            <%--<option value="<c:out value="${ville.idVille}"/>" <c:if test="${oldVille eq ville.idVille}"> selected="" </c:if> ><c:out value="${ville.nomVille}"/></option>--%>
                                        <%--</c:forEach>--%>
                                    <%--</select>--%>
                                <%--</div>--%>
                            <%--</div>--%>
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

<!--- FOOTER -->
<%@ include file="Footer.jsp" %>
</body>
</html>
<%--<html>--%>

    <%--<div class="container col-md-8">--%>

        <%--<br><br>--%>

        <%--<div class="section-title text-center wow zoomIn mt-5 font-weight-bold">--%>
            <%--<h1>Creer un evenement</h1>--%>
        <%--</div>--%>
        <%--<form action="addEvent" method="post" enctype="multipart/form-data">--%>

            <%--<!-- Title input -->--%>
            <%--<label for="title" class="mt-4">Title d'Evenement</label>--%>
            <%--<input type="text" id="title" name="title" class="form-control ">--%>

            <%--<!-- Body input -->--%>
            <%--<div class="form-group mt-5">--%>
                <%--<label for="description">Description d'Evenemtent</label>--%>
                <%--<textarea class="form-control" id="description" name="description" rows="7"></textarea>--%>
            <%--</div>--%>

            <%--&lt;%&ndash;Date input&ndash;%&gt;--%>
            <%--<label for="date" class="mt-4">Date d'Evenement</label>--%>
            <%--<input type="date" id="date" name="date" class="form-control ">--%>

            <%--<!-- Image input -->--%>
            <%--<div class="input-group mt-5">--%>
                <%--<div class="custom-file">--%>
                    <%--<input type="file" class="custom-file-input" id="imgInput" name="imgInput"--%>
                           <%--aria-describedby="imgInput">--%>
                    <%--<label class="custom-file-label" for="imgInput">Photo de couverture d'evenement</label>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<!-- Submit -->--%>
            <%--<button type="submit" class="btn btn-red my-1 mt-5">Ajouter</button>--%>

        <%--</form>--%>
    <%--</div>--%>

    <%--<%@include file="Footer.jsp"%>--%>
<%--</body>--%>

<%--</html>--%>
