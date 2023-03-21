package org.example.codechallenges.springbootkafka.kafka;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private static final Logger LOG = LogManager.getFormatterLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.consumer.topic}",
                   groupId = "${spring.kafka.consumer.group-id}")
    public void processMessage(String content) {
        LOG.info(content);
    }

}