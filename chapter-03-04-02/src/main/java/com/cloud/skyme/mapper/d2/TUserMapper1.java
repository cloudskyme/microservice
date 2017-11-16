package com.cloud.skyme.mapper.d2;

import com.cloud.skyme.entity.TUser1;

/**
 * @ClassName TUserMapper
 * @Description mapper CRUD接口
 * @author zhangfeng
 * @Date 2017年10月26日 下午3:03:25
 * @version 1.0.0
 */
public interface TUserMapper1 {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser1 record);

    int insertSelective(TUser1 record);

    TUser1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser1 record);

    int updateByPrimaryKeyWithBLOBs(TUser1 record);

    int updateByPrimaryKey(TUser1 record);
}