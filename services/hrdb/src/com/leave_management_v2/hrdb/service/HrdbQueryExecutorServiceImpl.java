/*Copyright (c) 2019-2020 imaginea.com All Rights Reserved.
 This software is the confidential and proprietary information of imaginea.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with imaginea.com*/
package com.leave_management_v2.hrdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;

import com.leave_management_v2.hrdb.models.query.AddLeaveBalRequest;
import com.leave_management_v2.hrdb.models.query.ApplyLeaveRequest;
import com.leave_management_v2.hrdb.models.query.ApproveRejectQueryRequest;

@Service
public class HrdbQueryExecutorServiceImpl implements HrdbQueryExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HrdbQueryExecutorServiceImpl.class);

    @Autowired
    @Qualifier("hrdbWMQueryExecutor")
    private WMQueryExecutor queryExecutor;

    @Transactional(value = "hrdbTransactionManager")
    @Override
    public Integer executeAddLeaveBal(AddLeaveBalRequest addLeaveBalRequest) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("bal", addLeaveBalRequest.getBal());
        params.put("id", addLeaveBalRequest.getId());

        return queryExecutor.executeNamedQueryForUpdate("AddLeaveBal", params);
    }

    @Transactional(value = "hrdbTransactionManager")
    @Override
    public Integer executeApplyLeave(ApplyLeaveRequest applyLeaveRequest) {
        Map<String, Object> params = new HashMap<>(5);

        params.put("srt", applyLeaveRequest.getSrt());
        params.put("end", applyLeaveRequest.getEnd());
        params.put("emp_id", applyLeaveRequest.getEmpId());
        params.put("status", applyLeaveRequest.getStatus());
        params.put("type", applyLeaveRequest.getType());

        return queryExecutor.executeNamedQueryForUpdate("ApplyLeave", params);
    }

    @Transactional(value = "hrdbTransactionManager")
    @Override
    public Integer executeApproveRejectQuery(ApproveRejectQueryRequest approveRejectQueryRequest) {
        Map<String, Object> params = new HashMap<>(2);

        params.put("status", approveRejectQueryRequest.getStatus());
        params.put("id", approveRejectQueryRequest.getId());

        return queryExecutor.executeNamedQueryForUpdate("ApproveRejectQuery", params);
    }

}