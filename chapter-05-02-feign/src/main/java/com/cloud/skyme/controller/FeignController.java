/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.controller
 *
 *    Filename:    RibbonController.java
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
 *    Create at:   2017年11月21日 上午11:51:03
 *
 *    Revision:
 *
 *    2017年11月21日 上午11:51:03
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cloud.skyme.model.User;
import com.cloud.skyme.service.BackgroundService;
import com.cloud.skyme.service.CloudClient;

/**
 * @ClassName RibbonController
 * @Description 测试ribbon负载均衡
 * @author zhangfeng
 * @Date 2017年11月21日 上午11:51:03
 * @version 1.0.0
 */
@RestController
public class FeignController {
	
	@Autowired
    private CloudClient cloudClient;
	
	@Autowired
    private BackgroundService backgroundService;

    /**
     * @Description feign调用测试
     * @return
     */
    @GetMapping(value = "/add")
    public Integer add() {
    	return cloudClient.add(20, 40);
    }
    
    /**
     * @Description feign远程测试
     * @return
     */
    @RequestMapping("/feign")
    public Map<String,Object> feignCore(){
        Map<String,Object> ret = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        String s1 = backgroundService.getName("张三");
        sb.append(s1).append("\n");
        User user = null;
        try {
            user = backgroundService.getNameAndAge(URLEncoder.encode("李四", "UTF-8"), 20);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        sb.append(user.toString()).append("\n");
        String s3 = backgroundService.getUser(new User("王五", 39));
        sb.append(s3).append("\n");
        ret.put("show",sb.toString());
        return ret;
    }

}
