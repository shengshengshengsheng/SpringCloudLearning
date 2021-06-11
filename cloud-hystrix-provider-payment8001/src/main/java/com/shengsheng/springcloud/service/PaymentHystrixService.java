package com.shengsheng.springcloud.service;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/3 10:43
 */

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentHystrixService {

    /**
     * 成功
     *
     * @param id
     * @return
     */
    public String paymentInfoOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "     paymentInfoOk,id：   " + id + "\t" + "哈哈哈";
    }

    /**
     * 失败
     * 添加服务降级的配置
     * 一旦这个方法调用失败会调用fallbackMethod中指定的方法
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")  //设置3
            // 秒钟以内就是正常的业务逻辑
    })
    public String paymentInfoTimeOut(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "     paymentInfoTimeOut,id：   " + id + "\t" + "呜呜呜" + " " +
                " 耗时(秒)" + timeNumber;
    }

    /**
     * 兜底方法
     *
     * @param id
     * @return
     */
    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   系统繁忙, 请稍候再试  ,id：  " + id + "\t" + "哭了哇呜";
    }

    /**
     * 服务熔断的相关配置
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            // 10秒(10000ms)内10次请求失败率达到60%就进行熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id")Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号：" + serialNumber;
    }

    /**
     * 服务熔断的默认回调方法
     * @param id
     * @return
     */
    public String paymentCircuitBreakerFallback(@PathVariable("id")Integer id) {
        return "id不能负数，请稍候再试,(┬＿┬)/~~ id: " + id;
    }

}
