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
    public void saveReport1(Map<String, Object> parameterMap) {
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

    @Override
    public Map<String, Object> queryReport4(Map<String, Object> parameterMap) {
        List<Map<String, String>> queryReport4xAxis = cashFlowDao.queryReport4xAxis();
        List<String> xAxis = new ArrayList<>();
        for (Map<String, String> map : queryReport4xAxis) {
            xAxis.add(map.get("CREATE_DATE$"));
        }
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("xAxis", xAxis);
        List<Map<String, Object>> queryReport4legend = cashFlowDao.queryReport4legend(parameterMap);
        List<String> legend = new ArrayList<>();
        for (Map<String, Object> map : queryReport4legend) {
            legend.add((String) map.get("legend"));
        }
        resultMap.put("legend", legend);

        // 获取主要数据
        List<Map<String, Object>> report4Data = cashFlowDao.queryReport4(parameterMap);


        List<Map<String, Object>> seriesResult = new ArrayList<>();
        List<Map<String, List<Map<String, Object>>>> output = new ArrayList<>();
        for (String leg : legend) {
            Map<String, List<Map<String, Object>>> newOutput = new HashMap<>();
            for (String item : xAxis) {
                Map<String, Object> series = new HashMap<>();
                series.put("name", item);
                ArrayList<String> values = new ArrayList<>();
                for (Map<String, Object> data : report4Data) {
                    if (data.get("CALENDAR_DATE").toString().equals(item)) {
                        values.add((String) data.get("VALUE"));
                    }
                }
                series.put("data", values);
                seriesResult.add(series);
            }
            newOutput.put(leg, seriesResult);
            output.add(newOutput);
        }
        resultMap.put("data", output);
        return resultMap;
    }
}

