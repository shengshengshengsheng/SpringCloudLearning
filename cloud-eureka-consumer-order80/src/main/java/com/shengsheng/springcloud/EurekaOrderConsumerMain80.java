package com.shengsheng.springcloud;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/1 20:57
 */

import com.shengsheng.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(value = "CLOUD-PAYMENT-SERVICE",configuration = {MySelfRule.class})
public class EurekaOrderConsumerMain80 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaOrderConsumerMain80.class, args);
    }

}
