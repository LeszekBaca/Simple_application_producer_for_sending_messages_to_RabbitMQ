package com.project.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping ("/addMessage")
    public String send(@RequestParam String message){
        rabbitTemplate.convertAndSend("FirstQueue", message);
        return "I added to the queue: "+message;
    }

    @GetMapping ("/addMessageToSecondQueue")
    public String sendToSecondQueue(@RequestParam String message){
        rabbitTemplate.convertAndSend("SecondQueue", message);
        return "I added to the queue: "+message;
    }

}
