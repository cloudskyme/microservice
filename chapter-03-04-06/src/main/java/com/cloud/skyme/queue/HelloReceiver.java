/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.queue
 *
 *    Filename:    HelloReceiver1.java
 *
 *    Description: 消息接收监听
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月7日 上午11:18:10
 *
 *    Revision:
 *
 *    2017年11月7日 上午11:18:10
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import com.cloud.skyme.domain.User;

/**
 * @ClassName HelloReceiver1
 * @Description 消息接收监听
 * @author zhangfeng
 * @Date 2017年11月7日 上午11:18:10
 * @version 1.0.0
 */
@Configuration
public class HelloReceiver {
	
	private final static Logger logger = LoggerFactory.getLogger(HelloReceiver.class);
	
	@RabbitListener(queues = "user")
    public void processUser(User user) {
		logger.info("接收到的消息 : "+user.toString());
    }
	
}
