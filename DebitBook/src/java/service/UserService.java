/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dal.AccountDBContext;
import dal.UserDBContext;
import model.Account;
import model.User;

/**
 *
 * @author bahoann79
 */
public class UserService {

    // insert new user & get user id
    public int insert(String name, String email, boolean gender, String phoneNumber, String address, String img) {
        User user = new User(name, email, address, phoneNumber, gender, img);
        UserDBContext userDB = new UserDBContext();
        userDB.insert(user);
        AccountDBContext accDB = new AccountDBContext();
        Account account = accDB.get(user.getEmail());
        int userId = account.getUsers().get(0).getId();
        return userId;
    }

}
