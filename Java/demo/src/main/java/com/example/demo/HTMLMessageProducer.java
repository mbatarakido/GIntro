package com.example.demo;

public class HTMLMessageProducer implements IMessageProducer{
    public String formatMessage(String message){
        return "HTML: Hello " +message;
    }
}
