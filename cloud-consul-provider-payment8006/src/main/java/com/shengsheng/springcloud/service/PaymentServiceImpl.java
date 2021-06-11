package com.shengsheng.springcloud.service;

import com.shengsheng.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import com.shengsheng.springcloud.dao.PaymentDao;

import javax.annotation.Resource;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/1 20:39
 */
@Service
public class PaymentServiceImpl implements PaymentService{
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
