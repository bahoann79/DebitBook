/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

    public ArrayList<Debtor> list(int userId, int idFrom, int idTo, String name, String address, String phoneNumber, String email,
            BigDecimal moneyFrom, BigDecimal moneyTo, Date createdFrom, Date createdTo, Date updatedFrom, Date updatedTo, int pageIndex, int pageSize) {
        PreparedStatement stm = null;
        ResultSet rs = null;

        ArrayList<Debtor> debtors = new ArrayList<>();
        try {
            String sql = SQLCommand.DEBTOR_QUERY_GET_LIST_DEBTOR;
            List<Object> params = new ArrayList<>();
            params.add(userId);

            if (idFrom != -1) {
                sql += " AND id >= ?";
                params.add(idFrom);
            }
            if (idTo != -1) {
                sql += " AND id <= ?";
                params.add(idTo);
            }
            if (name != null) {
                sql += " AND name LIKE '%' + ? + '%' ";
                params.add(name);
            }
            if (address != null) {
                sql += " AND address LIKE '%' + ? + '%' ";
                params.add(address);
            }
            if (phoneNumber != null) {
                sql += " AND [phone_number] LIKE '%' + ? + '%' ";
                params.add(phoneNumber);
            }
            if (email != null) {
                sql += " AND email LIKE '%' + ? + '%' ";
                params.add(email);
            }
            if (moneyFrom != null) {
                sql += " AND total_money >= ?";
                params.add(moneyFrom);
            }
            if (moneyTo != null) {
                sql += " AND total_money <= ?";
                params.add(moneyTo);
            }
            if (createdFrom != null) {
                sql += " AND createdAt >= ?";
                params.add(createdFrom);
            }
            if (createdTo != null) {
                sql += " AND createdAt <= ?";
                params.add(createdTo);
            }
            if (updatedFrom != null) {
                sql += " AND updatedAt >= ?";
                params.add(updatedFrom);
            }
            if (updatedTo != null) {
                sql += " AND updatedAt <= ?";
                params.add(updatedTo);
            }

            sql += ") t\n"
                    + "WHERE rownum > (? - 1) * ? AND rownum <= ? *  ?";

            params.add(pageIndex);
            params.add(pageSize);
            params.add(pageIndex);
            params.add(pageSize);

            stm = connection.prepareStatement(sql);
            int paramSize = params.size();
            for (int i = 0; i < paramSize; i++) {
                Object param = params.get(i);
                if (param instanceof Integer) {
                    stm.setInt(i + 1, (Integer) param);
                } else if (param instanceof String) {
                    stm.setString(i + 1, (String) param);
                } else if (param instanceof Boolean) {
                    stm.setBoolean(i + 1, (Boolean) param);
                } else if (param instanceof java.sql.Date) {
                    stm.setDate(i + 1, (java.sql.Date) param);
                } else if (param instanceof BigDecimal) {
                    stm.setBigDecimal(i + 1, (BigDecimal) param);
                }
            }

            rs = stm.executeQuery();
            while (rs.next()) {
                Debtor debtor = new Debtor();
                debtor.setId(rs.getInt("id"));
                debtor.setName(rs.getString("name"));
                debtor.setEmail(rs.getString("email"));
                debtor.setAddress(rs.getString("address"));
                debtor.setPhoneNumber(rs.getString("phone_number"));
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

    public int getTotalRecord(int userId) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.prepareStatement(SQLCommand.DEBTOR_QUERY_GET_TOTAL_RECORD_OF_USER);
            stm.setInt(1, userId);
            rs = stm.executeQuery();
            int totalRecord = 0;
            if (rs.next()) {
                totalRecord = rs.getInt("total_record");
            }
            return totalRecord;
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
