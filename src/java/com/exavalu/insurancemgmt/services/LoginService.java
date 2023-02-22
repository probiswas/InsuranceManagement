/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.insurancemgmt.services;

import com.exavalu.insurancemgmt.models.InsuranceOfficer;
import com.exavalu.insurancemgmt.models.Underwriter;
import com.exavalu.insurancemgmt.models.User;
import com.exavalu.insurancemgmt.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class LoginService {

    public static LoginService loginService = null;
    
    private LoginService(){}
    
    public static LoginService getInstance()
    {
        if(loginService==null)
        {
            return new LoginService();
        }
        else
        {
            return loginService;
        }
    }
    
    public String doLoginUser(User user)
    {

        String result="FAILURE";
        
        String sql = "Select * from users where emailAddress=? and password=?";
        
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmailAddress());
            ps.setString(2, user.getPassword());
            
            System.out.println("LoginService :: "+ps);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                String roleId=rs.getString("roleId");
                user.setRoleId(roleId);
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                switch(roleId)
                {
                    case "1":
                        result="USER";
                        break;
                    case "2":
                        result="UW";
                        break;
                    case "3":
                        result="IO";
                        break;
                    default:
                        break;
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }

    public boolean doLoginUnderwriter(Underwriter underwriter) {
        
        boolean success = false;
        
        String sql = "Select * from underwriters where emailAddress=? and password=?";
        
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, underwriter.getEmailAddress());
            ps.setString(2, underwriter.getPassword());
            
            System.out.println("LoginService :: "+ps);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                String roleId = rs.getString("roleId");
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return success;
    }

    public boolean doLoginInsuranceOfficer(InsuranceOfficer insuranceOfficer) {
        
        boolean success = false;
        
        String sql = "Select * from insuranceofficers where emailAddress=? and password=?";
        
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, insuranceOfficer.getEmailAddress());
            ps.setString(2, insuranceOfficer.getPassword());
            
            System.out.println("LoginService :: "+ps);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                success = true;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return success;
        
    }
    
}
