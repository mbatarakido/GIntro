package com.example.demo;

public class TextMessageProducer implements IMessageProducer{
    public String formatMessage(String message){
        return "Text: Hello " +message;
    }
}
