<%--
  Created by IntelliJ IDEA.
  User: ABDERRAHIM
  Date: 17/01/2019
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <%@include file="Header.jsp" %>
</head>
<body>
<%@include file="Navbar.jsp" %>

<div class="container col-md-8">

    <br><br>

    <div class="section-title text-center wow zoomIn mt-5 font-weight-bold">
        <h1>Create Blog</h1>
    </div>
    <form action="addBlog" method="post" enctype="multipart/form-data">

        <!-- Title input -->
        <label for="title" class="mt-4">Title</label>
        <input type="text" id="title" name="title" class="form-control ">

        <!-- Body input -->
        <div class="form-group mt-5">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" name="description" rows="7"></textarea>
        </div>

        <!-- Image input -->
        <div class="input-group mt-5">
            <div class="custom-file">
                <input type="file" class="custom-file-input" id="imgInput" name="imgInput"
                       aria-describedby="imgInput">
                <label class="custom-file-label" for="imgInput">Choose file</label>
            </div>
        </div>

        <!-- Submit -->
        <button type="submit" class="btn btn-red my-1 mt-5">Submit</button>

    </form>
</div>

<%@include file="Footer.jsp" %>
</body>
</html>
