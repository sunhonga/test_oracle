package com.observer;

/**
 * @ClassName Test2EventListener
 * @Description TODO
 * Author sunhong
 * Date 2020-5-9 19:13
 **/
public class Test2EventListener extends AbstractEventListener {
    public Test2EventListener(int order) {
        super(order);
    }


    @Override
    public void onTestEvent(Event event) {
        System.out.println("�¼�������2ִ��");
        EventObject eventObject = event.getEventObject();
        System.out.println(eventObject);
    }
}
