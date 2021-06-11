package com.shengsheng.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/7 9:49
 */
@RefreshScope
@RestController
public class ConfigClientController {
    @Value("${application.info}")
    private String applicationInfo;
    @GetMapping(value = "/configInfo")
    public String getApplicationInfo(){
        return applicationInfo;
    }
}
