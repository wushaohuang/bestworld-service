package com.scp.cashFlow.service;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

public interface CashFlowService {
    List<?> queryReport1(Map<String, Object> parameterMap);
}
