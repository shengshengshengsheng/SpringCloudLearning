package com.shengsheng.springcloud.api;

import com.shengsheng.springcloud.entities.CommonResult;
import com.shengsheng.springcloud.entities.Payment;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/11 11:09
 */
public class PaymentServiceImpl implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(404,"兜底方法",null);
    }
}
