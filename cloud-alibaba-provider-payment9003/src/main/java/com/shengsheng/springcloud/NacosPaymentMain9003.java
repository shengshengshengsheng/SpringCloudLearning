package com.shengsheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/11 10:35
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentMain9003.class,args);
    }
}
