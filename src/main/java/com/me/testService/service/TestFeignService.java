package com.me.testService.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.me.testService.service.impl.TestFeignServiceImpl;

@FeignClient(name = "${jobService.name}", fallback = TestFeignServiceImpl.class)
public interface TestFeignService {

    @RequestMapping(value = "${jobService.name}/test/getTestBean")
    public JSONObject getTestBean(
            @RequestParam(value = "id", defaultValue = "") String id,
            @RequestParam(value = "testJson", defaultValue = "{}") String testJson);

    @RequestMapping(value = "${jobService.name}/testhystrix")
    public JSONObject testhystrix(
            @RequestParam(value = "id", defaultValue = "") String id,
            @RequestParam(value = "testJson", defaultValue = "{}") String testJson);

}
