package com.observer;

/**
 * @ClassName AbstractEventListener
 * @Description TODO
 * Author sunhong
 * Date 2020-5-9 18:38
 **/
public class AbstractEventListener implements EventListener {

    private int order;

    public int getOrder() {
        return order;
    }

    public AbstractEventListener(int order) {
        this.order = order;
    }

    @Override
    public void onTestEvent(Event event) {

    }
}
