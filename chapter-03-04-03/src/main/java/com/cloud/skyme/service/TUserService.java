/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.service
 *
 *    Filename:    TUserService.java
 *
 *    Description: 多个方法连接多个数据源
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年10月31日 下午4:10:02
 *
 *    Revision:
 *
 *    2017年10月31日 下午4:10:02
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.skyme.datasource.TargetDataSource;
import com.cloud.skyme.entity.TUser;
import com.cloud.skyme.entity.TUser1;
import com.cloud.skyme.entity.TUser2;
import com.cloud.skyme.mapper.TUserMapper;
import com.cloud.skyme.mapper.TUserMapper1;
import com.cloud.skyme.mapper.TUserMapper2;

/**
 * @ClassName TUserService
 * @Description 多个方法连接多个数据源
 * @author zhangfeng
 * @Date 2017年10月31日 下午4:10:02
 * @version 1.0.0
 */
@Service
public class TUserService {
	
	private final static Logger logger = LoggerFactory.getLogger(TUserService.class);
	
	@Autowired
	private TUserMapper tUserMapper;//第一个数据源对应的mapper
	@Autowired
	private TUserMapper1 tUserMapper1;//第二个数据源对应的mapper
	@Autowired
	private TUserMapper2 tUserMapper2;//第三个数据源对应的mapper
	
	/**
	 * @Description 不指定数据源从默认数据源取数据
	 */
	public void getDataSource1() {
		TUser tUser = tUserMapper.selectByPrimaryKey(1);
		logger.info("默认数据源  "+tUser.getUsername());
	}
	
	/**
	 * @Description 数据源ds1
	 */
	@TargetDataSource(name="ds1")
	public void getDataSource2() {
		TUser1 tUser1 = tUserMapper1.selectByPrimaryKey(2);
		logger.info("数据源二 "+tUser1.getUsername());
	}
	
	/**
	 * 从第二个数据源获取数据
	 */
	@TargetDataSource(name="ds2")
	public void getDataSource3() {
		TUser2 tUser2 = tUserMapper2.selectByPrimaryKey(2);
		logger.info("数据源三 "+tUser2.getUsername());
	}

}
