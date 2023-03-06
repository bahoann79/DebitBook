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
        } finally {
            closeResources(connection, stm, rs);
        }
        return null;
    }

    @Override
    public void insert(Account model) {
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

    public static void main(String[] args) {
        AccountDBContext accountDBContext = new AccountDBContext();

        Account account = accountDBContext.get("bahoann@gmail.com", "202cb962ac59075b964b07152d234b70");
        System.out.println(account);
    }

}
