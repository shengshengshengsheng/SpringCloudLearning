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
public class ZookeeperPaymentProviderMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperPaymentProviderMain8004.class,args);
    }
}
