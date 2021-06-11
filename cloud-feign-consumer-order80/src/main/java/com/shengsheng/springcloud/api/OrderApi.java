package com.shengsheng.springcloud.api;

import com.shengsheng.springcloud.entities.CommonResult;
import com.shengsheng.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/3 9:34
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderApi {
    @GetMapping(value = "/payment/getPort")
    String getPort();

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
    @PostMapping(value = "/payment/create")
    CommonResult<Integer> create(@RequestBody Payment payment);
    @GetMapping(value = "/payment/discovery")
    Object discovery();
    @GetMapping(value = "/payment/getPort/timeOut")
    String getPortTimeOut();
}
