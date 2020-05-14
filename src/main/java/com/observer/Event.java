package com.observer;

import java.io.Serializable;

public interface Event extends Serializable {

    EventObject getEventObject();

    void setEventObject(EventObject eventObject);

}
