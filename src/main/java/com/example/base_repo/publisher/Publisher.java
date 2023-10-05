package com.example.base_repo.publisher;

public class Publisher {
    private Topic topic;

    public Publisher(Topic topic) {
        this.topic = topic;
    }

    public void publish(Message message) {
        Server.getInstance().sendMessage(topic, message);
    }
}
