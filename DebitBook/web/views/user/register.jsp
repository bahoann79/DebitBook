<%-- 
    Document   : register
    Created on : Mar 9, 2023, 3:05:25 PM
    Author     : bahoann79
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>

        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>

        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/register.css"/>


    </head>
    <body>

        <div class="h1 text-center mt-3  header">Register Form</div>
        <div class="container">
            <div class="content mt-3">
                <div class="h3 text-center content-text">Register a new account</div>
                <p class="text-center content-desc">You has an account? <a href="#">Login Now !</a></p>

                <form action="" name="" class="" id="registerForm" method="">

                    <div class="form-group form-item">
                        <label for="name" class="label-field"> Display Name <span class="text-danger">*</span></label>
                        <input type="text" class="form-control " placeholder="Display Name" id="name" name="name">
                        <div id="name-error" class="text-danger ml-1"></div>
                    </div>

                    <div class="form-group form-item mt-2">
                        <label for="email" class="label-field"> Email <span class="text-danger">*</span></label>
                        <input type="email" class="form-control " placeholder="E-mail" id="email" name="email">
                        <div id="email-error" class="text-danger ml-1"></div>
                    </div>

                    <div class="form-group form-item mt-2">
                        <label for="" id="gender" class="gen"> Gender <span class="text-danger">*</span></label> <br>

                        <button type="button" id="input-male" class="male gender active"> Male </button>
                        <input type="radio" class="" placeholder="" id="male" name="gender" value="1" checked hidden />

                        <button type="button" id="input-female" class="female gender"> Female </button>
                        <input type="radio" class="" placeholder="" id="female" name="gender" value="0" hidden />
                    </div>


                    <div class="form-group  form-item mt-2">
                        <label for="password" class="label-field"> Password <span class="text-danger">*</span></label>
                        <input type="password" class="form-control " placeholder="Password" id="password" name="password">
                        <div id="password-error" class="text-danger ml-1"></div>
                    </div>

                    <div class="form-group mt-3 form-item mt-2">
                        <label for="rePassword" class="label-field"> Confirm Password <span
                                class="text-danger">*</span></label>
                        <input type="password" class="form-control " placeholder="Confirm Password" id="rePassword"
                               name="rePassword">
                        <div id="rePassword-error" class="text-danger ml-1"></div>
                    </div>

                    <div class="form-group mt-3 form-item mt-2">
                        <label for="phoneNumber" class="label-field"> Phone Number <span
                                class="text-danger">*</span></label>
                        <input type="text" class="form-control " placeholder="Phone Number" id="phoneNumber"
                               name="phoneNumber">
                        <div id="phoneNumber-error" class="text-danger ml-1"></div>
                    </div>

                    <div class="form-group mt-3 form-item mt-2">
                        <label for="address" class="label-field"> Address <span class="text-danger">*</span></label>
                        <input type="text" class="form-control " placeholder="Address" id="address" name="address">
                        <div id="address-error" class="text-danger ml-1"></div>
                    </div>

                    <div class="form-group mt-3 form-item mt-2">
                        <label for="img" class="label-field"> Image </label>
                        <input type="file" class="form-control" placeholder="img" id="img" name="img">
                    </div>


                    <div class="form-check mt-4">
                        <a class="form-item-forgot" href="#">Forgot password?</a>
                    </div>

                    <div class="form-group mt-3 form-item-btn">
                        <button type="submit" class="btn btn-primary btn-register form-control"
                                id="register-btn">Register</button>
                    </div>
                </form>

            </div>
        </div>


        <!-- VALIDATE -->
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"
        type="text/javascript"></script>

        <script src="${pageContext.request.contextPath}/assets/js/register.js" ></script>

    </body>
</html>
