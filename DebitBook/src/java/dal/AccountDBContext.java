/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.User;
import util.SQLCommand;

/**
 *
 * @author bahoann79
 */
public class AccountDBContext extends DBContext<Account> {

    // singleton design patttern
    private static AccountDBContext instance;

    //a single object is used throughout the application, minimizing conflicts and avoiding memory waste.
    public static AccountDBContext getInstance() {
        return instance = instance != null ? instance : new AccountDBContext();
    }

    public Account get(String username, String password) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.prepareStatement(SQLCommand.ACCOUNT_QUERY_FIND_BY_USERNAME_AND_PASSWORD);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setUsername(username);
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(username);
                user.setAddress(rs.getString("address"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setGender(rs.getBoolean("gender"));
                account.getUsers().add(user);
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Account get(String username) {
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = connection.prepareStatement(SQLCommand.ACCOUNT_QUERY_FIND_BY_USERNAME);
            stm.setString(1, username);
            rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setUsername(rs.getString("username"));
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(username);
                user.setAddress(rs.getString("address"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setGender(rs.getBoolean("gender"));
                account.getUsers().add(user);
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Account model) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(SQLCommand.ACCOUNT_QUERY_INSERT);
            stm.setString(1, model.getUsername());
            stm.setString(2, model.getPassword());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Account model) {
    }

    @Override
    public void delete(Account model) {
    }

    @Override
    public Account get(int id) {
        return null;
    }

    @Override
    public ArrayList<Account> list() {
        return null;
    }
}
