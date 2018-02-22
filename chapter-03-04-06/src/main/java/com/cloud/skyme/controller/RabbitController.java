/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.controller
 *
 *    Filename:    RabbitController.java
 *
 *    Description: 队列测试
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月7日 上午11:19:19
 *
 *    Revision:
 *
 *    2017年11月7日 上午11:19:19
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.skyme.queue.FanoutSender;
import com.cloud.skyme.queue.HelloSender;
import com.cloud.skyme.queue.TopicSender;

/**
 * @ClassName RabbitController
 * @Description 队列测试
 * @author zhangfeng
 * @Date 2017年11月7日 上午11:19:19
 * @version 1.0.0
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitController {
	
	private final static Logger logger = LoggerFactory.getLogger(RabbitController.class);
	
	@Autowired
    private HelloSender helloSender;
	
	@Autowired
	private TopicSender topicSender;
	
	@Autowired
	private FanoutSender fanoutSender;
    
    /**
     * @Description 消息发送测试
     * @return
     */
    @RequestMapping("/send")
    public String send() {
    	logger.info("消息发送");
        helloSender.send();
        helloSender.sendUser();
        return "消息发送成功";
    }
    
    /**
     * @Description 单个生产者，多个消息者
     * @return
     */
    @RequestMapping("/sendMany")
    public String sendMany() {
    	logger.info("消息发送");
    	for (int i = 0; i < 10; i++) {
    		helloSender.send();
		}
        return "单生产，多消费消息发送成功";
    }
    
    /**
     * @Description topic exchange类型rabbitmq消息发送
     * @return
     */
    @RequestMapping("/topic")
    public String topic() {
    	topicSender.send();
    	return "topic exchange类型rabbitmq消息发送成功";
    }
    
    /**
     * @Description fanout exchange类型rabbitmq消息发送
     * @return
     */
    @RequestMapping("/fanoutSender")
    public String fanoutSender() {
    	fanoutSender.send();
    	return "fanout exchange类型rabbitmq消息发送成功";
    }

}
