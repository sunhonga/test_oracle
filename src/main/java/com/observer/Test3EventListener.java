package com.observer;

/**
 * @ClassName Test3EventListener
 * @Description TODO
 * Author sunhong
 * Date 2020-5-9 19:13
 **/
public class Test3EventListener extends AbstractEventListener {


    public Test3EventListener(int order) {
        super(order);
    }


    @Override
    public void onTestEvent(Event event) {
        System.out.println("�¼�������3ִ��");
        EventObject eventObject = event.getEventObject();
        System.out.println(eventObject);
    }
}
