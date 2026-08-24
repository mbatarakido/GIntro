package com.example.demo;

import java.nio.charset.StandardCharsets;

public class EncryptMessage implements IMessageProducer {

    @Override
    public String formatMessage(String message) {
        message = message.getBytes(StandardCharsets.UTF_8).toString();
        return "Bytes Message: " + message;
    }
}
