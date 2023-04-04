<%-- 
    Document   : profile
    Created on : Mar 20, 2023, 10:54:43 PM
    Author     : bahoann79
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>     
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/profile.css"/>

    </head>
    <body>

        <c:import url="/views/header.jsp" />

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
                            <input type="text" class="form-control" value="${user.name}" readonly>
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
                            <input type="text" class="form-control" value="${user.email}" readonly>
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
                            <input type="password" class="form-control" value="******" readonly>
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
                            <input type="text" class="form-control" value="${user.address}" readonly>
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
                            <input type="text" class="form-control" value="${user.phoneNumber}" readonly>
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
                            <c:if test="${user.gender}">
                                <button type="button" id="input-male" class="male gender actived"> Male </button>
                                <button type="button" id="input-female" class="female gender"> Female </button>
                            </c:if>

                            <c:if test="${!user.gender}">
                                <button type="button" id="input-male" class="male gender"> Male </button>
                                <button type="button" id="input-female" class="female gender actived"> Female </button>
                            </c:if>
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

        <c:import url="/views/footer.jsp" />

    </body>
</html>
