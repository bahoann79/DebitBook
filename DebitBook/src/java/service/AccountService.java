/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dal.AccountDBContext;
import model.Account;

/**
 *
 * @author bahoann79
 */
public class AccountService {

    public Account get(String username, String password) {
        AccountDBContext accDB = new AccountDBContext();
        Account account = accDB.get(username, password);
        return account;
    }
    
    


}
