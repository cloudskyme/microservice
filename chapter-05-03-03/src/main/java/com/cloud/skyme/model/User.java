/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.model
 *
 *    Filename:    User.java
 *
 *    Description: 要传输的对象
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月22日 下午4:56:50
 *
 *    Revision:
 *
 *    2017年11月22日 下午4:56:50
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.model;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description 要传输的对象
 * @author zhangfeng
 * @Date 2017年11月22日 下午4:56:50
 * @version 1.0.0
 */
public class User implements Serializable {
    private static final long serialVersionUID = -7233238826463139634L;
 
    private Long id;
 
    private String name;
 
    private Integer age;
 
    public User() {
    }
 
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Integer getAge() {
        return age;
    }
 
    public void setAge(Integer age) {
        this.age = age;
    }
 
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
