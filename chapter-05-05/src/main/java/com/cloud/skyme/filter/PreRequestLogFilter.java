/******************************************************************
 *
 *    Copyright (c) 2010-2017 Digital Telemedia Co.,Ltd
 *    https://home.cnblogs.com/u/skyme/
 *
 *    Package:     com.cloud.skyme.filter
 *
 *    Filename:    PreRequestLogFilter.java
 *
 *    Description: 日志记录过滤器
 *
 *    Copyright:   Copyright (c) 2010-2017
 *
 *    Company:     cloudskyme
 *
 *    @author:     zhangfeng
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年12月1日 上午10:48:52
 *
 *    Revision:
 *
 *    2017年12月1日 上午10:48:52
 *        - first revision
 *
 *****************************************************************/
package com.cloud.skyme.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @ClassName PreRequestLogFilter
 * @Description 日志记录过滤器
 * @author zhangfeng
 * @Date 2017年12月1日 上午10:48:52
 * @version 1.0.0
 */
public class PreRequestLogFilter extends ZuulFilter {
	private static final Logger logger = LoggerFactory.getLogger(PreRequestLogFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		PreRequestLogFilter.logger
				.info(String.format("send %s request to %s", request.getMethod(), request.getRequestURL().toString()));
		return null;
	}
}
