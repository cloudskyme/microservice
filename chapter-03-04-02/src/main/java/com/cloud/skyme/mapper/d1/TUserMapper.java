package com.cloud.skyme.mapper.d1;

import com.cloud.skyme.entity.TUser;

/**
 * @ClassName TUserMapper
 * @Description mapper CRUD接口
 * @author zhangfeng
 * @Date 2017年10月26日 下午3:03:25
 * @version 1.0.0
 */
public interface TUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKeyWithBLOBs(TUser record);

    int updateByPrimaryKey(TUser record);
}