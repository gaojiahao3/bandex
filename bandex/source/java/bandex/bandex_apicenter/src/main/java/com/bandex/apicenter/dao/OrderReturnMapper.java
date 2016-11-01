package com.bandex.apicenter.dao;

import com.bandex.apicenter.model.OrderReturn;

public interface OrderReturnMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderReturn record);

    int insertSelective(OrderReturn record);

    OrderReturn selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderReturn record);

    int updateByPrimaryKey(OrderReturn record);
}