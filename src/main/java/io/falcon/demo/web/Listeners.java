package io.falcon.demo.web;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

//@Component
public class Listeners {

//    @KafkaListener(topics = "Messages", groupId = "group1")
//    public void listen(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
//        System.out.println("ARSENAL ARSENAL: first" + message + " topic:"+topic);
//    }
}
