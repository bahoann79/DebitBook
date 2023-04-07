/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dal.DebtorDBContext;
import java.util.ArrayList;
import model.Debtor;

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

}
