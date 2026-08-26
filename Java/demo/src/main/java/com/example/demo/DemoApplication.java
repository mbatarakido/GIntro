package com.example.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanDefinitionReader(new ClassPathResource("D:\\Developer\\Java\\demo\\pom.xml"));
		MessageWriter messageWriter = (MessageWriter) factory.getBean("messageWriter", MessageWriter.class);
		IMessageProducer messageProducer = (IMessageProducer) factory.getBean("htmlMessageProducer", IMessageProducer.class);

		messageWriter.setMessageProducer(messageProducer);
		messageWriter.writeMessage("Welcome to Spring");
		//SpringApplication.run(DemoApplication.class, args);
	}

}
