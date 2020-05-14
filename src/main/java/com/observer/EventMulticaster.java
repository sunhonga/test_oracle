package com.observer;

import java.util.List;

/**
 * @ClassName EventMulticaster
 * @Description TODO
 * Author sunhong
 * Date 2020-5-9 19:14
 **/
public class EventMulticaster {


    private List<AbstractEventListener> listeners;

    public EventMulticaster(List<AbstractEventListener> listeners) {
        this.listeners = listeners;
    }



    public void multicastEvent(Event event){
        for (AbstractEventListener listener : listeners) {
            listener.onTestEvent(event);
        }
    }
}
