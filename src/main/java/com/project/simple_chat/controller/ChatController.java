package com.project.simple_chat.controller;

import com.project.simple_chat.domain.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketMessage;

@Controller
public class ChatController {




   @MessageMapping("/chat.send")
   @SendTo("/topic/public")
   public Message sendMessage(@Payload Message webSocketMessage){
       return webSocketMessage;
   }

    @MessageMapping("/chat.newUser")
    @SendTo("/topic/public")
    public Message newUser(@Payload Message webSocketMessage, SimpMessageHeaderAccessor headerAccessor){
       headerAccessor.getSessionAttributes()
               .put("username", webSocketMessage.getSender());
       return webSocketMessage;
    }
}
