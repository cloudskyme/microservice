package com.cloud.skyme.mapper;

import com.cloud.skyme.entity.TUser2;

/**
 * @ClassName TUserMapper
 * @Description mapper CRUD接口
 * @author zhangfeng
 * @Date 2017年10月26日 下午3:03:25
 * @version 1.0.0
 */
public interface TUserMapper2 {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser2 record);

    int insertSelective(TUser2 record);

    TUser2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser2 record);

    int updateByPrimaryKeyWithBLOBs(TUser2 record);

    int updateByPrimaryKey(TUser2 record);
}