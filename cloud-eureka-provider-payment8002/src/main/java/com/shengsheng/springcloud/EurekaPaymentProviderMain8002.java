package com.shengsheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/2 10:17
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaPaymentProviderMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaPaymentProviderMain8002.class,args);
    }
}
