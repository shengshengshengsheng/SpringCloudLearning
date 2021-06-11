package com.shengsheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/3 9:29
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class FeignOrderConsumerMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderConsumerMain80.class,args);
    }
}
