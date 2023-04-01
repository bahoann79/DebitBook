/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dal.OTPRequestDBContext;
import java.util.Date;
import model.OTPRequest;
import util.Email;

/**
 *
 * @author bahoann79
 */
public class OTPService {

    // insert new otp in DB and get code
    public String createOTPRequest(int userId, int otpType) {
        OTPRequestDBContext otpDB = new OTPRequestDBContext();
        String otpCode = otpDB.createOTPRequest(userId, otpType);
        return otpCode;

    }

    public OTPRequest sendMail(String email, int otpType, String otpCode, String name) {
        OTPRequestDBContext otpDB = new OTPRequestDBContext();
        OTPRequest otp = otpDB.get(otpCode);
        String message = otpDB.messageType(otpType, otpCode, name);
        Email sendEmail = new Email();
        sendEmail.sendMail(email, "Verify Your Code", message);
        return otp;
    }

    public OTPRequest get(int userId, int otpId, String otpCode) {
        OTPRequestDBContext otpDB = new OTPRequestDBContext();
        OTPRequest otp = otpDB.get(userId, otpId, otpCode);
        return otp;
    }

    // function check for code active if more than 2 minutes
    public boolean isTimeExpired(Date expiredTime) {
        Date currentTime = new Date();
        long timeDiffInMillis = currentTime.getTime() - expiredTime.getTime();
        int result = (int) (timeDiffInMillis / 1000);
        return result <= 120;
    }

    public void verifyCodeActive(int otpId) {
        OTPRequestDBContext otpDB = new OTPRequestDBContext();
        otpDB.verifyCodeActive(otpId);
    }

}
