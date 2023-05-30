package com.scp.cashFlow;

import com.scp.cashFlow.service.CashFlowService;
import com.starter.common.lang.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CashFlowController {
    @Resource
    private CashFlowService cashFlowService;

    @GetMapping("/calculation_cash_flow")
    public Result queryReport1() {
        System.out.println("1111111111111111111");
        Map<String, Object> result = cashFlowService.queryReport1();
        return Result.succ(result);
    }
}
