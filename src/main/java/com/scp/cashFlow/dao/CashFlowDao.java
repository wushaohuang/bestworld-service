package com.scp.cashFlow.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Mapper
public interface CashFlowDao {
    Map<String, Object> queryReport1(Map<String, Object> parameterMap);

    void saveReport1(Map<String, Object> parameterMap);

    List<Map<String, Object>> queryReport4(Map<String, Object> parameterMap);

    List<Map<String, String>> queryReport4xAxis();

    List<Map<String, Object>> queryReport4legend(Map<String, Object> parameterMap);

}
