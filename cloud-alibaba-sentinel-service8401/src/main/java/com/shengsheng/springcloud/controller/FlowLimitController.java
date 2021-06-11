package com.shengsheng.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/10 11:35
 */
@RestController
public class FlowLimitController {
    @GetMapping(value = "/testA")
    public String testA(){
        return "--------testA";
    }
    @GetMapping(value = "/testB")
    public String testB(){
        return "--------testB";
    }
    @GetMapping(value = "/testC")
    public String testC(){
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "--------testC";
    }

    @GetMapping(value = "/testD")
    public String testD(){
        int i = 1/0;
        return "--------testD";
    }
    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        return "------------------testHotKey";
    }

    /**
     * 兜底方法 出现错误时会响应该接口
     * @param p1
     * @param p2
     * @param exception
     * @return
     */
    public String dealTestHotKey(String p1, String p2, BlockException exception){
        return "------deal_testHotKey,o(╥﹏╥)o";
    }
}
