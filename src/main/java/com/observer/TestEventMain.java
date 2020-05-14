package com.observer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName TestEventMain
 * @Description TODO
 * Author sunhong
 * Date 2020-5-9 19:14
 **/
public class TestEventMain {


    public static void main(String[] args) {

        List<AbstractEventListener> listeners = new ArrayList<>();

        listeners.add(new Test1EventListener(2));
        listeners.add(new Test2EventListener(1));
        listeners.add(new Test3EventListener(3));

        listeners = listeners.stream().sorted(Comparator.comparing(AbstractEventListener::getOrder)).collect(Collectors.toList());

        EventMulticaster eventMulticaster = new EventMulticaster(listeners);

        Order order = new Order("WX"+System.currentTimeMillis());

        EventObject eventObject = new EventObject(order);

        eventMulticaster.multicastEvent(new OrderCallbackEvent(eventObject));


    }
}
