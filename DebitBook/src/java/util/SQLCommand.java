/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author bahoann79
 */
public class SQLCommand {

    // for login function
    public static final String ACCOUNT_QUERY_FIND_BY_USERNAME_AND_PASSWORD = "SELECT a.username,\n"
            + "	   u.id, u.[name], u.[address], u.phone_number, u.gender\n"
            + "FROM Account a LEFT JOIN [User] u ON a.username = u.email\n"
            + "WHERE a.username = ? AND a.[password] = ?";

    // check email exists for register || get user id 
    public static final String ACCOUNT_QUERY_FIND_BY_USERNAME = "SELECT a.username, u.id\n"
            + "FROM Account a LEFT JOIN [User] u ON a.username = u.email\n"
            + "WHERE a.username = ?";

    // register new account
    public static final String ACCOUNT_QUERY_INSERT = "INSERT INTO [dbo].[Account]\n"
            + "           ([username]\n"
            + "           ,[password])\n"
            + "     VALUES\n"
            + "           (?\n"
            + "           ,?)";

    // insert new user
    public static final String USER_QUERY_INSERT = "INSERT INTO [dbo].[User]\n"
            + "           ([name]\n"
            + "           ,[email]\n"
            + "           ,[address]\n"
            + "           ,[phone_number]\n"
            + "           ,[gender]\n"
            + "           ,[image])\n"
            + "     VALUES\n"
            + "           (?\n"
            + "           ,?\n"
            + "           ,?\n"
            + "           ,?\n"
            + "           ,?\n"
            + "           ,?)";

    // insert new otp request
    public static final String OTP_QUERY_INSERT = "INSERT INTO [dbo].[OTPRequest]\n"
            + "           ([code]\n"
            + "           ,[type]\n"
            + "           ,[createdBy]\n"
            + "           ,[createdAt])\n"
            + "     VALUES\n"
            + "           (?\n"
            + "           ,?\n"
            + "           ,?\n"
            + "           ,GETDATE())";

    // get otp request by code
    public static final String OTP_QUERY_GET_BY_CODE = "SELECT [id]\n"
            + "      ,[code]\n"
            + "      ,[type]\n"
            + "      ,[isVerify]\n"
            + "      ,[createdBy]\n"
            + "      ,[createdAt]\n"
            + "  FROM [dbo].[OTPRequest]\n"
            + "  WHERE isDeleted = 0 AND code = ?";

}
