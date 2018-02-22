/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.schedule
 *
 *    Filename:    ScheduledTasks.java
 *
 *    Description: 定时任务测试
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月8日 下午4:04:36
 *
 *    Revision:
 *
 *    2017年11月8日 下午4:04:36
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName ScheduledTasks
 * @Description 定时任务测试
 * @author zhangfeng
 * @Date 2017年11月8日 下午4:04:36
 * @version 1.0.0
 */
@Component
public class ScheduledTasks {
	
	private final static Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	/**
	 * @Description fixdDelay：以指定时间间隔调度（以方法执行结束时间为准）
	 */
//	@Scheduled(fixedRate = 5000)
//	public void reportCurrentTime() {
//		logger.info("The time is now {}", dateFormat.format(new Date()));
//	}
	
	/**
	 * @Description fixedRate：以指定时间间隔调度任务（以方法执行开始时间为准）
	 */
//	@Scheduled(fixedRate = 5000)
//	public void reportCurrentStartTime() {
//		logger.info("The time is now {}", dateFormat.format(new Date()));
//	}
	
	/**
	 * @Description initialDelay：指定延迟后开始调度任务
	 */
//	@Scheduled(initialDelay=1000, fixedRate=5000)
//	public void reportInitialTime() {
//		logger.info("The time is now {}", dateFormat.format(new Date()));
//	}
	
	/**
	 * @Description 按指定的cron表达式执行
	 */
	@Scheduled(cron="*/5 * * * * MON-FRI")
	public void reportCronTime() {
		logger.info("The time is now {}", dateFormat.format(new Date()));
	}

}
