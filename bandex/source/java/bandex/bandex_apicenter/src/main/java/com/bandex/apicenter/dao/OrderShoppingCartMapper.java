package com.bandex.apicenter.dao;

import com.bandex.apicenter.model.OrderShoppingCart;

public interface OrderShoppingCartMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderShoppingCart record);

    int insertSelective(OrderShoppingCart record);

    OrderShoppingCart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderShoppingCart record);

    int updateByPrimaryKey(OrderShoppingCart record);
}