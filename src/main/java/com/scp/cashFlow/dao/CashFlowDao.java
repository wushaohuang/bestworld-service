package com.scp.cashFlow.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Mapper
public interface CashFlowDao {
    Map<String, Object> queryReport1();
}
