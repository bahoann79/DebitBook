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
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Debtor;
import service.DebtorService;
import util.Helper;

/**
 *
 * @author bahoann79
 */
public class DebtorListController extends BaseAuthenticationController {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Account account)
            throws ServletException, IOException, ParseException {

        // get value input of user
        int idFrom = (request.getParameter("idFrom") == null || request.getParameter("idFrom").trim().isEmpty())
                ? -1 : Integer.parseInt(request.getParameter("idFrom"));
        int idTo = (request.getParameter("idTo") == null || request.getParameter("idTo").trim().isEmpty())
                ? -1 : Integer.parseInt(request.getParameter("idTo"));
        String name = (request.getParameter("name") == null || request.getParameter("name").trim().isEmpty())
                ? null : request.getParameter("name");
        String address = (request.getParameter("address") == null || request.getParameter("address").trim().isEmpty())
                ? null : request.getParameter("address");
        String phoneNumber = (request.getParameter("phoneNumber") == null || request.getParameter("phoneNumber").trim().isEmpty())
                ? null : request.getParameter("phoneNumber");
        String email = (request.getParameter("email") == null || request.getParameter("email").trim().isEmpty())
                ? null : request.getParameter("email");
        BigDecimal moneyFrom = (request.getParameter("moneyForm") == null || request.getParameter("moneyForm").trim().isEmpty())
                ? null : new BigDecimal(request.getParameter("moneyForm"));
        BigDecimal moneyTo = (request.getParameter("moneyTo") == null || request.getParameter("moneyTo").trim().isEmpty())
                ? null : new BigDecimal(request.getParameter("moneyTo"));
        Date createdFrom = (request.getParameter("createdFrom") == null || request.getParameter("createdFrom").trim().isEmpty())
                ? null : Helper.toDate(request.getParameter("createdFrom"));
        Date createdTo = (request.getParameter("createdTo") == null || request.getParameter("createdTo").trim().isEmpty())
                ? null : Helper.toDate(request.getParameter("createdTo"));
        Date updatedFrom = (request.getParameter("updatedFrom") == null || request.getParameter("updatedFrom").trim().isEmpty())
                ? null : Helper.toDate(request.getParameter("updatedFrom"));
        Date updatedTo = (request.getParameter("updatedTo") == null || request.getParameter("updatedTo").trim().isEmpty())
                ? null : Helper.toDate(request.getParameter("updatedTo"));

        int userId = account.getUsers().get(0).getId();
        int pageIndex = request.getParameter("page") == null ? 1 : Integer.parseInt("page");
        int pageSize = request.getParameter("size") == null ? 5 : Integer.parseInt(request.getParameter("size"));

        DebtorService debtorService = new DebtorService();
        int totalRecord = debtorService.getTotalRecord(userId);

        ArrayList<Debtor> debtors = debtorService.getDebtorList(userId, idFrom, idTo, name, address, phoneNumber,
                email, moneyFrom, moneyTo, createdFrom, createdTo, updatedFrom, updatedTo, pageIndex, pageSize);

        request.setAttribute("debtors", debtors);
        request.setAttribute("totalRecord", totalRecord);

        request.getRequestDispatcher("/views/user/debtorList.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account account) throws ServletException, IOException {
        try {
            processRequest(request, response, account);
        } catch (ParseException ex) {
            Logger.getLogger(DebtorListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account account) throws ServletException, IOException {
        try {
            processRequest(request, response, account);
        } catch (ParseException ex) {
            Logger.getLogger(DebtorListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
