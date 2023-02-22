/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.insurancemgmt.models;

import com.exavalu.insurancemgmt.services.FnolService;
import com.exavalu.insurancemgmt.services.LoginService;
import com.exavalu.insurancemgmt.services.SignupService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author lenovo
 */
public class User extends ActionSupport implements ApplicationAware, SessionAware, Serializable{
    private String userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String password;
    private String roleId;
    
    static Logger log = Logger.getLogger(User.class);
    
    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();
    
    
    public String doSignup() throws Exception {        
        boolean result=SignupService.doSignup(this);
        
        if(result)
            return "SUCCESS";
        else
            return "FAILURE";
    }
    
    public String doLogin() throws Exception {
        
        
        String result = LoginService.getInstance().doLoginUser(this);
        
        if (result.equals("USER")) {
            
            System.out.println("returning Success from doLogin method "+this.getEmailAddress());
            ArrayList fnolList = FnolService.getFnolsByEmailAddress(this.getEmailAddress());
            sessionMap.put("User", this);
            sessionMap.put("FnolList", fnolList);
        } 
        else if(result.equals("UW")) {
            ArrayList fnolList = FnolService.getAllFnol();
            sessionMap.put("User", this);
            sessionMap.put("FnolList", fnolList);
        }
        else if(result.equals("IO")) {
            ArrayList fnolList = FnolService.getAllFnol();
            sessionMap.put("User", this);
            sessionMap.put("FnolList", fnolList);
            
        }
        else{
            log.error("Username and passsword mismatch");
            System.out.println("returning Failure from doLogin method");
        }

        return result;
    }
    public String doLogout(){
        sessionMap.invalidate(); 
        return "SUCCESS";
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        sessionMap = (SessionMap) session;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the roleId
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
