package com.shengsheng.rule;

/**
 * description:Ribbon 负载均衡规则
 *
 * @author shengshenglalala
 * @date 2021/6/2 21:20
 */

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        //定义为随机
        return new RandomRule();
    }
}
