/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.insurancemgmt.services;

import com.exavalu.insurancemgmt.models.Fnol;
import com.exavalu.insurancemgmt.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author lenovo
 */
public class FnolService {

    static Logger log = Logger.getLogger(FnolService.class);
    
    public static void doFile(Fnol fnol) {
        Connection con = JDBCConnectionManager.getConnection();
        String sql = "INSERT INTO fnols"
                + "(policyNumber, "
                + "vehicleNumber, "
                + "description, "
                + "emailAddress, "
                + "status) "
                + "VALUES "
                + "(? , "
                + "? , "
                + "? , "
                + "? , "
                + "1)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, fnol.getPolicyNumber());
            preparedStatement.setString(2, fnol.getVehicleNumber());
            preparedStatement.setString(3, fnol.getDescription());
            preparedStatement.setString(4, fnol.getEmailAddress());

            System.out.println("fnol register statement = " + preparedStatement);

            preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss  dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();
                log.error(ex.getMessage() + "       Time = " + dtf.format(now));
                ex.printStackTrace();
        }
    }
    
    public static ArrayList getAllPendingFnol(){
         ArrayList fnols = new ArrayList();
         
         String sql = "select * from users,fnols where users.emailAddress=fnols.emailAddress having fnols.status=1";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Fnol fnol = new Fnol();
                
                fnol.setFnolId(rs.getString("fnolId"));
                fnol.setUserId(rs.getString("userId"));
                fnol.setFirstName(rs.getString("firstName"));
                fnol.setLastName(rs.getString("lastName"));
                fnol.setPolicyNumber(rs.getString("policyNumber"));
                fnol.setVehicleNumber(rs.getString("vehicleNumber"));
                fnol.setDescription(rs.getString("description"));
                fnol.setStatus(rs.getString("status"));
                switch(fnol.getStatus()){
                    case "0":
                        fnol.setStatus("Rejected");
                        break;
                    case "1":
                        fnol.setStatus("Pending");
                        break;
                    case "2":
                        fnol.setStatus("Accepted by UW");
                        break;
                    case "3":
                        fnol.setStatus("Accepted by IO");
                        break;
                }
                fnols.add(fnol);
            }
            
            
        }
        catch (SQLException ex) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss  dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            log.error(ex.getMessage() + "       Time = " + dtf.format(now));
            ex.printStackTrace();
        }
        System.err.println("Total rows:"+fnols.size());
        return fnols;
    }
    
    public static ArrayList getAllFnol(){
         ArrayList fnols = new ArrayList();
         
         String sql = "select * from users,fnols where users.emailAddress=fnols.emailAddress";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Fnol fnol = new Fnol();
                
                fnol.setFnolId(rs.getString("fnolId"));
                fnol.setUserId(rs.getString("userId"));
                fnol.setFirstName(rs.getString("firstName"));
                fnol.setLastName(rs.getString("lastName"));
                fnol.setPolicyNumber(rs.getString("policyNumber"));
                fnol.setVehicleNumber(rs.getString("vehicleNumber"));
                fnol.setDescription(rs.getString("description"));
                fnol.setStatus(rs.getString("status"));
                switch(fnol.getStatus()){
                    case "0":
                        fnol.setStatus("Rejected");
                        break;
                    case "1":
                        fnol.setStatus("Pending");
                        break;
                    case "2":
                        fnol.setStatus("Accepted by UW");
                        break;
                    case "3":
                        fnol.setStatus("Accepted by IO");
                        break;
                }
                fnols.add(fnol);
            }
            
            
        }
        catch (SQLException ex) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss  dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            log.error(ex.getMessage() + "       Time = " + dtf.format(now));
            ex.printStackTrace();
        }
        System.err.println("Total rows:"+fnols.size());
        return fnols;
    }

    public static ArrayList getFnolsByEmailAddress(String emailAddress) {
        
        ArrayList fnols = new ArrayList();
         
         String sql = "SELECT * FROM fnols where emailAddress = ?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emailAddress);
            System.out.println("PS after user login for fnol list = "+ps);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Fnol fnol = new Fnol();
                
                fnol.setFnolId(rs.getString("fnolId"));
                fnol.setPolicyNumber(rs.getString("policyNumber"));
                fnol.setVehicleNumber(rs.getString("vehicleNumber"));
                fnol.setDescription(rs.getString("description"));
                fnol.setStatus(rs.getString("status"));
                switch(fnol.getStatus()){
                    case "0":
                        fnol.setStatus("Rejected");
                        break;
                    case "1":
                        fnol.setStatus("Pending");
                        break;
                    case "2":
                        fnol.setStatus("Accepted by UW");
                        break;
                    case "3":
                        fnol.setStatus("Accepted by IO");
                        break;
                }
                fnols.add(fnol);
            }
            
            
        }
        catch (SQLException ex) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss  dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            log.error(ex.getMessage() + "       Time = " + dtf.format(now));
            ex.printStackTrace();
        }
        System.err.println("Total rows:"+fnols.size());
        return fnols;
    }

    public static void doChangeStatus(Fnol fnol) {
        
        String sql = "UPDATE fnols SET status = ? WHERE (fnolId = ?);";
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, fnol.getStatus());
            ps.setString(2, fnol.getFnolId());
            System.out.println("change status ps = "+ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss  dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            log.error(ex.getMessage() + "       Time = " + dtf.format(now));
            ex.printStackTrace();
        }
            
        
    }

    public static ArrayList getAllFnolAcceptedByUnderwriter() {
        
        ArrayList fnols = new ArrayList();
         
         String sql = "select * from users,fnols where users.emailAddress=fnols.emailAddress having fnols.status=2";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Fnol fnol = new Fnol();
                
                fnol.setFnolId(rs.getString("fnolId"));
                fnol.setFirstName(rs.getString("firstName"));
                fnol.setLastName(rs.getString("lastName"));
                fnol.setPolicyNumber(rs.getString("policyNumber"));
                fnol.setVehicleNumber(rs.getString("vehicleNumber"));
                fnol.setDescription(rs.getString("description"));
                fnol.setStatus(rs.getString("status"));
                switch(fnol.getStatus()){
                    case "0":
                        fnol.setStatus("Rejected");
                        break;
                    case "1":
                        fnol.setStatus("Pending");
                        break;
                    case "2":
                        fnol.setStatus("Accepted by UW");
                        break;
                    case "3":
                        fnol.setStatus("Accepted by IO");
                        break;
                }
                fnols.add(fnol);
            }
            
            
        }
        catch (SQLException ex) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss  dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            log.error(ex.getMessage() + "       Time = " + dtf.format(now));
            ex.printStackTrace();
        }
        System.err.println("Total rows:"+fnols.size());
        return fnols;
        
    }
        
}
