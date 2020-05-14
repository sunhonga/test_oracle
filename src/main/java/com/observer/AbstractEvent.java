package com.observer;

/**
 * @ClassName AbstractEvent
 * @Description TODO
 * Author sunhong
 * Date 2020-5-9 13:11
 **/
public class AbstractEvent implements Event {


    private long timestamp;
    private EventObject eventObject;


    public AbstractEvent(EventObject eventObject) {
        this.setEventObject(eventObject);
    }

    @Override
    public EventObject getEventObject() {
        return this.eventObject;
    }

    @Override
    public void setEventObject(EventObject eventObject) {
        this.eventObject = eventObject;
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp(){
        return this.timestamp;
    }
}
