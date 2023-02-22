/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.insurancemgmt.services;

import com.exavalu.insurancemgmt.models.User;
import com.exavalu.insurancemgmt.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.log4j.Logger;

/**
 *
 * @author lenovo
 */
public class SignupService {
    
    static Logger log = Logger.getLogger(SignupService.class);

    public static boolean doSignup(User user) {
        
        String sql = "insert into users  (`firstName`, `lastName`, `phoneNumber`, `emailAddress`, `password`) values(?,?,?,?,?)";
        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.setString(4, user.getEmailAddress());
            preparedStatement.setString(5, user.getPassword());
            

            if (preparedStatement.executeUpdate() != 0) {
                result = true;
            }

            System.out.println("SignupService :: " + preparedStatement);

        } catch (SQLException ex) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss  dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            log.error(ex.getMessage() + "       Time = " + dtf.format(now));
            ex.printStackTrace();
        }
        return result;
    }
    
}
