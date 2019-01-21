<%--
  Created by IntelliJ IDEA.
  User: Anass
  Date: 17/01/2019
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="Header.jsp" %>
    <style>
        .form-group.required .control-label:after {
            content:"*";
            color:red;
        }
    </style>
</head>
<body>
<!--- Navbar -->
<%@ include file="Navbar.jsp" %>

<!--- Contenue -->
<div class="container col-md-8" style="margin-top: 100px;">

    <div class="section-title text-center wow zoomIn mt-5 font-weight-bold">
        <h1 class="h1-responsive">Create a Demand</h1>
    </div>

    <div class="row">
        <div class="col col-md-12">
            <form>
                <div class="form-group required">
                    <label for="titleInput" class='control-label'>Demand Title</label>
                    <input type="text" class="form-control" id="titleInput" placeholder="Demand Title">
                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                </div>
                <div class="form-group required">
                    <label for="groupSangSelect" class='control-label'>Blood Type</label>
                    <select class="form-control" id="groupSangSelect" multiple="multiple">
                        <option>A+</option>
                        <option>A-</option>
                        <option>B+</option>
                        <option>B-</option>
                        <option>AB+</option>
                        <option>AB-</option>
                        <option>O+</option>
                        <option>O-</option>
                    </select>
                </div>
                <div class="form-group required">
                    <label for="urgentSelect" class='control-label'>Is Urgent ?</label>
                    <select class="form-control" id="urgentSelect">
                        <option>Yes</option>
                        <option>No</option>
                    </select>
                </div>
                <div class="form-group required">
                    <label for="villeSelect" class='control-label'>City</label>
                    <select class="form-control" id="villeSelect">
                        <option>Rabat</option>
                        <option>Casablanca</option>
                        <option>Taza</option>
                        <option>Fes</option>
                    </select>
                </div>
                <div class="form-group required">
                    <label for="descriptionTextarea" class='control-label'>Demand Description</label>
                    <textarea class="form-control" id="descriptionTextarea" rows="7"></textarea>
                </div>

                <div class="form-group">
                    <label for="inputFile">Image</label>
                    <input type="file" class="form-control-file" id="inputFile" aria-describedby="fileHelp">
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

