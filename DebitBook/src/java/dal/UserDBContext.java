/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import util.SQLCommand;

/**
 *
 * @author bahoann79
 */
public class UserDBContext extends DBContext<User> {

    // singleton design patttern
    private static UserDBContext instance;

    //a single object is used throughout the application, minimizing conflicts and avoiding memory waste.
    public static UserDBContext getInstance() {
        return instance = instance != null ? instance : new UserDBContext();
    }

    @Override
    public void insert(User model) {
        PreparedStatement stm = null;
        try {

            stm = connection.prepareStatement(SQLCommand.USER_QUERY_INSERT);
            stm.setString(1, model.getName());
            stm.setString(2, model.getEmail());
            stm.setString(3, model.getAddress());
            stm.setString(4, model.getPhoneNumber());
            stm.setBoolean(5, model.isGender());
            stm.setString(6, model.getImage());
            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // set status for user is verified
    public void verifyUserActive(int userId) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(SQLCommand.USER_QUERY_VERIFY_USER_ACTIVE);
            stm.setInt(1, userId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(User model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(User model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<User> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
