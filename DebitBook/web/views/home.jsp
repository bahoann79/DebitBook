<%-- 
    Document   : home
    Created on : Mar 3, 2023, 12:03:28 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/home.css"/>

    </head>
    <body>

        <c:import url="/views/header.jsp" />
        <section class="big-image">
            <div class="big-image-content">
                <p>Debit Book <span><i class="fa-regular fa-face-smile-wink"></i></span> </p>
            </div>
        </section>

    </body>
</html>
