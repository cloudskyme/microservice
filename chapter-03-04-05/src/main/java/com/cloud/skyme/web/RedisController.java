package com.cloud.skyme.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.skyme.entity.User;
import com.cloud.skyme.service.RedisService;
import com.cloud.skyme.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName UserController
 * @Description 用户的基本操作控制层，用于测试缓存
 * @author zhangfeng
 * @Date 2017年10月25日 下午5:04:54
 * @version 1.0.0
 */
@Api("消息队列相关api")
@RestController
@RequestMapping("/redis")
public class RedisController {

	private final static Logger logger = LoggerFactory.getLogger(RedisController.class);

	@Autowired
    RedisService redisService;

    /**
     * 设置Str缓存
     * @param key
     * @param val
     * @return
     */
	@ApiOperation(value = "设置缓存值", notes = "设置缓存值")
    @RequestMapping(value = "setStr")
    public String setStr(String key, String val){
        try {
            redisService.setStr(key, val);
            return "success";
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 根据key查询Str缓存
     * @param key
     * @return
     */
	@ApiOperation(value = "根据key取值", notes = "根据key取值")
    @RequestMapping(value = "getStr")
    public String getStr(String key){
        return redisService.getStr(key);
    }


    /**
     * 根据key产出Str缓存
     * @param key
     * @return
     */
	@ApiOperation(value = "删除key取值", notes = "删除key取值")
    @RequestMapping(value = "delStr")
    public String delStr(String key){
        try {
            redisService.del(key);
            return "success";
        } catch (Exception e){
            return "error";
        }
    }


    /**
     * 设置obj缓存
     * @param key
     * @param user
     * @return
     */
	@ApiOperation(value = "设置缓存对象", notes = "设置缓存对象")
    @RequestMapping(value = "setObj")
    public String setObj(String key, User user){
        try {
            redisService.setObj(key, user);
            return "success";
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 获取obj缓存
     * @param key
     * @return
     */
	@ApiOperation(value = "根据key取得对象", notes = "根据key取得对象")
    @RequestMapping(value = "getObj")
    public Object getObj(String key){
        return redisService.getObj(key);
    }


    /**
     * 删除obj缓存
     * @param key
     * @return
     */
	@ApiOperation(value = "删除缓存对象", notes = "删除缓存对象")
    @RequestMapping(value = "delObj")
    public Object delObj(String key){
        try {
            redisService.delObj(key);
            return "success";
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
}