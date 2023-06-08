package com.example.base_repo.publisher;

import java.util.*;
import java.util.stream.Collectors;

public class PublisherSubscriber {
    private static final String TOPIC_INFO = "info";
    private static final String TOPIC_WARNING = "warning";
    private static final String TOPIC_ERROR = "error";

    public static void main(String[] args) {
        Subscriber subscriberInfo = new SubscriberInfoImpl();
        Subscriber subscriberWarning = new SubscriberWarningImpl();
        Subscriber subscriberError = new SubscriberErrorImpl();

        Publisher publisher = new PublisherImpl();
        publisher.subscribe(TOPIC_INFO, subscriberInfo);
        publisher.subscribe(TOPIC_WARNING, subscriberWarning);
        publisher.subscribe(TOPIC_ERROR, subscriberError, subscriberWarning);
        publisher.publish();
        publisher.unsubscribe(TOPIC_ERROR, subscriberWarning);
        publisher.publish();
    }

    interface Publisher {
        void subscribe(String topicName, Subscriber... subscribers);

        void unsubscribe(String topicName, Subscriber subscriber);

        void publish();
    }

    static class PublisherImpl implements Publisher {
        Map<String, List<Subscriber>> topics;

        public PublisherImpl() {
            this.topics = new HashMap<>();
            topics.put(TOPIC_INFO, new ArrayList<>());
            topics.put(TOPIC_WARNING, new ArrayList<>());
            topics.put(TOPIC_ERROR, new ArrayList<>());
        }

        @Override
        public void subscribe(String topicName, Subscriber... subscribers) {
            topics.get(topicName).addAll(Arrays.stream(subscribers).collect(Collectors.toList()));
        }

        @Override
        public void unsubscribe(String topicName, Subscriber subscriber) {
            topics.get(topicName).remove(subscriber);
        }

        @Override
        public void publish() {
            List<Subscriber> subscribersInfo = topics.get(TOPIC_INFO);
            publish(subscribersInfo, "Info message");
            List<Subscriber> subscribersWarning = topics.get(TOPIC_WARNING);
            publish(subscribersWarning, "Warning message");
            List<Subscriber> subscribersError = topics.get(TOPIC_ERROR);
            publish(subscribersError, "Error message");
        }

        private void publish(List<Subscriber> subscribers, String message) {
            subscribers.forEach(subscriber -> subscriber.receiveMessage(message));
        }
    }

    interface Subscriber {
        void receiveMessage(String message);

        String getSubscriberId();
    }

    static class SubscriberInfoImpl implements Subscriber {

        @Override
        public void receiveMessage(String message) {
            System.out.println(String.format("Reading message - %s by subscriber id -%s", message, getSubscriberId()));
        }

        @Override
        public String getSubscriberId() {
            return "Subscriber info";
        }
    }

    static class SubscriberWarningImpl implements Subscriber {

        @Override
        public void receiveMessage(String message) {
            System.out.println(String.format("Reading message - %s by subscriber id -%s", message, getSubscriberId()));
        }

        @Override
        public String getSubscriberId() {
            return "Subscriber warning";
        }
    }

    static class SubscriberErrorImpl implements Subscriber {

        @Override
        public void receiveMessage(String message) {
            System.out.println(String.format("Reading message - %s by subscriber id -%s", message, getSubscriberId()));
        }

        @Override
        public String getSubscriberId() {
            return "Subscriber error";
        }
    }
}
