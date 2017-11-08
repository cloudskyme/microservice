package com.cloud.skyme.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.skyme.entity.UserEntity;
import com.cloud.skyme.mapper.UserMapper;
import com.cloud.skyme.service.UserService;


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
	private UserService userService;
    
    @RequestMapping("/add")
    public String save(UserEntity user) {
    	userService.testInsert();
    	return "测试事务处理";
    }    
    
}