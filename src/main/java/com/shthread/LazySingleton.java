package com.shthread;

/**
 * @ClassName LazySingleton
 * @Description TODO
 * Author sunhong
 * Date 2020-4-11 15:22
 * ˫�ؼ�鵥��ģʽ��������
 **/
public class LazySingleton {

    private static volatile  LazySingleton lazySingleton;

    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        if(lazySingleton == null){
            synchronized (LazySingleton.class){
                if (lazySingleton == null){
                    lazySingleton = new LazySingleton();
                    //�ֳ�����ִ�У�
                    //1.�����ڴ���������;
                    //2.��ʼ������
                    //3.����ʼ���õĶ�����ڴ��ַ������ϵ,��ֵ��
                }
            }
        }


        return lazySingleton;
    }



}
