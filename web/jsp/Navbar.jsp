<%--
  Created by IntelliJ IDEA.
  User: ABDERRAHIM
  Date: 15/01/2019
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>

<nav class="navbar fixed-top navbar-expand-lg navbar-dark top-nav-collapse">
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
                    <a class="nav-link" href="/forum">Forum</a>
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
                <!-- to set button invisible if the user is connected -->
                <li class="nav-item mr-1 ${not empty sessionScope.donnateur ? 'invisible': ''}">
                    <a href="/login"
                       class="nav-link border border-light rounded"
                       target="_blank">
                        <i class="fas fa-sign-in-alt mr-2"></i>Sign in
                    </a>
                </li>
                <li class="nav-item mr-1 ${not empty sessionScope.donnateur ? 'invisible': ''}">
                    <a class="nav-link border-light">
                        or
                    </a>
                </li>
                <li class="nav-item ${not empty sessionScope.donnateur ? 'invisible': ''}">
                    <a href="#"
                       class="nav-link border border-light rounded"
                       target="_blank">
                        <i class="fas fa-user-plus mr-2"></i>Sign up
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>