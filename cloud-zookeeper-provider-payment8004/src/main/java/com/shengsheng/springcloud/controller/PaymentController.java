package com.shengsheng.springcloud.controller;

import com.shengsheng.springcloud.entities.CommonResult;
import com.shengsheng.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.shengsheng.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/1 20:40
 */
@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/zk")
    public String paymentZk(){
        return "spring cloud with zookeeper :"+ serverPort + UUID.randomUUID().toString();
    }

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("8002*****插入结果：" + result);
        if (result > 0) {
            //成功
            return new CommonResult<>(200, "插入数据库成功", result);
        } else {
            return new CommonResult<>(444, "插入数据库失败", result);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("8002*****查询结果：" + payment);
        //说明有数据，能查询成功
        if (payment != null) {
            return new CommonResult<>(200, "查询成功", payment);
        } else {
            return new CommonResult<>(444, "没有对应记录，查询ID：" + id, null);
        }
    }
}
