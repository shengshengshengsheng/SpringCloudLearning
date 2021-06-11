package com.shengsheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/1 20:22
 */
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaPaymentProviderMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaPaymentProviderMain8001.class,args);
    }
}
