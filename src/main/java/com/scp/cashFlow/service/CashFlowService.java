package com.scp.cashFlow.service;

import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public interface CashFlowService {
    Map<String, Object> queryReport1(Map<String, Object> parameterMap);

    boolean saveReport1(Map<String, Object> parameterMap);

    Map<String, Object> queryReport4(Map<String, Object> parameterMap);
}
