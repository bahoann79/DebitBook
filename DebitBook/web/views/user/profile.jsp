<%-- 
    Document   : profile
    Created on : Mar 20, 2023, 10:54:43 PM
    Author     : bahoann79
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        
          <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
         <link rel="stylesheet" href="./assets/css/home.css">

        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
        <!-- ICON -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" >

         <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/profile.css"/>
        
    </head>
    <body>

        <!-- START HEADER -->
        <nav class="navbar navbar-expand-lg navbar-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="./assets/img/logo.png" alt="" width="52" height="46">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#btn-navbar"
                        aria-controls="btn-navbar" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="btn-navbar">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 list-btn">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i class="fa-regular fa-bell"></i>
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link" href="#" id="user-dropdown" role="button" data-bs-toggle="dropdown"
                               aria-expanded="false">
                                <i class="fa-regular fa-user"></i>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="user-dropdown">
                                <li><a class="dropdown-item" href="#">Profile</a></li>
                                <li><a class="dropdown-item" href="#">Debit Book</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="#">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- END HEADER -->

        <div class="container">

            <h1 class="text-center">Profile</h1>

            <div class="content row">
                <div class="content-left col-md-6">
                    <img src="/DebitBook/assets/img/VND.jpg">
                </div>

                <div class="content-right col-md-6">
                    <!-- Username -->
                    <div class="row align-items-center mt-3">
                        <div class="col-md-3">
                            <label class="col-form-label">Name</label>
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" value="Nguyễn Bá Hoàn" readonly>
                        </div>
                        <div class="col-md-2">
                            <button type="button" class="btn btn-primary form-control">
                                Edit
                            </button>
                        </div>
                    </div>

                    <!-- Email -->
                    <div class="row align-items-center mt-3">
                        <div class="col-md-3">
                            <label class="col-form-label">Email</label>
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" value="bahoann79@gmail.com" readonly>
                        </div>
                        <div class="col-md-2">
                            <button type="button" class="btn btn-primary form-control" disabled >
                                Edit
                            </button>
                        </div>
                    </div>

                    <!-- Password -->
                    <div class="row align-items-center mt-3">
                        <div class="col-md-3">
                            <label class="col-form-label">Password</label>
                        </div>
                        <div class="col-md-6">
                            <input type="password" class="form-control" value="bahoann79@gmail.com" readonly>
                        </div>
                        <div class="col-md-2">
                            <button type="button" class="btn btn-primary form-control">
                                Edit
                            </button>
                        </div>
                    </div>

                    <!-- Address -->
                    <div class="row align-items-center mt-3">
                        <div class="col-md-3">
                            <label class="col-form-label">Address</label>
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" value="Ha Noi" readonly>
                        </div>
                        <div class="col-md-2">
                            <button type="button" class="btn btn-primary form-control">
                                Edit
                            </button>
                        </div>
                    </div>

                    <!-- Phone Number -->
                    <div class="row align-items-center mt-3">
                        <div class="col-md-3">
                            <label class="col-form-label">Phone Number</label>
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" value="0983239802" readonly>
                        </div>
                        <div class="col-md-2">
                            <button type="button" class="btn btn-primary form-control">
                                Edit
                            </button>
                        </div>
                    </div>

                    <!-- Gender -->
                    <div class="row align-items-center mt-3 mb-3">
                        <div class="col-md-3">
                            <label class="col-form-label">Gender</label>
                        </div>
                        <div class="col-md-6">
                            <button type="button" id="input-male" class="male gender actived"> Male </button>
                            <input type="radio" class="" placeholder="" id="male" name="gender" value="1" checked hidden />
                            <button type="button" id="input-female" class="female gender"> Female </button>
                            <input type="radio" class="" placeholder="" id="female" name="gender" value="0" hidden />
                        </div>
                        <div class="col-md-2">
                            <button type="button" class="btn btn-primary form-control" disabled>
                                Edit
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- START FOOTER -->
        <div class="text-center mt-5 footer">
            <strong>If you have any questions please contact : </strong> Email: <a href="#">bahoann79@gmail.com</a>
            . Phone Number: <strong>0983239802</strong>
            <p>© Authored by <a href="fb.com/bahoann79">torao</a>
        </div>
        <!-- END FOOTER -->
    </body>
</html>
