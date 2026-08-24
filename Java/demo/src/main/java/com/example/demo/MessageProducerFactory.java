package com.example.demo;

public class MessageProducerFactory {
    public static IMessageProducer createMessageProducer(String type) {
        if(type.equals("html")){
            return new HTMLMessageProducer();
        }
        else if(type.equals("text")){
            return new TextMessageProducer();
        }
        else if(type.equals("encrypt")){
            return new EncryptMessage();
        }
        else{
            return null;
        }
    }
}
