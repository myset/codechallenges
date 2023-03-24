package org.example.codechallenges.springbootkafka.kafka;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.codechallenges.springbootkafka.jpa.Message;
import org.example.codechallenges.springbootkafka.jpa.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KafkaConsumerFiltered {
    private static final Logger LOG = LogManager.getFormatterLogger(KafkaConsumerFiltered.class);
    @Autowired
    private MessagesRepository messagesRepository;

    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private int batchMaxSize;

    private List<Message> messagesBatch;

    @KafkaListener(
            topics = "${spring.kafka.consumer.topic}",
            containerFactory = "concurrentKafkaListenerContainerFactory",
            autoStartup = "${listen.auto.start:true}",
            concurrency = "${listen.concurrency:2}")
    public void processMessage(String message) {
        LOG.info(message);

        Message jpaMessage=new Message();
        jpaMessage.setMessage(message);

        // no batch insert into database
        messagesRepository.save(jpaMessage);


        // batch insert into database
//        if(messagesBatch==null)
//            messagesBatch=new ArrayList<Message>();
//
//        if(messagesBatch.size() < batchMaxSize){
//            messagesBatch.add(jpaMessage);
//        }
//        else {
//            messagesRepository.saveAll(messagesBatch);
//            messagesBatch=new ArrayList<Message>();
//        }

    }

}