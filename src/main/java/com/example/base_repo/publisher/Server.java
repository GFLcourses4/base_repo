package com.example.base_repo.publisher;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Server {

    private Hashtable<Topic, List<Subscriber>> subscriberList;
    private static Server instance;

    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    private Server() {
        this.subscriberList = new Hashtable<>();
    }

    public void sendMessage(Topic topic, Message message) {
        List<Subscriber> subscribers = subscriberList.get(topic);
        for (Subscriber s : subscribers) {
            s.receivedMessage(topic, message);
        }
    }

    public void registerSubscriber(Subscriber subscriber, Topic topic) {
        if (!subscriberList.containsKey(topic)) {
            ArrayList<Subscriber> subscribers = new ArrayList();
            subscribers.add(subscriber);
            subscriberList.put(topic, subscribers);
        } else {
            subscriberList.get(topic).add(subscriber);
        }
    }
}
