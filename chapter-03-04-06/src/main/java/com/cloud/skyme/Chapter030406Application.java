package com.cloud.skyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName Chapter030406Application
 * @Description RabbitMQ收发消息测试
 * @author zhangfeng
 * @Date 2017年11月3日 上午11:46:14
 * @version 1.0.0
 */
@SpringBootApplication
public class Chapter030406Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter030406Application.class, args);
	}
}
