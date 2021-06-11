package com.shengsheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/2 10:17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulProviderPaymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulProviderPaymentMain8006.class,args);
    }
}
