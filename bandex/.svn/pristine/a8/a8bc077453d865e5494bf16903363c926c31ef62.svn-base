package com.bandex.apicenter.dao;

import cn.jpush.api.report.UsersResult;
import com.bandex.apicenter.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    List<UserInfo> queryUserInfoByUserIdList(@Param("userIdList") List<Long> friendUserIdList, @Param("searchKey") String searchKey,@Param("pageIndex") int pageIndex,@Param("pageSize") int appPageSize);

    List<UserInfo> queryUserIdList(@Param("userIdList")List<Long> userIdList);
}