package com.shengsheng.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 动态切换日志级别的controller
 * @author 江朝技术
 */
@RequestMapping("/api/log")
@RestController
public class LogbackController {

    private Logger log = LoggerFactory.getLogger(LogbackController.class);

    @GetMapping(value = "/testlog")
    public String logj(){
        log.error("我是error");
        log.warn("我是warn");
        log.info("我是info");
        log.debug("我是debug");
        return "success";
    }

    /**
     * logback动态修改包名的日志级别
     * @param level 日志级别
     * @param packageName 包名
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/setlevel")
    public String updateLogbackLevel( @RequestParam(value="level") String level,
                                      @RequestParam(value="packageName",defaultValue = "-1") String packageName) throws Exception {
        ch.qos.logback.classic.LoggerContext loggerContext =(ch.qos.logback.classic.LoggerContext) LoggerFactory.getILoggerFactory();
        if(packageName.equals("-1")) {
            // 默认值-1，更改全局日志级别；否则按传递的包名或类名修改日志级别。
            loggerContext.getLogger("root").setLevel(ch.qos.logback.classic.Level.toLevel(level));
        } else {
            loggerContext.getLogger(packageName).setLevel(ch.qos.logback.classic.Level.valueOf(level));
        }
        return "success";
    }

}