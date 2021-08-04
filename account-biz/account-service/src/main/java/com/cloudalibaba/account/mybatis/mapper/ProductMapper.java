package com.cloudalibaba.account.mybatis.mapper;

import com.cloudalibaba.account.mybatis.example.ProductExample;
import com.cloudalibaba.account.mybatis.po.Product;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectOneByExample(ProductExample example);

    Product selectOneByExampleForUpdate(ProductExample example);

    List<Product> selectByExampleWithLimit(@Param("example") ProductExample example, @Param("limit") Integer limit);

    List<Product> selectByExampleForUpdate(ProductExample example);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKeyForUpdate(Integer id);

    Product selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}