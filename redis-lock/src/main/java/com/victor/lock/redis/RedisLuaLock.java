package com.victor.lock.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

/**
 * @Description
 * Redis结合Lua脚本
 * @Author victor su
 * @Date 2019/9/23 23:56
 **/
public class RedisLuaLock {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisLuaLock.class);

    private static final Jedis jedis = new Jedis("192.168.1.101", 6379, 10000);

    public static void main(String[] args) {
        String lockStr = "jedis-lock";
        String requestId = "user-0001";

        boolean lock = getRedisLock(lockStr, requestId, 10);
        LOGGER.info("====> 获取Redis分布式锁: lockStr = {}, requestId = {}, result = {}", lockStr, requestId, lock);

        boolean unlock = releaseRedisLock(lockStr, requestId);
        LOGGER.info("====> 释放Redis分布式锁: lockStr = {}, requestId = {}, result = {}", lockStr, requestId, unlock);

    }

    /**
     * set 命令获取Redis锁
     *
     * @param lockStr
     * @param requestId
     * @param expireTime 单位：秒
     * @return
     */
    public static boolean getRedisLock (String lockStr, String requestId, int expireTime) {
        SetParams params = new SetParams();
        params.nx().ex(expireTime);
        String result = jedis.set(lockStr,requestId,params);
        if("OK".equals(result))
            return true;
        return false;
    }

    /**
     * Redis + Lua脚本 释放Redis锁
     * @param lockStr
     * @param requestId
     * @return
     */
    public static boolean releaseRedisLock (String lockStr, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockStr), Collections.singletonList(requestId));
        if(result.equals(1L))
            return true;
        return false;
    }
}
