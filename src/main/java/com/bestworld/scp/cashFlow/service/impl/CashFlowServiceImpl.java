package com.bestworld.scp.cashFlow.service.impl;

import com.bestworld.scp.cashFlow.dao.CashFlowDao;
import com.bestworld.scp.cashFlow.service.CashFlowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

@Service
public class CashFlowServiceImpl implements CashFlowService {

    @Resource
    private CashFlowDao cashFlowDao;
    @Override
    public Response queryReport1(Map<String, Object> parameterMap) {
        List<Map<String, Object>> dataList = cashFlowDao.queryReport1(parameterMap);
        return null;
    }
}

