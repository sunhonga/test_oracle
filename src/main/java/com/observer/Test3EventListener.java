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
        System.out.println("ÊÂ¼ş¼àÌıÆ÷3Ö´ĞĞ");
        EventObject eventObject = event.getEventObject();
        System.out.println(eventObject);
    }
}
