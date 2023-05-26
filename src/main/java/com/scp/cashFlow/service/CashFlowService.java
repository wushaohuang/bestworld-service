package com.scp.cashFlow.service;

import com.starter.common.lang.ResponseResult;

import java.util.List;
import java.util.Map;

public interface CashFlowService {
    ResponseResult queryReport1(Map<String, Object> parameterMap);
}
