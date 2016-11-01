package com.bandex.apicenter.dao;

import java.util.List;
import java.util.Map;

import com.bandex.apicenter.dto.OrderDetailDto;
import com.bandex.apicenter.dto.OrderListDto;
import com.bandex.apicenter.model.OrderInfo;

public interface OrderInfoMapper {
	int deleteByPrimaryKey(Long id);

	int insert(OrderInfo record);

	int insertSelective(OrderInfo record);

	OrderInfo selectByPrimaryKey(Long id);

	OrderInfo selectByOrderCode(String orderCode);

	int updateByPrimaryKeySelective(OrderInfo record);

	int updateByPrimaryKey(OrderInfo record);

	List<OrderListDto> selectMyOrderList(Map<String, Object> map);

	OrderDetailDto selectOrderDetailByOrderCode(String orderCode);
}