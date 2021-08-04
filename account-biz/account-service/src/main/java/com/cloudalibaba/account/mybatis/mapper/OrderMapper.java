package com.cloudalibaba.account.mybatis.mapper;

import com.cloudalibaba.account.mybatis.example.OrderExample;
import com.cloudalibaba.account.mybatis.po.Order;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectOneByExample(OrderExample example);

    Order selectOneByExampleForUpdate(OrderExample example);

    List<Order> selectByExampleWithLimit(@Param("example") OrderExample example, @Param("limit") Integer limit);

    List<Order> selectByExampleForUpdate(OrderExample example);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKeyForUpdate(Integer id);

    Order selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}