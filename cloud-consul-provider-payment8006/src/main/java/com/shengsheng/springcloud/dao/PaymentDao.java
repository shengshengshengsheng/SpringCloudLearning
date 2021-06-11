package com.shengsheng.springcloud.dao;

import com.shengsheng.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/1 20:31
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(@Param("id")Long id);
}
