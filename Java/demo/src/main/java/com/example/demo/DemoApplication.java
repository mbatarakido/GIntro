package com.example.demo;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.core.io.ClassPathResource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext();
		MessageWriter messageWriter = (MessageWriter) factory.getBean("messageWriter", MessageWriter.class);
		IMessageProducer messageProducer = (IMessageProducer) factory.getBean("htmlMessageProducer", IMessageProducer.class);

		messageWriter.setMessageProducer(messageProducer);
		messageWriter.writeMessage("Welcome to Spring");
		//SpringApplication.run(DemoApplication.class, args);
	}
}
