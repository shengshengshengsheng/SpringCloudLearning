package com.shengsheng.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/11 15:27
 */
@Configuration
@MapperScan(basePackages = {"com.shengsheng.springcloud.dao"})
public class MyBatisConfig {
}
