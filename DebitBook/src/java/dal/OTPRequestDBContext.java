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

    // singleton design patttern
    private static OTPRequestDBContext instance;

    //a single object is used throughout the application, minimizing conflicts and avoiding memory waste.
    public static OTPRequestDBContext getInstance() {
        return instance = instance != null ? instance : new OTPRequestDBContext();
    }

    String messageRegister = "<div style=\"text-align: center; background-color: #d3d3d3; padding: 10px; font-size: 20px;\">\n"
            + "        You or someone else used email to activate account when you signed up with name: <h1\n"
            + "            style=\"color:black; margin: 4px;\">display_name</h1>\n"
            + "        Here is the code to activate the account: <h1 style=\"color: red; margin: 4px;\">otp_code</h1>\n"
            + "        <p style=\"font-style: italic;\"> Note: This code can only be used within 2 minutes from the time of sending </p>\n"
            + "    </div>";

    String messageForgotPassword = "  <div style=\"text-align: center; background-color: #d3d3d3; padding: 10px; font-size: 20px;\">\n"
            + "        You or someone else used email when you forgot your password with an account named: <h1\n"
            + "            style=\"color:black; margin: 4px;\">display_name</h1>\n"
            + "        Here is the code to activate the account: <h1 style=\"color: red; margin: 4px;\">otp_code</h1>\n"
            + "        <p style=\"font-style: italic;\"> Note: This code can only be used within 2 minutes from the time of sending </p>\n"
            + "    </div>";

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
        }
        return null;
    }

    public OTPRequest get(int userId, int otpId, String otpCode) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.prepareStatement(SQLCommand.OTP_QUERY_GET_BY_CODE_NOT_ACTIVE);
            stm.setInt(1, userId);
            stm.setInt(2, otpId);
            stm.setString(3, otpCode);
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
        }
        return null;
    }

    public String messageType(int otpType, String otpCode, String name) {
        String message = "";

        if (otpType == 1) {
            message = messageRegister;
        }
        if (otpType == 2) {
            message = messageForgotPassword;
        }

        String replaceName = message.replace("display_name", name);
        String replacedCode = replaceName.replace("otp_code", otpCode);

        return replacedCode;
    }

    public void verifyCodeActive(int otpId) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(SQLCommand.OTP_QUERY_VERIFY_CODE_ACTIVE);
            stm.setInt(1, otpId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OTPRequestDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void insert(OTPRequest model) {
    }

    @Override
    public void update(OTPRequest model) {
    }

    @Override
    public void delete(OTPRequest model) {
    }

    @Override
    public OTPRequest get(int id) {
        return null;
    }

    @Override
    public ArrayList<OTPRequest> list() {
        return null;
    }
}
