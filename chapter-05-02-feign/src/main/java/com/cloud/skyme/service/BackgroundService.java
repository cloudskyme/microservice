/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.service
 *
 *    Filename:    BackgroundService.java
 *
 *    Description: feign远程调用
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月22日 下午5:31:47
 *
 *    Revision:
 *
 *    2017年11月22日 下午5:31:47
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.cloud.skyme.api.ServiceRemoteApi;

/**
 * @ClassName BackgroundService
 * @Description feign远程调用
 * @author zhangfeng
 * @Date 2017年11月22日 下午5:31:47
 * @version 1.0.0
 */
@FeignClient("CLOUD-CLIENT")
public interface BackgroundService extends ServiceRemoteApi{
}
