<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <%@ include file="jsp/Header.jsp"%>
  </head>
  <body>
    <%@ include file="jsp/NavbarIndex.jsp"%>
    <%@ include file="jsp/Donnateur/SubNavbarDonnateur.jsp"%>
    <div class="view"
         style="background-image: url('./img/home-bg.png'); background-repeat: no-repeat; background-size: cover;">
      <div class="mask rgba-black-light d-flex justify-content-center align-items-center">
        <div class="text-center white-text mx-5 wow fadeIn">
          <h1 class="mb-4 text-center">
            <img src="./img/give-n-save.png" style="display: block; margin-left: auto; margin-right: auto; width: 50%">
          </h1>
          <p>
            <strong>Join our community and be a Hero</strong>
          </p>

          <p class="mb-4 d-none d-md-block">
            <strong>Don’t let these misconceptions stop you from becoming a hero – one bag of blood can save three lives. </strong>
          </p>

          <a  href="/login" class="btn btn-outline-white btn-lg ${(not empty sessionScope.donnateur) || (not empty sessionScope.centre) ? 'invisible': ''}">
            Sign in
          </a>
          <a  href="/registre" class="btn btn-outline-white btn-lg ${(not empty sessionScope.donnateur) || (not empty sessionScope.centre) ? 'invisible': ''}">
            Sign up
          </a>
        </div>
      </div>
    </div>

    <main>
      <div class="container">
        <section class="mt-5 wow fadeIn">
          <h3 class="h3 text-center mb-4">FAQ</h3>
          <div class="line-shape mb-5"></div>
          <div class="row">
            <div class="col-md-6 mb-4">
              <img src="https://www.aub.edu.lb/fas/writing_center/PublishingImages/Pages/FAQ/faq%20(1).png" class="img-fluid z-depth-1-half"
                   alt="faq">
            </div>
            <div class="col-md-6 mb-4">
              <h3 class="h3 mb-3">Blood Donation</h3>
              <p>Find out how often you can donate blood and answers to more frequently asked
                questions about the <strong>blood donation</strong> process ...
              </p>

              <hr>
              <p>
                Giving blood is a quick, simple way to give back to your community.
                Learn about blood donation, FAQ, the donation process and more from BLOOD BROTHERS.
              </p>
              <a  href="/faq"
                 class="btn btn-red btn-md">FAQ
                <i class="fa fa-question-circle ml-1"></i>
              </a>
            </div>
          </div>
        </section>

        <hr class="my-5">

        <section>
          <h3 class="h3 text-center mb-4">About Us</h3>
          <div class="line-shape mb-5"></div>
          <div class="row wow fadeIn">
            <div class="col-lg-6 col-md-12 px-4">
              <div class="row">
                <div class="col-1 mr-3">
                  <i class="fa fa-code fa-2x indigo-text"></i>
                </div>
                <div class="col-10">
                  <h5 class="feature-title">Bootstrap 4</h5>
                  <p class="grey-text">Thanks to MDB you can take advantage of all feature of newest Bootstrap 4.</p>
                </div>
              </div>
              <div style="height:30px"></div>
              <div class="row">
                <div class="col-1 mr-3">
                  <i class="fa fa-book fa-2x blue-text"></i>
                </div>
                <div class="col-10">
                  <h5 class="feature-title">Detailed documentation</h5>
                  <p class="grey-text">We give you detailed user-friendly documentation at your disposal. It will help you
                    to implement your ideas
                    easily.
                  </p>
                </div>
              </div>
              <div style="height:30px"></div>
              <div class="row">
                <div class="col-1 mr-3">
                  <i class="fa fa-graduation-cap fa-2x cyan-text"></i>
                </div>
                <div class="col-10">
                  <h5 class="feature-title">Lots of tutorials</h5>
                  <p class="grey-text">We care about the development of our users. We have prepared numerous tutorials,
                    which allow you to learn
                    how to use MDB as well as other technologies.</p>
                </div>
              </div>
            </div>
            <div class="col-lg-6 col-md-12">
              <p class="h5 text-center mb-4">Watch our "5 min Quick Start" tutorial</p>
              <div class="embed-responsive embed-responsive-16by9">
                <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/cXTThxoywNQ"
                        allowfullscreen></iframe>
              </div>
            </div>
          </div>
        </section>

        <hr class="my-5">

        <section>
          <h3 class="h3 text-center mb-4">Get in touch with us</h3>
          <div class="line-shape mb-4"></div>
          <div class="row wow fadeIn">
            <div class="col-lg-5 col-md-12 px-4 mt-3">
              <div class="row">
                <div class="col-1">
                  <i class="fas fa-map-marker-alt"></i>
                </div>
                <div class="col-10">
                  <h5 class="feature-title">Address</h5>
                  <p class="grey-text">Avenue Mohamed Ben Abdellah Regragui, Rabat</p>
                </div>
              </div>
              <div style="height:30px"></div>
              <div class="row">
                <div class="col-1">
                  <i class="fas fa-phone"></i>
                </div>
                <div class="col-10">
                  <h5 class="feature-title">Phone</h5>
                  <p class="grey-text">+212612345678</p>
                </div>
              </div>
              <div style="height:30px"></div>
              <div class="row">
                <div class="col-1">
                  <i class="fas fa-at"></i>
                </div>
                <div class="col-10">
                  <h5 class="feature-title">Email</h5>
                  <p class="grey-text">ensias.contact@gmail.com</p>
                </div>
              </div>
            </div>
            <div class="col-lg-7 col-md-12">
              <form class="text-center" style="color: #757575;">
                <div class="md-form mt-3">
                  <input type="text" id="materialContactFormName" class="form-control">
                  <label for="materialContactFormName">Name</label>
                </div>
                <div class="md-form">
                  <input type="email" id="materialContactFormEmail" class="form-control">
                  <label for="materialContactFormEmail">E-mail</label>
                </div>
                <div class="md-form">
              <textarea type="text" id="materialContactFormMessage" class="form-control md-textarea"
                        rows="3"></textarea>
                  <label for="materialContactFormMessage">Message</label>
                </div>
                <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect"
                        type="submit" style="border-color: #D92228 !important; color: #D92228 !important;">
                  Send
                </button>
              </form>
            </div>
          </div>
        </section>
      </div>
    </main>

    <%@ include file="jsp/Footer.jsp"%>
  </body>
</html>
