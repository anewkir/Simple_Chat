package com.project.simple_chat.domain;

import lombok.Builder;
import lombok.Getter;

import java.security.PrivateKey;



@Builder
public class Message {

    /*
    using lombok to generate getters for the message class
    The type defines the type of message using enumerations
     that can be seen in Type.
     */
    @Getter
    private Type type;
    @Getter
    private String content;
    @Getter
    private String sender;
    @Getter
    private String time;


}
