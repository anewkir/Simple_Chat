package com.project.simple_chat.config;

import com.project.simple_chat.domain.Message;
import com.project.simple_chat.domain.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.awt.*;


@Component
public class ChatEventListener {


    private static final Logger LOGGER = LoggerFactory.getLogger(ChatEventListener.class);

    @Autowired
    private SimpMessageSendingOperations sendingOperations;

    @EventListener
    public void handleWebSocketConnectListener(final SessionConnectedEvent event){
        LOGGER.info("New connection");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(final SessionDisconnectEvent event){

        final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        final String userName = (String) headerAccessor
                .getSessionAttributes()
                .get("username");

        final Message message = Message.builder()
                .type(Type.DISCONNECT)
                .sender(userName)
                .build();

        sendingOperations.convertAndSend("/topic/public", message);


        }

    }

