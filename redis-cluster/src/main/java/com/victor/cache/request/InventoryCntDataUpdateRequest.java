package com.victor.cache.request;

import com.victor.cache.redis.JedisService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description
 * 数据更新操作请求
 *
 * cache aside pattern
 * @Author victor su
 * @Date 2019/9/29 18:17
 **/
public class InventoryCntDataUpdateRequest implements Request {
    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 库存数量
     */
    private Long inventoryCnt;

    @Autowired
    private JedisService jedisService;

    public InventoryCntDataUpdateRequest(Integer productId, Long inventoryCnt) {
        this.productId = productId;
        this.inventoryCnt = inventoryCnt;
    }


    @Override
    public void process() {

        //删除Redis中缓存

        //修改数据库中数据
    }
}
