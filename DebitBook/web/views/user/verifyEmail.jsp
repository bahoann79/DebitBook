<%-- 
    Document   : verify
    Created on : Mar 10, 2023, 9:26:09 PM
    Author     : bahoann79
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Page</title>

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

        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/verifyEmail.css"/>

    </head>
    <body>

        <c:if test="${requestScope.errorMessage ne null}">
            <div class="alert alert-danger text-center mt-5">
                ${requestScope.errorMessage}
            </div>
        </c:if>

        <c:if test="${requestScope.message ne null}">
            <div class="alert alert-success text-center mt-5">
                ${requestScope.message}
            </div>
        </c:if>

        <div class="container">
            <div class="content mt-5">
                <div class="h3 text-center content-text">Verify your email</div>

                <form action="verifyEmail" class="mt-4" id="verifyEmailForm" method="post"  >
                    <p>Email: ${requestScope.account.username}</p>
                    <p>Display Name: ${requestScope.account.getUsers().get(0).getName()}</p>
                    <p>Phone Number: ${requestScope.account.getUsers().get(0).getPhoneNumber()}</p>
                    <input  name="userId" type="hidden" value="${requestScope.account.getUsers().get(0).getId()}">
                    <input  name="otpId" type="hidden" value="${requestScope.otpId}"> 
                    <input  name="email" type="hidden" value="${requestScope.account.username}"> 
                    <input  name="otpType" type="hidden" value="${requestScope.otpType}">
                    <div class="form-group form-item">
                        <label for="code" class="label-field">Code Active <span class="text-danger">*</span></label>
                        <input type="text" class="form-control " placeholder="Enter your code" id="code" name="code">
                        <div id="code-error" class="text-danger ml-1"></div>                   
                    </div>

                    <div class="form-group mt-4 form-item-btn">
                        <div class="resend-btn">
                            <button type="button" class="btn btn-danger form-control" id="resend-btn">
                                <a href=
                                   "resend?userId=${requestScope.account.getUsers().get(0).getId()}&email=${requestScope.account.username}&otpType=${requestScope.otpType}">
                                    Resend
                                </a>
                            </button>
                        </div>

                        <div class="submit-btn">
                            <button type="submit" class="btn btn-primary form-control" id="active-btn">Active</button>
                        </div>
                    </div>

                </form>
            </div>
        </div>

        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"
        type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/verifyEmail.js"></script>

    </body>
</html>
