package io.falcon.persister.listener;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import io.falcon.persister.model.TheMessage;
import io.falcon.persister.persistance.MessageMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class Listeners {

    @Autowired
    private MessageMongoRepository repository;

    @KafkaListener(topics = "Messages", groupId = "group1")
    public void listen(TheMessage message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        System.out.println("ARSENAL ARSENAL: first" + message + " topic:"+topic);
        if(message != null) {
            repository.save(message);
        }
    }
}
