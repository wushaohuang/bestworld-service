package com.starter.common;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制层功能类
 */

public abstract class ControllerHelper {

    public Map<String, Object> parameterMap = new HashMap<>();

    /**
     * 页面初始加载,初始化session、parameterMap、logger对象
     *
     * @param request request
     */
    public void pageLoad(HttpServletRequest request) {
        this.loadParameter(request);
    }

    /**
     * 私有方法, 获取loadParameter
     * <p>
     *
     * @param request request
     */
    private void loadParameter(HttpServletRequest request) {
        parameterMap = new HashMap<>();

        if ("application/json".equalsIgnoreCase(request.getHeader("Content-Type"))) {
            String reqStr = null;
            try {
                if (request.getInputStream().isFinished()) {
                    reqStr = (String) request.getAttribute("_parameter_str");
                } else {
                    try (BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8))) {
                        // @RequestBody 会读取request,导致这里无法继续读取request, 所以, 在使用@RequestBody的方法上,是无法从parameterMap中获取到值的
                        if (request.getInputStream().isFinished()) {
                            return;
                        }
                        StringBuilder responseStrBuilder = new StringBuilder();
                        String inputStr;
                        while ((inputStr = streamReader.readLine()) != null) {
                            responseStrBuilder.append(inputStr);
                        }

                        reqStr = responseStrBuilder.toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (reqStr != null) {
                Map<String, Object> paramMap = JSONObject.parseObject(reqStr);

                for (String key : paramMap.keySet()) {
                    Object value = paramMap.get(key);
                    if (value instanceof String) {
                        paramMap.put(key, StringUtils.trim((String) value));
                    }
                }
                parameterMap.putAll(paramMap);
            }
        } else {
            Map<String, String[]> parameters = request.getParameterMap();
            Set<String> keySet = parameters.keySet();

            String[] para;
            for (String key : keySet) {
                if (parameters.get(key) != null) {
                    para = parameters.get(key);
                    System.out.println(StringUtils.removeEnd(key, "[]"));
                    if (para.length == 1) {
                        parameterMap.put(StringUtils.removeEnd(key, "[]"), StringUtils.trim(para[0]));
                    } else {
                        parameterMap.put(StringUtils.removeEnd(key, "[]"), para);
                    }
                }
            }
        }
    }
}
