package com.cloud.skyme.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cloud.skyme.entity.UserEntity;


/**
 * @ClassName UserDaoTest
 * @Description mongodb测试用例 
 * @author zhangfeng
 * @Date 2017年11月7日 下午5:50:45
 * @version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
	
	private final static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Autowired
    private UserDao userDao;

    /**
     * @Description 插入测试
     * @throws Exception
     */
    @Test
    public void testSaveUser() throws Exception {
        UserEntity user=new UserEntity();
        user.setId(20l);
        user.setUserName("张锋");
        user.setPassWord("123456");
        userDao.saveUser(user);
        logger.info("保存成功");
    }

    /**
     * @Description 根据用户名查询某个用户
     */
    @Test
    public void findUserByUserName(){
       UserEntity user= userDao.findUserByUserName("张锋");
       logger.info("user is "+user);
    }

    /**
     * @Description 更新用户信息
     */
    @Test
    public void updateUser(){
        UserEntity user=new UserEntity();
        user.setId(35l);
        user.setUserName("小李");
        user.setPassWord("456789");
        userDao.updateUser(user);
        logger.info("更新成功");
    }

    /**
     * @Description 删除用户信息
     */
    @Test
    public void deleteUserById(){
        userDao.deleteUserById(20l);
    }

}
