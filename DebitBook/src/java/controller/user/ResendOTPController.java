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
import java.io.PrintWriter;
import model.Account;
import model.OTPRequest;
import service.AccountService;
import service.OTPService;

/**
 *
 * @author bahoann79
 */
public class ResendOTPController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("userId"));
        String email = request.getParameter("email");
        int otpType = Integer.parseInt(request.getParameter("otpType"));

        OTPService otpService = new OTPService();
        String otpCode = otpService.createOTPRequest(userId, otpType);

        AccountService accountService = new AccountService();
        Account account = accountService.get(email);
        OTPRequest otp = otpService.sendMail(email, otpType, otpCode, account.getUsers().get(0).getName());

        String message = "Code has resend !";
        request.setAttribute("message", message);
        request.setAttribute("account", account);
        request.setAttribute("otpId", otp.getId());
        request.setAttribute("otpType", otpType);
        request.getRequestDispatcher("views/user/verifyEmail.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
