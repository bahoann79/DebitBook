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

/**
 *
 * @author bahoann79
 */
public class VerifyEmailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("userId"));
        int otpId = Integer.parseInt(request.getParameter("otpId"));
        String otpCodeInput = request.getParameter("code");
        OTPService otpService = new OTPService();
        OTPRequest otp = otpService.get(userId, otpId, otpCodeInput);

        String email = request.getParameter("email");
        AccountService accountService = new AccountService();
        Account account = accountService.get(email);

        int otpType = Integer.parseInt(request.getParameter("otpType"));

        if (otp != null) {
            if (!otpService.isTimeExpired(otp.getCreatedAt())) {
                otpService.verifyCodeActive(otp.getId());
                UserService userService = new UserService();
                userService.verifyUserActive(userId);
                
                if (otpType == 1) {
                    String message = "Your account has been registed successfully !";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
                } else if (otpType == 2) {
                    request.getRequestDispatcher("/views/user/changepassword.jsp").forward(request, response);
                }

            } else {
                request.setAttribute("errorMessage", "Code is expired !");
                request.setAttribute("account", account);
                request.setAttribute("otpId", otpId);
                request.setAttribute("otpType", otpType);
                request.getRequestDispatcher("/views/user/verifyEmail.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("errorMessage", "Code is invalid !");
            request.setAttribute("account", account);
            request.setAttribute("otpId", otpId);
            request.setAttribute("otpType", otpType);
            request.getRequestDispatcher("/views/user/verifyEmail.jsp").forward(request, response);
        }

    }
}
