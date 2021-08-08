package com.cloudalibaba.order.mybatis.mapper;

import com.cloudalibaba.order.mybatis.example.ShopOrderExample;
import com.cloudalibaba.order.mybatis.po.ShopOrder;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopOrderMapper {
    long countByExample(ShopOrderExample example);

    int deleteByExample(ShopOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopOrder record);

    int insertSelective(ShopOrder record);

    ShopOrder selectOneByExample(ShopOrderExample example);

    ShopOrder selectOneByExampleForUpdate(ShopOrderExample example);

    List<ShopOrder> selectByExampleWithLimit(@Param("example") ShopOrderExample example, @Param("limit") Integer limit);

    List<ShopOrder> selectByExampleForUpdate(ShopOrderExample example);

    List<ShopOrder> selectByExample(ShopOrderExample example);

    ShopOrder selectByPrimaryKeyForUpdate(Integer id);

    ShopOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopOrder record, @Param("example") ShopOrderExample example);

    int updateByExample(@Param("record") ShopOrder record, @Param("example") ShopOrderExample example);

    int updateByPrimaryKeySelective(ShopOrder record);

    int updateByPrimaryKey(ShopOrder record);
}