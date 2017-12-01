package com.cloud.skyme.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cloud.skyme.entity.UserEntity;
import com.cloud.skyme.enums.UserSexEnum;

/**
 * @ClassName UserMapperTest
 * @Description CRUD单数据源测试
 * @author zhangfeng
 * @Date 2017年10月25日 下午5:09:02
 * @version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	
	private final static Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

	@Autowired
	private UserMapper UserMapper;

	/**
	 * @Description 测试插入
	 * @throws Exception
	 */
	@Test
	public void testInsert() throws Exception {
		UserMapper.insert(new UserEntity("aa", "a123456", UserSexEnum.MAN));
		UserMapper.insert(new UserEntity("bb", "b123456", UserSexEnum.WOMAN));
		UserMapper.insert(new UserEntity("cc", "b123456", UserSexEnum.WOMAN));

		Assert.assertEquals(3, UserMapper.getAll().size());
	}

	/**
	 * @Description 测试查询
	 * @throws Exception
	 */
	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = UserMapper.getAll();
		for (UserEntity userEntity : users) {
			logger.info("users "+userEntity.toString());
		}
	}
	
	
	/**
	 * @Description 测试更新
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		UserEntity user = UserMapper.getOne(374L);
		logger.info("users "+user.toString());
		user.setNickName("neo");
		UserMapper.update(user);
		Assert.assertTrue(("neo".equals(UserMapper.getOne(374l).getNickName())));
	}

}