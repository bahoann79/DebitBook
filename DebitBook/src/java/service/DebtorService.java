/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dal.DebtorDBContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import model.Debtor;
import util.Helper;

/**
 *
 * @author bahoann79
 */
public class DebtorService {

//    get list debtor by user id
    public ArrayList<Debtor> getDebtorList(int userId) {
        ArrayList<Debtor> debtors = DebtorDBContext.getInstance().list(userId);
        return debtors;
    }

    public int getTotalRecord(int userId) {
        int totalRecord = DebtorDBContext.getInstance().getTotalRecord(userId);
        return totalRecord;

    }

    public ArrayList<Debtor> getDebtorList(int userId, int idFrom, int idTo, String name, String address, String phoneNumber,
            String email, BigDecimal moneyFrom, BigDecimal moneyTo, Date createdFrom, Date createdTo, Date updatedFrom, Date updatedTo, int pageIndex, int pageSize) {

        Date fromCreated = createdFrom == null ? null : Helper.toSQLDate(createdFrom);
        Date toCreated = createdTo == null ? null : Helper.toSQLDate(createdTo);
        Date fromUpdated = updatedFrom == null ? null : Helper.toSQLDate(updatedFrom);
        Date toUpdated = updatedTo == null ? null : Helper.toSQLDate(updatedTo);

        ArrayList<Debtor> debtors = DebtorDBContext.getInstance().list(userId, idFrom, idTo, name, address, phoneNumber, email, moneyFrom, moneyTo,
                fromCreated, toCreated, fromUpdated, toUpdated, pageIndex, pageSize);
        return debtors;
    }

}
