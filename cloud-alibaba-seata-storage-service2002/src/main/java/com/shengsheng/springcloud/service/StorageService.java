package com.shengsheng.springcloud.service;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/11 15:22
 */
public interface StorageService {
    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}
