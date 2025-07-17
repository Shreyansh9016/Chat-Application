package com.chat.application.app.controller;

import com.chat.application.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    // it is the end point where client sends message
    @SendTo("/topic/messages")
    // tells springboot to broadcast or send message to all clients subscribed to this "topic"
    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }

    @GetMapping("chat")
    public String chat(){
        return "chat";
    }
}
