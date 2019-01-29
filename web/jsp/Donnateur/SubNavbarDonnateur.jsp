<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 24/01/2019
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>

<!--Main Navigation-->


<c:if test="${not empty sessionScope.centre}">

    <nav class=" fixed-top navbar-expand-lg navbar-dark"
         style="position: absolute; top: 75px; background-color: transparent !important;">
        <div class="container">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav" style="padding-left: 16%;">

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                           aria-haspopup="true"
                           aria-expanded="false">Donor management</a>
                        <div class="dropdown-menu dropdown-secondary">
                            <a class="dropdown-item" href="/addDonnateur">Create Donor</a>
                            <a href="" data-toggle="modal" data-target="#updateModal" class="dropdown-item">Update
                                Donor</a>

                        </div>
                    </li>

                    <!--  STOCK MANAGEMENT  -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                           aria-haspopup="true"
                           aria-expanded="false">Stock management</a>
                        <div class="dropdown-menu dropdown-secondary">
                            <a class="dropdown-item" href="/statistics">Statistics</a>
                            <a href="" data-toggle="modal" data-target="#addBlood" class="dropdown-item">Add</a>
                            <a href="" data-toggle="modal" data-target="#deleteBlood" class="dropdown-item">Delete</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="/addEvent" role="button">Add Event</a>
                    </li>
                    <!--  STOCK MANAGEMENT  -->


                </ul>

            </div>
        </div>
    </nav>


    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header text-center">
                    <h4 class="modal-title w-100 font-weight-bold">Update Donor</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form method="get" action="/updateDonnateur">
                    <div class="modal-body mx-3">
                        <div class="row ">
                            <div class="form-group required col-sm-12">
                                <label for="id" class='control-label'>Id Donor</label>
                                <input type="text" name="id" class="form-control" id="id"
                                       placeholder="Identifiant donnateur">
                                <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                            </div>
                        </div>

                    </div>
                    <div class="modal-footer d-flex justify-content-center">

                        <div class="col-sm-4">
                            <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect"
                                    type="submit" style="border-color: #D92228 !important; color: #D92228 !important;">
                                update
                            </button>
                        </div>


                    </div>
                </form>
            </div>
        </div>
    </div>



    <!--  STOCK MANAGEMENT  -->

    <div class="modal fade" id="addBlood" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header text-center">
                    <h4 class="modal-title w-100 font-weight-bold">ADD</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form method="post" action="addstock">
                    <div class="modal-body mx-3">
                        <div class="form-group required">
                            <!-- quantity -->
                            <label for="quantity" class="control-label mt-4">Quantity to add (by bags)</label>
                            <input type="number" id="quantity" name="quantity" class="form-control "/>
                            <!-- type -->
                            <label for="groupSang" class="control-label mt-4">Blood type</label>
                            <select class="browser-default custom-select form-control" name="groupSang" id="groupSang">
                                <option selected value="">Choose blood type</option>
                                    <option value="1">A+</option>
                                    <option value="2">A-</option>
                                    <option value="3">B+</option>
                                    <option value="4">B-</option>
                                    <option value="5">AB+</option>
                                    <option value="6">AB-</option>
                                    <option value="7">O+</option>
                                    <option value="8">O-</option>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer d-flex justify-content-center">
                        <div class="col-sm-4">
                            <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect"
                                    type="submit" style="border-color: #D92228 !important; color: #D92228 !important;">
                                Add
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="modal fade" id="deleteBlood" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header text-center">
                    <h4 class="modal-title w-100 font-weight-bold">DELETE</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form method="post" action="deletestock">
                    <div class="modal-body mx-3">
                        <div class="form-group required">
                            <!-- quantity -->
                            <label for="quantity2" class="control-label mt-4" >Quantity to delete (by bags)</label>
                            <input type="number" id="quantity2" name="quantity" class="form-control "/>
                            <!-- type -->
                            <label for="groupSang2" class="control-label mt-4">Blood type</label>
                            <select class="browser-default custom-select form-control" name="groupSang" id="groupSang2">
                                <option selected value="">Choose blood type</option>
                                <option value="1">A+</option>
                                <option value="2">A-</option>
                                <option value="3">B+</option>
                                <option value="4">B-</option>
                                <option value="5">AB+</option>
                                <option value="6">AB-</option>
                                <option value="7">O+</option>
                                <option value="8">O-</option>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer d-flex justify-content-center">
                        <div class="col-sm-4">
                            <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect"
                                    type="submit" style="border-color: #D92228 !important; color: #D92228 !important;">
                                DELETE
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

</c:if>

<!--Main Navigation-->
