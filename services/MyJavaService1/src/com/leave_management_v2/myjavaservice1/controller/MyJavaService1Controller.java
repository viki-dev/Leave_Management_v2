/*Copyright (c) 2019-2020 imaginea.com All Rights Reserved.
 This software is the confidential and proprietary information of imaginea.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with imaginea.com*/
package com.leave_management_v2.myjavaservice1.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leave_management_v2.myjavaservice1.MyJavaService1;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;

/**
 * Controller object for domain model class {@link MyJavaService1}.
 * @see MyJavaService1
 */
@RestController
@Api(value = "MyJavaService1Controller", description = "controller class for java service execution")
@RequestMapping("/myJavaService1")
public class MyJavaService1Controller {

    @Autowired
    private MyJavaService1 myJavaService1;

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "empl", required = false) String empl) {
        return myJavaService1.add(name, empl);
    }
}