/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.controller
 *
 *    Filename:    AuthorController.java
 *
 *    Description: 作者信息
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2018年3月7日 上午9:21:53
 *
 *    Revision:
 *
 *    2018年3月7日 上午9:21:53
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.skyme.service.AuthorService;

/**
 * @ClassName AuthorController
 * @Description 作者信息
 * @author zhangfeng
 * @Date 2018年3月7日 上午9:21:53
 * @version 1.0.0
 */
@RestController
public class AuthorController {
	
	private final static Logger logger = LoggerFactory.getLogger(AuthorController.class);
	
	@Autowired
	private AuthorService authorService;
	
	/**
	 * @Description 获取作者信息
	 */
	@RequestMapping("/jooq")
	public void getJooq() {
		authorService.authSearch();
	}

}
