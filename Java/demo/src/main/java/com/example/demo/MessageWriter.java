package com.example.demo;

public class MessageWriter {
    private IMessageProducer messageProducer;
    public void writeMessage(String message){
        //instantiate messageProducer with concrete implementation class
        //messageProducer = MessageProducerFactory.createMessageProducer("html");
        String formattedData = messageProducer.formatMessage(message);
        System.out.println(formattedData);
    }
    public void setMessageProducer(IMessageProducer messageProducer){
        this.messageProducer = messageProducer;
    }
}
