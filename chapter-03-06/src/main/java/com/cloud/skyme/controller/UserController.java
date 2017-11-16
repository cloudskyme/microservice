/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.controller
 *
 *    Filename:    UserController.java
 *
 *    Description: 用户接口文档测试
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月8日 下午2:59:20
 *
 *    Revision:
 *
 *    2017年11月8日 下午2:59:20
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @ClassName UserController
 * @Description 用户接口文档测试
 * @author zhangfeng
 * @Date 2017年11月8日 下午2:59:20
 * @version 1.0.0
 */
@RestController
@RequestMapping("/user")
@Api("userController相关api")
public class UserController {

	/**
	 * @Description 
	 *  @Api：用在类上，说明该类的作用
    @ApiOperation：用在方法上，说明方法的作用
    @ApiImplicitParams：用在方法上包含一组参数说明
    @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
        paramType：参数放在哪个地方
            header-->请求参数的获取：@RequestHeader
            query-->请求参数的获取：@RequestParam
            path（用于restful接口）-->请求参数的获取：@PathVariable
        name：参数名
        dataType：参数类型
        required：参数是否必须传
        value：参数的意思
        defaultValue：参数的默认值
    @ApiResponses：用于表示一组响应
    @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
        code：数字，例如400
        message：信息，例如"请求参数输入有误"
        response：抛出异常的类
    @ApiModel：描述一个Model的信息（这种一般用在post创建的时候，使用@RequestBody这样的场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候）
        @ApiModelProperty：描述一个model的属性
	 * @param username
	 * @param password
	 * @return
	 */
	@ApiOperation("获取用户信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "header", name = "username", dataType = "String", required = true, value = "用户的姓名", defaultValue = "zhangfeng"),
			@ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "用户的密码", defaultValue = "123456") })
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public String getUser(@RequestHeader("username") String username, @RequestParam("password") String password) {
		return username + password + "接口测试";
	}

}
