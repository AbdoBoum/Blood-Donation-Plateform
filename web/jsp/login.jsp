<%--
  Created by IntelliJ IDEA.
  User: ABDERRAHIM
  Date: 18/01/2019
  Time: 20:04
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
<br><br><br>
<c:if test="${(not empty sessionScope.donnateur) || (not empty sessionScope.centre)}">
    <c:redirect url="/"></c:redirect>
</c:if>
<div class="container col-md-4 align-content-center mt-5 mb-5">
    <div class="card">
        <!-- Default form login -->

        <h5 class="card-header white-text text-center py-4" style="background: #AE1F23">
            <strong>Sign in</strong>
        </h5>
        <div class="card-body">
            <form class="text-center border border-light p-3" method="post" action="login">
                <!-- Email -->
                <input type="email" id="defaultLoginFormEmail" class="form-control mb-4" placeholder="E-mail"
                       name="email">

                <!-- Password -->
                <input type="password" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Password"
                       name="password">

                <div class="d-flex justify-content-around">
                    <div>
                        <!-- Remember me -->
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
                            <label class="custom-control-label" for="defaultLoginFormRemember">Remember me</label>
                        </div>
                    </div>
                    <div>
                        <!-- Forgot password -->
                        <a href="">Forgot password?</a>
                    </div>
                </div>

                <!-- Sign in button -->
                <button class="btn btn-block my-4" style="background: #AE1F23" type="submit">Sign in</button>

                <!-- Register -->
                <p>Not a member?
                    <a href="">Register</a>
                </p>

                <!--
                <p>or sign in with:</p>

                <a type="button" class="btn-floating btn-fb btn-sm">
                    <i class="fab fa-facebook-f"></i>
                </a>
                <a type="button" class="btn-floating btn-tw btn-sm">
                    <i class="fab fa-twitter"></i>
                </a>
                <a type="button" class="btn-floating btn-li btn-sm">
                    <i class="fab fa-linkedin-in"></i>
                </a>
                <a type="button" class="btn-floating btn-git btn-sm">
                    <i class="fab fa-github"></i>
                </a>
                Social login -->

            </form>
            <!-- Default form login -->
        </div>
    </div>
    <c:if test="${not empty msg}">
        <p>
            <div class="alert alert-danger">${msg}</div>
        </p>
    </c:if>
</div>
<%@include file="Footer.jsp"%>
</body>
</html>
