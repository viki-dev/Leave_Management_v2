/*Copyright (c) 2019-2020 imaginea.com All Rights Reserved.
 This software is the confidential and proprietary information of imaginea.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with imaginea.com*/
package com.leave_management_v2.myjavaservice1;
import org.apache.commons.lang.StringEscapeUtils;
import javax.servlet.http.HttpServletRequest;
import com.leave_management_v2.hrdb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.leave_management_v2.hrdb.service.*;
import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;

//import com.leave_management_v2.myjavaservice1.model.*;

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
public class MyJavaService1 {

    private static final Logger logger = LoggerFactory.getLogger(MyJavaService1.class);

    @Autowired
    private SecurityService securityService;
    @Autowired
    private DepartmentService departmentService;
    /**
     * This is sample java operation that accepts an input from the caller and responds with "Hello".
     *
     * SecurityService that is Autowired will provide access to the security context of the caller. It has methods like isAuthenticated(),
     * getUserName() and getUserId() etc which returns the information based on the caller context.
     *
     * Methods in this class can declare HttpServletRequest, HttpServletResponse as input parameters to access the
     * caller's request/response objects respectively. These parameters will be injected when request is made (during API invocation).
     */
    public String add(String name,String empl)
    {
        String str_data1=new String();
        Department department=new Department();
        department.setName(name);
          JSONArray jsonarr_2=new JSONArray();
           JSONArray jar=new JSONArray();
             String empl1=empl.replaceAll("&quot;","\"");
	          List<Employee> empli=new ArrayList<>();
	            
	          try{
	           
            JSONParser parse = new JSONParser();
           
          
            
             jar = (JSONArray)parse.parse(empl1);
            for(int j=0;j<jar.size();j++)
            {
                 Employee employee=new Employee();
                 JSONObject jsonobj_2 = (JSONObject)jar.get(j);
                 str_data1 = (String) jsonobj_2.get("name");
                 employee.setName(str_data1);
                 empli.add(employee);
            }
	          }
	          catch(Exception e)
	          {
	             return ""+e;
	          }
            department.setEmployees(empli);
            departmentService.create(department);
           return ""+jar;
          
    }

}