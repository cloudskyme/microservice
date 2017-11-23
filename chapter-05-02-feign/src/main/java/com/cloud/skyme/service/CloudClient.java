/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.service
 *
 *    Filename:    ComputeClient.java
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
 *    Create at:   2017年11月21日 下午4:13:06
 *
 *    Revision:
 *
 *    2017年11月21日 下午4:13:06
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName ComputeClient
 * @Description 定义远程调用的接口
 * @author zhangfeng
 * @Date 2017年11月21日 下午4:13:06
 * @version 1.0.0
 */
@FeignClient("CLOUD-CLIENT")
public interface CloudClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
