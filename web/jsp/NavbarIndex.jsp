<%--
  Created by IntelliJ IDEA.
  User: ABDERRAHIM
  Date: 15/01/2019
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>

<nav class="navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar">
    <div class="container">
        <a class="navbar-brand" href="https://mdbootstrap.com/docs/jquery/" target="_blank">
            <img src="img/logo.png" style="height: 38px; margin-top: -2px;" class="mr-4">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/blog">Blog</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/request">Requests</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/agenda">Agenda</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/faq">FAQ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/about">About us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contact">Contact us</a>
                </li>
            </ul>
            <ul class="navbar-nav nav-flex-icons">
                <li class="nav-item mr-1 ${(not empty sessionScope.donnateur) || (not empty sessionScope.centre) ? 'd-none': ''}">
                    <a href="/login"
                       class="nav-link border border-light rounded">
                        <i class="fas fa-sign-in-alt mr-2"></i>Sign in
                    </a>
                </li>
                <li class="nav-item mr-1 ${(not empty sessionScope.donnateur) || (not empty sessionScope.centre) ? 'd-none': ''}">
                    <a class="nav-link border-light">
                        or
                    </a>
                </li>

                <li class="nav-item ${(not empty sessionScope.donnateur) || (not empty sessionScope.centre)  ? 'd-none': ''}">
                    <a href="/registre" class="nav-link border border-light rounded">
                        <i class="fas fa-user-plus"></i>Sign up
                    </a>
                </li>
                <li class="nav-item dropdown ${(empty sessionScope.donnateur) && (empty sessionScope.centre) ? 'd-none' : ''}">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false">
                        <i class="fas fa-user"></i> ${not empty sessionScope.donnateur.getNomDonnateur() ?
                            sessionScope.donnateur.getNomDonnateur() : sessionScope.centre.getNameCentre()} </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-info" aria-labelledby="navbarDropdownMenuLink-4">
                        <a class="dropdown-item" href="#">My account</a>
                        <a class="dropdown-item" href="logout">Log out</a>
                    </div>
                </li>

            </ul>
        </div>
    </div>
</nav>