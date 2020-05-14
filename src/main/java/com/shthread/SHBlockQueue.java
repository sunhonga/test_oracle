package com.shthread;

/**
 * @ClassName SHBlockQueue
 * @Description TODO
 * Author sunhong
 * Date 2019-9-26 15:57
 **/

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Java8提供7中阻塞队列
 * ArrayBlockingQueue
 * LinkedBlockingQueue
 * PriorityBlockingQueue
 * DelayQueue
 * SynchronousQueue
 * LinkedTransferQueue
 * LinkedBlockingDeque
 */
public class SHBlockQueue {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue(10);             //默认非公平锁


        //添加元素的方法：add();  满了直接报错
        // offer(); 满了返回false
        // put();   满处于阻塞
        arrayBlockingQueue.put("sss");
        arrayBlockingQueue.take();
    }
}
