package com.msa.app.lchsupport.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Value("${lch.support.test}")
    private String str;

    @GetMapping("/test")
    public String test() {
        return str;
    }

    @GetMapping("/lch-msa-support/{param}")
    public String getLchMsaSupport(@PathVariable String param){
        if(param.equals("fail")) {
            throw new RuntimeException("failed");
        }
        return "Call Success Support Param : " + param;
    }

}
