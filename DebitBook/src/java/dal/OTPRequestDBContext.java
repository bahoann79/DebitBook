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

    String messageRegister = " <div style=\"text-align: center;\n"
            + "       background-color: #d3d3d3;\n"
            + "       padding: 10px;    font-size: 20px;;\">"
            + "Bạn hoặc ai đó đã sử dụng email để kích hoạt tài khoản khi đăng ký có tên " + "<h1>display_name</h1>" + "\n"
            + "\n"
            + "Ðây là  đoạn mã để kích hoạt tài khoản : <h1 style=\"color: red;\">otp_code</h1>\n"
            + "\n"
            + " <p style=\"font-style: italic;\"> Lưu ý: Mã code này chỉ có thẻ sử dụng  trong vòng 2 phút kể từ thời gian  gửi . Sau thời gian trên hãy sử dụng chức năng quên mật khẩu để tiến hành tạo mới mật khẩu và kích hoạt tài khoản. </p>\n"
            + "\n"
            + "\n"
            + "<p style=\"font-weight: 800;\">Trân trọng cảm ơn!!</p>"
            + "</div>";

    String messageForgotPassword = " <div style=\"text-align: center;\n"
            + "       background-color: #d3d3d3;\n"
            + "       padding: 10px;    font-size: 20px;\">"
            + "Bạn hoặc ai đó đã sử dụng email khi quên mật khẩu với tài khoản có tên " + "<h1>display_name</h1>" + "\n"
            + "\n"
            + "Ðây là  đoạn mã để kích hoạt tài khoản : <h1 style=\"color: red;\">otp_code</h1>\n"
            + "\n"
            + " <p style=\"font-style: italic;\"> Lưu ý: Mã code này chỉ có thẻ sử dụng  trong vòng 2 phút kể từ thời gian  gửi . Sau thời gian trên hãy sử dụng chức năng quên mật khẩu để tiến hành tạo mới mật khẩu và kích hoạt tài khoản. </p>\n"
            + "\n"
            + "\n"
            + "<p style=\"font-weight: 800;\">Trân trọng cảm ơn!!</p>"
            + "</div>";

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
