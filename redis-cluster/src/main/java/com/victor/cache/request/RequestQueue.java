package com.victor.cache.request;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Description
 * 请求内存队列
 * @Author victor su
 * @Date 2019/9/27 11:49
 **/
public class RequestQueue {

    private List<ArrayBlockingQueue<Request>> blockingQueues = new ArrayList<>();

    private static class SingletonHolder {
        private static RequestQueue instance;

        static {
            instance = new RequestQueue();
        }

        public static RequestQueue getInstance () {
            return instance;
        }
    }

    public static RequestQueue getInstance () {
        return SingletonHolder.getInstance();
    }

    /**
     * 添加内存队列
     * @param queue
     */
    public void addQueue (ArrayBlockingQueue<Request> queue) {
        this.blockingQueues.add(queue);
    }

}
