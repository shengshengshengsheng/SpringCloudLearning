package com.shengsheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/3 11:35
 */
@SpringBootApplication
@EnableHystrix //开启断路器
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class HystrixOrderConsumerMain80 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderConsumerMain80.class,args);
    }
}
