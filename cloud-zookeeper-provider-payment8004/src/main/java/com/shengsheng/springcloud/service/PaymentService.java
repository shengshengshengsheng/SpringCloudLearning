package com.shengsheng.springcloud.service;

import com.shengsheng.springcloud.entities.Payment;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/1 20:38
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
