package com.shengsheng.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.shengsheng.springcloud.api.PaymentApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/3 11:20
 */
@RestController
@DefaultProperties(defaultFallback = "orderGlobalFallbackMethod")
public class OrderController {
    @Autowired
    private PaymentApi paymentApi;

    /**
     * 设置服务降级的策略
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")//1.5秒钟以内就是正常的业务逻辑
    })
    @GetMapping("/order/hystrix/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        return paymentApi.paymentInfoTimeOut(id);
    }

    @GetMapping("/order/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id) {
        return paymentApi.paymentInfoOk(id);
    }

    /**
     * 特有的兜底方法
     */
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }

    /**
     * 下面是全局fallback方法
     * @return
     */
    public String orderGlobalFallbackMethod() {
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }
}
