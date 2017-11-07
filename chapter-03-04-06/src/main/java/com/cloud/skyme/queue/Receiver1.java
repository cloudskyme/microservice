/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.queue
 *
 *    Filename:    Receiver1.java
 *
 *    Description: 第1个接收者
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月7日 下午2:29:14
 *
 *    Revision:
 *
 *    2017年11月7日 下午2:29:14
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName Receiver1
 * @Description 第1个接收者
 * @author zhangfeng
 * @Date 2017年11月7日 下午2:29:14
 * @version 1.0.0
 */
@Configuration
public class Receiver1 {
	
	private final static Logger logger = LoggerFactory.getLogger(Receiver1.class);
	
	@RabbitListener(queues = "topic.message")
    public void process(String hello) {
		logger.info("receiver1接收到的消息 : "+hello);
    }

}
