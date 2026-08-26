package com.example.demo;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.core.io.ClassPathResource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		BeanFactory factory = new BeanFactory() {
			@Override
			public Object getBean(String name) throws BeansException {
				return null;
			}

			@Override
			public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
				return null;
			}

			@Override
			public Object getBean(String name, @Nullable Object @Nullable ... args) throws BeansException {
				return null;
			}

			@Override
			public <T> T getBean(Class<T> requiredType) throws BeansException {
				return null;
			}

			@Override
			public <T> T getBean(Class<T> requiredType, @Nullable Object @Nullable ... args) throws BeansException {
				return null;
			}

			@Override
			public <T> ObjectProvider<T> getBeanProvider(Class<T> requiredType) {
				return null;
			}

			@Override
			public <T> ObjectProvider<T> getBeanProvider(ResolvableType requiredType) {
				return null;
			}

			@Override
			public <T> ObjectProvider<T> getBeanProvider(ParameterizedTypeReference<T> requiredType) {
				return null;
			}

			@Override
			public boolean containsBean(String name) {
				return false;
			}

			@Override
			public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
				return false;
			}

			@Override
			public boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
				return false;
			}

			@Override
			public boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException {
				return false;
			}

			@Override
			public boolean isTypeMatch(String name, Class<?> typeToMatch) throws NoSuchBeanDefinitionException {
				return false;
			}

			@Override
			public @Nullable Class<?> getType(String name) throws NoSuchBeanDefinitionException {
				return null;
			}

			@Override
			public @Nullable Class<?> getType(String name, boolean allowFactoryBeanInit) throws NoSuchBeanDefinitionException {
				return null;
			}

			@Override
			public String[] getAliases(String name) {
				return new String[0];
			}
		};
		MessageWriter messageWriter = (MessageWriter) factory.getBean("messageWriter", MessageWriter.class);
		IMessageProducer messageProducer = (IMessageProducer) factory.getBean("htmlMessageProducer", IMessageProducer.class);

		messageWriter.setMessageProducer(messageProducer);
		messageWriter.writeMessage("Welcome to Spring");
		//SpringApplication.run(DemoApplication.class, args);
	}

}
