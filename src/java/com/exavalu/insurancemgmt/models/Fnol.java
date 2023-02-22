/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.insurancemgmt.models;

import com.exavalu.insurancemgmt.services.ApiService;
import com.exavalu.insurancemgmt.services.FnolService;
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
import org.json.simple.parser.ParseException;

/**
 *
 * @author lenovo
 */
public class Fnol extends ActionSupport implements ApplicationAware, SessionAware, Serializable{
    
    static Logger log = Logger.getLogger(Fnol.class);
    
    private String fnolId;
    private String userId;
    private String firstName;
    private String lastName;
    private String policyNumber;
    private String vehicleNumber;
    private String description;
    private String emailAddress;
    private String status;
    
    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();
    
    public String doFileFnol() throws ParseException{
        String result = "FAILURE";
        boolean apiValidated = ApiService.validateFnol(this);
        if(apiValidated){
            result="SUCCESS";
            FnolService.doFile(this);
            ArrayList fnolList = FnolService.getFnolsByEmailAddress(this.getEmailAddress());
            sessionMap.put("FnolList", fnolList);
        }
        else
        {
            log.error("Vehicle and Policy number Mismatch");
        }
        return result;
    }
    
    public String doChangeStatusUnderwriter() throws ParseException{
        String result = "SUCCESS";
        ArrayList fnolList = new ArrayList();
        FnolService.doChangeStatus(this);
        fnolList=FnolService.getAllFnol();
        sessionMap.put("FnolList", fnolList);
        return result;
    }
    public String doChangeStatusInsuranceOfficer() throws ParseException{
        String result = "SUCCESS";
        ArrayList fnolList = new ArrayList();
        FnolService.doChangeStatus(this);
        fnolList=FnolService.getAllFnol();
        sessionMap.put("FnolList", fnolList);
        return result;
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
     * @return the policyNumber
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * @param policyNumber the policyNumber to set
     */
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * @return the vehicleNumber
     */
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    /**
     * @param vehicleNumber the vehicleNumber to set
     */
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the fnolId
     */
    public String getFnolId() {
        return fnolId;
    }

    /**
     * @param fnolId the fnolId to set
     */
    public void setFnolId(String fnolId) {
        this.fnolId = fnolId;
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
    
}
