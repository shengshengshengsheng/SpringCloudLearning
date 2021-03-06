package com.shengsheng.springcloud.controller;

import com.shengsheng.springcloud.domain.CommonResult;
import com.shengsheng.springcloud.domain.Order;
import com.shengsheng.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/11 15:26
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")

    public CommonResult<Void> create(Order order) {
        orderService.create(order);
        return new CommonResult<>(200, "订单创建成功");
    }
}
