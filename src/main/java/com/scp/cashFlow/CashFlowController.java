package com.scp.cashFlow;

import com.scp.cashFlow.service.CashFlowService;
import com.starter.common.ControllerHelper;
import com.starter.common.lang.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class CashFlowController extends ControllerHelper {
    @Resource
    private CashFlowService cashFlowService;

    @GetMapping("/calculation_cash_flow")
    public Result queryReport1(HttpServletRequest request) {
        super.pageLoad(request);
        Map<String, Object> result = cashFlowService.queryReport1(parameterMap);
        return Result.succ(result);
    }
}
