package com.shengsheng.springcloud.controller;

import com.shengsheng.springcloud.entities.CommonResult;
import com.shengsheng.springcloud.entities.Payment;
import com.shengsheng.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/1 20:40
 */
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            logger.info("8001***** element:" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            logger.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        logger.info("8001*****插入结果：" + result);
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
        logger.info("8001*****查询结果：" + payment);
        //说明有数据，能查询成功
        if (payment != null) {
            return new CommonResult<>(200, "查询成功,serverPort"+serverPort, payment);
        } else {
            return new CommonResult<>(444, "没有对应记录，查询ID：" + id+",serverPort"+serverPort, null);
        }
    }

    /**
     * 负载均衡的调用接口
     * @return
     */
    @GetMapping(value = "/payment/getPort")
    public String getPort(){
        return serverPort;
    }

    @GetMapping(value = "/payment/getPort/timeOut")
    public String getPortTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            logger.error("睡眠出错");
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        logger.info("paymentZipkin:");
        return "hi ,I'm payment zipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }
}
