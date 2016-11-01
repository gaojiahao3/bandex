package com.bandex.apicenter.dao;

import java.util.List;

import com.bandex.apicenter.dto.OrderItemListDto;
import com.bandex.apicenter.model.OrderItem;

public interface OrderItemMapper {
	int deleteByPrimaryKey(Long id);

	int insert(OrderItem record);

	int insertSelective(OrderItem record);

	OrderItem selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(OrderItem record);

	int updateByPrimaryKey(OrderItem record);

	List<OrderItemListDto> selectItemListByOrderCode(String orderCode);
}