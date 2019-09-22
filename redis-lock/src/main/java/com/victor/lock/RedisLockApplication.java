package com.victor.lock;

import com.victor.lock.redisson.RedissonAutoConfiguration;
import com.victor.lock.redisson.RedissonLockUtil;
import com.victor.lock.redisson.RedissonProperties;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

/**
 * @Description
 * redis 分布式锁
 * @Author victor su
 * @Date 2019/9/22 17:45
 **/
public class RedisLockApplication {

    private static final RedissonLockUtil redissonLockUtil = new RedissonLockUtil();

    private static RLock lock;
    public static void main(String[] args) {

        //Redis 属性值
        RedissonProperties properties = new RedissonProperties();
        properties.setAddress("redis://192.168.1.101:6379");

        //Redis配置文件
        RedissonAutoConfiguration configuration = new RedissonAutoConfiguration(properties);

        //Redis客户端
        RedissonClient redissonClient = configuration.redissonSingle();

        //Redis锁类
        redissonLockUtil.setRedissonClient(redissonClient);

        Thread t1 = new Thread(()->{
            lock = redissonLockUtil.lock("redis-lock");
            try {
                System.out.println(Thread.currentThread().getName() + ", 获得锁-" + lock.getName());
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + ", 释放锁-" + lock.getName());
                redissonLockUtil.unlock(lock);
            }
        },"thread-a");
        t1.start();

        Thread t2 = new Thread(()->{
            lock = redissonLockUtil.lock("redis-lock");
            try {
                System.out.println(Thread.currentThread().getName() + ", 获得锁-" + lock.getName());
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + ", 释放锁-" + lock.getName());
                redissonLockUtil.unlock(lock);
            }
        },"thread-b");
        t2.start();
    }
}
