package com.me.testService.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.me.testService.bean.CommonResponse;
import com.me.testService.bean.TestBean;
import com.me.testService.util.DataUtils;

@RestController
@RequestMapping("/test")
@SuppressWarnings("all")
public class TestServiceController {

    @RequestMapping("/index")
    @ResponseBody
    public String testIndex(HttpServletRequest request, HttpServletResponse response) {
        return "server is startup." + DataUtils.formatDateTime(new Date());
    }

    @RequestMapping("/json")
    @ResponseBody
    public String testJson(HttpServletRequest request, HttpServletResponse response) {
        TestBean bean = new TestBean();
        bean.setName("名称");
        bean.setValue("值");
        bean.setUpdateTime(new Date());
        return JSONObject.toJSONString(bean);
    }

    @RequestMapping("/commJson")
    @ResponseBody
    public CommonResponse testCommonResponse(HttpServletRequest request, HttpServletResponse response) {
        TestBean bean = new TestBean();
        bean.setName("名称");
        bean.setValue("123456789");
        bean.setUpdateTime(new Date());
        return new CommonResponse(CommonResponse.SUCCESS, CommonResponse.SUCCESS_MSG, bean);
    }
}
