package com.stackroute.kafkademo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public String sendMessage(String message){
        logger.info(String.format("$$ -> Producing message --> %s",message));
        kafkaTemplate.send("first",message);
        return "$$ -> Produced message -->"+message;
    }
}
