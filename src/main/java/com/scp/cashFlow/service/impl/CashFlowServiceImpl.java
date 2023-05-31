package com.scp.cashFlow.service.impl;

import com.scp.cashFlow.dao.CashFlowDao;
import com.scp.cashFlow.service.CashFlowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class CashFlowServiceImpl implements CashFlowService {
    @Resource
    private CashFlowDao cashFlowDao;

    @Override
    public Map<String, Object> queryReport1(Map<String, Object> parameterMap) {
        return cashFlowDao.queryReport1(parameterMap);
    }

    @Override
    public boolean saveReport1(Map<String, Object> parameterMap) {
        int report1LastMonthResidue = (int) parameterMap.get("report1LastMonthResidue");
        parameterMap.put("name", "上月余额");
        parameterMap.put("type", "上月余额");
        parameterMap.put("value", report1LastMonthResidue);
        cashFlowDao.saveReport1(parameterMap);
        int report1PaymentCollection = (int) parameterMap.get("report1PaymentCollection");
        parameterMap.put("name", "上月回款");
        parameterMap.put("type", "上月回款");
        parameterMap.put("value", report1PaymentCollection);
        cashFlowDao.saveReport1(parameterMap);
        int report1StaffSalary = (int) parameterMap.get("report1StaffSalary");
        parameterMap.put("name", "分摊费用");
        parameterMap.put("type", "分摊费用");
        parameterMap.put("value", report1StaffSalary);
        cashFlowDao.saveReport1(parameterMap);
        String report1MonthVersion = (String) parameterMap.get("report1MonthVersion");
        List<Map<String, Object>> report2DynamicValidateForm = (List<Map<String, Object>>) ((Map<String, Object>)
                parameterMap.get("report2DynamicValidateForm")).get("domains");
        List<Map<String, Object>> report3DynamicValidateForm = (List<Map<String, Object>>) ((Map<String, Object>)
                parameterMap.get("report3DynamicValidateForm")).get("domains");
        reportDetails(parameterMap, report2DynamicValidateForm);
        reportDetails(parameterMap, report3DynamicValidateForm);
        return true;
    }

    private void reportDetails(Map<String, Object> parameterMap, List<Map<String, Object>> report3DynamicValidateForm) {
        String name;
        String type;
        String value;
        for (Map<String, Object> map : report3DynamicValidateForm) {
            name = (String) map.get("name");
            type = (String) map.get("type");
            value = String.valueOf(map.get("value"));
            parameterMap.put("name", name);
            parameterMap.put("type", type);
            parameterMap.put("value", value);
            cashFlowDao.saveReport1(parameterMap);
        }
    }

    //    {
//	legend: [],
//	xAixs: [],
//	series: {
//		name: '',
//		data: []
//	}
//}
    @Override
    public Map<String, Object> queryReport4(Map<String, Object> parameterMap) {
        List<Map<String, String>> queryReport4xAxis = cashFlowDao.queryReport4xAxis();
        List<String> xAxis = new ArrayList<>();
        for (Map<String, String> map : queryReport4xAxis) {
            xAxis.add(map.get("CREATE_DATE$"));
        }
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("xAxis",xAxis);

        List<Map<String, String>> queryReport4legend = cashFlowDao.queryReport4legend(parameterMap);
        List<String> legend = new ArrayList<>();
        for (Map<String, String> map : queryReport4legend) {
            legend.add(map.get("legend"));
        }
        resultMap.put("legend",legend);



        return cashFlowDao.queryReport4(parameterMap);
    }
}

