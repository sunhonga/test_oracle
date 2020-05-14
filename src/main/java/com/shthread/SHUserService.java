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
                    User user = (User) arrayBlockingQueue.take();       //�����ķ�ʽ��ȡ�����е�����
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
        arrayBlockingQueue.add(user);       //����첽��������
        return true;
    }


    private void addUser(User user){
        System.out.println("����û���" + user);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void sendPoints(User user){
        System.out.println("���ͻ��ָ�ָ���û���" + user);
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
