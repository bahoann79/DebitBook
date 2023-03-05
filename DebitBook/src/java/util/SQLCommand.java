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

    public static final String ACCOUNT_QUERY_FIND_BY_USERNAME_AND_PASSWORD = "SELECT a.username,\n"
            + "	   u.id, u.[name], u.[address], u.phone_number, u.gender\n"
            + "FROM Account a LEFT JOIN [User] u ON a.username = u.email\n"
            + "WHERE a.username = ? AND a.[password] = ?";

}
