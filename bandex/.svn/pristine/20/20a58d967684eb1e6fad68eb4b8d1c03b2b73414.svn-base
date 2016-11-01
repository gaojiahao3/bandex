package com.bandex.apicenter.dao;

import com.bandex.apicenter.model.UserIntegrationDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserIntegrationDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserIntegrationDetail record);

    int insertSelective(UserIntegrationDetail record);

    UserIntegrationDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserIntegrationDetail record);

    int updateByPrimaryKey(UserIntegrationDetail record);

    List<UserIntegrationDetail> selectAllByUserId(@Param("userId")Long userId, @Param("index")Integer index,@Param("limit") Integer limit);
}