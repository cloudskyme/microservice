package com.cloud.skyme.web;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.skyme.entity.TUser;
import com.cloud.skyme.entity.TUser1;
import com.cloud.skyme.mapper.d1.TUserMapper;
import com.cloud.skyme.mapper.d2.TUserMapper1;

/**
 * @ClassName UserController
 * @Description 用户的基本操作控制层
 * @author zhangfeng
 * @Date 2017年10月25日 下午5:04:54
 * @version 1.0.0
 */
@RestController
public class UserController {
	
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private TUserMapper tUserMapper;//第一个数据源
	
	@Autowired
	private TUserMapper1 tUserMapper2;//第二个数据源
	
	
	@RequestMapping("/getAll")
	public String getUsers() {
		TUser tUser = tUserMapper.selectByPrimaryKey(1);
		TUser1 tUser1 = tUserMapper2.selectByPrimaryKey(2);
		logger.info("数据源一 "+tUser.getUsername());
		logger.info("数据源二 "+tUser1.getUsername());
		return "测试多数据源";
	}
    
}