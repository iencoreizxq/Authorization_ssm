package com.dao;


import com.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {

    //查询所有的产品信息
    @Select("select * from PRODUCT")
    public List<Product> findAll() throws Exception;
}
