package com.tech.websocket.controller;

import com.tech.websocket.model.Greeting;
import com.tech.websocket.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws InterruptedException {
        Thread.sleep(1000);
        return new Greeting("Hello " + message.getName().trim() + "!.");
    }

}

/*
    /hello -> /app/hello is where the client publish data to server
    /topic/greetings is the topic where stomp client will subscribe to.
*/