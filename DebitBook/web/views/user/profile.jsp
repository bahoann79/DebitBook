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
    </head>
    <body>
        <div class="box">
            <img src="/DebtSystem/assets/image/dola.jpg" alt="">
            <form action="profile" method="post" class="form">
                <input type="hidden" name="userID" maxlength="150" value="${user.user_id}">
                <div class="profile_email">
                    <label>Email:</label>
                    <input class="bar_email" type="text" name="email" value="${user.email}"></br>
                </div>

                <div class="profile_username">
                    <label>UserName:</label>
                    <input class="bar_username" type="text" name="name" value="${user.display_name}" ><a href="edit?type=username"> Edit </a></br>
                </div>

                <div class="profile_phone">
                    <label>Phone number:</label>
                    <input class="bar_phone" type="text" name="phoneNumber" value="${user.phone_number}"><a href="edit?type=phone"> Edit </a>  </br>

                </div>



                <div class="profile_address" >
                    <label>Address:</label>
                    <input class="bar_address" type="textarea" name="address" value="${user.adr}"><a href="edit?type=address"> Edit </a> </br>
                </div>

                <div class="profile_changepassword" >
                    <label>Password:</label>
                    <input class="bar_address" type="password" name="address" value="***************"><a href="changepassword?email=${user.email}"> Edit </a> </br>
                </div>
            </form>

        </div>
    </body>
</html>
