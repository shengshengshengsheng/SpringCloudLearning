package com.shengsheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/7 11:30
 */
@EnableEurekaClient
@SpringBootApplication
public class StreamMQProviderMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQProviderMain8801.class,args);
    }
}
