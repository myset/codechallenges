package org.example.codechallenges.springbootkafka.kafka;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Function;

@Component
public class KafkaProducer{
    private static final Logger LOG = LogManager.getFormatterLogger(KafkaProducer.class);

    @Value("${spring.kafka.consumer.topic}")
    private String kafkaTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        LOG.info(message);
        kafkaTemplate.send(kafkaTopic, message);
    }

    public void sendMessageDebug(String message) {

        // Deprecated ListenableFutureCallback in favor of CompletableFuture
        CompletableFuture<SendResult<String,String>> future = kafkaTemplate.send(kafkaTopic, message);

        future
                // when ok
                .whenComplete(new BiConsumer<SendResult<String, String>, Throwable>() {
                        @Override
                        public void accept(SendResult<String, String> result, Throwable t) {
                            System.out.println(result);
                            LOG.info("%s - Offset: %s",message,result.getRecordMetadata().offset());
                        }
                })

                // when exception
                .exceptionally(new Function<Throwable, SendResult<String, String>>() {
                       @Override
                       public SendResult<String, String> apply(Throwable t) {
                           LOG.error("%s - Error: %s", message, t.getMessage());
                           return null;
                       }
                });

    }
}
