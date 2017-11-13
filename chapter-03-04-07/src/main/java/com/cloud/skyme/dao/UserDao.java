package com.cloud.skyme.dao;

import com.cloud.skyme.entity.UserEntity;

/**
 * @ClassName UserDao
 * @Description 用户操作类
 * @author zhangfeng
 * @Date 2017年11月7日 下午4:35:49
 * @version 1.0.0
 */
public interface UserDao  {

    public void saveUser(UserEntity user);

    public UserEntity findUserByUserName(String userName);

    public int updateUser(UserEntity user);

    public void deleteUserById(Long id);

}
