package com.shengsheng.springcloud.controller;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/1 21:00
 */

import com.shengsheng.springcloud.api.OrderApi;
import com.shengsheng.springcloud.entities.CommonResult;
import com.shengsheng.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderApi orderApi;


    @PostMapping("/feign/consumer/order/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        return orderApi.create(payment);
    }

    @GetMapping("/feign/consumer/order/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return orderApi.getPaymentById(id);
    }

    @GetMapping(value = "/feign/consumer/order/discovery")
    public Object discovery() {
        return orderApi.discovery();
    }
    @GetMapping(value = "/feign/order/getPort")
    public String getPort(){
        return orderApi.getPort();
    }
    @GetMapping(value = "/feign/order/getPort/timeOut")
    public String getPortTimeOut(){
        return orderApi.getPortTimeOut();
    }
}
