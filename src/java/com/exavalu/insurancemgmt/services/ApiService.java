/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.insurancemgmt.services;

import com.exavalu.insurancemgmt.models.DmvInformation;
import com.exavalu.insurancemgmt.models.Fnol;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author lenovo
 */
public class ApiService {
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ApiService.class);

    public static boolean validateFnol(Fnol fnol) throws ParseException {
        
        boolean result = false;
        
        URL url;
        try {
            url = new URL("https://mocki.io/v1/54f488ab-8d00-4c3e-8f4b-58373fafb86d");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
            if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
                else{
                    
                    String inline = "";
                    Scanner scanner = new Scanner(url.openStream());
                    while(scanner.hasNext()){
                        inline += scanner.nextLine();
                    }
                    scanner.close();
                    JSONParser parse = new JSONParser();
                    JSONArray jsonArray = (JSONArray)parse.parse(inline);
                    
                    for(int i = 0; i < jsonArray.size(); i++){

                        JSONObject obj = (JSONObject)jsonArray.get(i);
                        String vehicleNumber = obj.get("vehicleNumber").toString();
                        String policyNumber = obj.get("policyNumber").toString();
                        if(fnol.getVehicleNumber().equals(vehicleNumber)&&fnol.getPolicyNumber().equals(policyNumber)){
                            System.out.println("FNOL request validation success");
                            result=true;
                        }
                            
                    }

                }
            
            
        } catch (MalformedURLException e) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss  dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();
                log.error(e.getMessage() + "       Time = " + dtf.format(now));

		e.printStackTrace();

	  } catch (IOException e) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss  dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();
                log.error(e.getMessage() + "       Time = " + dtf.format(now));
		e.printStackTrace();

	  }
 
        return result;
    }
    
    
    public static DmvInformation getDmvInformationByUserId(String targetUserId) throws ParseException {
        
        URL url;
        DmvInformation dmvInfo = new DmvInformation();
        try {
            url = new URL("https://mocki.io/v1/12695de3-7103-41ec-a563-cbd01c779970");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
            if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
                else{
                    
                    String inline = "";
                    Scanner scanner = new Scanner(url.openStream());
                    while(scanner.hasNext()){
                        inline += scanner.nextLine();
                    }
                    scanner.close();
                    JSONParser parse = new JSONParser();
                    JSONArray jsonArray = (JSONArray)parse.parse(inline);
                    
                    for(int i = 0; i < jsonArray.size(); i++){

                        JSONObject obj = (JSONObject)jsonArray.get(i);
                        String userId = obj.get("userId").toString();
                        String firstName = obj.get("firstName").toString();
                        String lastName = obj.get("lastName").toString();
                        String vehicleNumber = obj.get("vehicleNumber").toString();
                        String policyNumber = obj.get("policyNumber").toString();
                        String accidentReport = obj.get("accidentReport").toString();
                        if(targetUserId.equals(userId)){
                            System.out.println("DMV info available for userid = "+userId);
                            dmvInfo.setFirstName(firstName);
                            dmvInfo.setLastName(lastName);
                            dmvInfo.setUserId(userId);
                            dmvInfo.setPolicyNumber(policyNumber);
                            dmvInfo.setVehicleNumber(vehicleNumber);
                            dmvInfo.setAccidentReport(accidentReport);
                        }
                            
                    }

                }
            
            
        } catch (MalformedURLException e) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss  dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();
                log.error(e.getMessage() + "       Time = " + dtf.format(now));

		e.printStackTrace();

	  } catch (IOException e) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss  dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();
                log.error(e.getMessage() + "       Time = " + dtf.format(now));
		e.printStackTrace();

	  }
 
        return dmvInfo;
    }
    
}
