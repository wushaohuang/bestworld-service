package com.bestworld.scp.cashFlow.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface CashFlowDao {
    List<Map<String, Object>> queryReport1(Map<String, Object> parameterMap);
}
