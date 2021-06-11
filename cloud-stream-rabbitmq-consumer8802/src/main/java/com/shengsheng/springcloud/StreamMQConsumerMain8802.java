package com.shengsheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/7 12:06
 */
@EnableEurekaClient
@SpringBootApplication
public class StreamMQConsumerMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQConsumerMain8802.class,args);
    }
}
