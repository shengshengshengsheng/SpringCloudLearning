package com.shengsheng.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/11 15:18
 */
@Mapper
public interface StorageDao {
    /**
     * 扣减库存信息
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
