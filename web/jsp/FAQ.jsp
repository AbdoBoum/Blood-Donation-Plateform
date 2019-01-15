<%--
  Created by IntelliJ IDEA.
  User: ABDERRAHIM
  Date: 15/01/2019
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="Navbar.jsp"%>
    <div class="container" style="margin-top: 100px;">
        <div class="row">
            <div class="col-md-12">
                <div class="section-title text-center wow zoomIn">
                    <h1>Frequently Asked Questions</h1>
                    <span></span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingOne">
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    Why should I donate blood ?
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                            <div class="panel-body">
                                <p>The need for blood affects us all. Eight out of ten people need blood or blood products at some time in our lives. One out of every ten patients in hospital requires blood transfusion. The number of blood donations that patients receive depends on their medical condition. Although an average of three donations is transfused to a patient, some patients require many more.
                                    Blood is in constant demand for the treatment of patients involved in accidents, patients with anaemia, malaria, cancer or a bleeding disorder such as haemophilia. Many surgical operations would not be possible without the availability of blood. Blood may be needed during or following childbirth or for an exchange transfusion in newborn babies. The need for blood never stops. Blood donors save lives. Every blood donation gives the person who receives it a new chance at life. </p>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingTwo">
                            <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                    What do I get in return for my blood donation ?
                                </a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                            <div class="panel-body">
                                <p>Blood is donated voluntarily, freely and without payment or reward of any kind. Blood must only be donated in the spirit of altruism for patients who need blood or blood products as part of their medical treatment. Blood is donated as an act of goodwill towards a fellow human being and nothing should be expected in return for giving this gift of life.
                                    What you do get in return is a physical and emotional sense of well-being and the knowledge that you have helped to save someone's life. We all hope that someone will do the same for us when we need a blood transfusion. </p>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingThree">
                            <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                    Is there anything special I need to do before donating ?
                                </a>
                            </h4>
                        </div>
                        <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                            <div class="panel-body">
                                <p>Eat at your regular mealtimes and drink plenty of fluid before you donate blood. Have a snack at least four hours before you donate, but do not eat too much right before the donation.
                                    Before you leave the blood donor clinic after your blood donation, have some tea, coffee or a soft drink to help replace the blood volume (approximately 450 ml) which has been reduced as a result of your donation.
                                    Avoid taking aspirin or aspirin-like anti-inflammatory medication in the 72 hours prior to your donation, because aspirin inhibits the function of blood platelets. If you have taken aspirin within this period, your blood platelet component cannot be transfused to a patient. </p>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingFour">
                            <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                                    What is the procedure when I donate blood ?
                                </a>
                            </h4>
                        </div>
                        <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
                            <div class="panel-body">
                                <p>Firstly, you will be asked to provide personal details such as your name, address, age, weight, ID number and/or date of birth. A medical history is taken by means of a written questionnaire.
                                    These questions are designed to ascertain that it is medically safe for you to donate blood and that the recipient of your blood will not be harmed in any way. In addition, very personal questions relating to your mode of life and sexual behaviour are asked to ascertain that you are not at increased risk of potentially transmitting infection through transfusion. People are asked to exclude themselves from blood donation if any of the deferral criteria apply to them.
                                    A finger prick test is performed in order to ascertain if your haemoglobin level is within a safe range for donation purposes. Potential donors will be permitted to donate only if this measurement is within the defined, acceptable range. If everything is in order you will proceed to donate your blood. </p>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingFive">
                            <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                                    How long does the donation take ?
                                </a>
                            </h4>
                        </div>
                        <div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
                            <div class="panel-body">
                                <p>The procedure, which is performed by a trained, skilled health-care professional, takes approximately 30 minutes. You will give about 450 ml of blood, after which you will be advised to remain on the donor bed for a few minutes longer and then to take some refreshments. Plan to spend about half an hour to an hour at the blood donor centre for the entire process, depending on the size of the centre and the number of donors. </p>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingSix">
                            <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
                                    Does the needle hurt the entire time ?
                                </a>
                            </h4>
                        </div>
                        <div id="collapseSix" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSix">
                            <div class="panel-body">
                                <p>No. There may be a little sting when the needle is inserted, but there should be no pain whatsoever during the rest of the donation. </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--- END COL -->
        </div><!--- END ROW -->
    </div>
    <%@ include file="Footer.jsp"%>
</head>
<body>

</body>
</html>
