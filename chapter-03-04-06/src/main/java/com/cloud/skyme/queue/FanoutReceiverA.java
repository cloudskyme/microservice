/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.queue
 *
 *    Filename:    FanoutReceiverA.java
 *
 *    Description: fanout消费者A
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月7日 下午3:14:01
 *
 *    Revision:
 *
 *    2017年11月7日 下午3:14:01
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName FanoutReceiverA
 * @Description fanout消费者A
 * @author zhangfeng
 * @Date 2017年11月7日 下午3:14:01
 * @version 1.0.0
 */
@Component
public class FanoutReceiverA {

	private final static Logger logger = LoggerFactory.getLogger(FanoutReceiverA.class);

	@RabbitListener(queues = "fanout.A")
	public void process(String msg) {
		logger.info("FanoutReceiverA  : " + msg);
	}

}
