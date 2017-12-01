/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.entity
 *
 *    Filename:    User.java
 *
 *    Description: User
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月6日 下午2:51:32
 *
 *    Revision:
 *
 *    2017年11月6日 下午2:51:32
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.entity;

/**
 * @ClassName User
 * @Description User
 * @author zhangfeng
 * @Date 2017年11月6日 下午2:51:32
 * @version 1.0.0
 */
public class User {
    private Integer userId;

    private String username;

    private String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}
