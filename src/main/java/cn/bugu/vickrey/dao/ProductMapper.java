package cn.bugu.vickrey.dao;

import cn.bugu.vickrey.domain.Product;

public interface ProductMapper {
    int insert(Product record);

    int insertSelective(Product record);
}