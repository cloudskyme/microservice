/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.config
 *
 *    Filename:    RedisConfig.java
 *
 *    Description: redis配置
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年11月6日 下午2:22:11
 *
 *    Revision:
 *
 *    2017年11月6日 下午2:22:11
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.config;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassName RedisConfig
 * @Description redis配置
 * @author zhangfeng
 * @Date 2017年11月6日 下午2:22:11
 * @version 1.0.0
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
	
	/* Redis缓存默认的Key生成策略，修改默认策略
	 * Description:
	 * @see org.springframework.cache.annotation.CachingConfigurerSupport#keyGenerator()
	 */
	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				String[] value = new String[1];
				Cacheable cacheable = method.getAnnotation(Cacheable.class);
				if (cacheable != null) {
					value = cacheable.value();
				}
				CachePut cachePut = method.getAnnotation(CachePut.class);
				if (cachePut != null) {
					value = cachePut.value();
				}
				CacheEvict cacheEvict = method.getAnnotation(CacheEvict.class);
				if (cacheEvict != null) {
					value = cacheEvict.value();
				}
				sb.append(value[0]);
				for (Object obj : params) {
					sb.append(":" + obj.toString());
				}
				return sb.toString();
			}
		};
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();

		redisTemplate.setConnectionFactory(factory);
		redisTemplate.afterPropertiesSet();
		setSerializer(redisTemplate);
		return redisTemplate;
	}

	private void setSerializer(RedisTemplate<String, String> template) {
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(jackson2JsonRedisSerializer);
	}

	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate) {
		RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
		// 设置缓存过期时间
		rcm.setDefaultExpiration(600);// 秒
		return rcm;
	}

}
