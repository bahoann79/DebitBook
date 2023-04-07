/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import controller.auth.BaseAuthenticationController;
import dal.DebtorDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.Account;
import model.Debtor;
import service.DebtorService;

/**
 *
 * @author bahoann79
 */
public class DebtorListController extends BaseAuthenticationController {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Account account)
            throws ServletException, IOException {

        DebtorService debtorService = new DebtorService();
        ArrayList<Debtor> debtors = debtorService.getDebtorList(account.getUsers().get(0).getId());

        request.setAttribute("debtors", debtors);
        request.getRequestDispatcher("/views/user/debtorList.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account account) throws ServletException, IOException {
        processRequest(request, response, account);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account account) throws ServletException, IOException {
        processRequest(request, response, account);
    }
}
