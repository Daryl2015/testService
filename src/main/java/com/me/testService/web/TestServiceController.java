package com.me.testService.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestServiceController {

    @RequestMapping("/index")
    @ResponseBody
    public String testIndex(HttpServletRequest request, HttpServletResponse response) {
        return "server is startup.";
    }
}
