package com.shengsheng.springcloud;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/1 20:57
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ZookeeperOrderConsumerMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperOrderConsumerMain80.class, args);
    }
}
