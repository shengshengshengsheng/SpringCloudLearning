package com.shengsheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/10 11:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaSentinelMainApp8401 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaSentinelMainApp8401.class,args);
    }
}
