package com.me.testService.service.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.me.testService.service.TestFeignService;
import com.me.testService.util.DataUtils;

@Component
public class TestFeignServiceImpl implements TestFeignService {

    @Override
    public JSONObject getTestBean(String id, String testJson) {
        JSONObject obj = new JSONObject();
        obj.put("name", "熔断");
        obj.put("value", "熔断返回值");
        obj.put("updateTime", DataUtils.formatDateTime(new Date()));
        return obj;
    }

    @Override
    public JSONObject getTestJson(String id, String testJson) {
        JSONObject obj = new JSONObject();
        obj.put("name", "熔断");
        obj.put("value", "熔断返回值");
        obj.put("updateTime", DataUtils.formatDateTime(new Date()));
        return obj;
    }

}
