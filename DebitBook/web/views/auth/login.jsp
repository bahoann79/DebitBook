<%-- 
    Document   : login
    Created on : Mar 3, 2023, 10:15:32 AM
    Author     : bahoann79
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

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

        <script src="https://www.google.com/recaptcha/api.js"></script>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css"/>

    </head>
    <body>

        <div class="h1 text-center mt-4 mb-2 header">Login Form</div>

        <c:if test="${requestScope.errorMessage ne null}">
            <div class="alert alert-danger text-center">
                ${requestScope.errorMessage}
            </div>
        </c:if>
        <c:if test="${requestScope.message ne null}">
            <div class="alert alert-success text-center">
                ${requestScope.message}
            </div>
        </c:if>

        <div class="container">
            <div class="content mt-3">

                <div class="h3 text-center content-text">Login to your account</div>
                <p class="text-center content-desc">Don't have an account? <a href="register">Sign Up Now !</a></p>

                <form action="login" class="mt-4" id="loginForm" method="post"  >

                    <div class="form-group form-item">
                        <label for="email" class="label-field">Email <span class="text-danger">*</span></label>
                        <input type="email" class="form-control " placeholder="E-mail" id="email" name="email">
                        <div id="email-error" class="text-danger ml-1"></div>
                    </div>

                    <div class="form-group mt-3 form-item">
                        <label for="password" class="label-field">Password <span class="text-danger">*</span></label>
                        <input type="password" class="form-control " placeholder="Password" id="password" name="password">
                        <div id="password-error" class="text-danger ml-1"></div>
                    </div>

                    <div class="g-recaptcha" data-sitekey="6LeBzHwkAAAAADz0I_qTXDeh5BhEPIk2dJ2lMcuW"></div>

                    <div class="form-check mt-4">
                        <a class="form-item-forgot" href="forgotPassword">Forgot password?</a>
                    </div>

                    <div class="form-group mt-3 form-item-btn">
                        <button type="submit" class="btn btn-primary btn-register form-control"
                                id="login-btn">Login</button>
                    </div>
                </form>
            </div>
        </div>

        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"
        type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/login.js" ></script>



    </body>
</html>
