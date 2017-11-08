/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.queue
 *
 *    Filename:    HelloSender1.java
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
 *    Create at:   2017年11月7日 上午11:17:20
 *
 *    Revision:
 *
 *    2017年11月7日 上午11:17:20
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.queue;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cloud.skyme.domain.User;

/**
 * @ClassName HelloSender1
 * @Description 消息发送，指定队列名为hello Direct模式
 * @author zhangfeng
 * @Date 2017年11月7日 上午11:17:20
 * @version 1.0.0
 */
@Component
public class HelloSender {
	
	private final static Logger logger = LoggerFactory.getLogger(HelloSender.class);
	
	@Autowired  
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String sendMsg = "hello " + new Date();
        logger.info("消息发送 : "+sendMsg);
        this.rabbitTemplate.convertAndSend("hello", sendMsg);
    }
    
    /**
     * @Description 序列化发送
     */
    public void sendUser() {
    	User user = new User();
    	user.setUserName("张锋");
    	user.setPassword("123456");
    	user.setAge(30);
    	this.rabbitTemplate.convertAndSend("user", user);
    }
    
    public void sendMessage() {
        String sendMsg = "exchange " + new Date();
        logger.info("消息发送 : "+sendMsg);
        this.rabbitTemplate.convertAndSend("exchange","topic.message", sendMsg);
    }

}
