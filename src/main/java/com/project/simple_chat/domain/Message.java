package com.project.simple_chat.domain;

import lombok.Builder;
import lombok.Getter;

import java.security.PrivateKey;

@Builder
public class Message {
    @Getter
    private Type type;
    @Getter
    private String content;
    @Getter
    private String sender;
    @Getter
    private String time;


}
