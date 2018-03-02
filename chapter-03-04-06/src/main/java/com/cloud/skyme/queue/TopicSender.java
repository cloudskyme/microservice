/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.queue
 *
 *    Filename:    TopicSender.java
 *
 *    Description: TopicSender ExChange
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月7日 下午2:44:29
 *
 *    Revision:
 *
 *    2017年11月7日 下午2:44:29
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName TopicSender
 * @Description TopicSender ExChange
 * @author zhangfeng
 * @Date 2017年11月7日 下午2:44:29
 * @version 1.0.0
 */
@Component
public class TopicSender {
	
private final static Logger logger = LoggerFactory.getLogger(TopicSender.class);
	
	@Autowired  
    private RabbitTemplate rabbitTemplate;


    public void send() {
        String msg1 = "I am topic.mesaage msg======";
        logger.info("发送者1 : " + msg1);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", msg1);
        
        String msg2 = "I am topic.mesaages msg########";
        logger.info("发送者2 : " + msg2);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", msg2);
    }

}
