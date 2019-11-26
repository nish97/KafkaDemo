package com.stackroute.kafkademo.controller;


import com.stackroute.kafkademo.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {


    private Producer producer;

    @Autowired
    public KafkaController(Producer producer) {
        this.producer = producer;
    }


    @GetMapping("/publish")
    public ResponseEntity getMessage(@RequestParam("message") String message){
        return new ResponseEntity<String>(producer.sendMessage(message), HttpStatus.CREATED);
    }
 }
