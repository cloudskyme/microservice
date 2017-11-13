/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.queue
 *
 *    Filename:    FanoutSender.java
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
 *    Create at:   2017年11月7日 下午3:11:19
 *
 *    Revision:
 *
 *    2017年11月7日 下午3:11:19
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
 * @ClassName FanoutSender
 * @Description fanout 发送
 * @author zhangfeng
 * @Date 2017年11月7日 下午3:11:19
 * @version 1.0.0
 */
@Component
public class FanoutSender {
	
	private final static Logger logger = LoggerFactory.getLogger(TopicSender.class);
	
	@Autowired  
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String msgString="fanoutSender :hello i am zhangfeng";
        logger.info(msgString);
        this.rabbitTemplate.convertAndSend("fanoutExchange","abcd.ee", msgString);
    }

}
