package com.cloud.skyme;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @ClassName Chapter0303ApplicationTests
 * @Description 测试AOP
 * @author zhangfeng
 * @Date 2017年10月24日 下午3:36:57
 * @version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Chapter0303ApplicationTests {

	@Autowired
	private MockMvc mvc;

	/**
	 * @Description 前置通知测试
	 * @throws Exception
	 */
	@Test
	public void getdoBeforeAdvice() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/aop/testBeforeService.do")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("前置通知测试")));
	}

	/**
	 * @Description 前置后置通知
	 * @throws Exception
	 */
	@Test
	public void getdoAfterReturning() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/aop/testAfterReturning.do")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("后置通知测试")));
	}

//	/**
//	 * @Description 异常通知测试
//	 * @throws Exception
//	 */
//	@Test
//	public void getdoAfterThrowing() throws Exception {
//		MvcResult result = mvc.perform(MockMvcRequestBuilders
//				.get("/aop/testAfterThrowing.do")
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isInternalServerError())
//				.andReturn();
//		Assert.assertTrue(NullPointerException.class.isAssignableFrom(result.getResolvedException().getClass()));  
//	}
	
	/**
	 * @Description 前置后置通知
	 * @throws Exception
	 */
	@Test
	public void gettestAfter() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/aop/testAfter.do")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("后置最终通知测试")));
	}
	
	/**
	 * @Description 环绕通知
	 * @throws Exception
	 */
	@Test
	public void gettestAroundService() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/aop/testAroundService.do")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("环绕通知")));
	}

}
