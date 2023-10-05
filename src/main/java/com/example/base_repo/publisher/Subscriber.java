package com.example.base_repo.publisher;

public class Subscriber {
    public Subscriber(Topic... topics) {
        for (Topic t : topics) {
            Server.getInstance().registerSubscriber(this, t);
        }
    }

    public void receivedMessage(Topic topic, Message m) {
        switch (topic) {
            case INFO:
                System.out.println("Topic info - " + m.getMessage());
                break;
            case WARNING:
                System.out.println("Topic warning - " + m.getMessage());
                break;
            case ERROR:
                System.out.println("Topic error - " + m.getMessage());
                break;
        }
    }
}
