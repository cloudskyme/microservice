/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.config
 *
 *    Filename:    RabbitConfig.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月7日 下午3:22:10
 *
 *    Revision:
 *
 *    2017年11月7日 下午3:22:10
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName RabbitConfig
 * @Description 所有消息队列配置类
 * @author zhangfeng
 * @Date 2017年11月7日 下午3:22:10
 * @version 1.0.0
 */
@Component
public class RabbitConfig {
	
	// =============Direct模式=============================
		final static String queueName = "hello";

		@Bean
		public Queue helloQueue() {
			return new Queue(queueName);
		}

		@Bean
		public Queue userQueue() {
			return new Queue("user");
		}
		// =============end Direct模式=============================

		// ===============以下是验证topic Exchange的队列==========
		@Bean
		public Queue queueMessage() {
			return new Queue("topic.message");
		}

		@Bean
		public Queue queueMessages() {
			return new Queue("topic.messages");
		}

		@Bean
		TopicExchange exchange() {
			return new TopicExchange("exchange");
		}

		/**
		 * 将队列topic.message与exchange绑定，binding_key为topic.message,就是完全匹配
		 * 
		 * @param queueMessage
		 * @param exchange
		 * @return
		 */
		@Bean
		Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
			return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
		}

		/**
		 * 将队列topic.messages与exchange绑定，binding_key为topic.#,模糊匹配
		 * 
		 * @param queueMessage
		 * @param exchange
		 * @return
		 */
		@Bean
		Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
			return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
		}
		// ===============以上是验证topic Exchange的队列==========

		// ===============以下是验证fanout ExChange的队列==========
		@Bean
	    public Queue AMessage() {
	        return new Queue("fanout.A");
	    }

	    @Bean
	    public Queue BMessage() {
	        return new Queue("fanout.B");
	    }

	    @Bean
	    public Queue CMessage() {
	        return new Queue("fanout.C");
	    }
	    
	    @Bean
	    FanoutExchange fanoutExchange() {
	        return new FanoutExchange("fanoutExchange");
	    }
		
	    @Bean
	    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange) {
	        return BindingBuilder.bind(AMessage).to(fanoutExchange);
	    }

	    @Bean
	    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
	        return BindingBuilder.bind(BMessage).to(fanoutExchange);
	    }

	    @Bean
	    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
	        return BindingBuilder.bind(CMessage).to(fanoutExchange);
	    }
		// ===============end fanout ExChange的队列===========

}
