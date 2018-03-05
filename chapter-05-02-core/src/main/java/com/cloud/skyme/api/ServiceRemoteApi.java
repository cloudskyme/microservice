/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.api
 *
 *    Filename:    ServiceRemoteApi.java
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
 *    Create at:   2017年11月22日 下午4:53:36
 *
 *    Revision:
 *
 *    2017年11月22日 下午4:53:36
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.skyme.model.User;

/**
 * @ClassName ServiceRemoteApi
 * @Description 共用胡API接口
 * @author zhangfeng
 * @Date 2017年11月22日 下午4:53:36
 * @version 1.0.0
 */
@RequestMapping("/service-remote")
public interface ServiceRemoteApi {
	
	/**
	 * @Description 得到用户名
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/getName", method = RequestMethod.GET)
    String getName(@RequestParam("name") String name);
 
    /**
     * @Description 得到用户对象
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/getNameAndAge", method = RequestMethod.GET)
    User getNameAndAge(@RequestHeader("name") String name,@RequestHeader("age") Integer age);
 
 
    /**
     * @Description 得到用户对象
     * @param user
     * @return
     */
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    String getUser(@RequestBody User user);

}
