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
import model.OTPRequest;
import util.Helper;
import util.SQLCommand;

/**
 *
 * @author bahoann79
 */
public class OTPRequestDBContext extends DBContext<OTPRequest> {

    // insert new otp request for user
    public String createOTPRequest(int userId, int otpType) {
        PreparedStatement stm = null;
        String title = null;
        try {
            if (otpType == 1) {
                title = "Register";
            }
            if (otpType == 2) {
                title = "Forgot Password";
            }

            String otpCode = Helper.generateRandomString();
            stm = connection.prepareStatement(SQLCommand.OTP_QUERY_INSERT);
            stm.setString(1, otpCode);
            stm.setString(2, title);
            stm.setInt(3, userId);
            stm.executeUpdate();
            return otpCode;
        } catch (SQLException ex) {
            Logger.getLogger(OTPRequestDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public OTPRequest get(String otpCode) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.prepareStatement(SQLCommand.OTP_QUERY_GET_BY_CODE);
            stm.setString(1, otpCode);
            rs = stm.executeQuery();
            if (rs.next()) {
                OTPRequest otp = new OTPRequest();
                otp.setId(rs.getInt("id"));
                otp.setCode(otpCode);
                otp.setType(rs.getString("type"));
                otp.setIsVerify(rs.getBoolean("isVerify"));
                otp.setCreatedBy(rs.getInt("createdBy"));
                otp.setCreatedAt(rs.getDate("createdAt"));
                return otp;
            }

        } catch (SQLException ex) {
            Logger.getLogger(OTPRequestDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources(connection, stm, rs);
        }
        return null;
    }

    @Override
    public void insert(OTPRequest model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(OTPRequest model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(OTPRequest model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OTPRequest get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<OTPRequest> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
