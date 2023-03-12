/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dal.OTPRequestDBContext;
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

    public OTPRequest sendMail(String email, String otpCode) {
        OTPRequestDBContext otpDB = new OTPRequestDBContext();
        OTPRequest otp = otpDB.get(otpCode);       
        Email sendEmail = new Email();
        sendEmail.sendMail(email, "Verify Your Code", otpCode);        
        
        return otp;
    }

}
