/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dal.AccountDBContext;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import util.MD5;

/**
 *
 * @author bahoann79
 */
public class AccountService {

    public Account get(String username, String password) {
        try {
            AccountDBContext accDB = new AccountDBContext();
            MD5 encode = new MD5();
            Account account = accDB.get(username, encode.encodeMD5(password));
            return account;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
