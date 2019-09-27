package com.victor.cache.thread;

import com.victor.cache.request.Request;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

/**
 * @Description
 * 任务队列处理线程
 * @Author victor su
 * @Date 2019/9/27 9:41
 **/
public class RequestProcessorThread implements Callable<Boolean> {

    private ArrayBlockingQueue<Request> queue;

    public RequestProcessorThread(ArrayBlockingQueue<Request> queue) {
        this.queue = queue;
    }

    @Override
    public Boolean call() throws Exception {
        while (true) {
            break;
        }
        return true;
    }
}
