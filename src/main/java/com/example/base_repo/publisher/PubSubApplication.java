package com.example.base_repo.publisher;

public class PubSubApplication {

    public static void main(String[] args) {

        new Subscriber(Topic.INFO, Topic.WARNING, Topic.ERROR);
        new Subscriber(Topic.INFO);

        Publisher infoPublisher = new Publisher(Topic.INFO);
        infoPublisher.publish(new Message("Info message"));
        Publisher warningPublisher = new Publisher(Topic.WARNING);
        warningPublisher.publish(new Message("Warning message"));
        Publisher errorPublisher = new Publisher(Topic.ERROR);
        errorPublisher.publish(new Message("Error message"));
        errorPublisher.publish(new Message("Test second message"));
    }
}
