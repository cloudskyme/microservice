/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.queue
 *
 *    Filename:    FanoutReceiverB.java
 *
 *    Description: 消费都B
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月7日 下午3:15:40
 *
 *    Revision:
 *
 *    2017年11月7日 下午3:15:40
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName FanoutReceiverB
 * @Description 消费都B
 * @author zhangfeng
 * @Date 2017年11月7日 下午3:15:40
 * @version 1.0.0
 */
@Component
public class FanoutReceiverB {
	
	private final static Logger logger = LoggerFactory.getLogger(FanoutReceiverB.class);

	@RabbitListener(queues = "fanout.B")
	public void process(String msg) {
		logger.info("FanoutReceiverB  : " + msg);
	}

}
