package com.shthread;

/**
 * @ClassName SHBlockQueue
 * @Description TODO
 * Author sunhong
 * Date 2019-9-26 15:57
 **/

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Java8�ṩ7����������
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
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue(10);             //Ĭ�Ϸǹ�ƽ��


        //���Ԫ�صķ�����add();  ����ֱ�ӱ���
        // offer(); ���˷���false
        // put();   ����������
        arrayBlockingQueue.put("sss");
        arrayBlockingQueue.take();
    }
}
