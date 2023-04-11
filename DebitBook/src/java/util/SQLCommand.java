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

    // check email exists for register || get user id & basic information of account
    public static final String ACCOUNT_QUERY_FIND_BY_USERNAME = "SELECT a.username, u.id, u.[name], u.[address], u.phone_number, u.gender\n"
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

    // set status for user is verified
    public static final String USER_QUERY_VERIFY_USER_ACTIVE = "UPDATE [dbo].[User]\n"
            + "   SET [isActive] = 1\n"
            + " WHERE id = ?";

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

    // get otp request by code for active account
    public static final String OTP_QUERY_GET_BY_CODE_NOT_ACTIVE = "SELECT [id]\n"
            + "      ,[code]\n"
            + "      ,[type]\n"
            + "      ,[isVerify]\n"
            + "      ,[createdBy]\n"
            + "      ,[createdAt]\n"
            + "  FROM [dbo].[OTPRequest]\n"
            + "  WHERE isDeleted = 0 AND isVerify = 0 AND createdBy = ? AND id = ? AND code = ?";

    // set status of otp is verified
    public static final String OTP_QUERY_VERIFY_CODE_ACTIVE = "UPDATE [dbo].[OTPRequest]\n"
            + "   SET [isVerify] = 1\n"
            + "      ,[updatedAt] = GETDATE()\n"
            + "   WHERE id = ?";

    public static final String DEBTOR_QUERY_GET_LIST_DEBTOR_BY_USER_ID = "SELECT [id], [name], [email], [address], [phone_number], "
            + "[gender], [createdBy] , [createdAt], [updatedAt], [total_money]\n"
            + "FROM [dbo].[Debtor]\n"
            + "WHERE createdBy = ?";

    // get debtor list with pagination & search
    public static final String DEBTOR_QUERY_GET_LIST_DEBTOR = "SELECT [id], [name], [email], [address],\n"
            + "				[phone_number], [createdAt], [updatedAt], [total_money]\n"
            + "				FROM (SELECT ROW_NUMBER() OVER (ORDER BY id ASC) AS rownum, [id], [name], [email], [address],\n"
            + "				[phone_number], [gender], [createdBy] , [createdAt], [updatedAt], [total_money]\n"
            + "				FROM Debtor WHERE createdBy = ? AND isDeleted = 0";

    public static String DEBTOR_QUERY_GET_TOTAL_RECORD_OF_USER = "SELECT COUNT(*) AS total_record FROM Debtor \n"
            + "				WHERE createdBy = ? AND isDeleted = 0";
}
