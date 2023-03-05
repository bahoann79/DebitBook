/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Account;
import service.AccountService;
import util.VerifyRecaptcha;

/**
 *
 * @author bahoann79
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("email");
        String password = request.getParameter("password");
        AccountService accountService = new AccountService();
        Account account = accountService.get(username, password);

        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);

        if (account != null && verify) {
            request.getSession().setAttribute("account", account);
            response.sendRedirect("home?userId=" + account.getUsers().get(0).getId());
        } else {
            if (verify) {
                String message = "Your email or password is invalid. Please try again !";
                request.setAttribute("message", message);
            } else {
                String message = "You missed the Captcha";
                request.setAttribute("message", message);
            }
            request.getRequestDispatcher("views/auth/login.jsp").forward(request, response);

        }

    }
}
