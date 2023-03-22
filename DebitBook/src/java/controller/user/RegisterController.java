/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Account;
import model.OTPRequest;
import service.AccountService;
import service.OTPService;
import service.UserService;
import util.Email;

/**
 *
 * @author bahoann79
 */
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        boolean gender = request.getParameter("gender").equals("male");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String defaultImg = gender ? "https://tse2.mm.bing.net/th?id=OIP.zL8PN3yVgzgZxy9ECCdXugHaHc&pid=Api&P=0" : "https://www.pngkit.com/png/full/115-1150342_user-avatar-icon-iconos-de-mujeres-a-color.png";
        String img = (request.getParameter("img").length() == 0 || request.getParameter("img") == null) ? defaultImg : request.getParameter("img");

        AccountService accountService = new AccountService();
        Account accountVerify = accountService.get(email);

        if (accountVerify != null) {
            String errorMessage = "Email already exists. Please try again !";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
        } else {
            accountService.insert(email, password);
            UserService userService = new UserService();
            int userId = userService.insert(name, email, gender, phoneNumber, address, img);

            int otpType = Integer.parseInt(request.getParameter("otpType"));
            OTPService otpService = new OTPService();
            String otpCode = otpService.createOTPRequest(userId, otpType);

            OTPRequest otp = otpService.sendMail(email, otpType, otpCode, name);
            Account account = accountService.get(email);

            request.setAttribute("otp", otp);
            request.setAttribute("account", account);
            request.getRequestDispatcher("views/user/verifyEmail.jsp").forward(request, response);

        }

    }
}
