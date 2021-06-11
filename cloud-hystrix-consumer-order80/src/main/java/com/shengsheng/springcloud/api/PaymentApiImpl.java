package com.shengsheng.springcloud.api;

import org.springframework.stereotype.Component;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/4 10:38
 */
@Component
public class PaymentApiImpl implements PaymentApi{
    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }

    @Override
    public String paymentInfoOk(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }
}
