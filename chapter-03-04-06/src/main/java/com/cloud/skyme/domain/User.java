/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.domain
 *
 *    Filename:    User.java
 *
 *    Description: 用户信息
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月7日 下午2:04:57
 *
 *    Revision:
 *
 *    2017年11月7日 下午2:04:57
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.domain;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description 用户信息
 * @author zhangfeng
 * @Date 2017年11月7日 下午2:04:57
 * @version 1.0.0
 */
public class User implements Serializable{

	private String userName;
	private String password;
	private int age;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", age=" + age + "]";
	}

}
