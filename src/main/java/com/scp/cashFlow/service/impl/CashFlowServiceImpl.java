package com.scp.cashFlow.service.impl;

import com.scp.cashFlow.dao.CashFlowDao;
import com.scp.cashFlow.service.CashFlowService;
import com.starter.common.lang.ResponseResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CashFlowServiceImpl implements CashFlowService {
    @Resource
    private CashFlowDao cashFlowDao;
    @Override
    public ResponseResult queryReport1(Map<String, Object> parameterMap) {
        List<Map<String, Object>> dataList = cashFlowDao.queryReport1(parameterMap);
        return null;
    }
}

