package com.victor.cache.thread;

import com.victor.cache.request.Request;
import com.victor.cache.request.RequestQueue;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * 请求处理线程池： 单例模式
 * @Author victor su
 * @Date 2019/9/27 9:29
 **/
public class RequestProcessorThreadPool {

    private ExecutorService threadPool = Executors.newFixedThreadPool(10);

    private RequestProcessorThreadPool() {

        RequestQueue requestQueue = RequestQueue.getInstance();

        for(int i=0; i<10;i++) {
            ArrayBlockingQueue<Request> queue = new ArrayBlockingQueue<>(100);
            requestQueue.addQueue(queue);
            threadPool.submit(new RequestProcessorThread(queue));
        }

    }

    private static class SingletonHolder {
        private static RequestProcessorThreadPool instance;

        static {
            instance = new RequestProcessorThreadPool();
        }

        public static RequestProcessorThreadPool getInstance () {
            return instance;
        }
    }

    public static RequestProcessorThreadPool getInstance () {
        return SingletonHolder.getInstance();
    }

    public static void init(){
        getInstance();
    }

}
