package com.scp.cashFlow.service;

import com.starter.common.lang.Response;

import java.util.List;
import java.util.Map;

public interface CashFlowService {
    Response queryReport1(Map<String, Object> parameterMap);
}
