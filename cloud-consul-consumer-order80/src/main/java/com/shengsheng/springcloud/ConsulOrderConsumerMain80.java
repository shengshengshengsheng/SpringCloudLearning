package com.shengsheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/2 11:44
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrderConsumerMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderConsumerMain80.class,args);
    }
}
