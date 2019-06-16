/*Copyright (c) 2019-2020 imaginea.com All Rights Reserved.
 This software is the confidential and proprietary information of imaginea.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with imaginea.com*/
package com.leave_management_v2.myjavaservice;

import javax.servlet.http.HttpServletRequest;
import com.leave_management_v2.hrdb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.leave_management_v2.hrdb.service.*;
import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//import com.leave_management_v2.myjavaservice.model.*;

/**
 * This is a singleton class with all its public methods exposed as REST APIs via generated controller class.
 * To avoid exposing an API for a particular public method, annotate it with @HideFromClient.
 *
 * Method names will play a major role in defining the Http Method for the generated APIs. For example, a method name
 * that starts with delete/remove, will make the API exposed as Http Method "DELETE".
 *
 * Method Parameters of type primitives (including java.lang.String) will be exposed as Query Parameters &
 * Complex Types/Objects will become part of the Request body in the generated API.
 *
 * NOTE: We do not recommend using method overloading on client exposed methods.
 */
@ExposeToClient
public class MyJavaService {

    private static final Logger logger = LoggerFactory.getLogger(MyJavaService.class);

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private SecurityService securityService;

   // private Department department;
    
    
    
    /**
     * This is sample java operation that accepts an input from the caller and responds with "Hello".
     *
     * SecurityService that is Autowired will provide access to the security context of the caller. It has methods like isAuthenticated(),
     * getUserName() and getUserId() etc which returns the information based on the caller context.
     *
     * Methods in this class can declare HttpServletRequest, HttpServletResponse as input parameters to access the
     * caller's request/response objects respectively. These parameters will be injected when request is made (during API invocation).
     */
    public String sampleJavaOperation(String name, HttpServletRequest request) {
        logger.debug("Starting sample operation with request url " + request.getRequestURL().toString());
        
        String result = null;
        if (securityService.isAuthenticated()) {
            result = "Hello " + name + ", You are logged in as "+  securityService.getLoggedInUser().getUserName();
        } else {
            result = "Hello " + name + ", You are not authenticated yet!";
        }
        logger.debug("Returning {}", result);
        return result;
    }
   public Department call(List<Employee> employees)
    {   
        Department department=new Department();
      /*  Employee employee1= new Employee();
        Employee employee2=new Employee();
        employee1.setName("viki");
        employee2.setName("Suresh");
        List<Employee> employees=new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);*/
        department.setEmployees(employees);
        department.setName("IT");
      return departmentService.create(department);
       /* 	try{
    	URL url = new URL("https://www.wavemakeronline.com/run-hgq00zgvms/Leave_Management_v2_master/services/hrdb/Department");
    		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    		conn.setRequestMethod("GET");
    		if (conn.getResponseCode() != 200) {
    		   throw new Exception("User  not found");
    			//throw new RuntimeException("Failed : HTTP error code : "+ conn.getResponseCode());
    		}
	        else
	        {
	            String inline = new String();
	            Scanner sc = new Scanner(url.openStream());
                while(sc.hasNext())
                    {
                        inline+=sc.nextLine();
                    }
            sc.close();
	        }
        	}
        	catch(Exception e)
        	{
        	    
        	}*/
    }
}