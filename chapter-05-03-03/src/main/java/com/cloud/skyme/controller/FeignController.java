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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.skyme.model.User;
import com.cloud.skyme.service.HystrixService;

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
    private HystrixService hystrixService;

    /**
     * @Description feign远程测试
     * @return
     */
    @RequestMapping("/feign")
    public Map<String,Object> feignCore(){
        Map<String,Object> ret = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        String s1 = hystrixService.getName("张三");
        sb.append(s1).append("\n");
        User user = null;
        try {
            user = hystrixService.getNameAndAge(URLEncoder.encode("李四", "UTF-8"), 20);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        sb.append(user.toString()).append("\n");
        String s3 = hystrixService.getUser(new User("王五", 39));
        sb.append(s3).append("\n");
        ret.put("show",sb.toString());
        return ret;
    }

}
