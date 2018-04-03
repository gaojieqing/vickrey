package cn.bugu.vickrey.dao;

import cn.bugu.vickrey.domain.Discount;

public interface DiscountMapper {
    int insert(Discount record);

    int insertSelective(Discount record);
}