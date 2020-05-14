package com.observer;

/**
 * @ClassName Test1EventListener
 * @Description TODO
 * Author sunhong
 * Date 2020-5-9 18:40
 **/
public class Test1EventListener extends AbstractEventListener {
    public Test1EventListener(int order) {
        super(order);
    }

    @Override
    public void onTestEvent(Event event) {
        System.out.println("ÊÂ¼ş¼àÌıÆ÷1Ö´ĞĞ");
        EventObject eventObject = event.getEventObject();
        System.out.println(eventObject);
    }
}
