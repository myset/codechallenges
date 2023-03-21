package org.example.codechallenges.springbootkafka.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    KafkaProducer kafkaProducer;

    @GetMapping("/kafka/{message}")
    public String hello(@PathVariable(value = "message") String message) {
        kafkaProducer.sendMessageDebug(message);
        return String.format(message);
    }
}
