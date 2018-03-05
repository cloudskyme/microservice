package com.cloud.skyme.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.skyme.service.TUserService;

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
	private TUserService tUserService;
	
	
	/**
	 * @Description 动态数据源测试
	 * @return
	 */
	@RequestMapping("/getAll")
	public String getUsers() {
		tUserService.getDataSource1();
		tUserService.getDataSource2();
		tUserService.getDataSource3();
		
		return "测试动态数据源";
	}
    
}