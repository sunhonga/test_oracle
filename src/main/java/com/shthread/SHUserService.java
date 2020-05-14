package com.shthread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName SHUserService
 * @Description TODO
 * Author sunhong
 * Date 2019-9-26 15:43
 **/
public class SHUserService {

    private final ExecutorService single =  Executors.newSingleThreadExecutor();

    private volatile boolean isRunning = true;

    ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);

    {

        init();
    }

    public void init(){
        single.execute(()->{
            while (isRunning){
                try {
                    User user = (User) arrayBlockingQueue.take();       //阻塞的方式获取队列中的数据
                    sendPoints(user);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public boolean register(){
        User user = new User();
        user.setName("sunhong");
        addUser(user);
        arrayBlockingQueue.add(user);       //添加异步阻塞队列
        return true;
    }


    private void addUser(User user){
        System.out.println("添加用户：" + user);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void sendPoints(User user){
        System.out.println("发送积分给指定用户：" + user);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SHUserService().register();
    }

}
