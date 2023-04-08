/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Debtor;
import util.SQLCommand;

/**
 *
 * @author bahoann79
 */
public class DebtorDBContext extends DBContext<Debtor> {

    // singleton design patttern
    private static DebtorDBContext instance;

    //a single object is used throughout the application, minimizing conflicts and avoiding memory waste.
    public static DebtorDBContext getInstance() {
        return instance = instance != null ? instance : new DebtorDBContext();
    }

    public ArrayList<Debtor> list(int userId) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<Debtor> debtors = new ArrayList<>();
        try {
            stm = connection.prepareStatement(SQLCommand.DEBTOR_QUERY_GET_LIST_DEBTOR_BY_USER_ID);
            stm.setInt(1, userId);
            rs = stm.executeQuery();

            while (rs.next()) {
                Debtor debtor = new Debtor();
                debtor.setId(rs.getInt("id"));
                debtor.setName(rs.getString("name"));
                debtor.setEmail(rs.getString("email"));
                debtor.setAddress(rs.getString("address"));
                debtor.setPhoneNumber(rs.getString("phone_number"));
                debtor.setGender(rs.getBoolean("gender"));
                debtor.setCreatedAt(rs.getDate("createdAt"));
                debtor.setUpdatedAt(rs.getDate("updatedAt"));
                debtor.setTotalMoney(rs.getBigDecimal("total_money"));
                debtors.add(debtor);
            }
            return debtors;

        } catch (SQLException ex) {
            Logger.getLogger(DebtorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int getNumberPage() {

        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) as totalPage  FROM Debtor ";
        try {
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            int totalPage = 0;
            while (rs.next()) {
                totalPage = rs.getInt("totalPage");
                int countPage = totalPage / 5;
            }
            return totalPage;
        } catch (SQLException ex) {
            Logger.getLogger(DebtorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public void insert(Debtor model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Debtor model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Debtor model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Debtor get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Debtor> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
