package com.scp.cashFlow.service.impl;

import com.scp.cashFlow.dao.CashFlowDao;
import com.scp.cashFlow.service.CashFlowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class CashFlowServiceImpl implements CashFlowService {
    @Resource
    private CashFlowDao cashFlowDao;

    @Override
    public Map<String, Object> queryReport1() {
        return cashFlowDao.queryReport1();
    }
}

