package io.falcon.demo.web;

import io.falcon.demo.model.TheMessage;
import io.falcon.demo.persistance.MessageMongoRepository;
import io.falcon.demo.persistance.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TheMessageController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageMongoRepository messageMongoRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private SimpMessagingTemplate socketTemplate;


    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public TheMessage message(TheMessage input) throws Exception {
       // this.redisTemplate.opsForHash().put("message", input, input);
        System.out.println("Mongo start");
        //this.messageMongoRepository.save(input);
        System.out.println("Mongo end");

        System.out.println("Kafka send start");
        kafkaTemplate.send("Messages", input.getMessage());
        //kafkaTemplate.send("Messages2", input.getMessage());
        System.out.println("Kafka send start");

        this.messageRepository.save(input);
        System.out.println("done");
        Thread.sleep(1000); // simulated delay
        return new TheMessage(HtmlUtils.htmlEscape(input.getMessage()));
    }

    @GetMapping(value = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TheMessage> listMessages() {
        return this.messageMongoRepository.findAll();
    }

    @PostMapping(value = "/messages", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @SendTo("/topic/messages")
    public TheMessage listMessages(@RequestBody  @Valid TheMessage message) {
        TheMessage message1 = this.messageMongoRepository.save(message);
        socketTemplate.convertAndSend("/topic/messages", message1);
        return message1;
    }
}