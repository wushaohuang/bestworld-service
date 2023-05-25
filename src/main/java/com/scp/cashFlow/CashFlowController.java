package com.scp.cashFlow;

import com.scp.cashFlow.service.CashFlowService;
import com.starter.common.lang.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CashFlowController {
    public Map<String, Object> parameterMap = new HashMap<>();
    @Resource
    private CashFlowService cashFlowService;

    @GetMapping("/calculation_cash_flow")
    public Response queryReport1(List<?> request) {
        System.out.println("1111111111111111111");
        return cashFlowService.queryReport1(parameterMap);
    }
}
