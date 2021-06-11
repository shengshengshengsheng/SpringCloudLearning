package com.shengsheng.springcloud.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/3 11:19
 */
@FeignClient(value = "CLOUD-HYSTRIX-PROVIDER-PAYMENT",fallback = PaymentApiImpl.class)
public interface PaymentApi {
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Integer id);
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id);
}
